package com.learn_with_me.models;

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
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "profesores")
public class Profesor extends Persona {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_profesor;
	private String curso;
	
	@OneToMany (mappedBy = "profe")
	private List<Curso> cursos;	

	public Profesor(String nombreCompleto, String apellidoCompleto, String dni, String mail, LocalDate fechaNacimiento,
			String pais, String estado, Integer id_profesor, String curso) {
		super(nombreCompleto, apellidoCompleto, dni, mail, fechaNacimiento, pais, estado);
		this.id_profesor = id_profesor;
		this.curso = curso;
	}

}
