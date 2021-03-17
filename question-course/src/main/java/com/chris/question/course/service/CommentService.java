package com.chris.question.course.service;

import com.chris.question.common.utils.PageRequest;
import com.chris.question.common.utils.PageResult;
import com.chris.question.course.pojo.Comment;

import java.math.BigInteger;
import java.util.List;

public interface CommentService {
    public int insertComment(Comment comment);
    public int deleteComment(Long commentId);
    public int updateComment(Comment comment);
    public Comment getComment(Long commentId);
    public List<Comment> getCommentList(Long questionId);
    public PageResult getCommentListPage(Long questionId, PageRequest pageRequest);
}
