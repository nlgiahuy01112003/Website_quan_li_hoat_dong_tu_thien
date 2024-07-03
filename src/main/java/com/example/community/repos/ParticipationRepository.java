package com.example.community.repos;

import com.example.community.Entity.Participation;
import com.example.community.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ParticipationRepository extends JpaRepository<Participation, Long> {
    List<Participation> findByUserAndProjetId(UserEntity user, Long projetId);
    boolean existsByUserAndProjetId(UserEntity user, Long projetId);

    @Query("SELECT p FROM Participation p WHERE p.projet.id = :projetId")
    List<Participation> findByProjetId(@Param("projetId") Long projetId);
}
