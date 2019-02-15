package com.example.demo.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.domain.Persona;
import com.example.demo.domain.Saludo;

@EnableFeignClients
@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceTest {

	
	@Autowired
	private SaludoClient saludoClient;
	
	@Test
	public void testCompletable()
	{
		
		Map<String,Persona> mapDatos=new HashMap<>();
		for(int i=0;i<10;i++)
		{
			Persona p=new Persona();
			p.setDni(i+"");
			p.setNombre(i+"");
			p.setApellidos(i+"");			
		}

		List<CompletableFuture<Saludo>> listaFuturos = new ArrayList<CompletableFuture<Saludo>>();
		for (Entry<String, Persona> entry : mapDatos.entrySet()) {
			listaFuturos.add(paralellCall(entry.getValue()));
	    }
		

        List<Saludo> result =
        		listaFuturos.stream()
                        .map(CompletableFuture::join)
                        .collect(Collectors.toList());

        System.out.println(result);
	}
	
	 CompletableFuture<Saludo> paralellCall(Persona persona){

	        CompletableFuture<Saludo> future = CompletableFuture.supplyAsync(new Supplier<Saludo>() {
	            @Override
	            public Saludo get() {
	                final Saludo toDo = saludoClient.getSaludo(persona);

	                return toDo;
	            }
	        });

	        return future;
	    }
}
