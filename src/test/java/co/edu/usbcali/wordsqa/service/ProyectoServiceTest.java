package co.edu.usbcali.wordsqa.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Date;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import co.edu.usbcali.wordsqa.domain.Archivo;
import co.edu.usbcali.wordsqa.domain.Proyecto;

@SpringBootTest
class ProyectoServiceTest {

	private static Long idArchivo = 1L;
	private static Long idProyecto = 1L;
	private static String emailUsuario = "andresfbastidas@hotmail.com";
	
	@Autowired
	ProyectoService proyectoService;
	
	@Autowired
	ArchivoService archivoService;
	
	@Autowired
	UsuarioService usuarioService;
	/*
	@Test
	@DisplayName("save")
	@Rollback(false)
	void atest() {
		
		Proyecto proyecto = new Proyecto();
		 proyecto.setEstado("A");
		 proyecto.setDescripcionProyecto("Proyecto banco de occidente");
		 proyecto.setNombreProyecto("banco de occidente");
		 Date fecha = new Date();
		 proyecto.setFechaCreacion(fecha);
		 
		 proyecto.setEstado("A");
		 Optional<Archivo> archivoOptional = archivoService.findById(idArchivo);
		 assertTrue(archivoOptional.isPresent(), "El archivo no existe");

		
		try {
			proyectoService.save(proyecto);
			assertNotNull(proyecto.getIdProyecto(),"No genero el id");
			
		} catch (Exception e) {
			assertNull(e,e.getMessage());
		}
	}
	
	@Test
	@DisplayName("update")
	@Rollback(false)
	void btest() {
		
		assertNotNull(proyectoService,  "El proyectoRepository esta nulo");
        assertTrue(proyectoService.findById(idProyecto).isPresent(), "el proyecto con id" + idProyecto+  "es nulo");
        
        Proyecto proyecto = proyectoService.findById(idProyecto).get();
        proyecto.setEstado("incativo");
        try {
        	proyectoService.update(proyecto);
		} catch (Exception e) {
			assertNull(e, e.getMessage());
		}
	}
	
	*/

}
