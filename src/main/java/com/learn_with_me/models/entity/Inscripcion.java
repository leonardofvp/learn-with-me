package com.learn_with_me.models.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name="inscripciones")
public class Inscripcion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_inscripcion;
	
	@ManyToOne
	@JoinColumn(name="id_curso")
	private Curso curso;
	
	@ManyToOne
	@JoinColumn(name="id_alumno")
	private Alumno alumno;

	public Inscripcion(Integer id_inscripcion, Curso curso, Alumno alumno) {
		super();
		this.id_inscripcion = id_inscripcion;
		this.curso = curso;
		this.alumno = alumno;
	}
	
	

}
