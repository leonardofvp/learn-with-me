package com.learn_with_me.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@Table(name = "cursos")
public class Curso {
	
 
    
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_Curso;
    private String nombreCurso;
    private Integer cantidadVideos;
    
    @ManyToOne 
    private Profesor profe;
    
	@OneToMany (mappedBy = "cursos")
	private List<Inscripcion> inscrip;	
    
    public Curso(Integer id_Curso, String nombreCurso, Integer cantidadVideos) {
		super();
		this.id_Curso = id_Curso;
		this.nombreCurso = nombreCurso;
		this.cantidadVideos = cantidadVideos;
	}
    
}