package com.simon.refugiodevida.Crud.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simon.refugiodevida.Crud.model.EntradaEmocional;
import com.simon.refugiodevida.Crud.service.EntradaEmocionalService;

@RestController
@RequestMapping("/api/entradas")
@CrossOrigin(origins = "*")
public class EntradaEmocionalController {

    private final EntradaEmocionalService service;

    public EntradaEmocionalController(EntradaEmocionalService service) {
        this.service = service;
    }

    @GetMapping
    public List<EntradaEmocional> listar() {
        return service.findAll();
    }

    @PostMapping
    public EntradaEmocional crear(@RequestBody EntradaEmocional entrada) {
        return service.save(entrada);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EntradaEmocional> actualizar(@PathVariable Long id, @RequestBody EntradaEmocional entrada) {
        return service.findById(id)
                .map(e -> {
                    e.setEmocion(entrada.getEmocion());
                    e.setDescripcion(entrada.getDescripcion());
                    e.setFecha(entrada.getFecha());
                    return ResponseEntity.ok(service.save(e));
                }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
