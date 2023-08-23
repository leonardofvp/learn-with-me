package com.learn_with_me.models;

import java.util.List;

public class Curso {
    private String idCurso;
    private String nombreCurso;
    private Integer cantidadVideos;
    private List<Video> videos;

    public Curso() {
    }

    public Curso(String idCurso, String nombreCurso, Integer cantidadVideos, List<Video> videos) {
        this.idCurso = idCurso;
        this.nombreCurso = nombreCurso;
        this.cantidadVideos = cantidadVideos;
        this.videos = videos;
    }

    public String getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(String idCurso) {
        this.idCurso = idCurso;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public Integer getCantidadVideos() {
        return cantidadVideos;
    }

    public void setCantidadVideos(Integer cantidadVideos) {
        this.cantidadVideos = cantidadVideos;
    }

    public List<Video> getVideos() {
        return videos;
    }

    public void setVideos(List<Video> videos) {
        this.videos = videos;
    }
    
    
}