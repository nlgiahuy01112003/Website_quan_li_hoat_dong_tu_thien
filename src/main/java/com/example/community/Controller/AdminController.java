package com.example.community.Controller;

import com.example.community.Services.ParticipationService;
import com.example.community.Services.ProjetService;
import com.example.community.Services.UserService;
import com.example.community.dto.ProjetDto;
import com.example.community.Entity.UserEntity;
import com.example.community.Entity.Participation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AdminController {

    private final ProjetService projetService;
    private final UserService userService;
    private final ParticipationService participationService;

    @Autowired
    public AdminController(ProjetService projetService, UserService userService, ParticipationService participationService) {
        this.projetService = projetService;
        this.userService = userService;
        this.participationService = participationService;
    }

    @GetMapping("/Admin")
    public String admin() {
        return "Admin";
    }

    @GetMapping("/AdminProjet")
    public String showAllAdminProjet(Model model) {
        List<ProjetDto> listproject = projetService.findAllProjet();
        model.addAttribute("listproject", listproject);
        return "AdminProjet";
    }

    @GetMapping("/AdminUtilisateur")
    public String showAllAdminUser(Model model) {
        List<UserEntity> listUsers = userService.findAllUsers();
        model.addAttribute("listUsers", listUsers);
        return "AdminUtilisateur";
    }

    @GetMapping("/UserEdit")
    public String editUser(@RequestParam("username") String username, Model model) {
        UserEntity user = userService.findByUsername(username);
        model.addAttribute("user", user);
        return "UserEdit";
    }

    @PostMapping("/users/{username}/edit")
    public String updateUser(@PathVariable("username") String username,
                             @Valid @ModelAttribute("user") UserEntity userEntity,
                             BindingResult result) {
        if (result.hasErrors()) {
            return "UserEdit";
        }
        userService.updateUserDetails(userEntity);
        return "redirect:/AdminUtilisateur";
    }

    @GetMapping("/AdminProjet/{id}/participations")
    public String viewParticipations(@PathVariable("id") Long projectId, Model model) {
        List<Participation> participations = participationService.findByProjetId(projectId);
        model.addAttribute("participations", participations);
        return "AdminParticipations";
    }
}
