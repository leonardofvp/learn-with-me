package com.learn_with_me.models.entity;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "imagenes")
public class Imagen {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_Imagen;
	
	private String mime; // Se encarga de asignar el formato del archivo de la imagen
	private String nombre;
	
	@ManyToOne
    @JoinColumn(name = "id_alumno")
    private Alumno alumno;
	
	@ManyToOne
    @JoinColumn(name = "id_profesor")
    private Profesor profesor;
	
	@ManyToOne
	@JoinColumn(name ="id_curso")
	private Curso curso;

	@Lob // Con Lob le digo a Spring q el dato puede ser pesado.
	@Basic(fetch = FetchType.LAZY) // Con Basic defino el tipo de carga y se va a cargar solamente cuando le pidamos (lo hago con un GET)
	@Column(length = 10485760) // Aca le doy la caracteristica de la columna							
	private byte[] contenido; // Aca es donde se guarda el contenido de la imagen

	public Imagen(Integer id_Imagen, String mime, String nombre, byte[] contenido) {
		super();
		this.id_Imagen = id_Imagen;
		this.mime = mime;
		this.nombre = nombre;
		this.contenido = contenido;
	}


	
/*
	public Imagen(Resource resource) {
		this.mime = "imagen/jpeg";
		this.nombre = resource.getFilename();
		try {
			this.contenido = Files.readAllBytes(resource.getFile().toPath());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	*/
	

}