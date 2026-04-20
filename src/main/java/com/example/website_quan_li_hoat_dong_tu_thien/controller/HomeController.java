package com.example.website_quan_li_hoat_dong_tu_thien.controller;

import com.example.website_quan_li_hoat_dong_tu_thien.model.*;
import com.example.website_quan_li_hoat_dong_tu_thien.service.BlogService;
import com.example.website_quan_li_hoat_dong_tu_thien.service.MenuService;
import com.example.website_quan_li_hoat_dong_tu_thien.service.EventService;
import com.example.website_quan_li_hoat_dong_tu_thien.service.SlideService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import java.util.Map;
@RequiredArgsConstructor
@RequestMapping("/trang-chu")
@Controller
public class HomeController {
    private final EventService eventService;
    private final BlogService blogService;
    private final MenuService menuService;
    private final SlideService slideService;
    @GetMapping
    public String Home(Model model){
        List<Blog> blogs = blogService.findAll();
        List<Menu> menus = menuService.findAll();
        List<Slide> slides = slideService.findAll();
        Map<Category, List<Event>> categoryEvents =
                eventService.getTop3EventsByCategory();
        model.addAttribute("categoryEvents", categoryEvents);
        model.addAttribute("slides", slides);
        model.addAttribute("blogs", blogs);
        model.addAttribute("menus", menus);
        return "Layout";
    }
}