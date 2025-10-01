package com.motoflow.motoflow.controller;

import com.motoflow.motoflow.model.Movimentacao;
import com.motoflow.motoflow.service.MovimentacaoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/movimentacoes")
public class MovimentacaoController {

    private final MovimentacaoService movimentacaoService;

    public MovimentacaoController(MovimentacaoService movimentacaoService) {
        this.movimentacaoService = movimentacaoService;
    }

    @GetMapping
    public List<Movimentacao> findAll() {
        return movimentacaoService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Movimentacao> findById(@PathVariable Long id) {
        return movimentacaoService.findById(id);
    }

    @PostMapping
    public Movimentacao save(@RequestBody Movimentacao movimentacao) {
        return movimentacaoService.save(movimentacao);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        movimentacaoService.delete(id);
    }
}
