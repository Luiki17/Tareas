package com.tareas.Tareas.repository;

import com.tareas.Tareas.model.Logro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LogroRepository extends JpaRepository<Logro, Long> {

    List<Logro> findByUsuarioId(Long usuarioId);
}
