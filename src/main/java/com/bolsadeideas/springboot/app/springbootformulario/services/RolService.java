package com.bolsadeideas.springboot.app.springbootformulario.services;

import java.util.List;

import com.bolsadeideas.springboot.app.springbootformulario.models.domain.Rol;

public interface RolService {
    
    public List<Rol> listar();
    public Rol obtenerPorId(Integer id);
}
