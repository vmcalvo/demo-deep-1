package com.example.demo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.domain.Persona;
import com.example.demo.domain.Saludo;


@RestController
public class ControladorRestTemplate {
	@Value("${customprop.externalUrl}")
	private String url;
	
	@Autowired
	Environment environment;
	@Autowired
	private RestTemplate saludoClient;


	@PostMapping(value = "/pruebaRestTemplate")
	public Saludo holaMundo(@RequestBody Persona persona)  {		
		ResponseEntity<Saludo> respuesta = saludoClient.postForEntity(url+"/hola",persona, Saludo.class);
		return respuesta.getBody();
	}
}
