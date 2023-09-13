package com.learn_with_me.models.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "cursos")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_Curso;
    private String nombreCurso;
    private Integer cantidadVideos;
    private String tipoDeAprendizaje;


    @OneToMany (mappedBy = "curso")
    @JsonIgnore
    private List<Tarea> tareas;
    
    @ManyToOne
    private Ruta ruta;
}