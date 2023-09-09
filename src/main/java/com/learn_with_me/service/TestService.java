package com.learn_with_me.service;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.learn_with_me.execptions.MiException;
import com.learn_with_me.models.entity.Alumno;
import com.learn_with_me.models.entity.Test;
import com.learn_with_me.modelsRequest.TestRequest;
import com.learn_with_me.repository.TestRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TestService {
	
	private final TestRepository testRepository;
	private final AlumnoService alumnoService;
	
	
	public void guardarTest( TestRequest request , Integer id) throws MiException {
		
		Test test = new Test();
		test.setResultado(request.getResultado());
	
		try {
			System.out.println("entro en el try");
			Optional<Alumno> alumno = alumnoService.buscarAlumnoPorId(id);
			test.setAlumno(alumno.get());
			System.out.println(alumno.get().getId_alumno());
			testRepository.save(test);
			
		} catch (Exception e) {
			
			System.out.println("lanzo una excepcion");

			throw new MiException("id alumno invalido", HttpStatus.BAD_REQUEST);
		}
		
				
	}
			
	
	

}
