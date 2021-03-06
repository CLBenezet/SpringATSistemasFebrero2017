package com.atsistemas.curso.configuracion;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

public class Inicializadora implements  WebApplicationInitializer{

	//Cuando se levanta el servidor de aplicaciones se ejecuta este metodo
	public void onStartup(ServletContext servletContext) throws ServletException {
		
		//Creamos un objeto que representa el contexto de Spring
		AnnotationConfigWebApplicationContext springContext = 
						new AnnotationConfigWebApplicationContext();
		
		//Configuramos el objeto de contexto de Spring, para que interprete las
		//clases con @Configuration dentro del paquete "com.atsistemas.curso.configuracion"
		springContext
			.setConfigLocation("com.atsistemas.curso.configuracion");
		
		//servletContext.setAttribute("MiContextoDeSpring", springContext);
		
		//
		servletContext.addListener(
				new ContextLoaderListener(
						springContext));
		
	}

}
