package co.edu.usbcali.wordsqa.service;



import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import co.edu.usbcali.wordsqa.domain.TipoUsuario;
import co.edu.usbcali.wordsqa.domain.Usuario;

@SpringBootTest
class UsuarioServiceTest {
	
	private final static Long idTipoUsuario = 1L;
	private final static String emailUsuario = "andresfbastidas@hotmail.com";
	
	@Autowired
	UsuarioService usuarioService;
	
	@Autowired
	TipoUsuarioService tipoUsuarioService;

	
	@Test
	@DisplayName("save")
	@Rollback(false)
	void atest() {
		assertNotNull(usuarioService,  "El usuarioService esta nulo");
		
		Usuario usuario = new Usuario();
		
		usuario.setEmailUsuario(emailUsuario);
		usuario.setEstado("Activo");
		usuario.setNombreUsuario("Andres Bastidas");
		usuario.setContrasena("123456");
		usuario.setFotoUrl("http//");
		
		 Optional<TipoUsuario> tipoUsuOptional = tipoUsuarioService.findById(idTipoUsuario);
		 assertTrue(tipoUsuOptional.isPresent(), "el tipo de usuario no existe");
		 
		 TipoUsuario tipoUsuario = tipoUsuOptional.get();
		 
		 usuario.setTipoUsuario(tipoUsuario);;
		 try {
			 usuarioService.save(usuario);
		} catch (Exception e) {
			assertNull(e, e.getMessage());
		}
		
	}
    
	@Test
	@DisplayName("findById")
	@Rollback(false)
	void btest() {
		assertNotNull(usuarioService,  "El usuarioService esta nulo");
        assertTrue(usuarioService.findById(emailUsuario).isPresent(), "el usuario con id" + emailUsuario+  "es nulo");
	}

	@Test
	@DisplayName("update")
	@Rollback(false)
	void ctest() {
		assertNotNull(usuarioService,  "El usuarioService esta nulo");
        assertTrue(usuarioService.findById(emailUsuario).isPresent(), "el usuario con id" + emailUsuario+  "es nulo");
        
        Usuario usuario = usuarioService.findById(emailUsuario).get();
        usuario.setNombreUsuario("F Mazuera");
        try {
        	usuarioService.update(usuario);
		} catch (Exception e) {
			assertNull(e, e.getMessage());
		}
	}

	@Test
	@DisplayName("delete")
	@Rollback(false)
	void dtest() {
		assertNotNull(usuarioService,  "El usuarioService esta nulo");
		assertNotNull(usuarioService.findById(emailUsuario).isPresent(), "el usuario con id" + emailUsuario+  "es nulo");
        
        Usuario usuario = usuarioService.findById(emailUsuario).get();
        
        try {
        	usuarioService.delete(usuario);
		} catch (Exception e) {
			assertNull(e, e.getMessage());
		}
	}

	@Test
	@DisplayName("findAll")
	@Rollback(false)
	void etest() {
		assertNotNull(usuarioService,  "El usuarioService esta nulo");
        List<Usuario> users = usuarioService.findAll();
        assertFalse(users.isEmpty(), "Los usuarios esta vacio");
	}

}
