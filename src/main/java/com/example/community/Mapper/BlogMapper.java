package com.example.community.Mapper;

import com.example.community.dto.BlogDto;
import com.example.community.Entity.Blog;

public class BlogMapper {

    public static Blog mapToBlog(BlogDto blogDto) {
        return Blog.builder()
                .id(blogDto.getId())
                .title(blogDto.getTitle())
                .content(blogDto.getContent())
                .imageUrl(blogDto.getImageUrl()) // Map image URL
                .createdOn(blogDto.getCreatedOn())
                .updatedOn(blogDto.getUpdatedOn())
                .createdBy(blogDto.getCreatedBy()) // Map createdBy
                .build();
    }

    public static BlogDto mapToBlogDto(Blog blog) {
        return BlogDto.builder()
                .id(blog.getId())
                .title(blog.getTitle())
                .content(blog.getContent())
                .imageUrl(blog.getImageUrl()) // Map image URL
                .createdOn(blog.getCreatedOn())
                .updatedOn(blog.getUpdatedOn())
                .createdBy(blog.getCreatedBy()) // Map createdBy
                .build();
    }
}
