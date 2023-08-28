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
@Table(name="alumnos")
public class Alumno extends Persona{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_alumno;
	private String matricula;
	private Boolean certificado;
	
	@OneToMany (mappedBy = "alumnos")
	private List<Inscripcion> inscrip;	
	
	

	public Alumno(String nombreCompleto, String apellidoCompleto, String dni, String mail, String password,
			LocalDate fechaNacimiento, String pais, String estado, String rol, Integer id_alumno, String matricula,
			Boolean certificado, List<Inscripcion> inscrip) {
		super(nombreCompleto, apellidoCompleto, dni, mail, password, fechaNacimiento, pais, estado, rol);
		this.id_alumno = id_alumno;
		this.matricula = matricula;
		this.certificado = certificado;
		this.inscrip = inscrip;
	}
   

}
