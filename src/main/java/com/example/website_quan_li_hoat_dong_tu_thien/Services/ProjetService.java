package com.example.community.Services;

import com.example.community.Entity.Projet;
import com.example.community.dto.ProjetDto;


import java.util.List;

public interface ProjetService {
    List<ProjetDto> findAllProjet();
    Projet saveProjet(ProjetDto projetDto);
    ProjetDto findProjetById(Long projetId);
    void updateProjet(ProjetDto projet);
    void delete(Long ProjetId);
    List<ProjetDto> searchProjet(String query);
}
