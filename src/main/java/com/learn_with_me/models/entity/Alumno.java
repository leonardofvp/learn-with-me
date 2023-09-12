package com.learn_with_me.models.entity;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.learn_with_me.utils.Persona;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.ManyToOne;
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
@Table(name="alumnos")
public class Alumno extends Persona {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_alumno;

	private Boolean certificado;
	
	@OneToMany (mappedBy = "alumno"  , cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore
	private List<Inscripcion> inscrip;
	
	
	@OneToMany (mappedBy = "alumno"  ,cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore
	private List<Test> Tests;
	
	//@OneToMany(mappedBy = "alumno", cascade = CascadeType.ALL, orphanRemoval = true )
	@ManyToOne(fetch = FetchType.LAZY)
	//@JoinColumn(name="id_imagen")
	//@JsonIgnore
	private Imagen imagen;


	

}









