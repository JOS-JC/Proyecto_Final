package com.example.tallervehiculos.model;

import jakarta.persistence.*;

@Entity
public class Reparacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "cita_id")
    private Cita cita;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public Cita getCita() { return cita; }
    public void setCita(Cita cita) { this.cita = cita; }
}
