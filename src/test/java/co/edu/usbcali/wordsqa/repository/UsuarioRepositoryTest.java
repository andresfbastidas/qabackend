package co.edu.usbcali.wordsqa.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import co.edu.usbcali.wordsqa.domain.TipoUsuario;
import co.edu.usbcali.wordsqa.domain.Usuario;

@SpringBootTest
class UsuarioRepositoryTest {

	
private final static Long idTipoUsuario = 1L;
private final static String emailUsuario = "andresfbastidasm@gmail.com";

@Autowired
UsuarioRepository usuarioRepository;

@Autowired
TipoUsuarioRepository tipoUsuarioRepository;

/*
@Test
@DisplayName("save")
@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
@Rollback(false)
void atest() {
	assertNotNull(usuarioRepository,  "El usuarioRepository esta nulo");
	
	Usuario usuario = new Usuario();
	
	usuario.setEmailUsuario(emailUsuario);
	usuario.setEstado("A");
	usuario.setNombreUsuario("Andres Bastidas");
	
	 Optional<TipoUsuario> tipoUsuOptional = tipoUsuarioRepository.findById(idTipoUsuario);
	 assertTrue(tipoUsuOptional.isPresent(), "el tipo de usuario no existe");
	 
	 TipoUsuario tipoUsuario = tipoUsuOptional.get();
	 
	 usuario.setTipoUsuario(tipoUsuario);
	 usuarioRepository.save(usuario);
	
}

@Test
@DisplayName("findById")
@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
@Rollback(false)
void btest() {
	assertNotNull(usuarioRepository,  "El usuarioRepository esta nulo");
    assertTrue(usuarioRepository.findById(emailUsuario).isPresent(), "el usuario con id" + emailUsuario+  "es nulo");
}

@Test
@DisplayName("update")
@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
@Rollback(false)
void ctest() {
	assertNotNull(usuarioRepository,  "El userRepository esta nulo");
    assertTrue(usuarioRepository.findById(emailUsuario).isPresent(), "el usuario con id" + emailUsuario+  "es nulo");
    
    Usuario usuario = usuarioRepository.findById(emailUsuario).get();
    usuario.setNombreUsuario("Felipe Bastidas");
    usuarioRepository.save(usuario);
}

@Test
@DisplayName("delete")
@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
@Rollback(false)
void dtest() {
	assertNotNull(usuarioRepository,  "El usuarioRepository esta nulo");
    assertTrue(usuarioRepository.findById(emailUsuario).isPresent(), "el usuario con id" + emailUsuario+  "es nulo");
    
    Usuario usuario = usuarioRepository.findById(emailUsuario).get();
    usuarioRepository.delete(usuario);
}

@Test
@DisplayName("findAll")
@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
@Rollback(false)
void etest() {
	assertNotNull(usuarioRepository,  "El userRepository esta nulo");
    List<Usuario> usuarios = usuarioRepository.findAll();
    assertFalse(usuarios.isEmpty(), "Los usuarios esta vacio");
}
*/
}
