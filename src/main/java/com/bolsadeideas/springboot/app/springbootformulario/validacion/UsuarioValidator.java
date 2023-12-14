package com.bolsadeideas.springboot.app.springbootformulario.validacion;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.bolsadeideas.springboot.app.springbootformulario.models.domain.Usuario;

@Component
public class UsuarioValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Usuario.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        Usuario usuario = (Usuario) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nombre", "NEWENombre");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "apellido", "NEWEApellido");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NEWEUsername");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pais", "NEWEPais");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "genero", "NEWEGenero");

        if (usuario.getId().isEmpty() || usuario.getId().isBlank()) {
            errors.rejectValue("id", "NEWEId");
        } else if (!usuario.getId().matches("[A-Z]{4}[-][0-9]{6}[-][A-Z]{6}[-][A-Z]{1}[0-9]{1}")) {
            errors.rejectValue("id", "RegexId");
        }

        if (!usuario.getPassword().isEmpty() || !usuario.getPassword().isBlank()) {
            if (usuario.getPassword().length() < 6) {
                errors.rejectValue("password", "SizePassword");
            }
            if (!usuario.getPassword().matches(".*[A-Z].*")) {
                errors.rejectValue("password", "MayusPassword");
            }
            if (!usuario.getPassword().matches(".*[0-9].*")) {
                errors.rejectValue("password", "NumPassword");
            }
        } else {
            errors.rejectValue("password", "NEWEPassword");
        }

        if (!usuario.getEmail().isEmpty() || !usuario.getEmail().isBlank()) {
            if (!usuario.getEmail().matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
                errors.rejectValue("email", "ValEmail");
            }
        } else {
            errors.rejectValue("email", "NEWEEmail");
        }

        if (usuario.getCuenta() == null) {
            errors.rejectValue("cuenta", "NullCuenta");
        } else if (usuario.getCuenta() < 10 || usuario.getCuenta() > 5000) {
            errors.rejectValue("cuenta", "valueCuenta");
        }
    }

}
