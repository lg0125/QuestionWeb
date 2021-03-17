package com.chris.question.user.service.impl;

import com.chris.question.user.dao.BlogCommentMapper;
import com.chris.question.user.pojo.BlogComment;
import com.chris.question.user.service.BlogCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service("BlogCommentService")
public class BlogCommentServiceImpl implements BlogCommentService {

    @Autowired
    private BlogCommentMapper blogCommentMapper;

    @Override
    public int insertBlogComment(BlogComment blogComment) {
        return blogCommentMapper.insertBlogComment(blogComment);
    }

    @Override
    public int deleteBlogComment(Long blogCommentId) {
        return blogCommentMapper.deleteBlogComment(blogCommentId);
    }

    @Override
    public int updateComment(BlogComment blogComment) {
        return blogCommentMapper.updateBlogComment(blogComment);
    }

    @Override
    public BlogComment getBlogComment(Long blogCommentId) {
        return blogCommentMapper.getBlogComment(blogCommentId);
    }

    @Override
    public List<BlogComment> getBlogCommentListByBlogId(Long blogId) {
        return blogCommentMapper.getBlogCommentListByBlogId(blogId);
    }
}
