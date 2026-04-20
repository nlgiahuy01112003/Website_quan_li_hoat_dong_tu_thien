package com.example.website_quan_li_hoat_dong_tu_thien.model;

import jakarta.persistence.*;
import java.util.Set;


@Entity
@Table(name = "Category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CAT")
    private int id;

    @Column(name = "NAME_CAT", nullable = false)
    private String name;

    @Column(name = "META")
    private String meta;

    @Column(name = "`ORDER`", nullable = false)
    private int order;

    @Column(name = "LINK")
    private String link;

    @Column(name = "HIDE", nullable = false)
    private boolean hide;

    @OneToMany(mappedBy = "category")
    private Set<Event> events;

    public Category() {}

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getMeta() { return meta; }
    public void setMeta(String meta) { this.meta = meta; }
    public int getOrder() { return order; }
    public void setOrder(int order) { this.order = order; }
    public String getLink() { return link; }
    public void setLink(String link) { this.link = link; }
    public boolean isHide() { return hide; }
    public void setHide(boolean hide) { this.hide = hide; }
    public Set<Event> getEvents() { return events; }
    public void setEvents(Set<Event> events) { this.events = events; }
}
