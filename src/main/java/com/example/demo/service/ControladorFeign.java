package com.example.demo.service;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Persona;
import com.example.demo.domain.Saludo;



@RestController
public class ControladorFeign {

	
	@Autowired
	Environment environment;
	@Autowired
	private SaludoClient saludoClient;



	@PostMapping(value = "/pruebaFeignDeclarativo")
	public Saludo holaMundo(@RequestBody Persona persona)  {
		
		
		//translatorClient.getProductsTranslation("A", "B", "C");
		return saludoClient.getSaludo(persona);
	}
}
