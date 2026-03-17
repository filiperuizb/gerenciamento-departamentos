package com.boligon.gerenciamento_departamentos.controller;

import com.boligon.gerenciamento_departamentos.entity.DepartamentoEntity;
import com.boligon.gerenciamento_departamentos.service.DepartamentoService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/departamentos")
public class DepartamentoController {

    @Autowired
    private DepartamentoService departamentoService;

    @PostMapping
    public ResponseEntity<DepartamentoEntity> save(@RequestBody DepartamentoEntity novoDepartamento) {
        DepartamentoEntity departamento = departamentoService.save(novoDepartamento);
        return ResponseEntity.status(201).body(departamento);
    }

    @GetMapping
    public ResponseEntity<List<DepartamentoEntity>> findAll() {
        List<DepartamentoEntity> departamentoList = departamentoService.findAll();
        return departamentoList.isEmpty()
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok().body(departamentoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartamentoEntity> findById(@PathVariable Long id) {
        Optional<DepartamentoEntity> departamento = departamentoService.findById(id);
        return departamento.isPresent()
                ? ResponseEntity.ok().body(departamento.get())
                : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        departamentoService.deleteById(id);
        return ResponseEntity.status(204).build();
    }

}
