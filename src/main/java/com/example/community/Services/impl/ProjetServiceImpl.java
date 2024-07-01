package com.example.community.Services.impl;

import com.example.community.Entity.Projet;
import com.example.community.Entity.UserEntity;
import com.example.community.Mapper.ProjetMapper;
import com.example.community.Security.SecurityUtil;
import com.example.community.Services.ProjetService;
import com.example.community.dto.ProjetDto;
import com.example.community.repos.ProjetRepository;
import com.example.community.repos.UserRepository;
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
        projetRepository.deleteById(projetId);
    }

    @Override
    public List<ProjetDto> searchProjet(String query) {
        List<Projet> projets = projetRepository.searchProjets(query);
        return projets.stream().map(ProjetMapper::mapToProjetDto).collect(Collectors.toList());
    }
}
