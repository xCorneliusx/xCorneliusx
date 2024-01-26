package com.prueba.curso.dao;

import com.prueba.curso.models.usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerDao extends JpaRepository<usuario, Integer> {

    @Query(value = "from usuario c where upper(c.nombre) like upper(concat('%', :name,'%'))")
    List<usuario> searchByFullNameQueryNative(@Param("name") String name);

}
