package com.plataformabienestar.plataforma_de_bienestar_digital.entities;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Instalacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String equipo;

    @SuppressWarnings("rawtypes")
    @OneToMany(mappedBy = "instalacion")
    private List<Reserva> reservas;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    @SuppressWarnings("rawtypes")
    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(@SuppressWarnings("rawtypes") List<Reserva> reservas) {
        this.reservas = reservas;
    }

    public Object getUbicacion() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getUbicacion'");
    }

    public void setUbicacion(Object ubicacion) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setUbicacion'");
    }

    // Getters y Setters
    
}