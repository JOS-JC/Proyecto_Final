package com.example.tallervehiculos.service;

import com.example.tallervehiculos.model.Reparacion;
import com.example.tallervehiculos.repository.ReparacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReparacionService {

    @Autowired
    private ReparacionRepository reparacionRepository;

    public Reparacion registrarReparacion(Reparacion reparacion) {
        return reparacionRepository.save(reparacion);
    }
}
