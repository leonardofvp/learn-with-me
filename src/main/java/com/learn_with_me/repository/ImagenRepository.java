package com.learn_with_me.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.learn_with_me.models.entity.Imagen;

@Repository
public interface ImagenRepository extends JpaRepository<Imagen, Integer>{
	
	 
	 @Query(value = "SELECT i.* FROM imagenes i WHERE id_alumno = :idAlumno", nativeQuery = true)
	 Imagen obtenerImagenPorIdAlumno(@Param("idAlumno") Integer idAlumno);

	
	Optional<Imagen> findByNombre(String nombre);
}


