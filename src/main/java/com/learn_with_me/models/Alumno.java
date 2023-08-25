package com.learn_with_me.models;

import java.time.LocalDate;
import java.util.List;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="alumnos")
public class Alumno extends Persona{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id_alumno;
    private Boolean certificado;
    private String nombreCompleto;
    private String apellidoCompleto;
    private String dni;
    private String mail;
    private LocalDate fechaNacimiento;


    public Alumno() {
    }


	public Alumno(Boolean certificado, String nombreCompleto, String apellidoCompleto, String dni, String mail,
			LocalDate fechaNacimiento) {
		super();
		this.certificado = certificado;
		this.nombreCompleto = nombreCompleto;
		this.apellidoCompleto = apellidoCompleto;
		this.dni = dni;
		this.mail = mail;
		this.fechaNacimiento = fechaNacimiento;
	}


	public long getId() {
		return id_alumno;
	}


	public void setId(long id) {
		this.id_alumno = id;
	}


	public Boolean getCertificado() {
		return certificado;
	}


	public void setCertificado(Boolean certificado) {
		this.certificado = certificado;
	}


	public String getNombreCompleto() {
		return nombreCompleto;
	}


	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}


	public String getApellidoCompleto() {
		return apellidoCompleto;
	}


	public void setApellidoCompleto(String apellidoCompleto) {
		this.apellidoCompleto = apellidoCompleto;
	}


	public String getDNI() {
		return dni;
	}


	public void setDNI(String dni) {
		dni = dni;
	}


	public String getMail() {
		return mail;
	}


	public void setMail(String mail) {
		this.mail = mail;
	}


	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}


	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}


	@Override
	public String toString() {
		return "Alumno [id=" + id_alumno + ", certificado=" + certificado + ", nombreCompleto=" + nombreCompleto
				+ ", apellidoCompleto=" + apellidoCompleto + ", DNI=" + dni + ", mail=" + mail + ", fechaNacimiento="
				+ fechaNacimiento + "]";
	}
    
    


    

}
