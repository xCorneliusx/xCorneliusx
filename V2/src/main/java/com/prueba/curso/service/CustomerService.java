package com.prueba.curso.service;
import java.util.List;
import com.prueba.curso.models.usuario;

public interface CustomerService {

    List<usuario> searchByFullNameQueryNative(String name);

    List<usuario> searchByFullNameQueryJPQL(String nombre2);

    List<usuario> findByFullNameContainingIgnoreCase(String nombre3);

    List<usuario> listAll();

}