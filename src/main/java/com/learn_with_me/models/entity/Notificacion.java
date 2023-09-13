package com.learn_with_me.models.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "notificaciones")
public class Notificacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_Notificacion;

    private String username;

    /*
    @OneToMany (mappedBy = "notificacion")
    private List<Profesor> profesores;
    
   */
    
    @OneToMany ( mappedBy = "notificacion" , cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Profesor> profesores;
    
}