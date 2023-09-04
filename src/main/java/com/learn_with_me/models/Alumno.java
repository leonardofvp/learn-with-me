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
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
@Table(name="alumnos")
public class Alumno extends Persona{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_alumno;

	private Boolean certificado;
	private String estado;
	
	@OneToMany (mappedBy = "alumnos")
	private List<Inscripcion> inscrip;

	public Alumno(String nombreCompleto, String apellidoCompleto, String dni, String mail, String password,
			LocalDate fechaNacimiento, String pais, String rol, Integer id_alumno, String matricula, Boolean certificado,
			List<Inscripcion> inscrip) {
		super(nombreCompleto, apellidoCompleto, dni, mail, password, fechaNacimiento, pais, matricula, rol);
		this.id_alumno = id_alumno;
		this.certificado = certificado;
		this.inscrip = inscrip;
	}

	

	

}
