package com.example.website_quan_li_hoat_dong_tu_thien.controller;

import com.example.website_quan_li_hoat_dong_tu_thien.service.*;
import com.example.website_quan_li_hoat_dong_tu_thien.model.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;
@Controller
@RequestMapping("/products")
@RequiredArgsConstructor
@Slf4j
public class EventController {
    private final CategoryService categoryService;
    private final MenuService menuService;
    private final ProductService productService;
    @GetMapping
    public String showProductList(Model model) {
        List<Menu> menus = menuService.findAll();
        Map<Category, List<Event>> categoryProducts =
                productService.getTop6ProductsByCategory();
        model.addAttribute("categoryProducts", categoryProducts);
        model.addAttribute("menus", menus);
        return "/products/product-list";
    }
    @GetMapping("/detail/{link}")
    public String productDetail(@PathVariable String link, Model model) {
        Optional<Event> productOpt = productService.getProductByLink(link);
        if (productOpt.isPresent()) {
            model.addAttribute("product", productOpt.get());
            addCommonAttributes(model);
            return "/products/productDetail";
        } else {
            return "error"; // Handle the case when the product is not found
        }
    }
    @GetMapping("/{category}")
    public String ProductCategory(Model model, @PathVariable String category,
                                  @RequestParam(name = "page", defaultValue = "0") int page) {
        Category cat = categoryService.findByLink(category);
        if (cat == null) {
            return "error"; // Xử lý khi không tìm thấy danh mục
        }
        int categoryId = cat.getId();
        List<Event> productsForCategory =
                productService.getProductsByCategoryId(categoryId);
        model.addAttribute("categoryName", cat.getName());
        model.addAttribute("productsForCategory", productsForCategory);
        addCommonAttributes(model);
        return "products/product";
    }
    private void addCommonAttributes(Model model) {
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("menus", menuService.findAll());
    }
    // For adding a new product 
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("product", new Event());
        model.addAttribute("categories", categoryService.findAll());
        return "/products/add-product";
    }
    // Process the form for adding a new product 
    @PostMapping("/add")
    public String addProduct(@Valid Event product, BindingResult result) {
        if (result.hasErrors()) {
            return "/products/add-product";
        }
        productService.addProduct(product);
        return "redirect:/products";
    }
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable String link, Model model) {
        Optional<Event> productOptional = productService.getProductByLink(link);
        if (productOptional.isPresent()) {
            Event product = productOptional.get();
            model.addAttribute("product", product);
            model.addAttribute("categories", categoryService.findAll());
            return "/products/update-product";
        } else {
            throw new IllegalArgumentException("Invalid product Id: " + link);
        }
    }
    @PostMapping("/update/{id}")
    public String updateProduct(@PathVariable Long id, @Valid Event product,
                                BindingResult result) {
        if (result.hasErrors()) {
            product.setId(Math.toIntExact(id));
            return "/products/update-product";
        }
        productService.updateProduct(product);
        return "redirect:/products";
    }
    // Handle request to delete a product 
    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.deleteProductById(Math.toIntExact(id));
        return "redirect:/products";
    }
} 
