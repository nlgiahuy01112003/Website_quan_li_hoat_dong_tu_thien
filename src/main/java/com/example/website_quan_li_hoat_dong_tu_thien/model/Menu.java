package com.example.website_quan_li_hoat_dong_tu_thien.model;

import jakarta.persistence.*;


@Entity
@Table(name = "Menu")
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_MENU")
    private int id;

    @Column(name = "TITLE", nullable = false)
    private String title;

    @Column(name = "DATEBEGIN", nullable = false)
    private java.sql.Date dateBegin;

    @Column(name = "META")
    private String meta;

    @Column(name = "`ORDER`", nullable = false)
    private int order;

    @Column(name = "LINK")
    private String link;

    @Column(name = "HIDE", nullable = false)
    private boolean hide;

    public Menu() {}

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public java.sql.Date getDateBegin() { return dateBegin; }
    public void setDateBegin(java.sql.Date dateBegin) { this.dateBegin = dateBegin; }
    public String getMeta() { return meta; }
    public void setMeta(String meta) { this.meta = meta; }
    public int getOrder() { return order; }
    public void setOrder(int order) { this.order = order; }
    public String getLink() { return link; }
    public void setLink(String link) { this.link = link; }
    public boolean isHide() { return hide; }
    public void setHide(boolean hide) { this.hide = hide; }
}

