package com.motoflow.motoflow.controller.view;

import com.motoflow.motoflow.model.Modelo;
import com.motoflow.motoflow.service.ModeloService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/modelos")
public class ModeloViewController {

    private final ModeloService modeloService;

    public ModeloViewController(ModeloService modeloService) {
        this.modeloService = modeloService;
    }

    @GetMapping
    public String listarModelos(Model model) {
        model.addAttribute("modelos", modeloService.findAll());
        return "modelo/modelo-list";
    }

    @GetMapping("/new")
    public String novoModeloForm(Model model) {
        model.addAttribute("modelo", new Modelo());
        return "modelo/modelo-form";
    }

    @PostMapping
    public String salvarModelo(@ModelAttribute Modelo modelo) {
        modeloService.save(modelo);
        return "redirect:/modelos";
    }

    @GetMapping("/edit/{id}")
    public String editarModelo(@PathVariable Long id, Model model) {
        model.addAttribute("modelo", modeloService.findById(id));
        return "modelo/modelo-form";
    }

    @GetMapping("/delete/{id}")
    public String deletarModelo(@PathVariable Long id) {
        modeloService.delete(id);
        return "redirect:/modelos";
    }
}
