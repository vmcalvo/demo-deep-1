package com.example.demo.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.domain.Persona;
import com.example.demo.domain.Saludo;

@FeignClient(name="saludo", url="${customprop.externalUrl}")
public interface SaludoClient {

	@PostMapping(value = "/hola")
    Saludo getSaludo(Persona persona);
}
