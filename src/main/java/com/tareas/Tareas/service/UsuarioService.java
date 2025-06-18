package com.tareas.Tareas.service;

import com.tareas.Tareas.dto.UsuarioDto;
import com.tareas.Tareas.model.Usuario;
import com.tareas.Tareas.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private MapperService mapperService;

    //Guardar usuario con contraseña encriptada
    public UsuarioDto guardarUsuario(Usuario usuario) {
        if (usuario.getPassword() != null) {
            usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        }
        Usuario savedUsuario = usuarioRepository.save(usuario);
        return mapperService.toDto(savedUsuario);
    }

    public List<UsuarioDto> listarUsuarios() {
        return usuarioRepository.findAll()
                .stream()
                .map(mapperService::toDto)
                .toList();
    }

    public Usuario buscarUsuarioPorId(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    public void eliminarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }
}
