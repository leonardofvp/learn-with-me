package com.learn_with_me.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn_with_me.execptions.MiException;
import com.learn_with_me.modelsRequest.AlumnoActualizarRequest;
import com.learn_with_me.service.AlumnoService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/alumno")
@RequiredArgsConstructor
public class AlumnoController {
	
	private final AlumnoService alumnoService;
	
	@PutMapping("/actualizarImagen/{id}")
	public ResponseEntity<?> actualizarImg (@ModelAttribute("formData") @Valid  AlumnoActualizarRequest request , @PathVariable("id") Integer id){
		  
		  try {
			alumnoService.actualizarRegistro(request , id);

			return new ResponseEntity<String>("datos actualizados" , HttpStatus.OK);
			
		} catch (MiException e) {

			return new ResponseEntity<String>( e.getMensaje(), e.getStatus() );
		}

	}
	
	
	
	
	
	
	@PutMapping("/actualizarDatos")
	public ResponseEntity<?> actualizarDatos (){
		
		
		return new ResponseEntity<String>("img actualizada" , HttpStatus.OK);
	}

	
	
}
	
	
