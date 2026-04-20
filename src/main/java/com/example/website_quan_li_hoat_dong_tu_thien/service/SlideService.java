package com.example.website_quan_li_hoat_dong_tu_thien.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import jakarta.validation.constraints.NotNull;

import com.example.website_quan_li_hoat_dong_tu_thien.model.Slide;
import com.example.website_quan_li_hoat_dong_tu_thien.repository.SlideRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class SlideService {
    @Autowired
    private final SlideRepository slideRepository;

    // Get all slides
    public List<Slide> findAll() {
        return slideRepository.findAll();
    }

    // Get slide by ID
    public ResponseEntity<Optional<Slide>> getSlideById(Long id) {
        if (id == null) {
            log.warn("Slide ID is null.");
            return ResponseEntity.badRequest().build();
        }
        Optional<Slide> slide = slideRepository.findById(id);
        if (slide.isPresent()) {
            log.info("Slide with ID {} found.", id);
            return ResponseEntity.ok(slide);
        } else {
            log.warn("Slide with ID {} not found.", id);
            return ResponseEntity.notFound().build();
        }
    }

    // Add new slide
    public ResponseEntity<Slide> addSlide(@NotNull Slide slide) {
        if (slide.getId() != 0 && slideRepository.existsById((long) slide.getId())) {
            log.warn("Slide with ID {} already exists.", slide.getId());
            return ResponseEntity.status(409).build(); // Conflict
        } else {
            Slide savedSlide = slideRepository.save(slide);
            log.info("Slide with ID {} created successfully.", savedSlide.getId());
            return ResponseEntity.status(201).body(savedSlide); // Created
        }
    }

    // Update existing slide
    public ResponseEntity<Slide> updateSlide(@NotNull Slide slide) {
        if (slide.getId() == 0) {
            log.warn("Slide ID is null, cannot update.");
            return ResponseEntity.badRequest().build(); // Bad Request
        }

        Slide existingSlide = slideRepository.findById((long) slide.getId())
                .orElseThrow(() -> new IllegalStateException(
                        "Slide with ID " + slide.getId() + " does not exist."));
        existingSlide.setTitle(slide.getTitle());
        existingSlide.setDateBegin(slide.getDateBegin());
        existingSlide.setMeta(slide.getMeta());
        existingSlide.setOrder(slide.getOrder());
        existingSlide.setLink(slide.getLink());
        existingSlide.setHide(slide.isHide());
        Slide updatedSlide = slideRepository.save(existingSlide);
        log.info("Slide with ID {} updated successfully.", updatedSlide.getId());
        return ResponseEntity.ok(updatedSlide);
    }

    // Delete slide by ID
    public ResponseEntity<Void> deleteSlideById(Long id) {
        if (id == null) {
            log.warn("Slide ID is null.");
            return ResponseEntity.badRequest().build();
        }
        if (!slideRepository.existsById(id)) {
            log.warn("Slide with ID {} does not exist.", id);
            return ResponseEntity.notFound().build();
        }
        slideRepository.deleteById(id);
        log.info("Slide with ID {} deleted successfully.", id);
        return ResponseEntity.noContent().build(); // No Content
    }
}
