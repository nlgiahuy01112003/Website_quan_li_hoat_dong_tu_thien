package com.example.community.Services;

import com.example.community.Entity.Projet;
import com.example.community.dto.ProjetDto;

import java.util.List;

public interface ProjetService {
    List<ProjetDto> findAllProjet();
    void saveProjet(Projet projet);
    ProjetDto findProjetById(Long id);
    void updateProjet(Projet projet);
    void updateProjet(ProjetDto projetDto);
    void deleteProjet(Long id);
    List<ProjetDto> searchProjet(String query);
}
