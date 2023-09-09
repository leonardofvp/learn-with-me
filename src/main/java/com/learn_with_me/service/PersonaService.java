package com.learn_with_me.service;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.learn_with_me.models.entity.Alumno;
import com.learn_with_me.models.entity.Profesor;
import com.learn_with_me.repository.AlumnoRepository;
import com.learn_with_me.repository.ProfesorRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PersonaService {

	private final AlumnoRepository alumnoRepository;
	
	private final ProfesorRepository profesorRepository;
	

	public UserDetails findUserByUsername(String username) {
		UserDetails user;
		Optional<Alumno> alumnoOptional = alumnoRepository.findByUsername(username);
		if (alumnoOptional.isPresent()) {
			user = alumnoOptional.get();
			return user;
		} else {
			Optional<Profesor> profesorOptional = profesorRepository.findByUsername(username);
			if (profesorOptional.isPresent()) {
			user = profesorOptional.get();
				return user;
			} else {
				return null;
			}
		}
	}
}
