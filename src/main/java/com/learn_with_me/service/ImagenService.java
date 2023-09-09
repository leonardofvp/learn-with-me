package com.learn_with_me.service;

import java.io.IOException;
import java.util.Optional;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.learn_with_me.execptions.MiException;
import com.learn_with_me.models.entity.Imagen;
import com.learn_with_me.repository.ImagenRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ImagenService {

	// crear un metodo que reciba un multiparfile

	private final ImagenRepository imagenRepository;

	public Imagen crearImagenDefault() { // Este es el tipo de archivo en el q se almacena la imagen

		// para la img
		String imagePath = "img/default.png";
		// Cargar el archivo de imagen como recurso desde el classpath
		Resource resource = new ClassPathResource(imagePath);

		Imagen imagen = new Imagen();
		imagen.setMime("image/jpeg");
		imagen.setNombre(resource.getFilename());
		
		
		try {
			//imagen.setContenido(Files.readAllBytes(resource.getFile().toPath()));
			imagen.setContenido(resource.getContentAsByteArray());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

		//imagenRepository.save(imagen);

		return imagen;

	}

	
	public Imagen obtenerImagenPorId(int idImagen) throws MiException {
        return imagenRepository.findById(idImagen)
                .orElseThrow(() -> new MiException("Imagan no encontrada", HttpStatus.BAD_REQUEST));
    }

}
