package com.learn_with_me.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn_with_me.execptions.MiException;
import com.learn_with_me.modelsRequest.TestRequest;
import com.learn_with_me.service.TestService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class TestController {

	private final TestService testService;

	@PostMapping("/guardarTest/{id}")
	ResponseEntity<?> guardarTest(@RequestBody @Valid TestRequest request, @PathVariable("id") Integer id) {

		try {
			testService.guardarTest(request, id);
		} catch (MiException miException) {
			System.out.println(miException.getMensaje());
			
			return new ResponseEntity<String>(miException.getMensaje(), miException.getStatus());
		}

		return new ResponseEntity<String>("Test guardado", HttpStatus.OK);
	}

}
