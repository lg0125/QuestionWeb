package com.chris.question.user.controller;


import com.chris.question.user.pojo.BlogComment;
import com.chris.question.user.service.BlogCommentService;
import com.chris.question.common.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;

@CrossOrigin
@RestController
@RequestMapping("blogComment/service")
public class BlogCommentController {

    @Autowired
    private BlogCommentService blogCommentService;

    @PostMapping("/insertion")
    public R insertBlogComment(@RequestBody BlogComment blogComment){
        int result = blogCommentService.insertBlogComment(blogComment);
        return R.ok();
    }

    @DeleteMapping("/deleting/{blogCommentId}")
    public R deleteBlogComment(@PathVariable Long blogCommentId){
        int result = blogCommentService.deleteBlogComment(blogCommentId);
        return R.ok();
    }

    @PutMapping("/updating")
    public R updateBlogComment(@RequestBody BlogComment blogComment){
        int result = blogCommentService.updateComment(blogComment);
        return R.ok();
    }

    @GetMapping("/getting/{blogCommentId}")
    public R getBlogComment(@PathVariable Long blogCommentId){
        return R.ok().put("BlogComment",blogCommentService.getBlogComment(blogCommentId));
    }

}
