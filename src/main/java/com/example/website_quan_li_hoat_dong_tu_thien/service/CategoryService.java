package com.example.website_quan_li_hoat_dong_tu_thien.service;

import com.example.website_quan_li_hoat_dong_tu_thien.model.Category;
import com.example.website_quan_li_hoat_dong_tu_thien.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import jakarta.validation.constraints.NotNull;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    // Trong CategoryService
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }
    public Category findByLink(String link) {
        return categoryRepository.findByLink(link);
    }
    public ResponseEntity<Optional<Category>> getCategoryById(Integer id) {
        Optional<Category> category = categoryRepository.findById(id);
        if (category.isPresent()) {
            log.info("Category with ID {} found.", id);
            return ResponseEntity.ok(category);
        } else {
            log.warn("Category with ID {} not found.", id);
            return ResponseEntity.notFound().build();
        }
    }
    public ResponseEntity<Category> addCategory(@NotNull Category category) {
        if (category.getId() != 0 && categoryRepository.existsById(category.getId())) {
            log.warn("Category with ID {} already exists.", category.getId());
            return ResponseEntity.status(409).build(); // Conflict
        } else {
            Category savedCategory = categoryRepository.save(category);
            log.info("Category with ID {} created successfully.",
                    savedCategory.getId());
            return ResponseEntity.status(201).body(savedCategory); // Created
        }
    }
    public ResponseEntity<Category> updateCategory(@NotNull Category category) {
        Category existingCategory = categoryRepository.findById(category.getId())
                .orElseThrow(() -> new IllegalStateException(
                        "Category with ID " + category.getId() + " does not exist."));
        existingCategory.setName(category.getName());
        existingCategory.setMeta(category.getMeta());
        existingCategory.setOrder(category.getOrder());
        existingCategory.setLink(category.getLink());
        existingCategory.setHide(category.isHide());
        Category updatedCategory = categoryRepository.save(existingCategory);
        log.info("Category with ID {} updated successfully.",
                updatedCategory.getId());
        return ResponseEntity.ok(updatedCategory);
    }
    public ResponseEntity<Void> deleteCategoryById(int id) {
        if (!categoryRepository.existsById(id)) {
            log.warn("Category with ID {} does not exist.", id);
            return ResponseEntity.notFound().build();
        }
        categoryRepository.deleteById(id);
        log.info("Category with ID {} deleted successfully.", id);
        return ResponseEntity.noContent().build(); // No Content
    }

}
