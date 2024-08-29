package com.empleos.service.db;



import com.empleos.model.Perfil;

import com.empleos.repository.PerfilesRepository;
import com.empleos.service.IPerfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class PerfilServiceJpa implements IPerfilService {

    @Autowired
    public PerfilesRepository perfilesRepository;


    @Override
    public void guardar(Perfil perfil) {
        perfilesRepository.save(perfil);
    }


    @Override
    public void eliminar(Integer id) {
        perfilesRepository.deleteById(id);
    }


     @Override
    public List<Perfil> buscarTodosPerfiles() {

         return perfilesRepository.findAll();
         //return (List<Perfil>) perfilesRepository.findAll();
    }


    @Override
    public Perfil buscarPorIdPerfil(Integer id) {
        Optional<Perfil> optional = perfilesRepository.findById(id);
        if(optional.isPresent()){
            return optional.get(); //regresa objeto categoria
        }
        return null; //  regresa un valor nulo si no encuentra el objeto.
    }


}
