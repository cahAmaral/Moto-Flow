package com.motoflow.motoflow.controller;

import com.motoflow.motoflow.model.Modelo;
import com.motoflow.motoflow.service.ModeloService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/modelos")
public class ModeloController {

    private final ModeloService modeloService;

    public ModeloController(ModeloService modeloService) {
        this.modeloService = modeloService;
    }

    @GetMapping
    public List<Modelo> findAll() {
        return modeloService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Modelo> findById(@PathVariable Long id) {
        return modeloService.findById(id);
    }

    @PostMapping
    public Modelo save(@RequestBody Modelo modelo) {
        return modeloService.save(modelo);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        modeloService.delete(id);
    }
}
