package com.sistema.aprendizaje.sistema_aprendizaje.controllers;

import org.springframework.web.bind.annotation.*;

import com.sistema.aprendizaje.sistema_aprendizaje.entities.Evaluacion;
import com.sistema.aprendizaje.sistema_aprendizaje.repositories.EvaluacionRepository;

import java.util.List;

@RestController
@RequestMapping("/api/evaluaciones")
public class EvaluacionController {

    private final EvaluacionRepository evaluacionRepository;

    public EvaluacionController(EvaluacionRepository evaluacionRepository) {
        this.evaluacionRepository = evaluacionRepository;
    }

    @GetMapping
    public List<Evaluacion> obtenerEvaluaciones() {
        return evaluacionRepository.findAll();
    }

    @PostMapping
    public Evaluacion crearEvaluacion(@RequestBody Evaluacion evaluacion) {
        return evaluacionRepository.save(evaluacion);
    }

    @PutMapping("/{id}")
    public Evaluacion actualizarEvaluacion(@PathVariable Long id, @RequestBody Evaluacion evaluacionActualizada) {
        return evaluacionRepository.findById(id)
                .map(evaluacion -> {
                    evaluacion.setCalificacion(evaluacionActualizada.getCalificacion());
                    return evaluacionRepository.save(evaluacion);
                })
                .orElseThrow(() -> new RuntimeException("Evaluacion no encontrada"));
    }

    @DeleteMapping("/{id}")
    public void eliminarEvaluacion(@PathVariable Long id) {
        evaluacionRepository.deleteById(id);
    }
}