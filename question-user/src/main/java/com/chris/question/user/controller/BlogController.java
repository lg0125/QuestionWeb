package com.chris.question.user.controller;

import com.chris.question.common.utils.PageRequest;
import com.chris.question.user.pojo.Blog;
import com.chris.question.user.service.BlogService;
import com.chris.question.common.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("blog/service")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @PostMapping("/insertion")
    public R insertBlog(@RequestBody Blog blog){
        int result = blogService.insertBlog(blog);
        return R.ok();
    }

    @DeleteMapping("/deleting/{blogId}")
    public R deleteBlog(@PathVariable Long blogId){
        int result = blogService.deleteBlog(blogId);
        return R.ok();
    }

    @PutMapping("/updating")
    public R updateBlog(@RequestBody Blog blog){
        int result = blogService.updateBlog(blog);
        return R.ok();
    }

    @GetMapping("/getting/{blogId}")
    public R getBlog(@PathVariable Long blogId){
        return R.ok().put("blog",blogService.getBlog(blogId));
    }

    @GetMapping("/list/{userId}")
    public R getBlogList(@PathVariable String userId) {
        return R.ok().put("blogList",blogService.getBlogListByUserId(userId));
    }

    @PostMapping("/list/page/{userId}")
    public R getBlogListPage(@PathVariable String userId,
                             @RequestBody PageRequest pageQuery)
    {
        return R.ok().put("result", blogService.getBlogListPageByUserId(userId, pageQuery));
    }

    @PostMapping("/list/page")
    public R getBlogArrayPage(@RequestBody PageRequest pageQuery)
    {
        return R.ok().put("result", blogService.getBlogList(pageQuery));
    }
}
