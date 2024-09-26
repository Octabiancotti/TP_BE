package com.sistema.aprendizaje.sistema_aprendizaje.controllers;

import org.springframework.web.bind.annotation.*;

import com.sistema.aprendizaje.sistema_aprendizaje.entities.Modulo;
import com.sistema.aprendizaje.sistema_aprendizaje.repositories.ModuloRepository;

import java.util.List;

@RestController
@RequestMapping("/api/modulos")
public class ModuloController {

    private final ModuloRepository moduloRepository;

    public ModuloController(ModuloRepository moduloRepository) {
        this.moduloRepository = moduloRepository;
    }

    @GetMapping
    public List<Modulo> obtenerModulos() {
        return moduloRepository.findAll();
    }

    @PostMapping
    public Modulo crearModulo(@RequestBody Modulo modulo) {
        return moduloRepository.save(modulo);
    }

    @PutMapping("/{id}")
    public Modulo actualizarModulo(@PathVariable Long id, @RequestBody Modulo moduloActualizado) {
        return moduloRepository.findById(id)
                .map(modulo -> {
                    modulo.setNombre(moduloActualizado.getNombre());
                    return moduloRepository.save(modulo);
                })
                .orElseThrow(() -> new RuntimeException("Modulo no encontrado"));
    }

    @DeleteMapping("/{id}")
    public void eliminarModulo(@PathVariable Long id) {
        moduloRepository.deleteById(id);
    }
}