package com.learn_with_me.modelsResponse;

import java.util.Base64;

import com.learn_with_me.models.entity.Alumno;


import lombok.Data;

@Data
public class ImagenResponse {
    
	private Integer id_Imagen;
	private String mime; 
	private String nombre;
	private String base64Encoded;
				
	public ImagenResponse(Alumno alumno){
		this.id_Imagen = alumno.getImagen().getId_Imagen();
		this.nombre = alumno.getImagen().getNombre();
		this.mime = alumno.getImagen().getMime();
		this.base64Encoded = Base64.getEncoder().encodeToString(alumno.getImagen().getContenido());
	}

}

