package com.learn_with_me.models;

import java.util.List;

public class Test {
    private String idTest;
    private List<String> preguntas;

    public Test() {
    }

    public Test(String idTest, List<String> preguntas) {
        this.idTest = idTest;
        this.preguntas = preguntas;
    }

    public String getIdTest() {
        return idTest;
    }

    public void setIdTest(String idTest) {
        this.idTest = idTest;
    }

    public List<String> getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(List<String> preguntas) {
        this.preguntas = preguntas;
    }
    
    
}
