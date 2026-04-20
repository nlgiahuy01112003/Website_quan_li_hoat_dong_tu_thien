package com.example.community.Controller;

import com.example.community.Entity.Projet;
import com.example.community.Entity.UserEntity;
import com.example.community.Security.SecurityUtil;
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
import java.util.List;

@Controller
public class ProjetController {

    @Autowired
    private ProjetService projetService;
    @Autowired
    private UserService userService;

    @Autowired
    public ProjetController(ProjetService projetService, UserService userService){
        this.projetService = projetService;
        this.userService = userService;
    }



    @GetMapping("/Upload")
    public String showUpload(Model model) {
        model.addAttribute("projetadd", new ProjetDto());
        return "Upload";
    }

    @PostMapping("/projets/save")
    public String ajouterProjet(@Valid @ModelAttribute("projetadd") ProjetDto projetDto, BindingResult result,
                                @RequestParam("fileImage") MultipartFile multipartFile, Model model) throws IOException {


        if (!multipartFile.isEmpty()) {
            // Ensure that the directory name is fixed
            String directoryName = "images";

            // Create directory if not exists
            File directory = new File("src/main/resources/static/" + directoryName);
            if (!directory.exists()) {
                directory.mkdirs();
            }

            // Get the original file name
            String originalFileName = multipartFile.getOriginalFilename();

            // Construct the file path
            String filePath = directory.getAbsolutePath() + File.separator + originalFileName;

            // Save the file to the directory
            File destFile = new File(filePath);
            multipartFile.transferTo(destFile);
            projetDto.setPhotoUrl(originalFileName);

            // Print out the directory path for debugging (to see if it works well)
            System.out.println("Directory path: " + directory.getAbsolutePath());
            System.out.println("File path: " + filePath);
        }

        projetDto.setAmount("0");
        projetService.saveProjet(projetDto);

        // Proceed with redirection to HTML page project
        return "redirect:/Projet";
    }


    @GetMapping("/ProjectDetails")
    public String projectDetails(@RequestParam("id") Long projectId, Model model) {
        ProjetDto project = projetService.findProjetById(projectId);
        model.addAttribute("projectSelect", project);
        return "projectDetails";
    }

    @GetMapping("/ProjetEdit")
    public String projectEdit(@RequestParam("id") Long projectId, Model model) {
        ProjetDto project = projetService.findProjetById(projectId);
        model.addAttribute("projet", project);
        return "ProjetEdit";
    }


    @PostMapping("/projets/{id}/edit")
    public String updateProjet(@PathVariable("id") Long projectId,
                               @Valid @ModelAttribute("projet") ProjetDto projetDto,
                               BindingResult result,
                               Model model) {


        ProjetDto existingProjet = projetService.findProjetById(projectId);
        projetDto.setPhotoUrl(existingProjet.getPhotoUrl());
        projetService.saveProjet(projetDto);
        projetDto.setId(projectId); // Ensure the ID is set for update
        projetService.saveProjet(projetDto);

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


}
