/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.farmacia.farmaciaweb.controller;



import com.farmacia.farmaciaweb.domain.Pelicula;
import com.farmacia.farmaciaweb.service.PeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/peliculas")
public class PeliculaController {

    @Autowired
    private PeliculaService peliculaService;

    // Listar todas las películas
    @GetMapping
    public String listarPeliculas(Model model) {
        List<Pelicula> peliculas = peliculaService.listarTodas();
        model.addAttribute("peliculas", peliculas);
        return "peliculas/lista"; // Thymeleaf view
    }

    // Mostrar formulario para agregar nueva película
    @GetMapping("/nuevo")
    public String mostrarFormulario(Pelicula pelicula) {
        return "peliculas/nuevo"; // Thymeleaf view
    }

    // Guardar nueva película
    @PostMapping("/guardar")
    public String guardarPelicula(Pelicula pelicula) {
        peliculaService.guardar(pelicula);
        return "redirect:/peliculas";
    }

    // Mostrar formulario para editar película
    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable("id") Integer id, Model model) {
        Pelicula pelicula = peliculaService.buscarPorId(id);
        model.addAttribute("pelicula", pelicula);
        return "peliculas/editar"; // Thymeleaf view
    }

    // Actualizar película editada
    @PostMapping("/actualizar/{id}")
    public String actualizarPelicula(@PathVariable("id") Integer id, Pelicula pelicula) {
        pelicula.setId(id);
        peliculaService.guardar(pelicula);
        return "redirect:/peliculas";
    }

    // Eliminar película
    @GetMapping("/eliminar/{id}")
    public String eliminarPelicula(@PathVariable("id") Integer id) {
        peliculaService.eliminar(id);
        return "redirect:/peliculas";
    }
}
