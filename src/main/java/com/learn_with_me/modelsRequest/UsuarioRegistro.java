package com.learn_with_me.modelsRequest;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import org.springframework.http.HttpStatus;

import com.learn_with_me.execptions.MiException;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class UsuarioRegistro {

    @NotNull(message = "El nombre completo no debe ser nulo")
    @NotBlank(message = "El nombre completo no debe estar en blanco")
    @Pattern(regexp = "^[a-zA-ZÀ-ÿ\\s']{1,30}$", message = "El nombre completo debe contener solo letras y tener un máximo de 30 caracteres")
    private String nombreCompleto;

    @NotNull(message = "El apellido completo no debe ser nulo")
    @NotBlank(message = "El apellido completo no debe estar en blanco")
    @Pattern(regexp = "^[a-zA-ZÀ-ÿ\\s']{1,30}$", message = "El apellido completo debe contener solo letras y tener un máximo de 30 caracteres")
    private String apellidoCompleto;

    @NotNull(message = "El DNI no debe ser nulo")
    @NotBlank(message = "El DNI no debe estar en blanco")
    @Pattern(regexp = "^[0-9]{8}$", message = "El DNI debe ser una cadena de 8 dígitos numéricos")
    private String dni;

    @NotNull(message = "El correo electrónico no debe ser nulo")
    @NotBlank(message = "El correo electrónico no debe estar en blanco")
    // @Email(message = "El formato de la dirección de correo electrónico no es
    // válido")
    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$", message = "La dirección de correo electrónico no es válida")
    private String mail;

    @NotNull(message = "El correo electrónico no debe ser nulo")
    @NotBlank(message = "El correo electrónico no debe estar en blanco")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!]).{8,15}$", message = "La contrase\u00F1a no cumple con los requisitos, ingrese letras mayusculas y minusculas, numeros, un caracter especial y maximo 15")
    private String password;

    @NotNull(message = "La fecha de nacimiento no debe ser nula")
    @NotBlank(message = "El campo fechaNacimiento no debe estar en blanco")
    private String fechaNacimiento;

    @NotNull(message = "El país no debe ser nulo")
    @NotBlank(message = "El país no debe estar en blanco")
    @Pattern(regexp = "^[a-zA-ZÀ-ÿ\\s']{1,30}$", message = "El pais debe contener solo letras y tener un máximo de 30 caracteres")
    private String pais;

    @NotNull(message = "El rol no debe ser nulo")
    @NotBlank(message = "El rol no debe estar en blanco")
    private String rol;

    //validar la fecha de nacimiento
    public LocalDate validarFecha(String fechaNacimiento) throws MiException  {
        try {
            LocalDate fechaNac = LocalDate.parse(fechaNacimiento);
            return fechaNac; 
        } catch (DateTimeParseException  e) {
            throw new MiException("El formato de fecha debe ser yyyy-MM-dd", HttpStatus.BAD_REQUEST);
        }
        
    }
    

}
