package com.learn_with_me.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.learn_with_me.models.entity.Profesor;

@Repository
public interface ProfesorRepository extends JpaRepository<Profesor, Integer> {

    boolean existsByMail(String  mail);
    
    Profesor findByMail(String mail);
   
    //obtener el id del ultimo registro de la tabla alumno
    @Query(value = "SELECT id_alumno FROM alumnos ORDER BY id_alumno DESC LIMIT 1", nativeQuery = true)
    Integer ultimoId();
    
}
