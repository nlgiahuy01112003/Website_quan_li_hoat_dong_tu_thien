package com.group_eight.website_quan_li_hoat_dong_tu_thien.service;
import com.group_eight.website_quan_li_hoat_dong_tu_thien.model.*;
import com.group_eight.website_quan_li_hoat_dong_tu_thien.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class SponsorshipService {
    @Autowired
    private SponsorshipRepository sponsorshipRepository;

    public List<Sponsorship> findByCampaign(Campaign campaign) {
        return sponsorshipRepository.findByCampaign(campaign);
    }

    public void save(Sponsorship sponsorship) {
        sponsorshipRepository.save(sponsorship);
    }
}