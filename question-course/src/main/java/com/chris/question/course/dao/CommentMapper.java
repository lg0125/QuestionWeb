package com.chris.question.course.dao;

import com.chris.question.course.pojo.Comment;
import org.apache.ibatis.annotations.Mapper;

import java.math.BigInteger;
import java.util.List;

@Mapper
public interface CommentMapper {
    public int insertComment(Comment comment);
    public int deleteComment(Long id);
    public int updateComment(Comment comment);
    public Comment getComment(Long id);
    public List<Comment> getCommentList(Long questionId);
    public int updatePics(Comment comment);
}
