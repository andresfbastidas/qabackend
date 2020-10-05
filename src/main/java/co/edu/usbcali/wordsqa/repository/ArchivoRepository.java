package co.edu.usbcali.wordsqa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.usbcali.wordsqa.domain.Archivo;


/**
* Interface for   ArchivoRepository.
*
*/
public interface ArchivoRepository extends JpaRepository<Archivo, Long> {
}
