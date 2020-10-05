package co.edu.usbcali.wordsqa.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.usbcali.wordsqa.domain.Archivo;
import co.edu.usbcali.wordsqa.dto.ArchivoDTO;
import co.edu.usbcali.wordsqa.mapper.ArchivoMapper;
import co.edu.usbcali.wordsqa.service.ArchivoService;


@RestController
@RequestMapping("/api/archivo")
@CrossOrigin(origins = "*")
public class ArchivoRestController {
    private static final Logger log = LoggerFactory.getLogger(ArchivoRestController.class);
    @Autowired
    private ArchivoService archivoService;
    @Autowired
    private ArchivoMapper archivoMapper;

    @GetMapping(value = "/findById/{idArchivo}")
    public ResponseEntity<?> findById(@PathVariable("idArchivo")
    Long idArchivo) {
        log.debug("Request to findById() Archivo");

        try {
            Archivo archivo = archivoService.findById(idArchivo).get();

            return ResponseEntity.ok()
                                 .body(archivoMapper.archivoToArchivoDTO(
                    archivo));
        } catch (Exception e) {
            log.error(e.getMessage(), e);

            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping(value = "/findAll")
    public ResponseEntity<?> findAll() {
        log.debug("Request to findAll() Archivo");

        try {
            return ResponseEntity.ok()
                                 .body(archivoMapper.listArchivoToListArchivoDTO(
                    archivoService.findAll()));
        } catch (Exception e) {
            log.error(e.getMessage(), e);

            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping(value = "/save")
    public ResponseEntity<?> save(@RequestBody
    ArchivoDTO archivoDTO) {
        log.debug("Request to save Archivo: {}", archivoDTO);

        try {
            Archivo archivo = archivoMapper.archivoDTOToArchivo(archivoDTO);
            archivo = archivoService.save(archivo);

            return ResponseEntity.ok()
                                 .body(archivoMapper.archivoToArchivoDTO(
                    archivo));
        } catch (Exception e) {
            log.error(e.getMessage(), e);

            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping(value = "/update")
    public ResponseEntity<?> update(@RequestBody
    ArchivoDTO archivoDTO) {
        log.debug("Request to update Archivo: {}", archivoDTO);

        try {
            Archivo archivo = archivoMapper.archivoDTOToArchivo(archivoDTO);
            archivo = archivoService.update(archivo);

            return ResponseEntity.ok()
                                 .body(archivoMapper.archivoToArchivoDTO(
                    archivo));
        } catch (Exception e) {
            log.error(e.getMessage(), e);

            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping(value = "/delete/{idArchivo}")
    public ResponseEntity<?> delete(@PathVariable("idArchivo")
    Long idArchivo) throws Exception {
        log.debug("Request to delete Archivo");

        try {
            Archivo archivo = archivoService.findById(idArchivo).get();

            archivoService.delete(archivo);

            return ResponseEntity.ok().build();
        } catch (Exception e) {
            log.error(e.getMessage(), e);

            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping(value = "/count")
    public ResponseEntity<?> count() {
        return ResponseEntity.ok().body(archivoService.count());
    }
}
