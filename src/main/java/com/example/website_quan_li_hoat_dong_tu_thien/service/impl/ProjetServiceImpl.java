package com.example.website_quan_li_hoat_dong_tu_thien.service.impl;

import com.example.website_quan_li_hoat_dong_tu_thien.entity.Projet;
import com.example.website_quan_li_hoat_dong_tu_thien.entity.UserEntity; 
import com.example.website_quan_li_hoat_dong_tu_thien.mapper.ProjetMapper;
import com.example.website_quan_li_hoat_dong_tu_thien.security.SecurityUtil;
import com.example.website_quan_li_hoat_dong_tu_thien.service.ProjetService;
import com.example.website_quan_li_hoat_dong_tu_thien.dto.ProjetDto;
import com.example.website_quan_li_hoat_dong_tu_thien.repository.ProjetRepository;
import com.example.website_quan_li_hoat_dong_tu_thien.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjetServiceImpl implements ProjetService {

    private final ProjetRepository projetRepository;
    private final UserRepository userRepository;

    @Autowired
    public ProjetServiceImpl(ProjetRepository projetRepository, UserRepository userRepository) {
        this.projetRepository = projetRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<ProjetDto> findAllProjet() {
        List<Projet> projets = projetRepository.findAll();
        return projets.stream().map(ProjetMapper::mapToProjetDto).collect(Collectors.toList());
    }

    @Override
    public Projet saveProjet(ProjetDto projetDto) {
        String username = SecurityUtil.getSessionUser();
        UserEntity user = userRepository.findByUsername(username);
        Projet projet = ProjetMapper.mapToProjet(projetDto);
        projet.setCreatedBy(user);
        projet.setCreatedOn(LocalDateTime.now());
        projet.setUpdatedOn(LocalDateTime.now());
        return projetRepository.save(projet);
    }

    @Override
    public ProjetDto findProjetById(Long projetId) {
        if (projetId == null) {
            throw new IllegalArgumentException("Project ID cannot be null");
        }
        Projet projet = projetRepository.findById(projetId).orElseThrow(() -> new RuntimeException("Project not found"));
        return ProjetMapper.mapToProjetDto(projet);
    }

    @Override
    public void updateProjet(ProjetDto projetDto) {
        String username = SecurityUtil.getSessionUser();
        UserEntity user = userRepository.findByUsername(username);
        Projet projet = ProjetMapper.mapToProjet(projetDto);
        projet.setCreatedBy(user);
        projet.setUpdatedOn(LocalDateTime.now());
        projetRepository.save(projet);
    }

    @Override
    public void delete(Long projetId) {
        if (projetId == null) {
            throw new IllegalArgumentException("Project ID cannot be null");
        }
        projetRepository.deleteById(projetId);
    }

    @Override
    public List<ProjetDto> searchProjet(String query) {
        List<Projet> projets = projetRepository.searchProjets(query);
        return projets.stream().map(ProjetMapper::mapToProjetDto).collect(Collectors.toList());
    }
}
