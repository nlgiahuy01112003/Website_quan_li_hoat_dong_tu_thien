package com.group_eight.website_quan_li_hoat_dong_tu_thien.service;

import com.group_eight.website_quan_li_hoat_dong_tu_thien.model.DonationCard;
import com.group_eight.website_quan_li_hoat_dong_tu_thien.repository.DonationCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DonationCardService {
    @Autowired
    private DonationCardRepository donationCardRepository;

    public List<DonationCard> findAll() {
        return donationCardRepository.findAll();
    }

    public DonationCard findById(@NonNull Long id) {
        return donationCardRepository.findById(id).orElse(null);
    }

    public void save(@NonNull DonationCard donationCard) {
        donationCardRepository.save(donationCard);
    }

    public void deleteById(@NonNull Long id) {
        donationCardRepository.deleteById(id);
    }
}