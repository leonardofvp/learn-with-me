package com.learn_with_me.utils;


import java.time.LocalDate;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@MappedSuperclass
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Persona {
  
	
    private String nombreCompleto;
    private String apellidoCompleto;
    private String dni;
    private String mail;
    private String password;
    private LocalDate fechaNacimiento;
    private String pais;
    private String estado;
    private String rol;

 
}
