package com.example.tallervehiculos.controller;

import com.example.tallervehiculos.model.Cita;
import com.example.tallervehiculos.service.CitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/citas")
public class CitaController {

    @Autowired
    private CitaService citaService;

    // Obtener todas las citas
    @GetMapping
    public List<Cita> obtenerCitas() {
        return citaService.obtenerCitas();
    }

    // Registrar una nueva cita
    @PostMapping
    public Cita registrarCita(@RequestBody Cita cita) {
        return citaService.registrarCita(cita);
    }
}
