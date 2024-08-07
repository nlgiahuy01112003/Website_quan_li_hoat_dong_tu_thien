package com.example.community.dto;

import com.example.community.Entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProjetDto {
    private Long id;
    private String title;
    private String photoUrl;
    private String content;
    private String amount;
    private String totalAmount;
    private UserEntity createdBy;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;
}
