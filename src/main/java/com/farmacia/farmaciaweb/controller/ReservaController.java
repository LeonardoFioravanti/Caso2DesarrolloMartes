package com.farmacia.farmaciaweb.controller;

import com.farmacia.farmaciaweb.domain.Reserva;
import com.farmacia.farmaciaweb.domain.Pelicula;
import com.farmacia.farmaciaweb.service.ReservaService;
import com.farmacia.farmaciaweb.service.PeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/reservas")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    @Autowired
    private PeliculaService peliculaService;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("reservas", reservaService.listarReservas());
        return "reservas/listado";
    }

    @GetMapping("/nueva")
    public String nueva(Model model) {
        model.addAttribute("reserva", new Reserva());
        model.addAttribute("peliculas", peliculaService.listarTodas());
        return "reservas/formulario";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Reserva reserva, @RequestParam Integer peliculaId) {
        Pelicula pelicula = peliculaService.buscarPorId(peliculaId);
        reserva.setPelicula(pelicula);
        reservaService.guardarReserva(reserva);
        return "redirect:/reservas";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Integer id, Model model) {
        model.addAttribute("reserva", reservaService.encontrarReserva(id));
        model.addAttribute("peliculas", peliculaService.listarTodas());
        return "reservas/formulario";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id) {
        reservaService.eliminarReserva(id);
        return "redirect:/reservas";
    }
}
