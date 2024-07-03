package com.example.community.Services;

import com.example.community.Entity.Participation;
import com.example.community.Entity.UserEntity;

import java.util.List;

public interface ParticipationService {
    boolean hasParticipated(UserEntity user, Long projectId);
    void saveParticipation(Participation participation);
    void deleteParticipation(Long id);
    List<Participation> findByProjetId(Long projectId);
    List<Participation> findAllParticipations();
}
