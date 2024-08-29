package com.empleos.controller;

import com.empleos.model.Perfil;
import com.empleos.model.RegistroAdmin;


import com.empleos.model.Vacante;
import com.empleos.service.IPerfilService;
import com.empleos.service.IRegistroService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;


import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Date;
import java.util.List;


@Controller
@RequestMapping("/registros")
public class RegistroAdminController {



    @Autowired
    private IRegistroService registroService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    public IPerfilService iPerfilService;


    /**
     * Método para renderizar el formulario para crear una nuevo perfil
     * @param registroAdmin
     * @return
     */
     // @GetMapping("/index")
     //public String crear(@ModelAttribute RegistroAdmin registroAdmin) {
    //    return "registros/formRegistroAdmin";
    // }

    @GetMapping("/index")
    public String crear(@ModelAttribute RegistroAdmin registroAdmin, Model model) {
        /*
        List<Perfil> listaperfiles = iPerfilService.buscarTodosPerfiles();
        for(Perfil listaP : listaperfiles) {
            System.out.println(" consulta la listaperfiles = " + listaP.getId()+ "  -> " + listaP.getPerfil());
            //List<Perfil> nombrePerfil = registroAdmin.getPerfiles();
            //System.out.println("nombrePerfil = " + nombrePerfil);
            model.addAttribute("perfiles", listaP);
            System.out.println("lista de perfiles del combo = " + listaP);
        }
       */

        List<Perfil> listaperfiles = iPerfilService.buscarTodosPerfiles();
        model.addAttribute("perfiles", listaperfiles);

        for(Perfil listaP : listaperfiles) {
            model.addAttribute("perfiles", listaP);
            System.out.println(" consulta la listaperfiles en create = " + listaP.getId() + "  -> " + listaP.getPerfil());

        }

        return "registros/formRegistroAdmin";
    }



    @PostMapping("/save")
    public String guardarRegistro(@ModelAttribute RegistroAdmin registroAdmin, BindingResult result, Model model,
                                  RedirectAttributes attributes) {

        String RegistroAdmin = registroAdmin.getUsername();
        System.out.println("username = " + registroAdmin);

        //encriptando la contraseña
        String pwdPlano = registroAdmin.getPassword();
        System.out.println("pwdPlano = " + pwdPlano);

        String pwdEncriptado = passwordEncoder.encode(pwdPlano);
        System.out.println("pwdEncriptado = " + pwdEncriptado);

        registroAdmin.setPassword(pwdEncriptado);

        registroAdmin.setEstatus(1); // Activado por defecto
        registroAdmin.setFechaRegistro(new Date()); // Fecha de Registro, la fecha actual del servidor

        List<Perfil> listaperfiles = registroAdmin.getPerfiles();
        System.out.println("listaperfiles = " + listaperfiles);
        for(Perfil listaP : listaperfiles) {
            System.out.println(" consulta la listaperfiles en save = " + listaP.getId() + "  -> " + listaP.getPerfil());
            System.out.println("listaP objeto completo  = " + listaP);
            System.out.println("listaP objeto listaP.getId() = " + listaP.getId());
            model.addAttribute("perfiles", listaP);

        }


        /*
            //Creamos el Perfil que le asignaremos al usuario nuevo
            Perfil perfil = new Perfil();
            perfil.setId(1); //ponemos el perfil Administrador
            System.out.println("ponemos el perfil en duro : " + perfil);
            registroAdmin.agregar(perfil); //agregamos el perfil
       */


        //Guardamos el usuario en la base de datos. El Perfil se guarda automaticamente
            registroService.guardarRegistro(registroAdmin);
            attributes.addFlashAttribute("msg", "Has sido registrado!");

        return "redirect:/usuarios/index";


    }

}



     /*   obtiene el perfil dela base de datos
        //Lista Perfiles
        List<Perfil> listaperfiles = iPerfilService.buscarTodosPerfiles();

        for(Perfil listaP : listaperfiles) {
            System.out.println(" consulta la listaperfiles en save = " + listaP.getId() + "  -> " + listaP.getPerfil());
            //List<Perfil> nombrePerfil = registroAdmin.getPerfiles();
            System.out.println("listaP objeto completo  = " + listaP);
            model.addAttribute("perfiles", listaP.getId());
            System.out.println("listaP objeto listaP.getId() = " + listaP.getId());
            }
        //

    */
