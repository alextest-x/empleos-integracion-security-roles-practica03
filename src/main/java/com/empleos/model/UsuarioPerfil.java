package com.empleos.model;

import jakarta.persistence.*;

@Entity
@Table(name = "usuarioperfil")
public class UsuarioPerfil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment MySQL
    private Integer idUsuario;

    @OneToOne
    @JoinColumn(name = "idPerfil")
    private Perfil perfil;



    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }


    @Override
    public String toString() {
        return "UsuarioPerfil{" +
                "idUsuario=" + idUsuario +
                ",perfil=" + perfil +
                '}';
    }
}
