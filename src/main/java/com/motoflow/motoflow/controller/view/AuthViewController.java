package com.motoflow.motoflow.controller.view;

import com.motoflow.motoflow.model.Usuario;
import com.motoflow.motoflow.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthViewController {

    private final UsuarioService usuarioService;

    public AuthViewController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login"; // arquivo login.html
    }

    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "register"; // arquivo register.html
    }

    @PostMapping("/register")
    public String registerUser(@Valid @ModelAttribute("usuario") Usuario usuario,
                               BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "register";
        }

        usuarioService.salvar(usuario);
        return "redirect:/login?registered";
    }
}
