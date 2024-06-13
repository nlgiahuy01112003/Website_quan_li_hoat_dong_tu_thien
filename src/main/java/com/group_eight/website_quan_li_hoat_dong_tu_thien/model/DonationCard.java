package com.group_eight.website_quan_li_hoat_dong_tu_thien.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "donation_cards")
public class DonationCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private Double targetAmount;
    private LocalDate startDate;
    private LocalDate endDate;

    @ManyToOne
    @JoinColumn(name = "campaign_id")
    private Campaign campaign;

    public List<DonationDetail> getDonationDetails() {
        List<DonationDetail> donationDetails = List.of(displayDonationDetails());
        donationDetails.forEach(donationDetail -> donationDetail.setDonationCard(this));
        return donationDetails;
    }

    private DonationDetail displayDonationDetails() {
        DonationDetail donationDetail = new DonationDetail();
        donationDetail.setDescription("Display");
        donationDetail.setAmount(0.0);
        return donationDetail;
    }
}