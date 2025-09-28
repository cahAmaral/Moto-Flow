package com.motoflow.motoflow.service;

import com.motoflow.motoflow.model.Setor;
import com.motoflow.motoflow.repository.SetorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SetorService {

    private final SetorRepository setorRepository;

    public SetorService(SetorRepository setorRepository) {
        this.setorRepository = setorRepository;
    }

    public List<Setor> findAll() {
        return setorRepository.findAll();
    }

    public Optional<Setor> findById(Long id) {
        return setorRepository.findById(id);
    }

    public Setor save(Setor setor) {
        return setorRepository.save(setor);
    }

    public void delete(Long id) {
        setorRepository.deleteById(id);
    }
}
