package com.learn_with_me.modelsRequest;

import org.springframework.web.multipart.MultipartFile;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlumnoActualizarRequest {


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
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!]).{8,15}$", message = "La contrase\u00F1a no cumple con los requisitos, ingrese letras mayusculas y minusculas, numeros, un caracter especial y maximo 15")
    private String password;

  
    @NotBlank(message = "El campo fechaNacimiento no debe estar en blanco formato de fecha YYYY/MM/DD")
    private String fechaNacimiento;

  
    @NotBlank(message = "El país no debe estar en blanco o nulo")
    @Pattern(regexp = "^[a-zA-ZÀ-ÿ\\s']{1,30}$", message = "El pais debe contener solo letras y tener un máximo de 30 caracteres")
    private String pais;
    
    private MultipartFile file;
}
