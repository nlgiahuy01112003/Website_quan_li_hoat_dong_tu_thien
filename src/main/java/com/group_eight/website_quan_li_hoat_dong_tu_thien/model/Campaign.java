package com.group_eight.website_quan_li_hoat_dong_tu_thien.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Data
@Entity
@Table(name = "campaigns")
public class Campaign {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private String status; // "active", "completed", "upcoming"

    @OneToMany(mappedBy = "campaign")
    private List<Donation> donations;

    @OneToMany(mappedBy = "campaign")
    private List<Expense> expenses;

    @OneToMany(mappedBy = "campaign")
    private List<Event> events;
}