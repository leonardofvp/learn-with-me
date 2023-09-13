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

    @OneToMany ( cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name="id_curso")
    private List<Curso> cursos;
    
 

    @OneToMany(mappedBy = "ruta", cascade = CascadeType.ALL)
    private List<Inscripcion> inscrip;

    @ManyToOne
    @JoinColumn(name="id_profesor")
    private Profesor profesor;

    
}
