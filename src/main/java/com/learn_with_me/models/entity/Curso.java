package com.learn_with_me.models.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@Table(name = "cursos")
public class Curso {
	
 
    
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_Curso;
    private String nombreCurso;
    private List<Tarea> tareas;
    private LocalDate fecha_inicio;
    private LocalDate fecha_finalizacion;
    private Integer cantidadVideosVistos;
    private Integer cantidadVideosRestantes;
    private Integer cantidadVideosTotal;

    
    @ManyToOne
    @JoinColumn(name="id_profesor")
    private Profesor profesor;
    
	@OneToMany (mappedBy = "curso")
	private List<Inscripcion> inscrip;	
	
	@OneToMany (mappedBy = "curso")
	private List<Imagen> imagenes;

	public Curso(Integer id_Curso, String nombreCurso, List<Tarea> tareas, LocalDate fecha_inicio,
			LocalDate fecha_finalizacion, Integer cantidadVideosVistos, Integer cantidadVideosRestantes,
			Integer cantidadVideosTotal, Profesor profesor, List<Inscripcion> inscrip, List<Imagen> imagenes) {
		super();
		this.id_Curso = id_Curso;
		this.nombreCurso = nombreCurso;
		this.tareas = tareas;
		this.fecha_inicio = fecha_inicio;
		this.fecha_finalizacion = fecha_finalizacion;
		this.cantidadVideosVistos = cantidadVideosVistos;
		this.cantidadVideosRestantes = cantidadVideosRestantes;
		this.cantidadVideosTotal = cantidadVideosTotal;
		this.profesor = profesor;
		this.inscrip = inscrip;
		this.imagenes = imagenes;
	}

	
	
    
}