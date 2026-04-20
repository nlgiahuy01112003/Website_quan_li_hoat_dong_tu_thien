package com.example.website_quan_li_hoat_dong_tu_thien.service;

import com.example.website_quan_li_hoat_dong_tu_thien.entity.Projet;
import com.example.website_quan_li_hoat_dong_tu_thien.dto.ProjetDto;


import java.util.List;

public interface ProjetService {
    List<ProjetDto> findAllProjet();
    Projet saveProjet(ProjetDto projetDto);
    ProjetDto findProjetById(Long projetId);
    void updateProjet(ProjetDto projet);
    void delete(Long ProjetId);
    List<ProjetDto> searchProjet(String query);
}
