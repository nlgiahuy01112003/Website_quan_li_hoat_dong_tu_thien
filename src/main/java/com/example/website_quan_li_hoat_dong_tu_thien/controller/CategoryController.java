package com.example.website_quan_li_hoat_dong_tu_thien.controller;

import com.example.website_quan_li_hoat_dong_tu_thien.model.Menu;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.example.website_quan_li_hoat_dong_tu_thien.service.CategoryService;
import com.example.website_quan_li_hoat_dong_tu_thien.model.Category;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    private final CategoryService categoryService;

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("category", new Category());
        return "/categories/add-category";
    }

    @PostMapping("/add")
    public String addCategory(@Valid Category category, BindingResult result) {
        if (result.hasErrors()) {
            return "/categories/add-category";
        }
        categoryService.addCategory(category);
        return "redirect:/categories";
    }

    @GetMapping("")
    public String listCategories(Model model) {
        List<Category> categories = categoryService.findAll();
        model.addAttribute("categories", categories);
        return "/categories/categories-list";
    }
    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        ResponseEntity<Optional<Category>> responseEntity = categoryService.getCategoryById(id);
        if (responseEntity.getStatusCode().is2xxSuccessful() && responseEntity.getBody().isPresent()) {
            Category category = responseEntity.getBody().get();
            model.addAttribute("category", category);
            return "/categories/update-category";
        } else {
            throw new IllegalArgumentException("Invalid category Id: " + id);
        }
    }

    // POST request to update category
    @PostMapping("/update/{id}")
    public String updateCategory(@PathVariable("id") Long id, @Valid Category
            category, BindingResult result, Model model) {
        if (result.hasErrors()) {
            category.setId(Math.toIntExact(id));
            return "/categories/update-category";
        }
        categoryService.updateCategory(category);
        model.addAttribute("categories", categoryService.findAll());
        return "redirect:/categories";
    }
    // GET request for deleting category
    @GetMapping("/delete/{id}")
    public String deleteCategory(@PathVariable("id") Integer id, Model model) {
        ResponseEntity<Optional<Category>> responseEntity = categoryService.getCategoryById(id);
        if (responseEntity.getStatusCode().is2xxSuccessful() && responseEntity.getBody().isPresent()) {
            categoryService.deleteCategoryById(id);
            model.addAttribute("categories", categoryService.findAll());
            return "redirect:/categories";
        } else {
            throw new IllegalArgumentException("Invalid category Id: " + id);
        }
    }

}