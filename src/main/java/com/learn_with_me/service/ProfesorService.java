package com.learn_with_me.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn_with_me.models.entity.Profesor;
import com.learn_with_me.repository.ProfesorRepository;

@Service
public class ProfesorService {
	
	@Autowired
	private ProfesorRepository profesorRepository;
	
	
	public Profesor registrarProfesor(Profesor prof) {
		
		return this.profesorRepository.save(prof);
	}
	
	
	public List< Profesor> listarProfesores() {
		
		return this.profesorRepository.findAll();
	}
	
	public Profesor buscarPorId(int id){
		Profesor profesor = profesorRepository.findById(id).get();
		return profesor;
	}
	
	public boolean eliminarPorId(int id){
		if (profesorRepository.existsById(id)) {
			profesorRepository.deleteById(id);
			return true;
		} else {
			return false;
		}
		
	}

	//para la validacion simple del registro
	public Profesor buscarPorEmail(String email){
		return profesorRepository.findByMail(email);
	}

	// actualizar por id
	public void actualizarProfesorPorId(Profesor prof) {
		profesorRepository.save(prof);
	}
}
