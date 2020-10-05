package co.edu.usbcali.wordsqa.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import co.edu.usbcali.wordsqa.domain.Categoria;
import co.edu.usbcali.wordsqa.domain.TipoUsuario;

@SpringBootTest
class CategoriaRepositoryTest {

	
private final static Long idTipoUsuario = 4L;
	
	@Autowired
	CategoriaRepository categoriaRepository;
	
	@Test
	@DisplayName("save")
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	@Rollback(false)
	void atest() {
		assertNotNull(categoriaRepository,  "El userTypeRepository esta nulo");
		
		Categoria categoria = new Categoria();
		
	categoria.setNombreCategoria("sadas");
		
		categoriaRepository.save(categoria);
	}
	
	
}
