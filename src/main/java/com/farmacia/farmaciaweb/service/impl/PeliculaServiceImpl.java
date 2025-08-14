/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.farmacia.farmaciaweb.service.impl;



import com.farmacia.farmaciaweb.dao.PeliculaDao;
import com.farmacia.farmaciaweb.domain.Pelicula;
import com.farmacia.farmaciaweb.service.PeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PeliculaServiceImpl implements PeliculaService {

    @Autowired
    private PeliculaDao peliculaDao;

    @Override
    public List<Pelicula> listarTodas() {
        return peliculaDao.findAll();
    }

    @Override
    public Pelicula guardar(Pelicula pelicula) {
        return peliculaDao.save(pelicula);
    }

    @Override
    public Pelicula buscarPorId(Integer id) {
        return peliculaDao.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Integer id) {
        peliculaDao.deleteById(id);
    }
}
