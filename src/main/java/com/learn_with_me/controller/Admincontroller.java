package com.learn_with_me.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.learn_with_me.models.entity.Alumno;
import com.learn_with_me.models.entity.Curso;
import com.learn_with_me.models.entity.Tarea;
import com.learn_with_me.modelsResponse.AlumnoResponse;
import com.learn_with_me.modelsResponse.CursoResponse;
import com.learn_with_me.modelsResponse.ImagenResponse;
import com.learn_with_me.repository.CursoRepository;
import com.learn_with_me.repository.TareasRepository;
import com.learn_with_me.service.AlumnoService;
import com.learn_with_me.service.CursoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class Admincontroller {

  
    private final  AlumnoService alumnoService;

    private final TareasRepository tareasRepository;
    private final CursoRepository cursoRepository;
    private final CursoService cursoService;

    @GetMapping("/listarAlumnos")
    public ResponseEntity<?> listaAlumnos() {
    	
    	
    	//creamos una lueva lista de alumnosResponse para mostrar los datos que queremos 
    	List<AlumnoResponse> listAlumno = new ArrayList<>();
    	
    	//obtenemos la lista con todos los datos
        List<Alumno> ListAlumnosTodosLosDatos = new ArrayList<>();
        ListAlumnosTodosLosDatos = (List<Alumno>) alumnoService.findAll();

        //verificamos que la lista no viene vacio
        if (ListAlumnosTodosLosDatos.isEmpty()) {
            return new ResponseEntity<String>("No se ha agregado ningún alumno a la lista", HttpStatus.ACCEPTED);
        }

       
        //Recorremos la lista que contiene todos los datos y por cada alumno de esa lista creamos un alumno de la clase aplimnoResponse
        for (Alumno alumno : ListAlumnosTodosLosDatos) {
        // alumno.getImagenes().size(); // Esto cargará las imágenes relacionadas con el alumno
        	AlumnoResponse alumnoResponse = new AlumnoResponse();
        	alumnoResponse.setApellidoCompleto(alumno.getApellidoCompleto());
        	alumnoResponse.setDni(alumno.getDni());
        	alumnoResponse.setFechaNacimiento(alumno.getFechaNacimiento());
        	alumnoResponse.setId(alumno.getId_alumno());
        	alumnoResponse.setNombreCompleto(alumno.getNombreCompleto());
        	alumnoResponse.setPais(alumno.getPais());
            
        	listAlumno.add(alumnoResponse);
            
        }
        
        return new ResponseEntity<List<AlumnoResponse>>(listAlumno, HttpStatus.ACCEPTED);

    }

    @GetMapping("/buscarPorId/{id}")
    public ResponseEntity<?> buscarPorID(@PathVariable int id) { // La anotación @PathVariable en el parámetro int id
                                                                 // capturará el valor de id de la URL y lo pasará
   
    	 Optional<Alumno> alumno = alumnoService.buscarAlumnoPorId(id);
        if (alumno.isPresent()) {
            
        	AlumnoResponse alumnoResponse = new AlumnoResponse();
        	alumnoResponse.setApellidoCompleto(alumno.get().getApellidoCompleto());
        	alumnoResponse.setDni(alumno.get().getDni());
        	alumnoResponse.setFechaNacimiento(alumno.get().getFechaNacimiento());
        	alumnoResponse.setId(alumno.get().getId_alumno());
        	alumnoResponse.setNombreCompleto(alumno.get().getNombreCompleto());
        	alumnoResponse.setPais(alumno.get().getPais());
        	
            return new ResponseEntity<AlumnoResponse>(alumnoResponse, HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<String>("Usuario no existe", HttpStatus.BAD_REQUEST);

    }

    @DeleteMapping("/eliminarPorId/{id}")
    public ResponseEntity<String> eliminarPorId(@PathVariable int id) {
        boolean eliminado = alumnoService.eliminarPorId(id);
        if (eliminado) {
            return new ResponseEntity<String>("Usuario eliminado con exito", HttpStatus.ACCEPTED);
        }

        return new ResponseEntity<String>("Usuario no existe", HttpStatus.BAD_REQUEST);

    }

    @GetMapping("/git stst/{id}")
    public ResponseEntity<?> buscarAlumnoImgPorID(@PathVariable int id) { // La anotación @PathVariable en el parámetro int id
                                                                 // capturará el valor de id de la URL y lo pasará
   
    	 Optional<Alumno> alumno = alumnoService.buscarAlumnoPorId(id);
        if (alumno.isPresent()) {
            ImagenResponse imagen = new ImagenResponse(alumno.get());



        	AlumnoResponse alumnoResponse = new AlumnoResponse();
        	alumnoResponse.setApellidoCompleto(alumno.get().getApellidoCompleto());
        	alumnoResponse.setDni(alumno.get().getDni());
        	alumnoResponse.setFechaNacimiento(alumno.get().getFechaNacimiento());
        	alumnoResponse.setId(alumno.get().getId_alumno());
        	alumnoResponse.setNombreCompleto(alumno.get().getNombreCompleto());
        	alumnoResponse.setPais(alumno.get().getPais());

            

            alumnoResponse.setImagen(imagen);
        	
            return new ResponseEntity<AlumnoResponse>(alumnoResponse, HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<String>("Usuario no existe", HttpStatus.BAD_REQUEST);

    }
    
    @PostMapping
    @RequestMapping("/crearCursos")
    public void crearCursos(){
        Curso html = new Curso();
        html.setNombreCurso("html");
        html.setCantidadVideos(5);
        html.setTipoDeAprendizaje("audiovisual");
        
        Curso css = new Curso();
        css.setNombreCurso("css");
        css.setCantidadVideos(10);
        css.setTipoDeAprendizaje("audiovisual");
        
        Curso js = new Curso();
        js.setNombreCurso("js");
        js.setCantidadVideos(10);
        js.setTipoDeAprendizaje("audiovisual");
        
        Curso react = new Curso();
        react.setNombreCurso("react");
        react.setCantidadVideos(20);
        react.setTipoDeAprendizaje("audiovisual");
        
        List<Tarea> listaTareas = tareasRepository.findAll();
        
        html.setTareas(listaTareas);
        
        cursoRepository.save(html); 

    }
    
    
    @GetMapping("/listarCursos")
    public ResponseEntity<?> listarCursos(){
        List<CursoResponse> listCurso = new ArrayList<>();

        List<Curso> listaCursoTodosLosDatos = new ArrayList<>();
        listaCursoTodosLosDatos = (List<Curso>) cursoService.findAll();

        if (listaCursoTodosLosDatos.isEmpty()) {
            return new ResponseEntity<String>("No se ha agregado ningún curso a la lista", HttpStatus.ACCEPTED);
        }

        for (Curso curso : listaCursoTodosLosDatos) {
            CursoResponse cursoResponse = new CursoResponse();

            cursoResponse.setId(curso.getId_Curso());
            cursoResponse.setNombreCurso(curso.getNombreCurso());
            cursoResponse.setTipoAprendizaje(curso.getTipoDeAprendizaje());
            cursoResponse.setCantidadVideos(curso.getCantidadVideos());
            cursoResponse.setTareas(curso.getTareas());
            listCurso.add(cursoResponse);
        }
        
        

        

        return new ResponseEntity<List<CursoResponse>>(listCurso, HttpStatus.ACCEPTED);
    }

    
    
  
}
