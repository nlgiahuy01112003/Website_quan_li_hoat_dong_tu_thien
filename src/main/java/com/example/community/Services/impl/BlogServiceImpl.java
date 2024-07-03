package com.example.community.Services.impl;

import com.example.community.Entity.Blog;
import com.example.community.Entity.UserEntity;
import com.example.community.Mapper.BlogMapper;
import com.example.community.Security.SecurityUtil;
import com.example.community.Services.BlogService;
import com.example.community.dto.BlogDto;
import com.example.community.repos.BlogRepository;
import com.example.community.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BlogServiceImpl implements BlogService {

    private final BlogRepository blogRepository;
    private final UserRepository userRepository;

    @Autowired
    public BlogServiceImpl(BlogRepository blogRepository, UserRepository userRepository) {
        this.blogRepository = blogRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<BlogDto> findAllBlogs() {
        List<Blog> blogs = blogRepository.findAll();
        return blogs.stream().map(BlogMapper::mapToBlogDto).collect(Collectors.toList());
    }

    @Override
    public BlogDto saveBlog(BlogDto blogDto) {
        String username = SecurityUtil.getSessionUser();
        UserEntity user = userRepository.findByUsername(username);
        Blog blog = BlogMapper.mapToBlog(blogDto);
        blog.setCreatedBy(user);
        blog.setCreatedOn(LocalDateTime.now());
        blog.setUpdatedOn(LocalDateTime.now());
        return BlogMapper.mapToBlogDto(blogRepository.save(blog));
    }

    @Override
    public BlogDto findBlogById(Long blogId) {
        Blog blog = blogRepository.findById(blogId).orElseThrow(() -> new RuntimeException("Blog not found"));
        return BlogMapper.mapToBlogDto(blog);
    }

    @Override
    public void updateBlog(BlogDto blogDto) {
        String username = SecurityUtil.getSessionUser();
        UserEntity user = userRepository.findByUsername(username);
        Blog blog = BlogMapper.mapToBlog(blogDto);
        blog.setCreatedBy(user);
        blog.setUpdatedOn(LocalDateTime.now());
        blogRepository.save(blog);
    }

    @Override
    public void delete(Long blogId) {
        blogRepository.deleteById(blogId);
    }
}
