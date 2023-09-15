package com.learn_with_me.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/notificacion")
@RequiredArgsConstructor
public class NotificacionesController {
/* 
	private final NotificacionRepository notificacionRepository;

	@PostMapping("/recibirEmail")
	ResponseEntity<?> guardarEmail(@RequestBody @Valid NotificacionRequest request) {
		
		Notificacion notificacion = new Notificacion();
		notificacion.setUsername(request.getUsername());

		notificacionRepository.save(notificacion);

		return new ResponseEntity<String>("Recibido", HttpStatus.OK);
	}*/

	// todo----> realizar la logica para el emvio de email
	@GetMapping("/enviarNotificaciones")
	public ResponseEntity<?> guardarEmail() {

		return new ResponseEntity<String>("notificaciones enviadas", HttpStatus.OK);
	}

}
