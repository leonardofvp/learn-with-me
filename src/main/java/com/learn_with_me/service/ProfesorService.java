package com.learn_with_me.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.learn_with_me.models.entity.Profesor;
import com.learn_with_me.repository.ProfesorRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProfesorService {
	
	
	private final ProfesorRepository profesorRepository;
	
	
	
	public Profesor registrarProfesor(Profesor profesor) {
		
		return this.profesorRepository.save(profesor);
	}
	
	
	public List< Profesor> listaProfesores() {
		
		return this.profesorRepository.findAll();
	}
	/*
	public Alumno buscarPorId(int id){
		Alumno alumno = alumnoRepository.findById(id).get();
		return alumno;
	}
	*/
	
	 public Optional<Profesor> buscarPdofesorPorId(Integer id) {
	        return profesorRepository.findById(id);
	    }

	public boolean profesorExiste(String username) {
	        Optional<Profesor> optionalAlumno = profesorRepository.findByUsername(username);
	        return optionalAlumno.isPresent();
	    }
	
	
	public boolean eliminarPorId(int id){
		if (profesorRepository.existsById(id)) {
			profesorRepository.deleteById(id);
			return true;
		} else {
			return false;
		}
		
	}


	public int ultimoIdRegistrado() {
		Integer id = profesorRepository.ultimoId();
		 if(id == null) {
			 
			 id=0;
			 
		 }
			return id;
	}


	
}
