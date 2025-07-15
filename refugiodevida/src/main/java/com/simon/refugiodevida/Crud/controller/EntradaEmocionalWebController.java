package com.simon.refugiodevida.Crud.controller;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.simon.refugiodevida.Crud.model.EntradaEmocional;
import com.simon.refugiodevida.Crud.service.EntradaEmocionalService;

@Controller
@RequestMapping("/entradas")
public class EntradaEmocionalWebController {

    private final EntradaEmocionalService service;

    public EntradaEmocionalWebController(EntradaEmocionalService service) {
        this.service = service;
    }

    // Mostrar todas las entradas y formulario para crear una nueva
    @GetMapping
    public String listarEntradas(Model model) {
        model.addAttribute("entradas", service.findAll());
        model.addAttribute("entradaNueva", new EntradaEmocional());
        return "entradas";  // archivo entradas.html en templates
    }

    // Guardar una nueva entrada
    @PostMapping("/guardar")
    public String guardarEntrada(@ModelAttribute("entradaNueva") EntradaEmocional entrada) {
        entrada.setFecha(LocalDateTime.now());  // <-- Asignar fecha aquí siempre
        service.save(entrada);
        return "redirect:/entradas";
    }

    // Eliminar una entrada por ID
    @GetMapping("/eliminar/{id}")
    public String eliminarEntrada(@PathVariable Long id) {
        service.deleteById(id);
        return "redirect:/entradas";
    }
}
