package com.boligon.gerenciamento_departamentos.service;

import com.boligon.gerenciamento_departamentos.entity.DepartamentoEntity;
import com.boligon.gerenciamento_departamentos.repository.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartamentoService {

    @Autowired
    private DepartamentoRepository departamentoRepository;

    public DepartamentoEntity save(DepartamentoEntity novoDepartamento) {
        return departamentoRepository.save(novoDepartamento);
    }

    public List<DepartamentoEntity> findAll() {
        return departamentoRepository.findAll();
    }

    public Optional<DepartamentoEntity> findById(Long id) {
        return departamentoRepository.findById(id);
    }

    public void deleteById(Long id) {
        departamentoRepository.deleteById(id);
    }

}
