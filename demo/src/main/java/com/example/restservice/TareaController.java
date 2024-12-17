package com.example.restservice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/tareas")
public class TareaController {

    private List<String> tareas = new ArrayList<>();

    @GetMapping
    public List<String> obtenerTareas() {
        return tareas;
    }

    @PostMapping
    public ResponseEntity<String> agregarTarea(@RequestBody String tarea) {
        tareas.add(tarea);
        return ResponseEntity.status(HttpStatus.CREATED).body("Tarea agregada: " + tarea);
    }

    @DeleteMapping("/{index}")
    public ResponseEntity<String> eliminarTarea(@PathVariable int index) {
        if (index >= 0 && index < tareas.size()) {
            String tareaEliminada = tareas.remove(index);
            return ResponseEntity.ok("Tarea eliminada: " + tareaEliminada);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Índice no válido");
        }
    }
}