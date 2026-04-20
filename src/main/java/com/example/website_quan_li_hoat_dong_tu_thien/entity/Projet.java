package com.example.website_quan_li_hoat_dong_tu_thien.entity;

import jakarta.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;


@Entity
@Table(name = "Projet")
public class Projet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String photoUrl;
    private String content;
    private String amount;
    private String totalAmount;

    @CreationTimestamp
    private LocalDateTime createdOn;

    @UpdateTimestamp
    private LocalDateTime updatedOn;

    @ManyToOne
    @JoinColumn(name = "created_by", nullable = false)
    private UserEntity createdBy;

    public Projet() {}

    public Projet(Long id, String title, String photoUrl, String content, String amount, String totalAmount, LocalDateTime createdOn, LocalDateTime updatedOn, UserEntity createdBy) {
        this.id = id;
        this.title = title;
        this.photoUrl = photoUrl;
        this.content = content;
        this.amount = amount;
        this.totalAmount = totalAmount;
        this.createdOn = createdOn;
        this.updatedOn = updatedOn;
        this.createdBy = createdBy;
    }

    public static ProjetBuilder builder() {
        return new ProjetBuilder();
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getPhotoUrl() { return photoUrl; }
    public void setPhotoUrl(String photoUrl) { this.photoUrl = photoUrl; }
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
    public String getAmount() { return amount; }
    public void setAmount(String amount) { this.amount = amount; }
    public String getTotalAmount() { return totalAmount; }
    public void setTotalAmount(String totalAmount) { this.totalAmount = totalAmount; }
    public LocalDateTime getCreatedOn() { return createdOn; }
    public void setCreatedOn(LocalDateTime createdOn) { this.createdOn = createdOn; }
    public LocalDateTime getUpdatedOn() { return updatedOn; }
    public void setUpdatedOn(LocalDateTime updatedOn) { this.updatedOn = updatedOn; }
    public UserEntity getCreatedBy() { return createdBy; }
    public void setCreatedBy(UserEntity createdBy) { this.createdBy = createdBy; }

    public static class ProjetBuilder {
        private Long id;
        private String title;
        private String photoUrl;
        private String content;
        private String amount;
        private String totalAmount;
        private LocalDateTime createdOn;
        private LocalDateTime updatedOn;
        private UserEntity createdBy;

        public ProjetBuilder id(Long id) { this.id = id; return this; }
        public ProjetBuilder title(String title) { this.title = title; return this; }
        public ProjetBuilder photoUrl(String photoUrl) { this.photoUrl = photoUrl; return this; }
        public ProjetBuilder content(String content) { this.content = content; return this; }
        public ProjetBuilder amount(String amount) { this.amount = amount; return this; }
        public ProjetBuilder totalAmount(String totalAmount) { this.totalAmount = totalAmount; return this; }
        public ProjetBuilder createdOn(LocalDateTime createdOn) { this.createdOn = createdOn; return this; }
        public ProjetBuilder updatedOn(LocalDateTime updatedOn) { this.updatedOn = updatedOn; return this; }
        public ProjetBuilder createdBy(UserEntity createdBy) { this.createdBy = createdBy; return this; }

        public Projet build() {
            return new Projet(id, title, photoUrl, content, amount, totalAmount, createdOn, updatedOn, createdBy);
        }
    }
}
