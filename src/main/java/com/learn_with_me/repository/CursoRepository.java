package com.learn_with_me.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn_with_me.models.entity.Curso;

public interface CursoRepository extends JpaRepository<Curso, Integer> {
    	

}
