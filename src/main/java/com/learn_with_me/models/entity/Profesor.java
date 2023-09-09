package com.learn_with_me.models.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


import com.learn_with_me.utils.Persona;
import com.learn_with_me.utils.Role;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "profesores")
public class Profesor extends Persona {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_profesor;
	private String especialidad;
	
	@OneToMany (mappedBy = "profesor",  cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Curso> cursos;
	
	@OneToMany(mappedBy = "profesor", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Imagen> imagenes = new ArrayList<>();

	
	public Profesor(String nombreCompleto, String apellidoCompleto, String dni, String username, String password,
			LocalDate fechaNacimiento, String pais, String matricula, Role role, Integer id_profesor,
			String especialidad, List<Curso> cursos, List<Imagen> imagenes) {
		super(nombreCompleto, apellidoCompleto, dni, username, password, fechaNacimiento, pais, matricula, role);
		this.id_profesor = id_profesor;
		this.especialidad = especialidad;
		this.cursos = cursos;
		this.imagenes = imagenes;
	}
	
	
	

	
	

	
	

}
