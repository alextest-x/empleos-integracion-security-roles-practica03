package com.empleos.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;


@Entity
@Table(name = "Usuarios")
public class RegistroAdmin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment MySQL
    private Integer id;

    private String username;

    private String nombre;

    private String email;

    private String password;

    private Integer estatus;

    private Date fechaRegistro;


    @ManyToMany(fetch=FetchType.EAGER) //persiste en el mismo momento todos los perfiles
    @JoinTable(name="UsuarioPerfil",
            joinColumns = @JoinColumn(name="idUsuario"),       //llave foranea de la tabla UsuarioPerfil
            inverseJoinColumns = @JoinColumn(name="idPerfil")  //llave foranea de la tabla UsuarioPerfil
    )
    private List<Perfil> perfiles;    //atributo perfiles porque un usuario va a tener varios perfiles



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getEstatus() {
        return estatus;
    }

    public void setEstatus(Integer estatus) {
        this.estatus = estatus;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public List<Perfil> getPerfiles() {
        return perfiles;
    }


    public void setPerfiles(List<Perfil> perfiles) {
        this.perfiles = perfiles;
    }




    @Override
    public String toString() {
        return "RegistroAdmin{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", estatus=" + estatus +
                ", fechaRegistro=" + fechaRegistro +
               // ", perfiles=" + perfiles +
                '}';
    }

    //metodo helper
    public void agregar(Perfil tempPerfil) {
        //si el perfil es nulo crea una lista
        //si no es nulo entonces la lista ya esta creada
        if (perfiles == null) {
            perfiles = new LinkedList<Perfil>();
        }
        //tempPerfil agrega perfil al usuario
        perfiles.add(tempPerfil);
    }
}
