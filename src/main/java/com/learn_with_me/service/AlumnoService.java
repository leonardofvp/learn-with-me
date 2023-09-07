package com.learn_with_me.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.learn_with_me.models.entity.Alumno;
import com.learn_with_me.repository.AlumnoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AlumnoService {
	

	private final AlumnoRepository alumnoRepository;
	
	
	public Alumno registrarAlumno(Alumno alumno) {
		
		return this.alumnoRepository.save(alumno);
	}
	
	
	public List< Alumno> listaAlumnos() {
		
		return this.alumnoRepository.findAll();
	}
	/*
	public Alumno buscarPorId(int id){
		Alumno alumno = alumnoRepository.findById(id).get();
		return alumno;
	}
	*/
	
	 public Optional<Alumno> buscarAlumnoPorId(Integer id) {
	        return alumnoRepository.findById(id);
	    }

	public boolean alumnoExiste(String username) {
	        Optional<Alumno> optionalAlumno = alumnoRepository.findByUsername(username);
	        return optionalAlumno.isPresent();
	    }
	
	
	
	
	
	
	public boolean eliminarPorId(int id){
		if (alumnoRepository.existsById(id)) {
			alumnoRepository.deleteById(id);
			return true;
		} else {
			return false;
		}
		
	}

	/*para la validacion simple del registro

	public Alumno buscarPorEmail(String username){
		return alumnoRepository.findByMail(username);
	} */

	// actualizar por id
	public void actualizarAlumno(Alumno alum) {
		alumnoRepository.save(alum);
	}
}
