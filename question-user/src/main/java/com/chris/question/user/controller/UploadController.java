package com.chris.question.user.controller;

import com.chris.question.common.utils.FileResult;
import com.chris.question.common.utils.R;
import com.chris.question.common.utils.UploadUtils;
import com.chris.question.user.pojo.Blog;
import com.chris.question.user.pojo.BlogComment;
import com.chris.question.user.pojo.Information;
import com.chris.question.user.service.BlogCommentService;
import com.chris.question.user.service.BlogService;
import com.chris.question.user.service.InformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("upload")
public class UploadController {

    @Autowired
    private InformationService informationService;
    @Autowired
    private BlogService blogService;
    @Autowired
    private BlogCommentService blogCommentService;

    private String getFileResult(MultipartFile file){
        String fileName = UploadUtils.createUniqueFileName(file);
        FileResult result = UploadUtils.upload(file, fileName);
        return result.getMessage();
    }

    @RequestMapping("/avatar")
    public R uploadAvatar(@RequestParam("avatar") MultipartFile avatar, @RequestParam("userId") String userId, HttpServletRequest request){
        String result = getFileResult(avatar);

        Information information = informationService.getInformation(userId);
        information.setAvatar(result);
        informationService.updateInformation(information);

        System.out.println(result);
        return R.ok();
    }

    @PostMapping("/pics")
    public R uploadPics(@RequestParam("file") MultipartFile[] files,
                        @RequestParam("id") Long id,
                        @RequestParam("type") String type,
                        HttpServletRequest request){

        System.out.println(id + " " + type);

        List<String> results = Arrays.stream(files)
                                        .map(this::getFileResult)
                                        .collect(Collectors.toList());
        int size = Math.min(results.size(), 3);
        String[] photos = new String[3];
        for(int i=0;i<size ;i++) photos[i] = results.get(i);

        System.out.println(photos[0]+" "+ photos[1]+" " +photos[2]);

        if(type.equals("blog")){
            Blog blog = new Blog(id,photos[0],photos[1],photos[2]);
            System.out.println(blog);
            blogService.updatePics(blog);
        }else{
            BlogComment blogComment = new BlogComment(id,photos[0],photos[1],photos[2]);
            System.out.println(blogComment);
            blogCommentService.updatePics(blogComment);
        }

        return R.ok();
    }

    @RequestMapping("/view/{photo}")
    public R view(HttpServletResponse res,@PathVariable String photo){
        String path = "src/main/resources/statics/upload/img" + "/" + photo;
        String result = UploadUtils.getBackFile(res,path);
        System.out.println(result);
        return R.ok().put("result",result);
    }
}
