package com.tareas.Tareas.controller;

import com.tareas.Tareas.dto.UsuarioDto;
import com.tareas.Tareas.model.Usuario;
import com.tareas.Tareas.repository.UsuarioRepository;
import com.tareas.Tareas.service.MapperService;
import com.tareas.Tareas.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    //Mostrar lista de usuarios
    @GetMapping
    public String listarUsuarios(Model model) {
        List<UsuarioDto> usuarios = usuarioService.listarUsuarios();
        model.addAttribute("usuarios", usuarios);
        return "usuarios";
    }

    //Formulario para crear nuevo usuario
    @GetMapping("/crear")
    public String crearUsuario(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "usuario_form";
    }

    //Guardar nuevo usuario (también para editar)
    @PostMapping("/guardar")
    public String guardarUsuario(@Valid Usuario usuario, BindingResult result, Model model) {
        if(result.hasErrors()){
            model.addAttribute("usuario", usuario);
            return "usuario_form"; //Muestra el formulario de nuevo si hay errores
        }
        usuarioService.guardarUsuario(usuario);
        return "redirect:/usuarios";
    }

    //Formulario para editar usuario existente
    @GetMapping("/editar/{id}")
    public String editarUsuario(@PathVariable Long id, Model model) {
        Usuario usuario = usuarioService.buscarUsuarioPorId(id);
        if (usuario != null) {
            model.addAttribute("usuario", usuario);
            return "usuario_form";
        }
        return "redirect:/usuarios";
    }

    //Eliminar usuario
    @GetMapping("/eliminar/{id}")
    public String eliminarUsuario(@PathVariable Long id) {
        usuarioService.eliminarUsuario(id);
        return "redirect:/usuarios";
    }

}
