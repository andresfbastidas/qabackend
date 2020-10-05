package co.edu.usbcali.wordsqa.service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import co.edu.usbcali.wordsqa.domain.TipoUsuario;

@SpringBootTest
class TipoUsuarioServiceTest {

	private static Long idTipoUsuario = null;
	
	@Autowired
	TipoUsuarioService tipoUsuarioService;
	
	@Test
	@DisplayName("save")
	@Rollback(false)
	void atest() {
		
		TipoUsuario tipoUsuario = new TipoUsuario();
		
		tipoUsuario.setEstado("Activo");
		tipoUsuario.setIdTipoUsuario(idTipoUsuario);
		tipoUsuario.setNombreTipoUsuario("OTRO 1");
		
		try {
			tipoUsuarioService.save(tipoUsuario);
			assertNotNull(tipoUsuario.getIdTipoUsuario(),"No genero el id");
			idTipoUsuario=tipoUsuario.getIdTipoUsuario();
		} catch (Exception e) {
			assertNull(e,e.getMessage());
		}
	}
	
	@Test
	@DisplayName("findById")
	@Rollback(false)
	void btest() {
		assertNotNull(tipoUsuarioService,  "El tipoUsuario esta nulo");
        assertTrue(tipoUsuarioService.findById(idTipoUsuario).isPresent(), "el tipo de usuario con id" + idTipoUsuario+  "es nulo");
	}
	
	@Test
	@DisplayName("update")
	@Rollback(false)
	void ctest() {
		assertNotNull(tipoUsuarioService,  "El tipoUsuarioService esta nulo");
        assertTrue(tipoUsuarioService.findById(idTipoUsuario).isPresent(), "el tipo de usuario con id" + idTipoUsuario+  "es nulo");
        
        TipoUsuario tipoUsuario = tipoUsuarioService.findById(idTipoUsuario).get();
        tipoUsuario.setEstado("D");
        try {
        	tipoUsuarioService.save(tipoUsuario);
		} catch (Exception e) {
			assertNull(e, e.getMessage());
		}
	}
	
	@Test
	@DisplayName("delete")
	@Rollback(false)
	void dtest() {
		assertNotNull(tipoUsuarioService,  "El tipoUsuarioService esta nulo");
		assertNotNull(tipoUsuarioService.findById(idTipoUsuario).isPresent(), "el tipo de usuario con id" + idTipoUsuario+  "es nulo");
        
        TipoUsuario userType = tipoUsuarioService.findById(idTipoUsuario).get();
        try {
        	tipoUsuarioService.delete(userType);
		} catch (Exception e) {
			assertNull(e, e.getMessage());
		}
	}
	
	@Test
	@DisplayName("findAll")
	@Rollback(false)
	void etest() {
		assertNotNull(tipoUsuarioService,  "El tipoUsuarioService esta nulo");
        List<TipoUsuario> usersType = tipoUsuarioService.findAll();
        assertFalse(usersType.isEmpty(), "Los  tipos de usuarios estan vacios");
	}

}
