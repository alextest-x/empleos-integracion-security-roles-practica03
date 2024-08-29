package com.empleos.controller;

import com.empleos.model.Perfil;
import com.empleos.service.IPerfilService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;


import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.List;


@Controller
@RequestMapping("/perfiles")
public class PerfileController {

        @Autowired
        public IPerfilService servicePerfil;


        @GetMapping("/index")
        public String mostrarPerfiles(Model model){
            List<Perfil> listaPerfiles = servicePerfil.buscarTodosPerfiles();
            model.addAttribute("perfiles", listaPerfiles);
            return "perfiles/listPerfil";
        }


    /**
     * Método para renderizar el formulario para crear una nuevo perfil
     * @paramperfil
     * @return
     */

    @GetMapping("/create")
    public String crear(Perfil perfil, RedirectAttributes attributes) {
        return "perfiles/formPerfil";
    }


    @PostMapping("/save")
    public String guardar(Perfil perfiles, BindingResult result, RedirectAttributes attributes) {
        System.out.println("getPerfil()" + perfiles.getPerfil());
        System.out.println("getPerfil()" + perfiles.getId());
        System.out.println("obtiene perfil: " + perfiles);

        if (result.hasErrors()){
            System.out.println("Existieron errores");
            //attributes.addFlashAttribute("msg", "Error al registrar!");
            return "perfiles/formPerfil";
        }
        // Guardamos el objeto perfil en la bd
        servicePerfil.guardar(perfiles);
        System.out.println("Registrando: " + perfiles);
        attributes.addFlashAttribute("msg", "Los datos del perfil fueron guardados!");
        return "redirect:/perfiles/index";

    }


    /*
     * Método para guardar un perfil en la base de datos
     * //@param perfil
     * //@param result
     * @param-model
     * @param attributes
     * @return
     */

    /*
    @PostMapping("/save")
    public String guardar(Perfil perfil, BindingResult result, RedirectAttributes attributes) {
        System.out.println("getPerfil()" + perfil.getPerfil());
        System.out.println("getPerfil()" + perfil.getId());
        System.out.println("obtiene perfil: " + perfil);
        
        if (result.hasErrors()){
            System.out.println("Existieron errores");
            //attributes.addFlashAttribute("msg", "Error al registrar!");
            return "perfiles/formPerfil";
        }
        // Guardamos el objeto perfil en la bd
        servicePerfil.guardar(perfil);
        System.out.println("Registrando: " + perfil);
        attributes.addFlashAttribute("msg", "Los datos del perfil fueron guardados!");
        return "redirect:/perfiles/index";

    }

    */


    @GetMapping("/delete/{id}")
    public String eliminar(@PathVariable ("id") int idPerfil, Model model, RedirectAttributes attributes) {
        System.out.println("Borrando perfil con id: " + idPerfil);
        servicePerfil.eliminar(idPerfil);
        attributes.addFlashAttribute("msg", "El Perfil: " +  idPerfil + " fue eliminado" );
        return "redirect:/perfiles/index";
    }

    /* error
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.setRequiredFields(new String[]{"perfil"});

    }
    */

  /*
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Currency.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) throws IllegalArgumentException {
                // Custom parsing logic
                String[] parts = text.split(" ");
                setValue(new Currency(parts[0], Double.valueOf(parts[1])));
            }
        });
    }
    */

    /*
    @GetMapping("/delete/{id}")
    public String eliminar(@PathVariable("id") int idPerfil, RedirectAttributes attributes){
        servicePerfil.eliminar(idPerfil);
        attributes.addFlashAttribute("msg", "El Perfil fue eliminado");
        return "redirect:/perfiles/listPerfil";

    }
*/

    /*
   @InitBinder permite crear metodos para configurar el DataBinding directamente en el controlador
    para uno tipo de datos que esten en la vista del input formulario
    como las fechas
 */

    /*
    // fechas
    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");             //false
        webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }
   */

/*
    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor convertAString = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }
*/

}