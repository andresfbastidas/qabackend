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

import co.edu.usbcali.wordsqa.domain.TipoUsuario;

@SpringBootTest
class TipoUsuarioRepositoryTest {

	
private final static Long idTipoUsuario=null;
	
	@Autowired
	TipoUsuarioRepository tipoUsuarioRepository;
	
	@Test
	@DisplayName("save")
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	@Rollback(false)
	void atest() {
		assertNotNull(tipoUsuarioRepository,  "El userTypeRepository esta nulo");
		
		TipoUsuario tipoUsuario = new TipoUsuario();
		
		tipoUsuario.setEstado("A");
	
		tipoUsuario.setNombreTipoUsuario("ANALISTAS DE QA");
		
		tipoUsuarioRepository.save(tipoUsuario);
	}
	
	@Test
	@DisplayName("findById")
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	@Rollback(false)
	void btest() {
		assertNotNull(tipoUsuarioRepository,  "El tipoUsuarioRepository esta nulo");
        assertTrue(tipoUsuarioRepository.findById(idTipoUsuario).isPresent(), "el tipo de usuario con id" + idTipoUsuario+  "es nulo");
	}
	
	@Test
	@DisplayName("update")
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	@Rollback(false)
	void ctest() {
		assertNotNull(tipoUsuarioRepository,  "El tipoUsuarioRepository esta nulo");
        assertTrue(tipoUsuarioRepository.findById(idTipoUsuario).isPresent(), "el tipo de usuario con id" + idTipoUsuario+  "es nulo");
        
        TipoUsuario tipoUsuario = tipoUsuarioRepository.findById(idTipoUsuario).get();
        tipoUsuario.setEstado("D");
        tipoUsuarioRepository.save(tipoUsuario);
	}
	
	@Test
	@DisplayName("delete")
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	@Rollback(false)
	void dtest() {
		assertNotNull(tipoUsuarioRepository,  "El tipoUsuarioRepository esta nulo");
        assertTrue(tipoUsuarioRepository.findById(idTipoUsuario).isPresent(), "el tipo de usuario con id" + idTipoUsuario+  "es nulo");
        
        TipoUsuario tipoUsuario = tipoUsuarioRepository.findById(idTipoUsuario).get();
        tipoUsuarioRepository.delete(tipoUsuario);
	}
	
	@Test
	@DisplayName("findAll")
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	@Rollback(false)
	void etest() {
		assertNotNull(tipoUsuarioRepository,  "El tipoUsuarioRepository esta nulo");
        List<TipoUsuario> tipoUsuarios = tipoUsuarioRepository.findAll();
        assertFalse(tipoUsuarios.isEmpty(), "Los  tipos de usuarios estan vacios");
	}


}
