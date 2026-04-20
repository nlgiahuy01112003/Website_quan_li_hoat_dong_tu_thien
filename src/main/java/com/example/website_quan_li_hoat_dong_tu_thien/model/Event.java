package com.example.website_quan_li_hoat_dong_tu_thien.model;

import jakarta.persistence.*;

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

    public Event() {}

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public Category getCategory() { return category; }
    public void setCategory(Category category) { this.category = category; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getQuantityHave() { return quantityHave; }
    public void setQuantityHave(int quantityHave) { this.quantityHave = quantityHave; }
    public int getQuantityNeed() { return quantityNeed; }
    public void setQuantityNeed(int quantityNeed) { this.quantityNeed = quantityNeed; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    public String getDetail() { return detail; }
    public void setDetail(String detail) { this.detail = detail; }
    public String getImg1() { return img1; }
    public void setImg1(String img1) { this.img1 = img1; }
    public String getImg2() { return img2; }
    public void setImg2(String img2) { this.img2 = img2; }
    public String getImg3() { return img3; }
    public void setImg3(String img3) { this.img3 = img3; }
    public String getMeta() { return meta; }
    public void setMeta(String meta) { this.meta = meta; }
    public int getOrder() { return order; }
    public void setOrder(int order) { this.order = order; }
    public String getLink() { return link; }
    public void setLink(String link) { this.link = link; }
    public boolean isHide() { return hide; }
    public void setHide(boolean hide) { this.hide = hide; }
}