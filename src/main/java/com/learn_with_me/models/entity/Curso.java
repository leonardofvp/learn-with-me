package com.learn_with_me.models.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
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
@Table(name = "cursos")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_Curso;
    private String nombreCurso;
    private LocalDate fecha_inicio;
    private LocalDate fecha_finalizacion;
    private Integer cantidadVideosVistos;
    private Integer cantidadVideosRestantes;
    private Integer cantidadVideosTotal;
    private String tipoDeAprendizaje;

    @ManyToOne
    @JoinColumn(name = "id_profesor")
    private Profesor profesor;

    @OneToMany(mappedBy = "curso")
    private List<Inscripcion> inscrip;

    @OneToMany(mappedBy = "curso")
    private List<Tarea> tareas;

   @ManyToOne 
   @JoinColumn(name="Id_ruta")
   private Ruta ruta;
}