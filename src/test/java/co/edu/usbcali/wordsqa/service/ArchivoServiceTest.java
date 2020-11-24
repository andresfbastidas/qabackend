package co.edu.usbcali.wordsqa.service;



import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import co.edu.usbcali.wordsqa.domain.Archivo;
import co.edu.usbcali.wordsqa.domain.Proyecto;

@SpringBootTest
class ArchivoServiceTest {
	
	private final static Long idProyecto = 1L;
	
	@Autowired
	ArchivoService archivoService;
	
	@Autowired
	ProyectoService proyectoService;
/*
	@Test
	@DisplayName("save")
	@Rollback(false)
	void atest() {
		assertNotNull(archivoService,  "El usuarioService esta nulo");
		
		Archivo archivo = new Archivo();
		
		archivo.setNombreArchivo("Proceso de negocio Banco");
		archivo.setUrlArchivo("www");
		
		
		 Optional<Proyecto> proyeOptional = proyectoService.findById(idProyecto);
		 assertTrue(proyeOptional.isPresent(), "el proyecto no existe");
		 
		 Proyecto proyecto = proyeOptional.get();
		 archivo.setProyecto(proyecto);
		
		 try {
			 archivoService.save(archivo);
		} catch (Exception e) {
			assertNull(e, e.getMessage());
		}
		
	}
	*/
    
	

}
