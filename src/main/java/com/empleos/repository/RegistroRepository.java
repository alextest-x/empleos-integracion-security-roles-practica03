package com.empleos.repository;


import com.empleos.model.RegistroAdmin;
import com.empleos.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RegistroRepository extends JpaRepository<RegistroAdmin, Integer> {

    /*
    // Buscar usuario por username
    RegistroAdmin findByUsername(String username);
    List<RegistroAdmin> findByFechaRegistroNotNull();

    @Modifying
    @Query("UPDATE Usuario u SET u.estatus=0 WHERE u.id = :paramIdUsuario")
    int lock(@Param("paramIdUsuario") int idUsuario);

    @Modifying
    @Query("UPDATE Usuario u SET u.estatus=1 WHERE u.id = :paramIdUsuario")
    int unlock(@Param("paramIdUsuario") int idUsuario);
    */

}
