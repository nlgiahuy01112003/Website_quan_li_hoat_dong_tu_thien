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
public class EventService {
    private final EventRepository eventRepository;

    public List<Event> findAll() {
        return eventRepository.findAll();
    }

    public Optional<Event> getEventByLink(String link) {
        return eventRepository.findByLink(link);
    }

    public Optional<Event> findById(int id) {
        return eventRepository.findById(id);
    }

    public List<Event> getEventsByCategoryId(int categoryId) {
        return eventRepository.findByCategoryIdAndHideTrueOrderByOrderAsc(categoryId);
    }

    public Map<Category, List<Event>> getTop3EventsByCategory() {
        List<Event> allEvents = eventRepository.findAll();
        Map<Category, List<Event>> eventsByCategory = allEvents.stream()
                .filter(Event::isHide)
                .collect(Collectors.groupingBy(Event::getCategory));
        eventsByCategory.forEach((category, events) -> {
            List<Event> top3Events = events.stream()
                    .sorted(Comparator.comparingInt(Event::getOrder))
                    .limit(3)
                    .collect(Collectors.toList());
            eventsByCategory.put(category, top3Events);
        });
        return eventsByCategory;
    }

    public Map<Category, List<Event>> getTop6EventsByCategory() {
        List<Event> allEvents = eventRepository.findAll();
        Map<Category, List<Event>> eventsByCategory = allEvents.stream()
                .filter(Event::isHide)
                .collect(Collectors.groupingBy(Event::getCategory));
        eventsByCategory.forEach((category, events) -> {
            List<Event> top6Events = events.stream()
                    .sorted(Comparator.comparingInt(Event::getOrder))
                    .limit(6)
                    .collect(Collectors.toList());
            eventsByCategory.put(category, top6Events);
        });
        return eventsByCategory;
    }

    public Event addEvent(Event event) {
        return eventRepository.save(event);
    }

    public Event updateEvent(Event event) {
        Event existingEvent = eventRepository.findById((int) event.getId())
                .orElseThrow(() -> new IllegalStateException("Event with ID " + event.getId() + " does not exist."));
        existingEvent.setName(event.getName());
        existingEvent.setPrice(event.getPrice());
        existingEvent.setQuantityHave(event.getQuantityHave());
        existingEvent.setDetail(event.getDetail());
        existingEvent.setCategory(event.getCategory());
        existingEvent.setMeta(event.getMeta());
        existingEvent.setOrder(event.getOrder());
        existingEvent.setLink(event.getLink());
        existingEvent.setHide(event.isHide());
        return eventRepository.save(existingEvent);
    }

    public void deleteEventById(int id) {
        if (!eventRepository.existsById(id)) {
            throw new IllegalStateException("Event with ID " + id + " does not exist.");
        }
        eventRepository.deleteById(id);
    }
}
