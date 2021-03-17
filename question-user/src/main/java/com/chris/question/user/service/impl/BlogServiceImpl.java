package com.chris.question.user.service.impl;

import com.chris.question.common.utils.PageRequest;
import com.chris.question.common.utils.PageResult;
import com.chris.question.common.utils.PageUtils;
import com.chris.question.user.dao.BlogMapper;
import com.chris.question.user.pojo.Blog;
import com.chris.question.user.service.BlogService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service("BlogService")
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogMapper blogMapper;

    @Override
    public int insertBlog(Blog blog) {
        return blogMapper.insertBlog(blog);
    }

    @Override
    public int deleteBlog(Long blogId) {
        return blogMapper.deleteBlog(blogId);
    }

    @Override
    public int updateBlog(Blog blog) {
        return blogMapper.updateBlog(blog);
    }

    @Override
    public Blog getBlog(Long blogId) {
        return blogMapper.getBlog(blogId);
    }

    @Override
    public List<Blog> getBlogListByUserId(String userId) {
        return blogMapper.getBlogListByUserId(userId);
    }

    @Override
    public PageResult getBlogListPageByUserId(String userId, PageRequest pageRequest) {
        return PageUtils.getPageResult(pageRequest,getPageInfoByUserId(userId, pageRequest));
    }

    private PageInfo<Blog> getPageInfoByUserId(String userId,PageRequest pageRequest){
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<Blog> listByPage = blogMapper.getBlogListByUserId(userId);
        return new PageInfo<>(listByPage);
    }
}
