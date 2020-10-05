package co.edu.usbcali.wordsqa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.usbcali.wordsqa.domain.Categoria;


/**
* Interface for   CategoriaRepository.
*
*/
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
