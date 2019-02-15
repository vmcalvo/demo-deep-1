package com.example.demo.service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

import org.springframework.beans.factory.annotation.Autowired;


import com.example.demo.domain.Persona;
import com.example.demo.domain.Saludo;


public class TareaAsincrona {

	@Autowired
	private SaludoClient saludoClient;
	public CompletableFuture<Saludo> asyncMethodWithReturnType(Persona persona, Executor executor) {
		return CompletableFuture.supplyAsync(()->saludoClient.getSaludo(persona),executor);
	
	}
}
