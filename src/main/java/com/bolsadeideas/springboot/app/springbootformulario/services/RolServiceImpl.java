package com.bolsadeideas.springboot.app.springbootformulario.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bolsadeideas.springboot.app.springbootformulario.models.domain.Rol;

@Service
public class RolServiceImpl implements RolService {

    private List<Rol> roles;

    public RolServiceImpl() {
        this.roles = Arrays.asList(
                new Rol(1, "ADMIN", "ADM"),
                new Rol(2, "MODERATOR", "MOD"),
                new Rol(3, "USER", "USR"));
    }

    @Override
    public List<Rol> listar() {
        return roles;
    }

    @Override
    public Rol obtenerPorId(Integer id) {
        Rol resultado = null;
        for (Rol rol : roles) {
            if (id == rol.getId()) {
                resultado = rol;
                break;
            }
        }
        return resultado;
    }

}
