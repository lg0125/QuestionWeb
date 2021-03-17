package com.chris.question.course.controller;

import com.chris.question.common.utils.PageRequest;
import com.chris.question.course.pojo.Comment;
import com.chris.question.course.service.CommentService;
import com.chris.question.common.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;

@CrossOrigin
@RestController
@RequestMapping("comment/service")
public class CommentController {

    @Autowired
    private CommentService commentService;


    @PostMapping("/insertion")
    public R insertComment(@RequestBody Comment comment){
        int result = commentService.insertComment(comment);
        return R.ok();
    }

    @DeleteMapping("/deleting/{commentId}")
    public R deleteComment(@PathVariable Long commentId){
        int result = commentService.deleteComment(commentId);
        return R.ok();
    }

    @PutMapping("/updating")
    public R updateComment(@RequestBody Comment comment){
        int result = commentService.updateComment(comment);
        return R.ok();
    }

    @GetMapping("/getting/{commentId}")
    public R getComment(@PathVariable Long commentId){
        return R.ok().put("comment",commentService.getComment(commentId));
    }

    //TODO
    @GetMapping("/getting/{questionId}")
    public R getCommentListByQuestionId(@PathVariable Long questionId){
        return R.ok().put("commentList",commentService.getCommentList(questionId));
    }

    //TODO
    @PostMapping("/list/page/{questionId}")
    public R getCommentListPage(@PathVariable Long questionId,
                                @RequestBody PageRequest pageQuery)
    {
        return R.ok().put("result",commentService.getCommentListPage(questionId,pageQuery));
    }
}
