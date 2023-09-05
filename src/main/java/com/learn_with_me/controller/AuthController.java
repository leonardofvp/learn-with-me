package com.learn_with_me.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn_with_me.execptions.MiException;
import com.learn_with_me.models.entity.Alumno;
import com.learn_with_me.models.entity.Profesor;
import com.learn_with_me.modelsRequest.UsuarioRegistro;
import com.learn_with_me.repository.AlumnoRepository;
import com.learn_with_me.repository.ProfesorRepository;
import com.learn_with_me.service.AlumnoService;
import com.learn_with_me.service.ProfesorService;
import com.learn_with_me.utils.Rol;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AlumnoService alumnoService;

    @Autowired
    private AlumnoRepository alumnoRepository;

    @Autowired
    private ProfesorRepository profesorRepository;

    @Autowired
    private ProfesorService profesorService;

    @PostMapping("/login")
    public ResponseEntity<String> Login(@RequestBody Alumno alumno) {

        String email = alumno.getMail();
        String password = alumno.getPassword();

        Alumno alu = alumnoService.buscarPorEmail(email);

        if (alu != null && alu.getPassword().equals(password)) {

            return new ResponseEntity<String>("Bienvenido  usuario: " + alu.getNombreCompleto(),
                    HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<String>("Usuario o clave incorrecta ", HttpStatus.BAD_REQUEST);
    }

    
    @PostMapping("/registro")
    public ResponseEntity<String> registrarAlumno(@RequestBody @Valid UsuarioRegistro usuario) {
        
        Alumno alumno = new Alumno();
        Profesor profesor = new Profesor();        
        int num_matriculaAlumno = alumnoRepository.ultimoId();
        int num_matriculaProfesor = profesorRepository.ultimoId();

        String tipo1 = Rol.PROFESOR.name();
        String tipo2 = Rol.ALUMNO.name();
        String rolRquest = usuario.getRol().toString();
        LocalDate fechaNac;
        
        // validacion de la fecha
        try {
           fechaNac = usuario.validarFecha(usuario.getFechaNacimiento());
        } catch (MiException miException) {
            System.out.println(miException.getMessage() + "---------");
           return new ResponseEntity<String>(miException.getMessage(), miException.getStatus());         
        }
        
        // si el email esta registrdo no permite el registro
        // todo---< para refactorizar pover los metodos a servicio y colocar esta codicion dentro del condicional de alumno y prof
        if (alumnoRepository.existsByMail(usuario.getMail()) || profesorRepository.existsByMail(usuario.getMail())){
            return new ResponseEntity<String>("usuario ya existe", HttpStatus.BAD_REQUEST);
        }

        // depende del rol se va a regustrar in alumnono prefesor
        if (rolRquest.equalsIgnoreCase(tipo2)) {

            num_matriculaAlumno++;
            alumno.setNombreCompleto(usuario.getNombreCompleto());
            alumno.setApellidoCompleto(usuario.getApellidoCompleto());
            alumno.setDni(usuario.getDni());
            alumno.setMail(usuario.getMail());
            alumno.setPassword(usuario.getPassword());
            alumno.setPais(usuario.getPais());
            alumno.setRol(tipo2);
            alumno.setFechaNacimiento((fechaNac));
            alumno.setCertificado(false);
            alumno.setEstado("registrado");
            alumno.setMatricula("LWMA-" + String.valueOf(num_matriculaAlumno));
            alumnoService.registrarAlumno(alumno);
            return new ResponseEntity<String>(" Alumno registrado con exito", HttpStatus.OK);

        }else if(rolRquest.equalsIgnoreCase(tipo1)){
            
            num_matriculaProfesor++;
            profesor.setMatricula("LWMP-" + String.valueOf(num_matriculaProfesor));
            profesor.setRol(tipo1);
            profesor.setNombreCompleto(usuario.getNombreCompleto());
            profesor.setApellidoCompleto(usuario.getApellidoCompleto());
            profesor.setDni(usuario.getDni());
            profesor.setMail(usuario.getMail());
            profesor.setPassword(usuario.getPassword());
            profesor.setPais(usuario.getPais());
            profesor.setEspecialidad("java");
            //llamar profesor service para guardar db
            profesorService.registrarProfesor(profesor);
            return new ResponseEntity<String>(" Profesor registrado con exito", HttpStatus.ACCEPTED);
        }
        
        // si el roll no coincide se mostrara un mensaje pidiendo que se ingrese el rol correcto
        return new ResponseEntity<String>("Ingrese un rol de alumno o profesor", HttpStatus.BAD_REQUEST);
        

    }
}
