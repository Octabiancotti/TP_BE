package com.plataformabienestar.plataforma_de_bienestar_digital.entities;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class SistemaRecomendacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @SuppressWarnings("unused")
    private String algoritmo;
    @SuppressWarnings("unused")
    private String preferencias;

    @SuppressWarnings("rawtypes")
    @ManyToMany
    @JoinTable(
        name = "recomendaciones_miembros",
        joinColumns = @JoinColumn(name = "recomendacion_id"),
        inverseJoinColumns = @JoinColumn(name = "miembro_id")
    )
    private List<Miembro> miembros;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAlgoritmo() {
        return algoritmo;
    }

    public void setAlgoritmo(String algoritmo) {
        this.algoritmo = algoritmo;
    }

    public String getPreferencias() {
        return preferencias;
    }

    public void setPreferencias(String preferencias) {
        this.preferencias = preferencias;
    }

    @SuppressWarnings("rawtypes")
    public List<Miembro> getMiembros() {
        return miembros;
    }

    public void setMiembros(@SuppressWarnings("rawtypes") List<Miembro> miembros) {
        this.miembros = miembros;
    }

    public Object getDescripcion() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getDescripcion'");
    }

    public void setDescripcion(Object descripcion) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setDescripcion'");
    }

    // Getters y Setters
    
}
