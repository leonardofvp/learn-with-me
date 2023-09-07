package com.learn_with_me.models.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name="tests")
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_Test;
    private String pregunta;
    private String respuesta;

    @ManyToOne
    @JoinColumn(name="id_alum")
    private Alumno alum;

    public Test(Integer id_Test, String pregunta, String respuesta, Alumno alum) {
        this.id_Test = id_Test;
        this.pregunta = pregunta;
        this.respuesta = respuesta;
        this.alum = alum;
    }
}