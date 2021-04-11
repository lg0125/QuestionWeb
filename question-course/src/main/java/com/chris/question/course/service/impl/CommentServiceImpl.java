package com.chris.question.course.service.impl;

import com.chris.question.common.utils.PageRequest;
import com.chris.question.common.utils.PageResult;
import com.chris.question.common.utils.PageUtils;
import com.chris.question.course.dao.CommentMapper;
import com.chris.question.course.pojo.Comment;
import com.chris.question.course.service.CommentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("CommentService")
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Override
    public int insertComment(Comment comment) {
        return commentMapper.insertComment(comment);
    }

    @Override
    public int deleteComment(Long commentId) {
        return commentMapper.deleteComment(commentId);
    }

    @Override
    public int updateComment(Comment comment) {
        return commentMapper.updateComment(comment);
    }

    @Override
    public Comment getComment(Long commentId) {
        return commentMapper.getComment(commentId);
    }

    @Override
    public List<Comment> getCommentList(Long questionId) {
        return commentMapper.getCommentList(questionId);
    }

    @Override
    public PageResult getCommentListPage(Long questionId, PageRequest pageRequest) {
        return PageUtils.getPageResult(pageRequest,getPageInfo(questionId,pageRequest));
    }

    @Override
    public int updatePics(Comment comment) {
        return commentMapper.updatePics(comment);
    }

    private PageInfo<Comment> getPageInfo(Long questionId, PageRequest pageRequest){
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum,pageSize);
        List<Comment> commentList = commentMapper.getCommentList(questionId);
        return new PageInfo<>(commentList);
    }
}
