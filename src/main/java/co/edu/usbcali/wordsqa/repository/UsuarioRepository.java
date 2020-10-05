package co.edu.usbcali.wordsqa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.usbcali.wordsqa.domain.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, String> {

}
