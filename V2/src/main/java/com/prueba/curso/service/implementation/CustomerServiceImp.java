package com.prueba.curso.service.implementation;

import com.prueba.curso.dao.CustomerDao;
import com.prueba.curso.models.usuario;
import com.prueba.curso.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerServiceImp implements CustomerService {

    @Autowired
    private CustomerDao customerDao;
    @Override
    public List<usuario> searchByFullNameQueryNative(String name) {
        return customerDao.searchByFullNameQueryNative(name);
    }

    @Override
    public List<usuario> searchByFullNameQueryJPQL(String nombre2) {
        return null;
    }

    @Override
    public List<usuario> findByFullNameContainingIgnoreCase(String nombre3) {
        return null;
    }

    @Override
    public List<usuario> listAll() {
        return null;
    }
}
