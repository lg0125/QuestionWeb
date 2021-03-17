package com.chris.question.user.service;

import com.chris.question.user.pojo.BlogComment;

import java.math.BigInteger;
import java.util.List;

public interface BlogCommentService {
    public int insertBlogComment(BlogComment blogComment);
    public int deleteBlogComment(Long blogCommentId);
    public int updateComment(BlogComment blogComment);
    public BlogComment getBlogComment(Long blogCommentId);
    public List<BlogComment> getBlogCommentListByBlogId(Long blogId);
}
