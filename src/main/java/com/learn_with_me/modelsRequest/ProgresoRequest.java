package com.learn_with_me.modelsRequest;

import java.time.LocalDate;

import lombok.Data;

@Data
public class ProgresoRequest {

    private Double estadoVideoFaltante;

    private LocalDate fecha_Inicio;

    private Integer tareasCumplidas;

    private Integer totalRuta;

    
}
