package com.example.saml.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.saml.auth.StoredUser;
import com.example.saml.controller.model.AuthUser;
import com.example.saml.repository.UserRepository;

/**
 * "auth-db" landing page in which the user will enter their username and password.
 * database authentication, or the SAML auth flow will be initiated.
 */
@Controller
public class IndexController {
    private static final Logger LOGGER = LoggerFactory.getLogger(SSOController.class);
    
    @Autowired
    UserRepository userRepository;
    
    @GetMapping
    public String index(Model model) {
        model.addAttribute("username", "test");
        model.addAttribute(new AuthUser());
        
        return "index";
    }
    
    
    @PostMapping("/auth-db")
    public String authDb(@ModelAttribute AuthUser authUser,RedirectAttributes redirectAttributes) {
        Optional<StoredUser> user = userRepository.findByUsernameAndPasswordHash(authUser.getUsername(), authUser.getPassword());
        
        if (user.isPresent()) {
            redirectAttributes.addFlashAttribute("success", "Correct auth");
            return "redirect:/";
        } else {
            redirectAttributes.addFlashAttribute("error", "Invalid Username");
            return "redirect:/";
        }
    }
}