package com.example.demo.service;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.CompletableFuture;

import java.util.stream.Collectors;


import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.domain.Persona;
import com.example.demo.domain.Saludo;



@RestController
public class ControladorTestAsync {


	@Autowired
	TareaAsincrona tareaAsincrona;
	


	@PostMapping(value = "/pruebaAsync")
	public Saludo holaMundo(@RequestBody Persona persona)  {
		testCompletable();
		return null;
	}
	
	
	public void testCompletable()
	{
//						
//		Map<String,Persona> mapDatos=new HashMap<>();
//		for(int i=0;i<3;i++)
//		{
//			Persona p=new Persona();
//			p.setDni(i+"");
//			p.setNombre(i+"");
//			p.setApellidos(i+"");
//			mapDatos.put(i+"",p);
//		}
//
//
//		List<CompletableFuture<Saludo>> listaFuturos = new ArrayList<>();
//		
//		for (Entry<String, Persona> entry : mapDatos.entrySet()) {
//			listaFuturos.add(tareaAsincrona.asyncMethodWithReturnType(entry.getValue()));
//	    }
//		
//        List<Saludo> result =
//        		listaFuturos.stream()
//                        .map(CompletableFuture::join)
//                        .collect(Collectors.toList());
//
//        System.out.println(result);
	}
	
	
}
