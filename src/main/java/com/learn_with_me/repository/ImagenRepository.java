package com.learn_with_me.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.learn_with_me.models.entity.Imagen;

@Repository
public interface ImagenRepository extends JpaRepository<Imagen, Integer>{
	
	 @Query(value ="SELECT * FROM imagenes WHERE id_imagen = 1", nativeQuery = true)
	 Imagen obtenerImagen();
	
}
