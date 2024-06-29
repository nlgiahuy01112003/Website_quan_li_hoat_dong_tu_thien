package com.example.website_quan_li_hoat_dong_tu_thien.service;

import com.example.website_quan_li_hoat_dong_tu_thien.model.Category;
import com.example.website_quan_li_hoat_dong_tu_thien.model.Event;
import com.example.website_quan_li_hoat_dong_tu_thien.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class ProductService {
    private final EventRepository productRepository;
    public List<Event> findAll() {
        return productRepository.findAll();
    }
    public Optional<Event> getProductByLink(String link) {
        return productRepository.findByLink(link);
    }
    public List<Event> getProductsByCategoryId(int categoryId) {
        return
                productRepository.findByCategoryIdAndHideTrueOrderByOrderAsc(categoryId);
    }
    public Map<Category, List<Event>> getTop3ProductsByCategory() {
        List<Event> allProducts = productRepository.findAll();
        Map<Category, List<Event>> productsByCategory = allProducts.stream()
                .filter(Event::isHide)
                .collect(Collectors.groupingBy(Event::getCategory));
        productsByCategory.forEach((category, products) -> {
            List<Event> top3Products = products.stream()
                    .sorted(Comparator.comparingInt(Event::getOrder))
                    .limit(3)
                    .collect(Collectors.toList());
            productsByCategory.put(category, top3Products);
        });
        return productsByCategory;
    }
    public Map<Category, List<Event>> getTop6ProductsByCategory() {
        List<Event> allProducts = productRepository.findAll();
        Map<Category, List<Event>> productsByCategory = allProducts.stream()
                .filter(Event::isHide)
                .collect(Collectors.groupingBy(Event::getCategory));
        productsByCategory.forEach((category, products) -> {
            List<Event> top6Products = products.stream()
                    .sorted(Comparator.comparingInt(Event::getOrder))
                    .limit(6)
                    .collect(Collectors.toList());
            productsByCategory.put(category, top6Products);
        });
        return productsByCategory;
    }
    public Event addProduct(Event product) {
        return productRepository.save(product);
    }
    public Event updateProduct(Event product) {
        Event existingProduct = productRepository.findById((int) product.getId())
                .orElseThrow(() -> new IllegalStateException("Product with ID " +
                        product.getId() + " does not exist."));
        existingProduct.setName(product.getName());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setQuantityHave(product.getQuantityHave());
        existingProduct.setDetail(product.getDetail());
        existingProduct.setCategory(product.getCategory());
        existingProduct.setMeta(product.getMeta());
        existingProduct.setOrder(product.getOrder());
        existingProduct.setLink(product.getLink());
        existingProduct.setHide(product.isHide());
        return productRepository.save(existingProduct);
    }

    public void deleteProductById(int id) {
        if (!productRepository.existsById(id)) {
            throw new IllegalStateException("Product with ID " + id + " does not exist.");
        }
        productRepository.deleteById(id);
    }
} 