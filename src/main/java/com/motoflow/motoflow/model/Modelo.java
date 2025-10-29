package com.motoflow.motoflow.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "modelo")
public class Modelo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Gera ID automaticamente
    @Column(name = "id_modelo")
    private Long id;

    @NotBlank(message = "O nome do modelo é obrigatório.")
    @Size(max = 100, message = "O nome do modelo deve ter no máximo 100 caracteres.")
    @Column(name = "nm_modelo", nullable = false, length = 100)
    private String nome;

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
