package com.empleos.service;


import com.empleos.model.RegistroAdmin;
import com.empleos.model.Usuario;

import java.util.List;


public interface IRegistroService {

    void guardarRegistro(RegistroAdmin registroAdmin);

    void eliminarRegistro(Integer id);

    List<RegistroAdmin> buscarTodosRegistros();

    //RegistroAdmin buscarPorId(Integer idUsuario);

    //RegistroAdmin buscarPorUsername(String username);

}
