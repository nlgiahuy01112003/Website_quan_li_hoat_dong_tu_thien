package com.example.community.Mapper;

import com.example.community.dto.ProjetDto;
import com.example.community.Entity.Projet;

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
