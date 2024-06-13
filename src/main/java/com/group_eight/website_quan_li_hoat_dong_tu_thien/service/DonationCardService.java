package com.group_eight.website_quan_li_hoat_dong_tu_thien.service;

import com.group_eight.website_quan_li_hoat_dong_tu_thien.model.DonationCard;
import com.group_eight.website_quan_li_hoat_dong_tu_thien.repository.DonationCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DonationCardService {
    @Autowired
    private DonationCardRepository donationCardRepository;

    public List<DonationCard> findAll() {
        return donationCardRepository.findAll();
    }

    public DonationCard findById(Long id) {
        return donationCardRepository.findById(id).orElse(null);
    }

    public void save(DonationCard donationCard) {
        donationCardRepository.save(donationCard);
    }

    public void deleteById(Long id) {
        donationCardRepository.deleteById(id);
    }
}