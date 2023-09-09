package com.learn_with_me.Auth;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import org.springframework.http.HttpStatus;

import com.learn_with_me.execptions.MiException;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

   
    @NotBlank(message = "El nombre completo no debe estar en blanco o nulo")
    @Pattern(regexp = "^[a-zA-ZÀ-ÿ\\s']{1,30}$", message = "El nombre completo debe contener solo letras y tener un máximo de 30 caracteres")
    private String nombreCompleto;

    
    @NotBlank(message = "El apellido completo no debe estar en blanco o nulo")
    @Pattern(regexp = "^[a-zA-ZÀ-ÿ\\s']{1,30}$", message = "El apellido completo debe contener solo letras y tener un máximo de 30 caracteres")
    private String apellidoCompleto;

   
    @NotBlank(message = "El DNI no debe estar en blanco o nulo")
    @Pattern(regexp = "^[0-9]{8}$", message = "El DNI debe ser una cadena de 8 dígitos numéricos")
    private String dni;

  
    @NotBlank(message = "El correo electrónico no debe estar en blanco o nulo")
    // @Email(message = "El formato de la dirección de correo electrónico no es
    // válido")
    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$", message = "La dirección de correo electrónico no es válida")
    private String username;

 
    @NotBlank(message = "El correo electrónico no debe estar en blanco o nulo")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!]).{8,15}$", message = "La contrase\u00F1a no cumple con los requisitos, ingrese letras mayusculas y minusculas, numeros, un caracter especial y maximo 15")
    private String password;

  
    @NotBlank(message = "El campo fechaNacimiento no debe estar en blanco formato de fecha YYYY/MM/DD")
    private String fechaNacimiento;

  
    @NotBlank(message = "El país no debe estar en blanco o nulo")
    @Pattern(regexp = "^[a-zA-ZÀ-ÿ\\s']{1,30}$", message = "El pais debe contener solo letras y tener un máximo de 30 caracteres")
    private String pais;

 
    @NotBlank(message = "El rol no debe estar en blanco o nulo")
    private String rol;
    

    //validar la fecha de nacimiento
    public LocalDate validarFecha(String fechaNacimiento) throws MiException  {
        try {
        	//si la fecha que recibe es en formato corrrecto devuelve la fecha como localdate
            LocalDate fechaNac = LocalDate.parse(fechaNacimiento);
            
            // Verifica si la fecha de nacimiento es del pasado
            LocalDate fechaActual = LocalDate.now();
            if (fechaNac.isAfter(fechaActual)) {
                throw new MiException("La fecha de nacimiento debe ser del pasado", HttpStatus.BAD_REQUEST);
            }
            return fechaNac; 
            
        } catch (DateTimeParseException  e) {
            throw new MiException("El formato de fecha debe ser yyyy-MM-dd", HttpStatus.BAD_REQUEST);
        }
        
    }
    

}
