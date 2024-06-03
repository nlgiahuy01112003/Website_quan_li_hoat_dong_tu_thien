package com.group_eight.website_quan_li_hoat_dong_tu_thien.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
@Entity
@Table(name = "sponsorships")
public class Sponsorship {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String sponsorName;
    private Double amount;

    @ManyToOne
    @JoinColumn(name = "campaign_id")
    private Campaign campaign;
}