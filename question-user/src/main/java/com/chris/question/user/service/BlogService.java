package com.chris.question.user.service;

import com.chris.question.common.utils.PageRequest;
import com.chris.question.common.utils.PageResult;
import com.chris.question.user.pojo.Blog;

import java.math.BigInteger;
import java.util.List;

public interface BlogService {
    public int insertBlog(Blog blog);
    public int deleteBlog(Long blogId);
    public int updateBlog(Blog blog);
    public Blog getBlog(Long blogId);
    public List<Blog> getBlogListByUserId(String userId);
    public PageResult getBlogListPageByUserId(String userId, PageRequest pageRequest);
    public int updatePics(Blog blog);
    public PageResult getBlogList( PageRequest pageRequest);
}
