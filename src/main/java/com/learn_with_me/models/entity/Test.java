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
    private String resultado;
    

    @ManyToOne
    @JoinColumn(name="id_alumno")
    private Alumno alumno;


	public Test(Integer id_Test, String resultado, Alumno alumno) {
		super();
		this.id_Test = id_Test;
		this.resultado = resultado;
		this.alumno = alumno;
	}
    
  





  
}