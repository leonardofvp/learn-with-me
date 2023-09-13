package com.learn_with_me.models.entity;

import java.util.List;

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
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="rutas")
public class Ruta {
     
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_rutas;
    private String descripcion;
    private String tipoAprendizaje;
    private Integer cantidadCursos;

    @OneToMany (mappedBy = "ruta", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Curso> cursos;
    
 

    @OneToMany(mappedBy = "ruta", cascade = CascadeType.ALL)
    private List<Inscripcion> inscrip;

    @ManyToOne
    private Profesor profesor;

    
}
