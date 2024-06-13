package com.group_eight.website_quan_li_hoat_dong_tu_thien.service;

import com.group_eight.website_quan_li_hoat_dong_tu_thien.model.Campaign;
import com.group_eight.website_quan_li_hoat_dong_tu_thien.model.Event;
import com.group_eight.website_quan_li_hoat_dong_tu_thien.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {
    @Autowired
    private EventRepository eventRepository;

    public List<Event> findByCampaign(Campaign campaign) {
        return eventRepository.findByCampaign(campaign);
    }

    public void save(Event event) {
        eventRepository.save(event);
    }

    public Object findAll() {
        return eventRepository.findAll();
    }
}