package com.example.tallervehiculos.repository;

import com.example.tallervehiculos.model.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface VehiculoRepository extends JpaRepository<Vehiculo, Long> {
    // Consulta para obtener vehículos basados en el ID del cliente
    List<Vehiculo> findByCliente_Id(Long clienteId); // Aquí hacemos referencia a 'cliente.id'
}