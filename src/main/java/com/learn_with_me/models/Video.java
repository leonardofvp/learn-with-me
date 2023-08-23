package com.learn_with_me.models;

public class Video {
    private String idVideo;
    private String titulo;
    private Integer duracion;

    public Video() {
    }

    public Video(String idVideo, String titulo, Integer duracion) {
        this.idVideo = idVideo;
        this.titulo = titulo;
        this.duracion = duracion;
    }

    public String getIdVideo() {
        return idVideo;
    }

    public void setIdVideo(String idVideo) {
        this.idVideo = idVideo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getDuracion() {
        return duracion;
    }

    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }
    
    
}
