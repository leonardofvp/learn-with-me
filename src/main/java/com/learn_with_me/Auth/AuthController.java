package com.learn_with_me.Auth;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn_with_me.execptions.MiException;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

	private final AuthService authService;

	@PostMapping("/login")
	public ResponseEntity<AuthResponse> Login(@RequestBody LoginRequest request) {

		return ResponseEntity.ok(authService.login(request));
		/*
		 * String email = alumno.getMail(); String password = alumno.getPassword();
		 * 
		 * Alumno alu = alumnoService.buscarPorEmail(email);
		 * 
		 * if (alu != null && alu.getPassword().equals(password)) {
		 * 
		 * return new ResponseEntity<String>("Bienvenido  usuario: " +
		 * alu.getNombreCompleto(), HttpStatus.ACCEPTED); } return new
		 * ResponseEntity<String>("Usuario o clave incorrecta ",
		 * HttpStatus.BAD_REQUEST);
		 */
	}
	

	@PostMapping("/registro")
	public ResponseEntity<?> registrarAlumno(@RequestBody @Valid RegisterRequest request) {

		// primero se valida que los datos ingresen correctos con @valid
		try {
			return ResponseEntity.ok(authService.register(request));
		} catch (MiException miException) {
			return new ResponseEntity<String>(miException.getMessage(), miException.getStatus());
		}

	}
}
