package com.prueba.curso.controllers;



import com.prueba.curso.dao.UsuarioDao;
import com.prueba.curso.models.usuario;
import com.prueba.curso.security.JWT;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.prueba.curso.service.CustomerService;


import java.util.ArrayList;
import java.util.List;

@RestController
public class UsuariosController {
    @Autowired
    private UsuarioDao usuarioDao;
    @Autowired
    private JWT jwt;

    @Autowired
    private CustomerService customerService;
    @GetMapping(value = "usuario/native")
    public List<usuario> searchCustomerQueryNative(@RequestParam("nombreQueryNative") String nombre, Model model) {

        return customerService.searchByFullNameQueryNative(nombre);
        }

    @RequestMapping(value = "/api/usuarios", method = RequestMethod.GET)
    public List<usuario> getUsuarios(@RequestHeader(value="Authorization")String token) {
        String usuarioId = jwt.getKey(token);
        if (usuarioId ==null){
            return new ArrayList<>();
        }


        return usuarioDao.getUsuarios();
    }
    @RequestMapping(value = "api/usuarios/{id}", method = RequestMethod.DELETE)
    public void eliminar(@PathVariable Long id) {
        usuarioDao.eliminar(id);

    }

    @RequestMapping(value = "/api/usuarios", method = RequestMethod.POST)
    public void registrarUsuario(@RequestBody usuario usuario) {
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        String hash= argon2.hash(1, 1024,1,usuario.getPassword());
        usuario.setPassword(hash);
        usuarioDao.registrar(usuario);

    }



    }


