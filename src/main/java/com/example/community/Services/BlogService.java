package com.example.community.Services;

import com.example.community.dto.BlogDto;

import java.util.List;

public interface BlogService {
    List<BlogDto> findAllBlogs();
    BlogDto saveBlog(BlogDto blogDto);
    BlogDto findBlogById(Long blogId);
    void updateBlog(BlogDto blogDto);
    void delete(Long blogId);
}
