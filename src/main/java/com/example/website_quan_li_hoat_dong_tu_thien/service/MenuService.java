package com.example.website_quan_li_hoat_dong_tu_thien.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import jakarta.validation.constraints.NotNull;

import com.example.website_quan_li_hoat_dong_tu_thien.model.Menu;
import com.example.website_quan_li_hoat_dong_tu_thien.repository.MenuRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class MenuService {

    @Autowired
    private final MenuRepository menuRepository;

    // Get all menus
    public List<Menu> findAll() {
        return menuRepository.findAll();
    }

    // Get menu by ID
    public ResponseEntity<Optional<Menu>> getMenuById(Integer id) {
        if (id == null) {
            log.warn("Menu ID is null.");
            return ResponseEntity.badRequest().build();
        }
        Optional<Menu> menu = menuRepository.findById(id);
        if (menu.isPresent()) {
            log.info("Menu with ID {} found.", id);
            return ResponseEntity.ok(menu);
        } else {
            log.warn("Menu with ID {} not found.", id);
            return ResponseEntity.notFound().build();
        }
    }

    // Add new menu
    public ResponseEntity<Menu> addMenu(@NotNull Menu menu) {
        if (menu.getId() != 0 && menuRepository.existsById( menu.getId())) {
            log.warn("Menu with ID {} already exists.", menu.getId());
            return ResponseEntity.status(409).build(); // Conflict
        } else {
            Menu savedMenu = menuRepository.save(menu);
            log.info("Menu with ID {} created successfully.", savedMenu.getId());
            return ResponseEntity.status(201).body(savedMenu); // Created
        }
    }

    // Update existing menu
    public ResponseEntity<Menu> updateMenu(@NotNull Menu menu) {
        if (menu.getId() == 0) {
            log.warn("Menu ID is null, cannot update.");
            return ResponseEntity.badRequest().build(); // Bad Request
        }

        Menu existingMenu = menuRepository.findById( menu.getId())
                .orElseThrow(() -> new IllegalStateException(
                        "Menu with ID " + menu.getId() + " does not exist."));
        existingMenu.setTitle(menu.getTitle());
        existingMenu.setDateBegin(menu.getDateBegin());
        existingMenu.setMeta(menu.getMeta());
        existingMenu.setOrder(menu.getOrder());
        existingMenu.setLink(menu.getLink());
        existingMenu.setHide(menu.isHide());
        Menu updatedMenu = menuRepository.save(existingMenu);
        log.info("Menu with ID {} updated successfully.", updatedMenu.getId());
        return ResponseEntity.ok(updatedMenu);
    }

    // Delete menu by ID
    public ResponseEntity<Void> deleteMenuById(Integer id) {
        if (id == null) {
            log.warn("Menu ID is null.");
            return ResponseEntity.badRequest().build();
        }
        if (!menuRepository.existsById(id)) {
            log.warn("Menu with ID {} does not exist.", id);
            return ResponseEntity.notFound().build();
        }
        menuRepository.deleteById(id);
        log.info("Menu with ID {} deleted successfully.", id);
        return ResponseEntity.noContent().build(); // No Content
    }
}
