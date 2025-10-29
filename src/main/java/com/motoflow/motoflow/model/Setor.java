package com.motoflow.motoflow.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "setor")
public class Setor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_setor")
    private Long id;

    @NotBlank(message = "O nome do setor é obrigatório.")
    @Size(max = 100, message = "O nome do setor deve ter no máximo 100 caracteres.")
    @Column(name = "nm_setor", nullable = false, length = 100)
    private String nome;

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
}
