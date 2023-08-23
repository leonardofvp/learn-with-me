package com.learn_with_me.models;

import java.time.LocalDate;
import java.util.List;

public class Alumno extends Persona{
    private List<Curso> cursos;
    private Test test;
    private Boolean certificado;

    public Alumno() {
    }

    public Alumno(List<Curso> cursos, Test test, Boolean certificado, String idPersona, String nombreCompleto, String apellidoCompleto, String DNI, String mail, LocalDate fechaNacimiento) {
        super(idPersona, nombreCompleto, apellidoCompleto, DNI, mail, fechaNacimiento);
        this.cursos = cursos;
        this.test = test;
        this.certificado = certificado;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    public Boolean getCertificado() {
        return certificado;
    }

    public void setCertificado(Boolean certificado) {
        this.certificado = certificado;
    }

    

}
