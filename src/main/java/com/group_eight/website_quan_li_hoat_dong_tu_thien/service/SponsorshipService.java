package com.group_eight.website_quan_li_hoat_dong_tu_thien.service;

import com.group_eight.website_quan_li_hoat_dong_tu_thien.model.Campaign;
import com.group_eight.website_quan_li_hoat_dong_tu_thien.model.Sponsorship;
import com.group_eight.website_quan_li_hoat_dong_tu_thien.repository.SponsorshipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SponsorshipService {
    @Autowired
    private SponsorshipRepository sponsorshipRepository;

    public List<Sponsorship> findByCampaign(Campaign campaign) {
        return sponsorshipRepository.findByCampaign(campaign);
    }

    public List<Sponsorship> findAll() {
        return sponsorshipRepository.findAll();
    }

    public void save(@NonNull Sponsorship sponsorship) {
        sponsorshipRepository.save(sponsorship);
    }
}