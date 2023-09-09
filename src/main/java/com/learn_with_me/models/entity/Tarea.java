package com.learn_with_me.models.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "tareas")
public class Tarea {
	
    
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_tarea;
    
    private Integer tareasTotales;
    private Integer tareasCumplidas;
    private Integer tareasRestantes;
    
    
	public Tarea(Integer id_tarea, Integer tareasTotales, Integer tareasCumplidas, Integer tareasRestantes) {
		super();
		this.id_tarea = id_tarea;
		this.tareasTotales = tareasTotales;
		this.tareasCumplidas = tareasCumplidas;
		this.tareasRestantes = tareasRestantes;
	}

    

}
