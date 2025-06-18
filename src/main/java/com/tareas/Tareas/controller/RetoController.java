package com.tareas.Tareas.controller;

import com.tareas.Tareas.model.Reto;
import com.tareas.Tareas.repository.RetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/retos")
public class RetoController {

    @Autowired
    private RetoRepository retoRepository;

    @GetMapping
    public String listarRetos(Model model) {
        model.addAttribute("retos", retoRepository.findAll());
        return "retos";
    }

    @GetMapping("/crear")
    public String crearReto(Model model) {
        model.addAttribute("reto", new Reto());
        return "crear_reto";
    }

    @PostMapping("/guardar")
    public String guardarReto(Reto reto) {
        retoRepository.save(reto);
        return "redirect:/retos";
    }

    @GetMapping("/{id}")
    public String verReto(@PathVariable Long id, Model model) {
        Reto reto = retoRepository.findById(id).orElse(null);
        if (reto != null) {
            model.addAttribute("reto", reto);
            return "ver_reto";
        }
        return "redirect:/retos";
    }

    @GetMapping("/eliminar{id}")
    public String eliminarReto(@PathVariable Long id) {
        retoRepository.deleteById(id);
        return "redirect:/retos";
    }
}

