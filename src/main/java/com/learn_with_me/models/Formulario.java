package com.learn_with_me.models;

import java.util.List;

public class Formulario {
    private String idFormulario;
    private List<String> preguntas;

    public Formulario() {
    }

    public Formulario(String idFormulario, List<String> preguntas) {
        this.idFormulario = idFormulario;
        this.preguntas = preguntas;
    }

    public String getIdFormulario() {
        return idFormulario;
    }

    public void setIdFormulario(String idFormulario) {
        this.idFormulario = idFormulario;
    }

    public List<String> getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(List<String> preguntas) {
        this.preguntas = preguntas;
    }
    
    
}
