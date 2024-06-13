package com.group_eight.website_quan_li_hoat_dong_tu_thien.repository;

import com.group_eight.website_quan_li_hoat_dong_tu_thien.model.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SponsorshipRepository extends JpaRepository<Sponsorship, Long> {
    List<Sponsorship> findByCampaign(Campaign campaign);
}