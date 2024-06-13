package com.group_eight.website_quan_li_hoat_dong_tu_thien.service;

import com.group_eight.website_quan_li_hoat_dong_tu_thien.model.Volunteer;
import com.group_eight.website_quan_li_hoat_dong_tu_thien.repository.VolunteerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VolunteerService {
    @Autowired
    private VolunteerRepository volunteerRepository;

    public void save(Volunteer volunteer) {
        volunteerRepository.save(volunteer);
    }
}