package com.learn_with_me.controller;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	alumno.setApellidoCompleto("vargas");
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
	
	@GetMapping("/listaAlumnos")
	public List<Alumno> listaAlumnos() {
		return alumnoService.listaAlumnos();
		
	}
	
		

}