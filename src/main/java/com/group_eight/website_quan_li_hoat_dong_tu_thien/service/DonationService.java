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

import java.util.List;
@Service
public class DonationService {
    @Autowired
    private DonationRepository donationRepository;

    @Autowired
    private JavaMailSender mailSender;

    public List<Donation> findByCampaign(Campaign campaign) {
        return donationRepository.findByCampaign(campaign);
    }

    public void save(Donation donation) {
        donationRepository.save(donation);
        sendThankYouEmail(donation);
    }

    private void sendThankYouEmail(Donation donation) {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        String subject = "Thank you for your donation!";
        String content = "<p>Hello, " + donation.getUser().getUsername() + "</p>"
                + "<p>Thank you for your generous donation of $" + donation.getAmount() + " to the campaign " + donation.getCampaign().getName() + ".</p>";

        try {
            helper.setTo(donation.getUser().getEmail());
            helper.setSubject(subject);
            helper.setText(content, true);
            mailSender.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
