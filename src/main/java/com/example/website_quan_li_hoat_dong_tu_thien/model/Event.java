package com.example.website_quan_li_hoat_dong_tu_thien.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.Set;
@Data
@Entity
@Table(name = "Event")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_EVENT")
    private int id;

    @ManyToOne
    @JoinColumn(name = "ID_CAT", referencedColumnName = "ID_CAT")
    private Category category;

    @Column(name = "NAME_EVENT", nullable = false)
    private String name;

    @Column(name = "QUANTITY_HAVE", nullable = false)
    private int quantityHave;

    @Column(name = "QUANTITY_NEED", nullable = false)
    private int quantityNeed;

    @Column(name = "PRICE")
    private double price;

    @Column(name = "DETAIL")
    private String detail;

    @Column(name = "IMG1")
    private String img1;

    @Column(name = "IMG2")
    private String img2;

    @Column(name = "IMG3")
    private String img3;

    @Column(name = "META")
    private String meta;

    @Column(name = "`ORDER`", nullable = false)
    private int order;

    @Column(name = "LINK")
    private String link;

    @Column(name = "HIDE", nullable = false)
    private boolean hide;

//    @OneToMany(mappedBy = "event")
//    private Set<CartDetail> cartDetails;
}