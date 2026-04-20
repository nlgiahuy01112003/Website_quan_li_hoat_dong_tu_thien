package com.example.website_quan_li_hoat_dong_tu_thien.dto;

import com.example.website_quan_li_hoat_dong_tu_thien.entity.UserEntity; 
import jakarta.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

public class ProjetDto {
    private Long id;

    @NotEmpty(message = "Club title should not be empty")
    private String title;

    @NotEmpty(message = "Photo link should not be empty")
    private String photoUrl;

    @NotEmpty(message = "Content should not be empty")
    private String content;

    private UserEntity createdBy;

    private LocalDateTime createdOn;

    private LocalDateTime updatedOn;

    private String amount;

    private String totalAmount;

    public ProjetDto() {}

    public ProjetDto(Long id, String title, String photoUrl, String content, UserEntity createdBy, LocalDateTime createdOn, LocalDateTime updatedOn, String amount, String totalAmount) {
        this.id = id;
        this.title = title;
        this.photoUrl = photoUrl;
        this.content = content;
        this.createdBy = createdBy;
        this.createdOn = createdOn;
        this.updatedOn = updatedOn;
        this.amount = amount;
        this.totalAmount = totalAmount;
    }

    public static ProjetDtoBuilder builder() {
        return new ProjetDtoBuilder();
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getPhotoUrl() { return photoUrl; }
    public void setPhotoUrl(String photoUrl) { this.photoUrl = photoUrl; }
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
    public UserEntity getCreatedBy() { return createdBy; }
    public void setCreatedBy(UserEntity createdBy) { this.createdBy = createdBy; }
    public LocalDateTime getCreatedOn() { return createdOn; }
    public void setCreatedOn(LocalDateTime createdOn) { this.createdOn = createdOn; }
    public LocalDateTime getUpdatedOn() { return updatedOn; }
    public void setUpdatedOn(LocalDateTime updatedOn) { this.updatedOn = updatedOn; }
    public String getAmount() { return amount; }
    public void setAmount(String amount) { this.amount = amount; }
    public String getTotalAmount() { return totalAmount; }
    public void setTotalAmount(String totalAmount) { this.totalAmount = totalAmount; }

    public static class ProjetDtoBuilder {
        private Long id;
        private String title;
        private String photoUrl;
        private String content;
        private UserEntity createdBy;
        private LocalDateTime createdOn;
        private LocalDateTime updatedOn;
        private String amount;
        private String totalAmount;

        public ProjetDtoBuilder id(Long id) { this.id = id; return this; }
        public ProjetDtoBuilder title(String title) { this.title = title; return this; }
        public ProjetDtoBuilder photoUrl(String photoUrl) { this.photoUrl = photoUrl; return this; }
        public ProjetDtoBuilder content(String content) { this.content = content; return this; }
        public ProjetDtoBuilder createdBy(UserEntity createdBy) { this.createdBy = createdBy; return this; }
        public ProjetDtoBuilder createdOn(LocalDateTime createdOn) { this.createdOn = createdOn; return this; }
        public ProjetDtoBuilder updatedOn(LocalDateTime updatedOn) { this.updatedOn = updatedOn; return this; }
        public ProjetDtoBuilder amount(String amount) { this.amount = amount; return this; }
        public ProjetDtoBuilder totalAmount(String totalAmount) { this.totalAmount = totalAmount; return this; }

        public ProjetDto build() {
            return new ProjetDto(id, title, photoUrl, content, createdBy, createdOn, updatedOn, amount, totalAmount);
        }
    }
}
