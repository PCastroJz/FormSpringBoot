package com.bolsadeideas.springboot.app.springbootformulario.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bolsadeideas.springboot.app.springbootformulario.models.domain.Pais;

@Service
public class PaisServiceImpl implements PaisService{

    private List<Pais> lista;

    public PaisServiceImpl(){
        this.lista = Arrays.asList(
            new Pais(1, "MX", "Mexico"), 
            new Pais(2, "EU", "Estados Unidos"),
            new Pais(3, "CA", "Canada")
        );
    }

    @Override
    public List<Pais> listar() {
        return lista;
    }

    @Override
    public Pais obtenerPorId(Integer id) {
        Pais resultado = null;
        for(Pais pais: this.lista){
            if(id==pais.getId()){
                resultado=pais;
                break;
            }
        }
        return resultado;
    }
    
}
