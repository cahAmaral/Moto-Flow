package com.motoflow.motoflow.controller.view;

import com.motoflow.motoflow.model.Movimentacao;
import com.motoflow.motoflow.service.MovimentacaoService;
import com.motoflow.motoflow.service.MotoService;
import com.motoflow.motoflow.service.SetorService;
import com.motoflow.motoflow.service.OperadorService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/movimentacoes")
public class MovimentacaoViewController {

    private final MovimentacaoService movimentacaoService;
    private final MotoService motoService;
    private final SetorService setorService;
    private final OperadorService operadorService;

    public MovimentacaoViewController(MovimentacaoService movimentacaoService,
                                      MotoService motoService,
                                      SetorService setorService,
                                      OperadorService operadorService) {
        this.movimentacaoService = movimentacaoService;
        this.motoService = motoService;
        this.setorService = setorService;
        this.operadorService = operadorService;
    }

    @GetMapping
    public String listarMovimentacoes(Model model) {
        model.addAttribute("movimentacoes", movimentacaoService.findAll());
        return "movimentacao/movimentacao-list";
    }

    @GetMapping("/new")
    public String novaMovimentacaoForm(Model model) {
        model.addAttribute("movimentacao", new Movimentacao());
        model.addAttribute("motos", motoService.findAll());
        model.addAttribute("setores", setorService.findAll());
        model.addAttribute("operadores", operadorService.findAll());
        return "movimentacao/movimentacao-form";
    }

    @PostMapping
    public String salvarMovimentacao(@Valid @ModelAttribute("movimentacao") Movimentacao movimentacao,
                                     BindingResult result, Model modelAttr) {
        if (result.hasErrors()) {
            modelAttr.addAttribute("motos", motoService.findAll());
            modelAttr.addAttribute("setores", setorService.findAll());
            modelAttr.addAttribute("operadores", operadorService.findAll());
            return "movimentacao/movimentacao-form";
        }
        movimentacaoService.save(movimentacao);
        return "redirect:/movimentacoes";
    }

    @GetMapping("/edit/{id}")
    public String editarMovimentacao(@PathVariable Long id, Model model) {
        model.addAttribute("movimentacao", movimentacaoService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Movimentação não encontrada")));
        model.addAttribute("motos", motoService.findAll());
        model.addAttribute("setores", setorService.findAll());
        model.addAttribute("operadores", operadorService.findAll());
        return "movimentacao/movimentacao-form";
    }

    @GetMapping("/delete/{id}")
    public String deletarMovimentacao(@PathVariable Long id) {
        movimentacaoService.delete(id);
        return "redirect:/movimentacoes";
    }
}
