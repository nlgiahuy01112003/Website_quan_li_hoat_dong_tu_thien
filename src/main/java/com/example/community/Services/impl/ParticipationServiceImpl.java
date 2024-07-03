package com.example.community.Services.impl;

import com.example.community.Entity.Participation;
import com.example.community.Entity.UserEntity;
import com.example.community.repos.ParticipationRepository;
import com.example.community.Services.ParticipationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParticipationServiceImpl implements ParticipationService {

    private final ParticipationRepository participationRepository;

    @Autowired
    public ParticipationServiceImpl(ParticipationRepository participationRepository) {
        this.participationRepository = participationRepository;
    }

    @Override
    public boolean hasParticipated(UserEntity user, Long projetId) {
        return participationRepository.existsByUserAndProjetId(user, projetId);
    }

    @Override
    public void saveParticipation(Participation participation) {
        participationRepository.save(participation);
    }

    @Override
    public void deleteParticipation(Long id) {
        participationRepository.deleteById(id);
    }

    @Override
    public List<Participation> findByProjetId(Long projetId) {
        return participationRepository.findByProjetId(projetId);
    }

    @Override
    public List<Participation> findAllParticipations() {
        return participationRepository.findAll();
    }
}
