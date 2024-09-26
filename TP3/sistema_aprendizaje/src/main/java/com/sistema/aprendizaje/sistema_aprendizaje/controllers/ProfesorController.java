package com.sistema.aprendizaje.sistema_aprendizaje.controllers;

import org.springframework.web.bind.annotation.*;

import com.sistema.aprendizaje.sistema_aprendizaje.entities.Profesor;
import com.sistema.aprendizaje.sistema_aprendizaje.repositories.ProfesorRepository;

import java.util.List;

@RestController
@RequestMapping("/api/profesores")
public class ProfesorController {

    private final ProfesorRepository profesorRepository;

    public ProfesorController(ProfesorRepository profesorRepository) {
        this.profesorRepository = profesorRepository;
    }

    @GetMapping
    public List<Profesor> obtenerProfesores() {
        return profesorRepository.findAll();
    }

    @PostMapping
    public Profesor crearProfesor(@RequestBody Profesor profesor) {
        return profesorRepository.save(profesor);
    }

    @PutMapping("/{id}")
    public Profesor actualizarProfesor(@PathVariable Long id, @RequestBody Profesor profesorActualizado) {
        return profesorRepository.findById(id)
                .map(profesor -> {
                    profesor.setNombre(profesorActualizado.getNombre());
                    profesor.setEmail(profesorActualizado.getEmail());
                    return profesorRepository.save(profesor);
                })
                .orElseThrow(() -> new RuntimeException("Profesor no encontrado"));
    }

    @DeleteMapping("/{id}")
    public void eliminarProfesor(@PathVariable Long id) {
        profesorRepository.deleteById(id);
    }
}