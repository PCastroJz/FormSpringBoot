package com.bolsadeideas.springboot.app.springbootformulario.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.bolsadeideas.springboot.app.springbootformulario.editors.EditorsMayus;
import com.bolsadeideas.springboot.app.springbootformulario.editors.PaisPropertyEditor;
import com.bolsadeideas.springboot.app.springbootformulario.editors.RolPropertyEditor;
import com.bolsadeideas.springboot.app.springbootformulario.models.domain.Pais;
import com.bolsadeideas.springboot.app.springbootformulario.models.domain.Rol;
import com.bolsadeideas.springboot.app.springbootformulario.models.domain.Usuario;
import com.bolsadeideas.springboot.app.springbootformulario.services.PaisService;
import com.bolsadeideas.springboot.app.springbootformulario.services.RolService;
import com.bolsadeideas.springboot.app.springbootformulario.validacion.UsuarioValidator;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;


@Controller
@SessionAttributes("usuario")
public class FormController {

    @Autowired
    private UsuarioValidator validator;

    @Autowired
    private PaisService paisService;

    @Autowired
    private RolService rolService;

    @Autowired
    private PaisPropertyEditor paisEditor;

    @Autowired
    private RolPropertyEditor rolEditor;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(validator);
        binder.registerCustomEditor(String.class, "nombre", new EditorsMayus());
        binder.registerCustomEditor(String.class, "apellido", new EditorsMayus());
        binder.registerCustomEditor(Pais.class, "pais", paisEditor);
        binder.registerCustomEditor(Rol.class, "roles", rolEditor);
    }

    @ModelAttribute("genero")
    public List<String> genero(){
        return Arrays.asList("Hombre", "Mujer");
    }

    @ModelAttribute("listaRoles")
    public List<Rol> listaRoles(){
        return this.rolService.listar();
    }


    @ModelAttribute("listaPaises")
    public List<Pais> listaPaises() {
        return paisService.listar();
    }

    @GetMapping("/form")
    public String form(Model model) {
        Usuario usuario = new Usuario();
        usuario.setId("CAJP-000211-HSLSMD-A2");
        usuario.setHabilitar(true);
        usuario.setPais(new Pais(1, "MX", "Mexico"));
        usuario.setRoles(Arrays.asList(new Rol(3, "", "")));
        model.addAttribute("title", "Nuevo formulario");
        model.addAttribute("usuario", usuario);
        return "form";
    }

    @PostMapping("/form")
    public String resultado(@Valid Usuario usuario, BindingResult result, Model model) {
        // validator.validate(usuario, result);
        if (result.hasErrors()) {
            model.addAttribute("title", "Nuevo formulario");
            return "form";
        }

        return "redirect:/ver";
    }

    @GetMapping("/ver")
    public String ver(@SessionAttribute(name="usuario", required = false) Usuario usuario, Model model, SessionStatus status) {

        if(usuario==null){
            return "redirect:/form";
        }
        model.addAttribute("title", "Resultado Formulario");

        status.setComplete();
        return "resultado";
    }
    

}
