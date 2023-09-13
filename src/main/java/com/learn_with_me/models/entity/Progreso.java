package com.learn_with_me.models.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="progresos")
public class Progreso {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_Progreso;

    private LocalDate fecha_Inicio;
    private Integer estadoVideoFaltante;
    private Integer totalRuta; //Sera igual a la cantidad de cursos q haya en la lista del alumno
    private Integer tareasTotales;
	private Integer tareasCumplidas;
	private Integer tareasRestantes;
	
	
	@ManyToOne
	@JoinColumn (name = "id_alumno")
	private Alumno alumno;
	
}
