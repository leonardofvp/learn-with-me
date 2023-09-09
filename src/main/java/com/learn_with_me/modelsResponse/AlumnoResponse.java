package com.learn_with_me.modelsResponse;

import java.time.LocalDate;
import lombok.Data;


@Data
public class AlumnoResponse {
	
	private Integer id;
	
    private String nombreCompleto;

    private String apellidoCompleto;

    private String dni;

    private LocalDate fechaNacimiento;

    private String pais;
    
 
}
