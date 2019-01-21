package com.example.demo.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Persona;
import com.example.demo.domain.Saludo;


import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class Controlador {
	@Value("${customprop.vercambiosdeconfig}")
	private String vercambiosdeconfig;
	
	@Autowired
	Environment environment;
	@Autowired
	private SaludoClient saludoClient;

	@RequestMapping(value = "/hola", method = RequestMethod.POST)
	public Saludo holaMundo(@RequestBody Persona persona) throws IOException {
		if (persona.getNombre().equals("error")) {
			throw new IOException("Esto es un error provocado para probar un fallback");
		}
		
		log.info("Controlador1");
		return saludoClient.getSaludo(persona);
		
	}
}
