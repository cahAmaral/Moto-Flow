package com.motoflow.motoflow.controller;

import com.motoflow.motoflow.model.Moto;
import com.motoflow.motoflow.service.MotoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/motos")
public class MotoController {

    private final MotoService motoService;

    public MotoController(MotoService motoService) {
        this.motoService = motoService;
    }

    @GetMapping
    public List<Moto> findAll() {
        return motoService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Moto> findById(@PathVariable Long id) {
        return motoService.findById(id);
    }

    @PostMapping
    public Moto save(@RequestBody Moto moto) {
        return motoService.save(moto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        motoService.delete(id);
    }
}
