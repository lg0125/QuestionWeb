package com.chris.question.course.controller;

import com.chris.question.common.utils.FileResult;
import com.chris.question.common.utils.R;
import com.chris.question.common.utils.UploadUtils;
import com.chris.question.course.pojo.Comment;
import com.chris.question.course.pojo.Question;
import com.chris.question.course.service.CommentService;
import com.chris.question.course.service.QuestionService;
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
    private CommentService commentService;
    @Autowired
    private QuestionService questionService;

    private String getFileResult(MultipartFile file){
        String fileName = UploadUtils.createUniqueFileName(file);
        FileResult result = UploadUtils.upload(file, fileName);
        return result.getMessage();
    }

    @PostMapping("/pics")
    public R upload(@RequestParam("file") MultipartFile[] files,
                    @RequestParam("id") Long id,
                    @RequestParam("type") String type,
                    HttpServletRequest request){
        List<String> results = Arrays.stream(files)
                .map(this::getFileResult)
                .collect(Collectors.toList());
        int size = Math.min(results.size(), 3);
        String[] photos = new String[3];
        for(int i=0;i<size ;i++) photos[i] = results.get(i);

        switch (type){
            case "comment":
                Comment comment = new Comment(id,photos[0],photos[1],photos[2]);
                commentService.updatePics(comment);
                break;
            case "question":
                Question question = new Question(id,photos[0],photos[1],photos[2]);
                questionService.updatePics(question);
                break;
            default:break;
        }
        return R.ok();
    }

    @RequestMapping("/view/{photo}")
    public R view(HttpServletResponse res, @PathVariable String photo){
        String path = "src/main/resources/statics/upload/img" + "/" + photo;
        String result = UploadUtils.getBackFile(res,path);
        System.out.println(result);
        return R.ok().put("result",result);
    }

}
