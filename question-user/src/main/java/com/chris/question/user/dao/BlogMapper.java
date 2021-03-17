package com.chris.question.user.dao;

import com.chris.question.user.pojo.Blog;

import java.math.BigInteger;
import java.util.List;

public interface BlogMapper {
    public int insertBlog(Blog blog);
    public int deleteBlog(Long id);
    public int updateBlog(Blog blog);
    public Blog getBlog(Long id);
    public List<Blog> getBlogListByUserId(String userId);
}
