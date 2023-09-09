package com.learn_with_me.controller;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.learn_with_me.models.entity.Alumno;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/profesor")
public class ProfesorController {

	//no funciona
	@PostMapping("/upload")
	public ResponseEntity<String> uploadImage(@RequestBody Alumno alum) throws IOException {

		System.out.println(alum);

		// Realiza otras operaciones con la imagen aquí

		return ResponseEntity.ok("Imagen recibida con éxito.");
	}
	
	
                           //funciona de esta forma
	@PostMapping("/upload2")
	public ResponseEntity<String> uploadFile(@RequestParam("username") String username, @RequestParam("password") String password,
			@RequestParam("file") MultipartFile file) {
		System.out.println("Username: " + username);
		System.out.println("Password: " + password);
		System.out.println("File Name: " + file.getOriginalFilename());
		System.out.println("File Size: " + file.getSize() + " bytes");
        return ResponseEntity.ok("Imagen recibida con éxito.");

	}
	
	                      //funciona de esta forma
	@PostMapping("/upload3")
	public ResponseEntity<String> uploadFile3( @RequestPart("username") String username,
		    @RequestPart("password") String password,
		    @RequestPart("file") MultipartFile file) {
		System.out.println("Username: " + username);
		System.out.println("Password: " + password);
		System.out.println("File Name: " + file.getOriginalFilename());
		System.out.println("File Size: " + file.getSize() + " bytes");
        return ResponseEntity.ok("Imagen recibida con éxito.");

	}
	
	
	     /*                   //funciona de esta forma
	 @PostMapping("/upload4")
	    public ResponseEntity<String> uploadFile4(@ModelAttribute("formData") @Valid RequesTest form) {
	        String username = form.getUsername();
	        String password = form.getPassword();
	        MultipartFile file = form.getFile();

	        System.out.println("Username: " + username);
	        System.out.println("Password: " + password);
	        System.out.println("File Name: " + file.getOriginalFilename());
	        System.out.println("File Size: " + file.getSize() + " bytes");

	        // Realiza otras operaciones con la imagen aquí

	        return ResponseEntity.ok("Imagen recibida con éxito.");
	    }
*/

}
