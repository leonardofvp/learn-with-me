package com.learn_with_me.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.learn_with_me.models.entity.Profesor;

@Repository
public interface ProfesorRepository extends JpaRepository<Profesor, Integer> {

	Optional<Profesor> findByUsername(String username); 
    
	
   
    //obtener el id del ultimo registro de la tabla alumno
    @Query(value = "SELECT id_profesor FROM profesores ORDER BY id_profesor DESC LIMIT 1", nativeQuery = true)
    Integer ultimoId();
    
    
}
