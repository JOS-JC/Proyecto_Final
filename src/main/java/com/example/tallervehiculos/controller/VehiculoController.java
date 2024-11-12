package com.example.tallervehiculos.controller;

import com.example.tallervehiculos.model.Vehiculo;
import com.example.tallervehiculos.service.VehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehiculos")
public class VehiculoController {

    @Autowired
    private VehiculoService vehiculoService;

    // Obtener todos los vehículos
    @GetMapping
    public List<Vehiculo> obtenerVehiculos() {
        return vehiculoService.obtenerVehiculos();
    }

    // Registrar un vehículo
    @PostMapping
    public Vehiculo registrarVehiculo(@RequestBody Vehiculo vehiculo) {
        return vehiculoService.registrarVehiculo(vehiculo);
    }
}
