package co.edu.usbcali.wordsqa.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import co.edu.usbcali.wordsqa.domain.Categoria;

@SpringBootTest
class CategoriaServiceTest {

	private static Long idCategoria = null;

	
	@Autowired
	CategoriaService categoriaService;
	

	
	@Test
	@DisplayName("save")
	@Rollback(false)
	void atest() {
		
	Categoria categoria = new Categoria();
		categoria.setNombreCategoria("prueba 2");
		
		
		try {
			categoriaService.save(categoria);
			assertNotNull(categoria.getIdCategoria(),"No genero el id");
			idCategoria=categoria.getIdCategoria();
		} catch (Exception e) {
			assertNull(e,e.getMessage());
		}
	}
	
	

}
