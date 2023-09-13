package com.learn_with_me.models.entity;

import java.util.List;

import com.learn_with_me.utils.Persona;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode(callSuper=false)
@Entity
@Table(name = "profesores")
public class Profesor extends Persona {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_profesor;
	private String especialidad;
	
	/*
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_notificacion")
	private Notificacion notificacion;

*/
	
    
}
