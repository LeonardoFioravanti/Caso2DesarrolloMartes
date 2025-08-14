package com.farmacia.farmaciaweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SugerenciasController {

    @GetMapping("/sugerencias")
    public String sugerencias() {
        return "sugerencias";
    }
}
