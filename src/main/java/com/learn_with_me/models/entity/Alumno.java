package com.learn_with_me.models.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
	private String estado;
	
	@OneToMany (mappedBy = "alumno"  , cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Inscripcion> inscrip;
	
	
	@OneToMany (mappedBy = "alumno"  ,cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Test> Tests;
	
	@OneToMany(mappedBy = "alumno", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore
	private List<Imagen> imagenes = new ArrayList<>();


	public Alumno(String nombreCompleto, String apellidoCompleto, String dni, String username, String password,
			LocalDate fechaNacimiento, String pais, String matricula, Role role, Integer id_alumno, Boolean certificado,
			String estado, List<Inscripcion> inscrip, List<Test> tests) {
		super(nombreCompleto, apellidoCompleto, dni, username, password, fechaNacimiento, pais, matricula, role);
		this.id_alumno = id_alumno;
		this.certificado = certificado;
		this.estado = estado;
		this.inscrip = inscrip;
		Tests = tests;
	}
	
	
	
	/*
	public Alumno(RegisterRequest request) {
        super(
            request.getNombreCompleto(),
            request.getApellidoCompleto(),
            request.getDni(),
            request.getUsername(),
            request.getPassword(),
            request.getFechaNacimiento(),
            request.getPais(),
            request.getMatricula(),
            Role.ALUMNO
        );

        // Inicializa los atributos específicos de Alumno
        this.certificado = false;
        this.estado = "registrado";
    }
    
    */

}









