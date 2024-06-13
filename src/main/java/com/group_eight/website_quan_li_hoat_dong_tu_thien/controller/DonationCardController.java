package com.group_eight.website_quan_li_hoat_dong_tu_thien.controller;

import com.group_eight.website_quan_li_hoat_dong_tu_thien.model.DonationCard;
import com.group_eight.website_quan_li_hoat_dong_tu_thien.service.CampaignService;
import com.group_eight.website_quan_li_hoat_dong_tu_thien.service.DonationCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/donation-cards")
public class DonationCardController {
    @Autowired
    private DonationCardService donationCardService;

    @Autowired
    private CampaignService campaignService;

    @GetMapping
    public String listDonationCards(Model model) {
        model.addAttribute("donationCards", donationCardService.findAll());
        return "admin/donation_cards";
    }

    @GetMapping("/new")
    public String newDonationCard(Model model) {
        model.addAttribute("donationCard", new DonationCard());
        model.addAttribute("campaigns", campaignService.findAll());
        return "admin/donation_card_form";
    }

    @PostMapping
    public String saveDonationCard(@ModelAttribute DonationCard donationCard) {
        donationCardService.save(donationCard);
        return "redirect:/admin/donation-cards";
    }

    @GetMapping("/edit/{id}")
    public String editDonationCard(@PathVariable Long id, Model model) {
        model.addAttribute("donationCard", donationCardService.findById(id));
        model.addAttribute("campaigns", campaignService.findAll());
        return "admin/donation_card_form";
    }

    @GetMapping("/delete/{id}")
    public String deleteDonationCard(@PathVariable Long id) {
        donationCardService.deleteById(id);
        return "redirect:/admin/donation-cards";
    }
}