package com.learn_with_me.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn_with_me.models.Alumno;
import com.learn_with_me.repository.AlumnoRepository;
import com.learn_with_me.service.AlumnoService;
import com.learn_with_me.utils.Rol;

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

		if (alu != null && alu.getPassword().equals(password)) {

			return new ResponseEntity<String>("Bienvenido  usuario: " + alu.getNombreCompleto(),
					HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<String>("Usuario o clave incorrecta ", HttpStatus.BAD_REQUEST);
	}

	
	
	@PostMapping("/registro")
	public ResponseEntity<String> registrarAlumno(@RequestBody Alumno alumno) {

		alumno.setRol(Rol.ALUMNO);

		if(alumnoRepository.existsByMail(alumno.getMail())){
			return new ResponseEntity<String>("usuario ya existe", HttpStatus.BAD_REQUEST);
		}

		if(alumno.getRol() == Rol.PROFESOR){
			alumno.setMatricula("LWMP");
		}else{
			alumno.setMatricula("LWMA");
		}

		alumno.setCertificado(false);
		
		alumnoService.registrarAlumno(alumno);
		return new ResponseEntity<String>("usuario registrado con exito", HttpStatus.ACCEPTED);

	}


	@GetMapping("/listarAlumnos")
	public ResponseEntity<?> listaAlumnos() {
		List<Alumno> ListAlumnos = new ArrayList<>();
		ListAlumnos = alumnoService.listaAlumnos();

		if (ListAlumnos.isEmpty()) {
			return new ResponseEntity<String>("No se ha agregado ningún alumno a la lista", HttpStatus.ACCEPTED);
		}

		return new ResponseEntity<List<Alumno>>(ListAlumnos, HttpStatus.ACCEPTED);

	}

	@GetMapping("/buscarPorId/{id}")
	public ResponseEntity<?> buscarPorID(@PathVariable int id) { // La anotación @PathVariable en el parámetro int id
																	// capturará el valor de id de la URL y lo pasará
																	// como argumento al método.

		if (alumnoRepository.existsById(id)) {
			Alumno alumno = alumnoService.buscarPorId(id);
			return new ResponseEntity<Alumno>(alumno, HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<String>("Usuario no existe", HttpStatus.BAD_REQUEST);

	}

	@PutMapping("/actualizarPorId/{id}")
	public ResponseEntity<String> actualizarAlumno(@PathVariable int id, @RequestBody Alumno alum) {

		if (alumnoRepository.existsById(id)) {
			alum.setId_alumno(id);
			alumnoService.actualizarAlumno(alum);
			return new ResponseEntity<String>("usuario modificado con exito", HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<String>("id de usuario no existe", HttpStatus.BAD_REQUEST);
	}

	@DeleteMapping("/eliminarPorId/{id}")
	public ResponseEntity<String> eliminarPorId(@PathVariable int id) {
		boolean eliminado = alumnoService.eliminarPorId(id);
		if (eliminado) {
			return new ResponseEntity<String>("Usuario eliminado con exito", HttpStatus.ACCEPTED);
		}

		return new ResponseEntity<String>("Usuario no existe", HttpStatus.BAD_REQUEST);

	}
}