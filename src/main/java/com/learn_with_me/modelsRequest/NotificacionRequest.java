package com.learn_with_me.modelsRequest;

import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class NotificacionRequest {

	@Pattern(regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$", message = "La dirección de correo electrónico no es válida")
	String username;
}
