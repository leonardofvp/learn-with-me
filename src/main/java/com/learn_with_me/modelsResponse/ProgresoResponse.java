package com.learn_with_me.modelsResponse;

import java.time.LocalDate;
import java.util.List;

import com.learn_with_me.models.entity.Tarea;

import lombok.Data;

@Data
public class ProgresoResponse {

    private Double porcentajeRuta;

    private Double porcentajeTareas;

    private LocalDate fecha_FinRuta;

    private Integer tareasCumplidas;
    
    private List<Tarea> tareasFaltantes;
    


}
