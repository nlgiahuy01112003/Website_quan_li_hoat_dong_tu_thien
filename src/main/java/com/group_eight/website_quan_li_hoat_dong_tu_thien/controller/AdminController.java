package com.group_eight.website_quan_li_hoat_dong_tu_thien.controller;

import com.group_eight.website_quan_li_hoat_dong_tu_thien.model.*;
import com.group_eight.website_quan_li_hoat_dong_tu_thien.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private CampaignService campaignService;

    @Autowired
    private EventService eventService;

    @Autowired
    private DonationService donationService;

    @Autowired
    private ExpenseService expenseService;

    @Autowired
    private SponsorshipService sponsorshipService;

    @GetMapping("/campaigns")
    public String listCampaigns(Model model) {
        model.addAttribute("campaigns", campaignService.findAll());
        return "admin/campaigns";
    }

    @GetMapping("/campaigns/new")
    public String newCampaign(Model model) {
        model.addAttribute("campaign", new Campaign());
        return "admin/campaign_form";
    }

    @PostMapping("/campaigns")
    public String saveCampaign(@ModelAttribute Campaign campaign) {
        campaignService.save(campaign);
        return "redirect:/admin/campaigns";
    }

    @GetMapping("/events")
    public String listEvents(Model model) {
        model.addAttribute("events", eventService.findAll());
        return "admin/events";
    }

    @GetMapping("/events/new")
    public String newEvent(Model model) {
        model.addAttribute("event", new Event());
        return "admin/event_form";
    }

    @PostMapping("/events")
    public String saveEvent(@ModelAttribute Event event) {
        eventService.save(event);
        return "redirect:/admin/events";
    }

    @GetMapping("/donations")
    public String listDonations(Model model) {
        model.addAttribute("donations", donationService.findAll());
        return "admin/donations";
    }

    @GetMapping("/expenses")
    public String listExpenses(Model model) {
        model.addAttribute("expenses", expenseService.findAll());
        return "admin/expenses";
    }

    @GetMapping("/sponsorships")
    public String listSponsorships(Model model) {
        model.addAttribute("sponsorships", sponsorshipService.findAll());
        return "admin/sponsorships";
    }
}