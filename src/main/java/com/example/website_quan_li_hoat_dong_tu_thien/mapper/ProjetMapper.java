package com.example.website_quan_li_hoat_dong_tu_thien.mapper;

import com.example.website_quan_li_hoat_dong_tu_thien.dto.ProjetDto;
import com.example.website_quan_li_hoat_dong_tu_thien.entity.Projet;

public class ProjetMapper {

    public static Projet mapToProjet(ProjetDto projetDto) {
        return Projet.builder()
                .id(projetDto.getId())
                .title(projetDto.getTitle())
                .photoUrl(projetDto.getPhotoUrl())
                .content(projetDto.getContent())
                .amount(projetDto.getAmount())
                .totalAmount(projetDto.getTotalAmount())
                .createdOn(projetDto.getCreatedOn())
                .createdBy(projetDto.getCreatedBy())
                .updatedOn(projetDto.getUpdatedOn())
                .build();
    }

    public static ProjetDto mapToProjetDto(Projet projet) {
        return ProjetDto.builder()
                .id(projet.getId())
                .title(projet.getTitle())
                .photoUrl(projet.getPhotoUrl())
                .content(projet.getContent())
                .amount(projet.getAmount())
                .totalAmount(projet.getTotalAmount())
                .createdOn(projet.getCreatedOn())
                .createdBy(projet.getCreatedBy())
                .updatedOn(projet.getUpdatedOn())
                .build();
    }
}
