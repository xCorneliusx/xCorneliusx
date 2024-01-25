package com.prueba.curso.dao;

import com.prueba.curso.models.usuario;

import java.util.List;

public interface UsuarioDao {
    List<usuario>getUsuarios();


    usuario verificarCredenciales(usuario usuario);

    void eliminar(Long id);

    void registrar(usuario usuario);
}
