package com.bolsadeideas.springboot.app.springbootformulario.editors;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bolsadeideas.springboot.app.springbootformulario.services.RolService;

@Component
public class RolPropertyEditor extends PropertyEditorSupport{

    @Autowired
    private RolService service;

    @Override
    public void setAsText(String idString) throws IllegalArgumentException {
        try {
            Integer id = Integer.parseInt(idString);
            this.setValue(service.obtenerPorId(id));
        } catch (NumberFormatException e) {
            setValue(null);
        }
    }
    
}
