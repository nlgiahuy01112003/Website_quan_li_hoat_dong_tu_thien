package com.group_eight.website_quan_li_hoat_dong_tu_thien.controller;

import com.group_eight.website_quan_li_hoat_dong_tu_thien.model.Donation;
import com.group_eight.website_quan_li_hoat_dong_tu_thien.model.DonationCard;
import com.group_eight.website_quan_li_hoat_dong_tu_thien.model.User;
import com.group_eight.website_quan_li_hoat_dong_tu_thien.service.DonationCardService;
import com.group_eight.website_quan_li_hoat_dong_tu_thien.service.DonationService;
import com.group_eight.website_quan_li_hoat_dong_tu_thien.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
@RequestMapping("/donation-cards")
public class UserDonationCardController {
    @Autowired
    private DonationCardService donationCardService;

    @Autowired
    private DonationService donationService;

    @Autowired
    private UserService userService;

    @GetMapping
    public String listDonationCards(Model model) {
        model.addAttribute("donationCards", donationCardService.findAll());
        return "user/donation_cards";
    }

    @GetMapping("/{id}")
    public String viewDonationCard(@PathVariable Long id, Model model) {
        model.addAttribute("donationCard", donationCardService.findById(id));
        return "user/donation_card_detail";
    }

    @PostMapping("/donate")
    public String donate(@RequestParam Long cardId, @RequestParam Double amount, Authentication authentication) {
        DonationCard donationCard = donationCardService.findById(cardId);
        User user = userService.findByUsername(authentication.getName());

        Donation donation = new Donation();
        donation.setAmount(amount);
        donation.setDate(LocalDate.now());
        donation.setDonationCard(donationCard);
        donation.setUser(user);

        donationService.save(donation);
        return "redirect:/donation-cards";
    }
}