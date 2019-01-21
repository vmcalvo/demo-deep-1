package com.example.demo.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.domain.Persona;
import com.example.demo.domain.Saludo;

@FeignClient(name="posts", url="${customprop.externalUrl}")
public interface SaludoClient {

	@RequestMapping(method = RequestMethod.POST, value = "/hola")
    Saludo getSaludo(Persona persona);
}
