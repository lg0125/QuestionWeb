package com.chris.question.user.dao;

import com.chris.question.user.pojo.BlogComment;

import java.math.BigInteger;
import java.util.List;

public interface BlogCommentMapper {
    public int insertBlogComment(BlogComment blogComment);
    public int deleteBlogComment(Long id);
    public int updateBlogComment(BlogComment blogComment);
    public BlogComment getBlogComment(Long id);

    public List<BlogComment> getBlogCommentListByBlogId(Long blogId);
}
