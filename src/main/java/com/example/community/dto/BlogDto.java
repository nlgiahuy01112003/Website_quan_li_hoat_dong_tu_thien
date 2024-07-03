package com.example.community.dto;

import com.example.community.Entity.UserEntity;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BlogDto {
    private Long id;

    @NotEmpty(message = "Title should not be empty")
    private String title;

    @NotEmpty(message = "Content should not be empty")
    private String content;

    private String imageUrl; // New field for image URL

    private LocalDateTime createdOn;

    private LocalDateTime updatedOn;

    private UserEntity createdBy; // New field for creator
}
