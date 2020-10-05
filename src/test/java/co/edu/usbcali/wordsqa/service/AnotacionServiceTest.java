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

import co.edu.usbcali.wordsqa.domain.Anotacion;
import co.edu.usbcali.wordsqa.domain.Archivo;
import co.edu.usbcali.wordsqa.domain.Categoria;
import co.edu.usbcali.wordsqa.domain.TipoUsuario;

@SpringBootTest
class AnotacionServiceTest {

	private static Long idCategoria = 1L;
	private static Long idAnotacion = null;
	
	@Autowired
	AnotacionService anotacionService;
	
	@Autowired
	CategoriaService categoriaService;
	
	@Test
	@DisplayName("save")
	@Rollback(false)
	void atest() {
		
		Anotacion anotacion = new Anotacion();
		
		anotacion.setDescripcionAnotacion("representa las");
		 Optional<Categoria> cateOptional = categoriaService.findById(idCategoria);
		 assertTrue(cateOptional.isPresent(), "La categoria no existe");
		 
		 Categoria categoria = cateOptional.get();
		 
		 anotacion.setCategoria(categoria);
		
		try {
			anotacionService.save(anotacion);
			assertNotNull(anotacion.getIdAnotacion(),"No genero el id");
			idAnotacion=anotacion.getIdAnotacion();
		} catch (Exception e) {
			assertNull(e,e.getMessage());
		}
	}
	
	

}
