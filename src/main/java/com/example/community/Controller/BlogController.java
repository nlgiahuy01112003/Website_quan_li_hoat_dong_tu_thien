package com.example.community.Controller;

import com.example.community.Entity.UserEntity;
import com.example.community.Security.SecurityUtil;
import com.example.community.Services.BlogService;
import com.example.community.Services.UserService;
import com.example.community.dto.BlogDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/blogs")
public class BlogController {

    private final BlogService blogService;
    private final UserService userService;

    @Autowired
    public BlogController(BlogService blogService, UserService userService) {
        this.blogService = blogService;
        this.userService = userService;
    }

    @GetMapping
    public String listBlogs(Model model) {
        List<BlogDto> blogs = blogService.findAllBlogs();
        model.addAttribute("blogs", blogs);
        return "blogs/list";
    }
    @GetMapping("/Item")
    public String listBlogItem(Model model) {
        List<BlogDto> blogs = blogService.findAllBlogs();
        model.addAttribute("blogs", blogs);
        return "Item";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("blog", new BlogDto());
        return "blogs/create";
    }

    @PostMapping
    public String createBlog(@Valid @ModelAttribute("blog") BlogDto blogDto, @RequestParam("fileImage") MultipartFile multipartFile, BindingResult result, RedirectAttributes redirectAttributes) throws IOException {
        if (result.hasErrors()) {
            return "blogs/create";
        }

        if (!multipartFile.isEmpty()) {
            String directoryName = "src/main/resources/static/images";
            File directory = new File(directoryName);
            if (!directory.exists()) {
                directory.mkdirs();
            }

            String originalFileName = multipartFile.getOriginalFilename();
            String filePath = directory.getAbsolutePath() + File.separator + originalFileName;
            File destFile = new File(filePath);
            multipartFile.transferTo(destFile);
            blogDto.setImageUrl("/images/" + originalFileName);
        }

        String username = SecurityUtil.getSessionUser();
        UserEntity user = userService.findByUsername(username);
        blogDto.setCreatedBy(user);
        blogDto.setCreatedOn(LocalDateTime.now());
        blogDto.setUpdatedOn(LocalDateTime.now());

        blogService.saveBlog(blogDto);
        redirectAttributes.addFlashAttribute("message", "Blog created successfully!");
        return "redirect:/blogs";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        BlogDto blog = blogService.findBlogById(id);
        model.addAttribute("blog", blog);
        return "blogs/edit";
    }

    @PostMapping("/{id}")
    public String updateBlog(@PathVariable Long id, @Valid @ModelAttribute("blog") BlogDto blogDto, @RequestParam("fileImage") MultipartFile multipartFile, BindingResult result, RedirectAttributes redirectAttributes) throws IOException {
        if (result.hasErrors()) {
            return "blogs/edit";
        }

        if (!multipartFile.isEmpty()) {
            String directoryName = "src/main/resources/static/images";
            File directory = new File(directoryName);
            if (!directory.exists()) {
                directory.mkdirs();
            }

            String originalFileName = multipartFile.getOriginalFilename();
            String filePath = directory.getAbsolutePath() + File.separator + originalFileName;
            File destFile = new File(filePath);
            multipartFile.transferTo(destFile);
            blogDto.setImageUrl("/images/" + originalFileName);
        }

        blogDto.setId(id);
        blogDto.setUpdatedOn(LocalDateTime.now());
        blogService.updateBlog(blogDto);
        redirectAttributes.addFlashAttribute("message", "Blog updated successfully!");
        return "redirect:/blogs";
    }

    @GetMapping("/delete/{id}")
    public String deleteBlog(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        blogService.delete(id);
        redirectAttributes.addFlashAttribute("message", "Blog deleted successfully!");
        return "redirect:/blogs";
    }
}
