package com.motoflow.motoflow.controller.view;

import com.motoflow.motoflow.model.Moto;
import com.motoflow.motoflow.service.MotoService;
import com.motoflow.motoflow.service.ModeloService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/motos")
public class MotoViewController {

    private final MotoService motoService;
    private final ModeloService modeloService;

    public MotoViewController(MotoService motoService, ModeloService modeloService) {
        this.motoService = motoService;
        this.modeloService = modeloService;
    }

    @GetMapping
    public String listarMotos(Model model) {
        model.addAttribute("motos", motoService.findAll());
        return "moto/moto-list";
    }

    @GetMapping("/new")
    public String novaMotoForm(Model model) {
        model.addAttribute("moto", new Moto());
        model.addAttribute("modelos", modeloService.findAll());
        return "moto/moto-form";
    }

    @PostMapping
    public String salvarMoto(@ModelAttribute Moto moto) {
        motoService.save(moto);
        return "redirect:/motos";
    }

    @GetMapping("/edit/{id}")
    public String editarMoto(@PathVariable Long id, Model model) {
        model.addAttribute("moto", motoService.findById(id));
        model.addAttribute("modelos", modeloService.findAll());
        return "moto/moto-form";
    }

    @GetMapping("/delete/{id}")
    public String deletarMoto(@PathVariable Long id) {
        motoService.delete(id);
        return "redirect:/motos";
    }
}
