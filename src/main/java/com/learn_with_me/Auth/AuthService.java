package com.learn_with_me.Auth;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.learn_with_me.execptions.MiException;
import com.learn_with_me.jwt.JwtService;
import com.learn_with_me.models.entity.Alumno;
import com.learn_with_me.models.entity.Imagen;
import com.learn_with_me.models.entity.Profesor;
import com.learn_with_me.repository.AlumnoRepository;
import com.learn_with_me.repository.ProfesorRepository;
import com.learn_with_me.service.AlumnoService;
import com.learn_with_me.service.ImagenService;
import com.learn_with_me.service.ProfesorService;
import com.learn_with_me.utils.Role;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

	private final AlumnoRepository alumnoRepository;
	private final AlumnoService alumnoService;

	private final ProfesorService profesorService;
	private final ProfesorRepository profesorRepository;

	private final ImagenService imagenService;

	private final JwtService jwtService;

	private final PasswordEncoder passwordEncoder;

	private final AuthenticationManager authenticationManager;

	// logica de login

	public ResponseEntity<?> login(LoginRequest request) throws MiException {

		try {
			Optional<Alumno> alumno = alumnoRepository.findByUsername(request.getUsername());
			Optional<Profesor> profesor = profesorRepository.findByUsername(request.getUsername());

			System.out.println(alumno.isPresent() + "  -----" + profesor.isPresent());

			if (alumno.isPresent() && profesor.isPresent()) {

				System.out.println("entro ene l if y lanza la exception");
				throw new UsernameNotFoundException("usuarios no registrados");
			}

			UserDetails user = (alumno.isPresent()) ? alumno.get() : profesor.get();

			System.out.println("paso el linea 63");

			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));

			String token = jwtService.getToken(user);

			AuthResponse authResponse = new AuthResponse();
			authResponse.setToken(token);

			return ResponseEntity.ok(authResponse);

		} catch (Exception e) {
			System.out.println(" ****** este es el mensaje de la exceptio *****" + e.getMessage());
			throw new MiException("Error de autenticacion clave o password incorrectos", HttpStatus.BAD_REQUEST);

		}

	}

	/*
	 * authenticationManager.authenticate(new
	 * UsernamePasswordAuthenticationToken(request.getUsername(),
	 * request.getPassword()));
	 * 
	 * UserDetails user =
	 * alumnoRepository.findByUsername(request.getUsername()).orElseThrow();
	 * 
	 * 
	 * String token = jwtService.getToken(user);
	 * 
	 * return AuthResponse.builder().token(token).build();
	 */

	// logica resgistro de usuarios
	public ResponseEntity<?> register(RegisterRequest request) throws MiException {

		// instancias necesarias
		AuthResponse authResponse = new AuthResponse();
		Alumno alumno = new Alumno();
		Profesor profesor = new Profesor();

		int num_matriculaAlumno = alumnoService.ultimoIdRegistrado();
		int num_matriculaProfesor = profesorService.ultimoIdRegistrado();

		// para validar el rol que se recibe
		String tipo1 = Role.PROFESOR.name();
		String tipo2 = Role.ALUMNO.name();
		String rolRquest = request.getRol();
		LocalDate fechaNac;
		Imagen imagen;

		// validacion de la fecha para este formato xxx/xx/xx
		fechaNac = request.validarFecha(request.getFechaNacimiento());

		// si el email esta registrdo no permite el registro
		if (alumnoService.alumnoExiste(request.getUsername())
				|| (profesorService.profesorExiste(request.getUsername()))) {
			return new ResponseEntity<String>("usuario ya existe", HttpStatus.BAD_REQUEST);
		}

		// este metodo guarla img por defecto y me devuelta la imagen para asignarsela a
		// al alumno
		imagen = imagenService.crearImagenDefault();

		// despues de las validaciones, depende del rol se va a regustrar un alumnono o
		// prefesor en la db
		if (rolRquest.equalsIgnoreCase(tipo2)) {
			// se crea el alumno
			num_matriculaAlumno++;
			alumno.setNombreCompleto(request.getNombreCompleto());
			alumno.setApellidoCompleto(request.getApellidoCompleto());
			alumno.setDni(request.getDni());
			alumno.setUsername(request.getUsername());
			alumno.setPassword(passwordEncoder.encode(request.getPassword()));
			alumno.setPais(request.getPais());
			alumno.setRole(Role.ALUMNO);
			alumno.setFechaNacimiento((fechaNac));
			alumno.setCertificado(false);
			alumno.setEstado(true);
			alumno.setMatricula("LWMA-" + String.valueOf(num_matriculaAlumno));
			alumno.getImagenes().add(imagen);

			imagen.setAlumno(alumno);

			// guardar db
			alumnoService.registrarAlumno(alumno);

			// asigno el token al usuario creado
			authResponse.setToken(jwtService.getToken(alumno));

			return ResponseEntity.ok(authResponse);

		} else if (rolRquest.equalsIgnoreCase(tipo1)) {
			// se crea el alumno
			num_matriculaProfesor++;
			profesor.setMatricula("LWMP-" + String.valueOf(num_matriculaProfesor));
			profesor.setRole(Role.PROFESOR);
			profesor.setNombreCompleto(request.getNombreCompleto());
			profesor.setApellidoCompleto(request.getApellidoCompleto());
			profesor.setDni(request.getDni());
			profesor.setUsername(request.getUsername());
			profesor.setPassword(passwordEncoder.encode(request.getPassword()));
			profesor.setPais(request.getPais());
			profesor.setEspecialidad("java");
			profesor.setFechaNacimiento(fechaNac);
			profesor.setEstado(true);
			profesor.getImagenes().add(imagen);

			imagen.setProfesor(profesor);

			// guardar db
			profesorService.registrarProfesor(profesor);

			// asigno el token al usuario creado
			authResponse.setToken(jwtService.getToken(profesor));

			return ResponseEntity.ok(authResponse);
		}

		// si el roll no coincide se mostrara un mensaje pidiendo que se ingrese el rol
		// correcto
		throw new MiException("Ingrese un rol de usuario o profesor", HttpStatus.BAD_REQUEST);

	}

	
}
