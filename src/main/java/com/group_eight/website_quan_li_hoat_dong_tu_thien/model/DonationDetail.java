package com.group_eight.website_quan_li_hoat_dong_tu_thien.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
@Entity
@Table(name = "donation_details")
public class DonationDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private Double amount;

    @ManyToOne
    @JoinColumn(name = "donation_id")
    private DonationCard donation;

    public void setDonationCard(DonationCard donationCard) {
        this.donation = donationCard;
    }
}