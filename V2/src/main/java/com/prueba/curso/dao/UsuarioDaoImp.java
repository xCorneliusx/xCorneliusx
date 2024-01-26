package com.prueba.curso.dao;

import com.prueba.curso.models.usuario;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class UsuarioDaoImp implements  UsuarioDao{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<usuario> getUsuarios() {
       String query = "FROM usuario";
       return entityManager.createQuery(query).getResultList();

    }

    @Override
    public usuario verificarCredenciales(usuario usuario) {
        String query = "FROM usuario WHERE email = :email";
        List<usuario> lista = entityManager.createQuery(query)
                .setParameter("email", usuario.getEmail())
                .getResultList();

        if(lista.isEmpty()){
            return null;
        }

        String passwordHashed = lista.get(0).getPassword();

        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        if (argon2.verify(passwordHashed, usuario.getPassword())){
            return lista.get(0);
        }
        return null;
    }

    @Override
    public void eliminar(Long id) {
        usuario usuario = entityManager.find(com.prueba.curso.models.usuario.class, id);
        entityManager.remove(usuario);


    }

    @Override
    public void registrar(usuario usuario) {
        entityManager.merge(usuario);
    }



}
