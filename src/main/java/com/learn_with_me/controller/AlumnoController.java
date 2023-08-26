package com.learn_with_me.controller;


import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn_with_me.models.Alumno;
import com.learn_with_me.service.AlumnoService;

@RestController
@RequestMapping("/alumno")
public class AlumnoController {
	
	@Autowired
	private AlumnoService alumnoService;
	
	@PostMapping("/registro")
	public Alumno registrarAlumno() {
		
	Alumno alumno = new Alumno();
	
	alumno.setApellidoCompleto("vergas");
	alumno.setNombreCompleto("leonardo");
	alumno.setDni("12546587");
	alumno.setMail("leehdhd@gmail.com");
	alumno.setPais("argentina");
	alumno.setEstado("capital");
	alumno.setFechaNacimiento(LocalDate.of(1990, 06, 14));
	alumno.setMatricula("ab-1234");
	alumno.setCertificado(false);
	
	return this.alumnoService.registrarAlumno(alumno);
		
		
	}

}