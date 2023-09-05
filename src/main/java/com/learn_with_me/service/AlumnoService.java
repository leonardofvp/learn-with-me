package com.learn_with_me.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn_with_me.models.entity.Alumno;
import com.learn_with_me.repository.AlumnoRepository;

@Service
public class AlumnoService {
	
	@Autowired
	private AlumnoRepository alumnoRepository;
	
	
	public Alumno registrarAlumno(Alumno alumno) {
		
		return this.alumnoRepository.save(alumno);
	}
	
	
	public List< Alumno> listaAlumnos() {
		
		return this.alumnoRepository.findAll();
	}
	
	public Alumno buscarPorId(int id){
		Alumno alumno = alumnoRepository.findById(id).get();
		return alumno;
	}
	
	public boolean eliminarPorId(int id){
		if (alumnoRepository.existsById(id)) {
			alumnoRepository.deleteById(id);
			return true;
		} else {
			return false;
		}
		
	}

	//para la validacion simple del registro

	public Alumno buscarPorEmail(String email){
		return alumnoRepository.findByMail(email);
	}

	// actualizar por id
	public void actualizarAlumno(Alumno alum) {
		alumnoRepository.save(alum);
	}
}
