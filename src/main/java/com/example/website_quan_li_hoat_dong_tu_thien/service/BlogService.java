package com.example.website_quan_li_hoat_dong_tu_thien.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import jakarta.validation.constraints.NotNull;

import com.example.website_quan_li_hoat_dong_tu_thien.model.Blog;
import com.example.website_quan_li_hoat_dong_tu_thien.repository.BlogRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class BlogService {
    @Autowired
    private final BlogRepository blogRepository;

    // Get all blogs
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    // Get blog by ID
    public ResponseEntity<Optional<Blog>> getBlogById(Long id) {
        if (id == null) {
            log.warn("Blog ID is null.");
            return ResponseEntity.badRequest().build();
        }
        Optional<Blog> blog = blogRepository.findById(id);
        if (blog.isPresent()) {
            log.info("Blog with ID {} found.", id);
            return ResponseEntity.ok(blog);
        } else {
            log.warn("Blog with ID {} not found.", id);
            return ResponseEntity.notFound().build();
        }
    }

    // Add new blog
    public ResponseEntity<Blog> addBlog(@NotNull Blog blog) {
        if (blog.getId() != 0 && blogRepository.existsById((long) blog.getId())) {
            log.warn("Blog with ID {} already exists.", blog.getId());
            return ResponseEntity.status(409).build(); // Conflict
        } else {
            Blog savedBlog = blogRepository.save(blog);
            log.info("Blog with ID {} created successfully.", savedBlog.getId());
            return ResponseEntity.status(201).body(savedBlog); // Created
        }
    }

    // Update existing blog
    public ResponseEntity<Blog> updateBlog(@NotNull Blog blog) {
        if (blog.getId() == 0) {
            log.warn("Blog ID is null, cannot update.");
            return ResponseEntity.badRequest().build(); // Bad Request
        }

        Blog existingBlog = blogRepository.findById((long) blog.getId())
                .orElseThrow(() -> new IllegalStateException(
                        "Blog with ID " + blog.getId() + " does not exist."));
        existingBlog.setTitle(blog.getTitle());
        existingBlog.setImg(blog.getImg());
        existingBlog.setDetail(blog.getDetail());
        existingBlog.setDateBegin(blog.getDateBegin());
        existingBlog.setMeta(blog.getMeta());
        existingBlog.setOrder(blog.getOrder());
        existingBlog.setLink(blog.getLink());
        existingBlog.setHide(blog.isHide());
        Blog updatedBlog = blogRepository.save(existingBlog);
        log.info("Blog with ID {} updated successfully.", updatedBlog.getId());
        return ResponseEntity.ok(updatedBlog);
    }

    // Delete blog by ID
    public ResponseEntity<Void> deleteBlogById(Long id) {
        if (id == null) {
            log.warn("Blog ID is null.");
            return ResponseEntity.badRequest().build();
        }
        if (!blogRepository.existsById(id)) {
            log.warn("Blog with ID {} does not exist.", id);
            return ResponseEntity.notFound().build();
        }
        blogRepository.deleteById(id);
        log.info("Blog with ID {} deleted successfully.", id);
        return ResponseEntity.noContent().build(); // No Content
    }
}
