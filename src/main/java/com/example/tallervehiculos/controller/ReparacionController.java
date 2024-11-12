package com.example.tallervehiculos.controller;

import com.example.tallervehiculos.model.Reparacion;
import com.example.tallervehiculos.service.ReparacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reparaciones")
public class ReparacionController {

    @Autowired
    private ReparacionService reparacionService;

    // Registrar una nueva reparación
    @PostMapping
    public Reparacion registrarReparacion(@RequestBody Reparacion reparacion) {
        return reparacionService.registrarReparacion(reparacion);
    }
}
