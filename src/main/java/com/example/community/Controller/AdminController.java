package com.example.community.Controller;

import com.example.community.Services.ProjetService;
import com.example.community.Services.UserService;
import com.example.community.dto.ProjetDto;
import com.example.community.Entity.UserEntity;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AdminController {
    @Autowired
    private ProjetService projetService;

    @Autowired
    private UserService userService;

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
                             BindingResult result,
                             Model model) {
        if (result.hasErrors()) {
            return "useredit";
        }
        return "redirect:/AdminUtilisateur";
    }
}
