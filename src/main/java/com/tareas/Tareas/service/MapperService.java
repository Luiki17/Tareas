package com.tareas.Tareas.service;

import com.tareas.Tareas.dto.RetoDto;
import com.tareas.Tareas.dto.UsuarioDto;
import com.tareas.Tareas.model.Reto;
import com.tareas.Tareas.model.Usuario;
import org.springframework.stereotype.Service;

@Service
public class MapperService {

    public UsuarioDto toDto(Usuario usuario) {
        if (usuario == null) {
            return null;
        }
        return new UsuarioDto(usuario.getId(), usuario.getNombre());
    }

    public RetoDto toDto(Reto reto) {
        if (reto == null) {
            return null;
        }
        return new RetoDto(reto.getId(), reto.getTitulo(), reto.getFechaInicio(), reto.getFechaFin());
    }
}
