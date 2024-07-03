package com.example.community.Controller;

import com.example.community.Entity.Participation;
import com.example.community.Entity.Projet;
import com.example.community.Entity.UserEntity;
import com.example.community.Mapper.ProjetMapper;
import com.example.community.Security.SecurityUtil;
import com.example.community.Services.ParticipationService;
import com.example.community.Services.ProjetService;
import com.example.community.Services.UserService;
import com.example.community.dto.ProjetDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ProjetController {

    private final ProjetService projetService;
    private final UserService userService;
    private final ParticipationService participationService;

    @Autowired
    public ProjetController(ProjetService projetService, UserService userService, ParticipationService participationService) {
        this.projetService = projetService;
        this.userService = userService;
        this.participationService = participationService;
    }

    @GetMapping("/Upload")
    public String showUpload(Model model) {
        model.addAttribute("projetadd", new ProjetDto());
        return "Upload";
    }

    @PostMapping("/projets/save")
    public String ajouterProjet(@Valid @ModelAttribute("projetadd") ProjetDto projetDto, BindingResult result, @RequestParam("fileImage") MultipartFile multipartFile) throws IOException {
        if (!multipartFile.isEmpty()) {
            String directoryName = "images";
            File directory = new File("src/main/resources/static/" + directoryName);
            if (!directory.exists()) {
                directory.mkdirs();
            }

            String originalFileName = multipartFile.getOriginalFilename();
            String filePath = directory.getAbsolutePath() + File.separator + originalFileName;
            File destFile = new File(filePath);
            multipartFile.transferTo(destFile);
            projetDto.setPhotoUrl(originalFileName);
        }

        projetDto.setAmount("0");
        String username = SecurityUtil.getSessionUser();
        UserEntity user = userService.findByUsername(username);
        Projet projet = ProjetMapper.mapToProjet(projetDto);
        projet.setCreatedBy(user);
        projetService.saveProjet(projet);
        return "redirect:/Projet";
    }

    @GetMapping("/ProjectDetails")
    public String projectDetails(@RequestParam("id") Long projectId, Model model) {
        ProjetDto project = projetService.findProjetById(projectId);
        model.addAttribute("projectSelect", project);
        return "projectDetails";
    }

    @GetMapping("/ProjectDetails1")
    public String projectDetails1(@RequestParam("id") Long projectId, Model model) {
        ProjetDto project = projetService.findProjetById(projectId);
        model.addAttribute("projectSelect", project);
        return "projectDetails1";
    }

    @GetMapping("/ProjetEdit")
    public String projectEdit(@RequestParam("id") Long projectId, Model model) {
        ProjetDto project = projetService.findProjetById(projectId);
        model.addAttribute("projet", project);
        return "ProjetEdit";
    }

    @PostMapping("/projets/{id}/delete")
    public String deleteProjet(@PathVariable("id") Long projectId) {
        projetService.deleteProjet(projectId);
        return "redirect:/Projet";
    }

    @PostMapping("/projets/{id}/edit")
    public String updateProjet(@PathVariable("id") Long projectId, @Valid @ModelAttribute("projet") ProjetDto projetDto, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "ProjetEdit";
        }
        ProjetDto existingProjet = projetService.findProjetById(projectId);
        projetDto.setPhotoUrl(existingProjet.getPhotoUrl());
        projetDto.setId(projectId); // Ensure the ID is set for update
        projetService.updateProjet(projetDto);
        return "redirect:/Projet";
    }

    @GetMapping("/Projet")
    public String showProjet(Model model) {
        UserEntity user = new UserEntity();
        List<ProjetDto> projets = projetService.findAllProjet();
        String username = SecurityUtil.getSessionUser();
        if (username != null) {
            user = userService.findByUsername(username);
            model.addAttribute("user", user);
        }
        model.addAttribute("projets", projets);
        return "Projet";
    }

    @GetMapping("/participate")
    public String showParticipationForm(@RequestParam("projectId") Long projectId, Model model) {
        ProjetDto project = projetService.findProjetById(projectId);
        if (Double.parseDouble(project.getAmount()) >= Double.parseDouble(project.getTotalAmount())) {
            model.addAttribute("error", "This project has already reached its funding goal.");
            return "redirect:/ProjectDetails?id=" + projectId;
        }
        model.addAttribute("project", project);
        model.addAttribute("participation", new Participation());
        return "participate";
    }

    @PostMapping("/participate")
    public String participate(@RequestParam("projectId") Long projectId,
                              @RequestParam("amount") double amount,
                              @RequestParam("comment") String comment,
                              @RequestParam("customerName") String customerName,
                              @RequestParam("phone") String phone,
                              @RequestParam("address") String address,
                              @RequestParam("email") String email,
                              Model model) {
        String username = SecurityUtil.getSessionUser();
        UserEntity user = userService.findByUsername(username);
        ProjetDto projetDto = projetService.findProjetById(projectId);

        if (participationService.hasParticipated(user, projectId)) {
            model.addAttribute("error", "You have already participated in this project.");
            return "redirect:/ProjectDetails?id=" + projectId;
        }

        double newAmount = Double.parseDouble(projetDto.getAmount()) + amount;
        if (newAmount > Double.parseDouble(projetDto.getTotalAmount())) {
            model.addAttribute("error", "The total amount exceeds the project goal.");
            return "redirect:/ProjectDetails?id=" + projectId;
        }

        projetDto.setAmount(String.valueOf(newAmount));
        Projet projet = ProjetMapper.mapToProjet(projetDto);

        Participation participation = new Participation();
        participation.setUser(user);
        participation.setProjet(projet);
        participation.setAmount(amount);
        participation.setComment(comment);
        participation.setCustomerName(customerName);
        participation.setPhone(phone);
        participation.setAddress(address);
        participation.setEmail(email);

        if (projet.getParticipations() == null) {
            projet.setParticipations(new ArrayList<>());
        }

        projet.getParticipations().add(participation);

        projetService.updateProjet(projet);
        participationService.saveParticipation(participation);

        return "redirect:/Projet";
    }
}
