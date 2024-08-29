package com.empleos.service;

import com.empleos.model.Perfil;


import java.util.List;

public interface IPerfilService {

    public void guardar(Perfil perfil);

    public void eliminar(Integer id);

    List<Perfil> buscarTodosPerfiles();

    public Perfil buscarPorIdPerfil(Integer id);


}
