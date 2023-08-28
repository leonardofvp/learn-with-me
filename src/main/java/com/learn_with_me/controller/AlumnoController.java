package com.learn_with_me.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn_with_me.models.Alumno;
import com.learn_with_me.repository.AlumnoRepository;
import com.learn_with_me.service.AlumnoService;

@RestController
@RequestMapping("/alumno")
public class AlumnoController {

	@Autowired
	private AlumnoService alumnoService;

	@Autowired
	private AlumnoRepository alumnoRepository;

	@PostMapping("/login")
	public ResponseEntity<String> Login(@RequestBody Alumno alumno) {
		
		String email = alumno.getMail();
		String password = alumno.getPassword();

		Alumno alu = alumnoService.buscarPorEmail(email);

		if(alumno != null && alu.getPassword().equals(password) ){

			return new ResponseEntity<String>("Bienvenido  usuario: " + alu.getNombreCompleto(), HttpStatus.BAD_REQUEST);
		}
			return new ResponseEntity<String>("Usuario o clave incorrecta " , HttpStatus.BAD_REQUEST);		
	}




	@PostMapping("/registro")
	public ResponseEntity<String> registrarAlumno(@RequestBody Alumno alumno) {

		if(alumnoRepository.existsByMail(alumno.getMail())){
			return new ResponseEntity<String>("usuario ya existe", HttpStatus.BAD_REQUEST);
		}

		alumno.setCertificado(false);
		alumno.setMatricula("LWM-001");
		alumnoService.registrarAlumno(alumno);
		return new ResponseEntity<String>("usuario registrado con exito", HttpStatus.ACCEPTED);

	}

	@GetMapping("/listarAlumnos")
	public List<Alumno> listaAlumnos() {
		return alumnoService.listaAlumnos();

	}

	@GetMapping("/buscarPorId/{id}")
	public Alumno buscarPorID(@PathVariable int id) { // La anotación @PathVariable en el parámetro int id capturará el
														// valor de id de la URL y lo pasará como argumento al método.
		Alumno alumno = alumnoService.buscarPorId(id);
		return alumno;
	}

	@DeleteMapping("/eliminarPorId/{id}")
	public String eliminarPorId(@PathVariable int id) {
		boolean eliminado = alumnoService.eliminarPorId(id);
		if (eliminado) {
			return "Registro eliminado correctamente";
		} else {
			return "No se encontró el registro con el ID proporcionado";
		}
	}
}