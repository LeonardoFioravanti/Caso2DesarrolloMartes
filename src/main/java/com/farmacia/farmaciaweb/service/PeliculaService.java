/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.farmacia.farmaciaweb.service;


import com.farmacia.farmaciaweb.domain.Pelicula;
import java.util.List;

public interface PeliculaService {
    List<Pelicula> listarTodas();
    Pelicula guardar(Pelicula pelicula);
    Pelicula buscarPorId(Integer id);
    void eliminar(Integer id);
}
