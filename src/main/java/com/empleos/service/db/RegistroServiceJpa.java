package com.empleos.service.db;

import com.empleos.model.RegistroAdmin;

import com.empleos.repository.RegistroRepository;
import com.empleos.service.IRegistroService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RegistroServiceJpa implements IRegistroService {

    @Autowired
    public RegistroRepository registroRepository;


    @Override
    public void guardarRegistro(RegistroAdmin registroAdmin) {
        registroRepository.save(registroAdmin);
    }


    @Override
    public void eliminarRegistro(Integer idRegistroAdmin) {
        registroRepository.deleteById(idRegistroAdmin);

    }

    @Override
    public List<RegistroAdmin> buscarTodosRegistros() {
        return registroRepository.findAll();
    }


}
