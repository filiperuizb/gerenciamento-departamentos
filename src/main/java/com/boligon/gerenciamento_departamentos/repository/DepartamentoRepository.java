package com.boligon.gerenciamento_departamentos.repository;

import com.boligon.gerenciamento_departamentos.entity.DepartamentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartamentoRepository extends JpaRepository<DepartamentoEntity, Long> {
}
