package com.learn_with_me.modelsRequest;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class TestRequest {
	
	 
	 @NotBlank(message = "no debe estar en blanco o nulo")
	 @Pattern(regexp = "^[a-zA-ZÀ-ÿ\\s']{1,30}$", message = " solo letras y tener un máximo de 30 caracteres")
	 private String resultado;
	    

}
