package com.motoflow.motoflow.controller.view;

import com.motoflow.motoflow.model.Operador;
import com.motoflow.motoflow.service.OperadorService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/operadores")
public class OperadorViewController {

    private final OperadorService operadorService;

    public OperadorViewController(OperadorService operadorService) {
        this.operadorService = operadorService;
    }

    @GetMapping
    public String listarOperadores(Model model) {
        model.addAttribute("operadores", operadorService.findAll());
        return "operador/operador-list";
    }

    @GetMapping("/new")
    public String novoOperadorForm(Model model) {
        model.addAttribute("operador", new Operador());
        return "operador/operador-form";
    }

    @PostMapping
    public String salvarOperador(@Valid @ModelAttribute("operador") Operador operador, BindingResult result) {
        if (result.hasErrors()) {
            return "operador/operador-form";
        }
        operadorService.save(operador);
        return "redirect:/operadores";
    }

    @GetMapping("/edit/{id}")
    public String editarOperador(@PathVariable Long id, Model model) {
        model.addAttribute("operador", operadorService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Operador não encontrado")));
        return "operador/operador-form";
    }

    @GetMapping("/delete/{id}")
    public String deletarOperador(@PathVariable Long id) {
        operadorService.delete(id);
        return "redirect:/operadores";
    }
}
