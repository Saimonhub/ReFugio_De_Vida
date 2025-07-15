package com.simon.refugiodevida.Crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.simon.refugiodevida.Crud.model.EntradaEmocional;
import com.simon.refugiodevida.Crud.repositorio.EntradaEmocionalRepository;

@Service
public class EntradaEmocionalService {

    private final EntradaEmocionalRepository repository;

    public EntradaEmocionalService(EntradaEmocionalRepository repository) {
        this.repository = repository;
    }

    public List<EntradaEmocional> findAll() {
        return repository.findAll();
    }

    public Optional<EntradaEmocional> findById(Long id) {
        return repository.findById(id);
    }

    public EntradaEmocional save(EntradaEmocional entrada) {
        return repository.save(entrada);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}