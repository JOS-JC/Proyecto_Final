package com.example.tallervehiculos.service;

import com.example.tallervehiculos.model.Cita;
import com.example.tallervehiculos.repository.CitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CitaService {

    @Autowired
    private CitaRepository citaRepository;

    public List<Cita> obtenerCitas() {
        return citaRepository.findAll();
    }

    public Cita registrarCita(Cita cita) {
        return citaRepository.save(cita);
    }
}
