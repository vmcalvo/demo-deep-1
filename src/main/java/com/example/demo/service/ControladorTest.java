package com.example.demo.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import org.apache.catalina.core.ApplicationContext;
import org.apache.logging.log4j.ThreadContext;
import org.jboss.logging.MDC;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.core.env.Environment;
import org.springframework.security.concurrent.DelegatingSecurityContextExecutor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.jwt.Jwt;
import org.springframework.security.jwt.JwtHelper;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import com.example.demo.domain.Persona;
import com.example.demo.domain.Saludo;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class ControladorTest {

	@Autowired
	Environment environment;
	@Autowired
	private SaludoClient saludoClient;
	@Autowired
	OAuth2ClientContext oAuth2ClientContext;

	@PostMapping(value = "/prueba")
	public Saludo holaMundo(@RequestBody Persona persona) throws JsonParseException, JsonMappingException, IOException {
		testCompletable();
		return null;
	}

	public void testCompletable() throws JsonParseException, JsonMappingException, IOException {

		
//
//		if(Optional.of(SecurityContextHolder.getContext())
//	    .map(SecurityContext::getAuthentication)
//	    .map(Authentication::getDetails).isPresent())
//		{
//			ObjectMapper objectMapper = new ObjectMapper();
//			TypeReference<Map<String,Object>> typeRef 
//            = new TypeReference<Map<String,Object>>() {};
//			Map<String, Object> mapDetails = objectMapper.convertValue(SecurityContextHolder.getContext().getAuthentication().getDetails(), typeRef);
//			Object tokenValue = mapDetails.get("tokenValue");
//			if(tokenValue!=null && tokenValue instanceof String)
//			{
//				Jwt jwt = JwtHelper.decode((String) tokenValue);
//				Map<String, Object> claims = objectMapper.readValue(jwt.getClaims(), typeRef);
//				for(Entry<String,Object> entry:claims.entrySet())
//				{
//					MDC.put(entry.getKey(), entry.getValue());
//				}
//			}			
//			
//		}
//		
//		for(Entry<String, Object> entry:MDC.getMap().entrySet())
//		{
//			System.out.println(entry.getKey()+" ---> "+ entry.getValue());
//		}
//		
//	
		
		
log.info("HolaMundo");

	
	SecurityContext securityContext = SecurityContextHolder.getContext();
	Executor delegatedExecutor = Executors.newFixedThreadPool(1);
	Executor delegatingExecutor = new DelegatingSecurityContextExecutor(delegatedExecutor, securityContext);

	Map<String, Persona> mapDatos = new HashMap<>();for(
	int i = 0;i<3;i++)
	{
		Persona p = new Persona();
		p.setDni(i + "");
		p.setNombre(i + "");
		p.setApellidos(i + "");
		mapDatos.put(i + "", p);
	}


	}

	private Map convertir(Object object) {
		// TODO Auto-generated method stub
		return null;
	}



}
