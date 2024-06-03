package com.group_eight.website_quan_li_hoat_dong_tu_thien.service;

import com.group_eight.website_quan_li_hoat_dong_tu_thien.model.Campaign;
import com.group_eight.website_quan_li_hoat_dong_tu_thien.repository.CampaignRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CampaignService {
    @Autowired
    private CampaignRepository campaignRepository;

    public List<Campaign> findAll() {
        return campaignRepository.findAll();
    }

    public List<Campaign> findByStatus(String status) {
        return campaignRepository.findByStatus(status);
    }

    public void save(Campaign campaign) {
        campaignRepository.save(campaign);
    }
}