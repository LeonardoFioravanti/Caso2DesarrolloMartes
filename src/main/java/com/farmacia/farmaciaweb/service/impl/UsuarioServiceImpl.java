/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.farmacia.farmaciaweb.service.impl;


import com.farmacia.farmaciaweb.dao.UsuarioDao;
import com.farmacia.farmaciaweb.domain.Usuario;
import com.farmacia.farmaciaweb.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioDao usuarioDao;

    @Override
    public List<Usuario> listarTodos() {
        return usuarioDao.findAll();
    }

    @Override
    public Usuario guardar(Usuario usuario) {
        return usuarioDao.save(usuario);
    }

    @Override
    public Usuario buscarPorId(Integer id) {
        return usuarioDao.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Integer id) {
        usuarioDao.deleteById(id);
    }
}
