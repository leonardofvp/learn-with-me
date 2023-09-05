package com.learn_with_me.models.entity;

import java.time.LocalDate;
import java.util.List;

import com.learn_with_me.utils.Persona;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
@Table(name = "profesores")
public class Profesor extends Persona {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_profesor;
	private String curso;  //***** revisar este campoo me parece esta de mas ********   <----- ojo
	private String especialidad;
	
	@OneToMany (mappedBy = "profe")
	private List<Curso> cursos;

	public Profesor(String nombreCompleto, String apellidoCompleto, String dni, String mail, String password,
			LocalDate fechaNacimiento, String pais, String matricula, String rol, Integer id_profesor, String curso,
			String especialidad, List<Curso> cursos) {
		super(nombreCompleto, apellidoCompleto, dni, mail, password, fechaNacimiento, pais, matricula, rol);
		this.id_profesor = id_profesor;
		this.curso = curso;
		this.especialidad = especialidad;
		this.cursos = cursos;
	}

	

	

	

	
	

}
