package com.prueba.curso.controllers;

import com.prueba.curso.dao.UsuarioDao;
import com.prueba.curso.models.usuario;
import com.prueba.curso.security.JWT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {


    @Autowired
    private UsuarioDao usuarioDao;
    @Autowired
    private JWT jwt;

    @RequestMapping(value = "/api/login", method = RequestMethod.POST)
    public String login(@RequestBody usuario usuario) {

        usuario usuarioLogueado = usuarioDao.verificarCredenciales(usuario);
        if (usuarioLogueado !=null) {
            String token = jwt.create(String.valueOf(usuarioLogueado.getId()),usuarioLogueado.getEmail());
            return token;
        }
        return "FAIL";

    }
}
