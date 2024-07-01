package com.example.community.repos;

import com.example.community.Entity.Projet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProjetRepository extends JpaRepository<Projet, Long> {
    Optional<Projet> findByTitle(String url);
    @Query("SELECT c from Projet c WHERE c.title LIKE CONCAT('%', :query, '%')")
    List<Projet> searchProjets(String query);
}
