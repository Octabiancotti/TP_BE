package com.plataformabienestar.plataforma_de_bienestar_digital.entities;
import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@SuppressWarnings("hiding")
@Entity
public class Reserva<Reserva> {

     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date fecha;
    private String hora;

    @SuppressWarnings("rawtypes")
    @ManyToOne
    @JoinColumn(name = "miembro_id")
    private Miembro miembro;

    @SuppressWarnings("rawtypes")
    @ManyToOne
    @JoinColumn(name = "servicio_id")
    private Servicio servicio;

    @SuppressWarnings("rawtypes")
    @ManyToOne
    @JoinColumn(name = "instructor_id")
    private Instructor instructor;

    @ManyToOne
    @JoinColumn(name = "instalacion_id")
    private Instalacion instalacion;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    @SuppressWarnings("rawtypes")
    public Miembro getMiembro() {
        return miembro;
    }

    public void setMiembro(@SuppressWarnings("rawtypes") Miembro miembro) {
        this.miembro = miembro;
    }

    @SuppressWarnings("rawtypes")
    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(@SuppressWarnings("rawtypes") Servicio servicio) {
        this.servicio = servicio;
    }

    @SuppressWarnings("rawtypes")
    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(@SuppressWarnings("rawtypes") Instructor instructor) {
        this.instructor = instructor;
    }

    public Instalacion getInstalacion() {
        return instalacion;
    }

    public void setInstalacion(Instalacion instalacion) {
        this.instalacion = instalacion;
    }

    // Getters y Setters

    

}
