package com.learn_with_me.modelsResponse;


import java.util.List;

import com.learn_with_me.models.entity.Tarea;

import lombok.Data;

@Data
	public class CursoResponse {
	    private Integer id;

	    private String nombreCurso;

	    private String tipoAprendizaje;

	    private Integer cantidadVideos;
	    
	    private List<Tarea> tareas;
	}


