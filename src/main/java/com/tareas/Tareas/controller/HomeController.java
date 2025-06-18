package com.tareas.Tareas.controller;

import com.tareas.Tareas.repository.RetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;

@Controller
public class HomeController {

    @Autowired
    private RetoRepository retoRepository;

    @GetMapping("")
    public String home(Model model) {
        model.addAttribute("retos", retoRepository.findAll()
                .stream()
                .filter(r -> r.getFechaFin().isAfter(LocalDate.now()))
                .toList());
        return "home"; // Retorna la vista index.html
    }
}
