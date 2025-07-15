package com.simon.refugiodevida.Crud.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.simon.refugiodevida.Crud.model.EntradaEmocional;

@Repository
public interface EntradaEmocionalRepository extends JpaRepository<EntradaEmocional, Long> {
}
