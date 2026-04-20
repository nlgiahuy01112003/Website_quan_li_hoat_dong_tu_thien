package com.example.website_quan_li_hoat_dong_tu_thien.controller;

import com.example.website_quan_li_hoat_dong_tu_thien.model.Category;
import com.example.website_quan_li_hoat_dong_tu_thien.model.Event;
import com.example.website_quan_li_hoat_dong_tu_thien.service.CategoryService;
import com.example.website_quan_li_hoat_dong_tu_thien.service.EventService;
import com.example.website_quan_li_hoat_dong_tu_thien.service.MenuService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping("/events")
@RequiredArgsConstructor
@Slf4j
public class EventController {
    private final CategoryService categoryService;
    private final MenuService menuService;
    private final EventService eventService;

    @GetMapping
    public String showEventList(Model model) {
        List<Event> events = eventService.findAll();
        model.addAttribute("events", events);
        return "events/event-list";
    }

    @GetMapping("/detail/{link}")
    public String eventDetail(@PathVariable String link, Model model) {
        Optional<Event> eventOpt = eventService.getEventByLink(link);
        if (eventOpt.isPresent()) {
            model.addAttribute("event", eventOpt.get());
            addCommonAttributes(model);
            return "events/event-detail";
        } else {
            return "error"; // Handle the case when the event is not found
        }
    }

    @GetMapping("/{category}")
    public String eventCategory(@PathVariable String category, Model model) {
        Category cat = categoryService.findByLink(category);
        if (cat == null) {
            return "error"; // Handle the case when the category is not found
        }
        List<Event> eventsForCategory = eventService.getEventsByCategoryId(cat.getId());
        model.addAttribute("categoryName", cat.getName());
        model.addAttribute("eventsForCategory", eventsForCategory);
        addCommonAttributes(model);
        return "events/event-category";
    }

    private void addCommonAttributes(Model model) {
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("menus", menuService.findAll());
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("event", new Event());
        model.addAttribute("categories", categoryService.findAll());
        return "events/add-event";
    }

    @PostMapping("/add")
    public String addEvent(@Valid Event event, BindingResult result) {
        if (result.hasErrors()) {
            return "events/add-event";
        }
        eventService.addEvent(event);
        return "redirect:/events";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable int id, Model model) {
        Event event = eventService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Event not found: " + id));
        model.addAttribute("event", event);
        model.addAttribute("categories", categoryService.findAll());
        return "events/edit-event";
    }

    @PostMapping("/update/{id}")
    public String updateEvent(@PathVariable int id, @Valid Event event, BindingResult result) {
        if (result.hasErrors()) {
            event.setId(id);
            return "events/edit-event";
        }
        eventService.updateEvent(event);
        return "redirect:/events";
    }

    @GetMapping("/delete/{id}")
    public String deleteEvent(@PathVariable int id) {
        eventService.deleteEventById(id);
        return "redirect:/events";
    }
}
