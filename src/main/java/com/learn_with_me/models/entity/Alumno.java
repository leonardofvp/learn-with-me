package com.learn_with_me.models.entity;

import java.time.LocalDate;
import java.util.List;

import com.learn_with_me.utils.Persona;
import com.learn_with_me.utils.Role;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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
	
	@OneToMany (mappedBy = "alumnos" , fetch = FetchType.LAZY)
	private List<Inscripcion> inscrip;
	
	
	@ManyToOne
    @JoinColumn(name = "id_Imagen") // Nombre de la columna de clave foránea en la tabla de alumnos
    private Imagen imagen;


	public Alumno(String nombreCompleto, String apellidoCompleto, String dni, String username, String password,
			LocalDate fechaNacimiento, String pais, String matricula, Role role, Integer id_alumno, Boolean certificado,
			String estado, List<Inscripcion> inscrip, Imagen imagen) {
		super(nombreCompleto, apellidoCompleto, dni, username, password, fechaNacimiento, pais, matricula, role);
		this.id_alumno = id_alumno;
		this.certificado = certificado;
		this.estado = estado;
		this.inscrip = inscrip;
		this.imagen = imagen;
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









