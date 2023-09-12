package com.learn_with_me.service;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.learn_with_me.Auth.RegisterRequest;
import com.learn_with_me.execptions.MiException;
import com.learn_with_me.models.entity.Alumno;
import com.learn_with_me.models.entity.Imagen;
import com.learn_with_me.modelsRequest.AlumnoActualizarRequest;
import com.learn_with_me.repository.AlumnoRepository;
import com.learn_with_me.repository.ImagenRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AlumnoService {

	private final AlumnoRepository alumnoRepository;

	private final PasswordEncoder passwordEncoder;

	private final ImagenRepository imagenRepository;

	public Alumno registrarAlumno(Alumno alumno) {

		return this.alumnoRepository.save(alumno);
	}

	public List<Alumno> listaAlumnos() {

		return this.alumnoRepository.findAll();
	}

	public Iterable<Alumno> findAll() {
		return alumnoRepository.findAll();
	}

	public Optional<Alumno> buscarAlumnoPorId(Integer id) {
		return alumnoRepository.findById(id);
	}

	public boolean alumnoExiste(String username) {
		Optional<Alumno> optionalAlumno = alumnoRepository.findByUsername(username);
		return optionalAlumno.isPresent();
	}

	public boolean eliminarPorId(int id) {
		if (alumnoRepository.existsById(id)) {
			alumnoRepository.deleteById(id);
			return true;
		} else {
			return false;
		}

	}

	// actualizar por id
	public void actualizarAlumno(Alumno alum) {
		alumnoRepository.save(alum);
	}

	// obtener el ultimo id registrado
	public Integer ultimoIdRegistrado() {

		Integer id = alumnoRepository.ultimoId();
		if (id == null) {

			id = 0;

		}
		return id;
	}

	// actualizar imagen

	public ResponseEntity<?> actualizarRegistro(AlumnoActualizarRequest request, Integer id) throws MiException {
		
		RegisterRequest validarFecha = new RegisterRequest();
		LocalDate fechaNac;
		// construimos la imagen con los datos del multipar
		MultipartFile archivo = request.getFile();
		
		Optional<Alumno> alumnoOptional;
		Optional<Imagen> imagenOptional; 
		Imagen imagenNueva = new Imagen();
		Alumno alumno;
		
		//validamops la fecha
		fechaNac =  validarFecha.validarFecha(request.getFechaNacimiento());
		
		
		//validamos que el archivo no venga nulo
		if (archivo != null) {
			
			imagenNueva.setMime(archivo.getContentType());
			imagenNueva.setNombre(archivo.getOriginalFilename());
			

			try {
				imagenNueva.setContenido(archivo.getBytes());
			} catch (IOException e) {
				
				e.printStackTrace();
			}

		}
		
		

		//buscamos el alumno por el id
		alumnoOptional = this.buscarAlumnoPorId(id);
		//verificamos si laimagen esta en la base de datos
		imagenOptional = imagenRepository.findByNombre(imagenNueva.getNombre());
		//creamos un objeto alumno
		alumno = alumnoOptional.get();

		//verificamos si la imagen esta presente le seteamos la imagen al alumno sino
		// guardamos la image y le seteamos al alumno
		if (!imagenOptional.isPresent()) {
			imagenRepository.save(imagenNueva);
			imagenRepository.deleteById(imagenOptional.get().getId_Imagen());;
			alumno.setImagen(imagenNueva);
		}
		
		//---------<sadadadf
		//caragamos los nuevos datos del alumno
	
		if (alumnoOptional.isPresent()) {
			
			alumno.setNombreCompleto(request.getNombreCompleto());
			alumno.setApellidoCompleto(request.getApellidoCompleto());
			alumno.setDni(request.getDni());
			alumno.setUsername(alumnoOptional.get().getUsername());
			alumno.setPassword(passwordEncoder.encode(request.getPassword()));
			alumno.setPais(request.getPais());
			alumno.setFechaNacimiento((fechaNac));
			
			//imagenDefaul.setAlumno(alumno);

			// actualizamos el alumno
			this.actualizarAlumno(alumno);
			return new ResponseEntity<String>("Usuario actualizado correctamente" , HttpStatus.OK );
		}

		throw new MiException(" cargue una imagen o el id no existe", HttpStatus.BAD_REQUEST);
		
	}


}
