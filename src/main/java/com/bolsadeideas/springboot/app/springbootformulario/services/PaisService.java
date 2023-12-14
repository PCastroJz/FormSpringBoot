package com.bolsadeideas.springboot.app.springbootformulario.services;

import java.util.List;

import com.bolsadeideas.springboot.app.springbootformulario.models.domain.Pais;

public interface PaisService {
    
    public List<Pais> listar();
    public Pais obtenerPorId(Integer id);

}
