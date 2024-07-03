package com.example.community.Mapper;

import com.example.community.Entity.Projet;
import com.example.community.dto.ProjetDto;

import java.util.ArrayList;

public class ProjetMapper {
    public static ProjetDto mapToProjetDto(Projet projet) {
        return ProjetDto.builder()
                .id(projet.getId())
                .title(projet.getTitle())
                .photoUrl(projet.getPhotoUrl())
                .content(projet.getContent())
                .amount(projet.getAmount())
                .totalAmount(projet.getTotalAmount())
                .createdBy(projet.getCreatedBy())
                .createdOn(projet.getCreatedOn())
                .updatedOn(projet.getUpdatedOn())
                .build();
    }

    public static Projet mapToProjet(ProjetDto projetDto) {
        Projet projet = Projet.builder()
                .id(projetDto.getId())
                .title(projetDto.getTitle())
                .photoUrl(projetDto.getPhotoUrl())
                .content(projetDto.getContent())
                .amount(projetDto.getAmount())
                .totalAmount(projetDto.getTotalAmount())
                .createdBy(projetDto.getCreatedBy())
                .createdOn(projetDto.getCreatedOn())
                .updatedOn(projetDto.getUpdatedOn())
                .build();
        projet.setParticipations(new ArrayList<>()); // Initialize the list
        return projet;
    }
}
