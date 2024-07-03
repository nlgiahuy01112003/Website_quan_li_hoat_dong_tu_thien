package com.example.community.Services.impl;

import com.example.community.Entity.Projet;
import com.example.community.Mapper.ProjetMapper;
import com.example.community.Services.ProjetService;
import com.example.community.dto.ProjetDto;
import com.example.community.repos.ProjetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjetServiceImpl implements ProjetService {

    private final ProjetRepository projetRepository;

    @Autowired
    public ProjetServiceImpl(ProjetRepository projetRepository) {
        this.projetRepository = projetRepository;
    }

    @Override
    public List<ProjetDto> findAllProjet() {
        return projetRepository.findAll().stream().map(ProjetMapper::mapToProjetDto).collect(Collectors.toList());
    }

    @Override
    public void saveProjet(Projet projet) {
        projetRepository.save(projet);
    }

    @Override
    public ProjetDto findProjetById(Long id) {
        Projet projet = projetRepository.findById(id).orElse(null);
        return ProjetMapper.mapToProjetDto(projet);
    }

    @Override
    public void updateProjet(Projet projet) {
        Projet existingProjet = projetRepository.findById(projet.getId()).orElseThrow(() -> new RuntimeException("Project not found"));

        existingProjet.setTitle(projet.getTitle());
        existingProjet.setPhotoUrl(projet.getPhotoUrl());
        existingProjet.setContent(projet.getContent());
        existingProjet.setAmount(projet.getAmount());
        existingProjet.setTotalAmount(projet.getTotalAmount());
        existingProjet.setCreatedBy(projet.getCreatedBy());
        existingProjet.setCreatedOn(projet.getCreatedOn());
        existingProjet.setUpdatedOn(projet.getUpdatedOn());

        existingProjet.getParticipations().clear();
        existingProjet.getParticipations().addAll(projet.getParticipations());

        projetRepository.save(existingProjet);
    }

    @Override
    public void updateProjet(ProjetDto projetDto) {
        Projet projet = ProjetMapper.mapToProjet(projetDto);
        projetRepository.save(projet);
    }

    @Override
    public void deleteProjet(Long id) {
        projetRepository.deleteById(id);
    }

    @Override
    public List<ProjetDto> searchProjet(String query) {
        return projetRepository.searchProjets(query).stream().map(ProjetMapper::mapToProjetDto).collect(Collectors.toList());
    }
}
