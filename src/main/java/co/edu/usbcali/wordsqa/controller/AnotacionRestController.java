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

import co.edu.usbcali.wordsqa.domain.Anotacion;
import co.edu.usbcali.wordsqa.dto.AnotacionDTO;
import co.edu.usbcali.wordsqa.mapper.AnotacionMapper;
import co.edu.usbcali.wordsqa.service.AnotacionService;


@RestController
@RequestMapping("/api/anotacion")
@CrossOrigin(origins = "*")
public class AnotacionRestController {
    private static final Logger log = LoggerFactory.getLogger(AnotacionRestController.class);
    @Autowired
    private AnotacionService anotacionService;
    @Autowired
    private AnotacionMapper anotacionMapper;

    @GetMapping(value = "/findById/{idAnotacion}")
    public ResponseEntity<?> findById(
        @PathVariable("idAnotacion")
    Long idAnotacion) {
        log.debug("Request to findById() Anotacion");

        try {
            Anotacion anotacion = anotacionService.findById(idAnotacion).get();

            return ResponseEntity.ok()
                                 .body(anotacionMapper.anotacionToAnotacionDTO(
                    anotacion));
        } catch (Exception e) {
            log.error(e.getMessage(), e);

            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping(value = "/findAll")
    public ResponseEntity<?> findAll() {
        log.debug("Request to findAll() Anotacion");

        try {
            return ResponseEntity.ok()
                                 .body(anotacionMapper.listAnotacionToListAnotacionDTO(
                    anotacionService.findAll()));
        } catch (Exception e) {
            log.error(e.getMessage(), e);

            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping(value = "/save")
    public ResponseEntity<?> save(@RequestBody
    AnotacionDTO anotacionDTO) {
        log.debug("Request to save Anotacion: {}", anotacionDTO);

        try {
            Anotacion anotacion = anotacionMapper.anotacionDTOToAnotacion(anotacionDTO);
            anotacion = anotacionService.save(anotacion);

            return ResponseEntity.ok()
                                 .body(anotacionMapper.anotacionToAnotacionDTO(
                    anotacion));
        } catch (Exception e) {
            log.error(e.getMessage(), e);

            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping(value = "/update")
    public ResponseEntity<?> update(@RequestBody
    AnotacionDTO anotacionDTO) {
        log.debug("Request to update Anotacion: {}", anotacionDTO);

        try {
            Anotacion anotacion = anotacionMapper.anotacionDTOToAnotacion(anotacionDTO);
            anotacion = anotacionService.update(anotacion);

            return ResponseEntity.ok()
                                 .body(anotacionMapper.anotacionToAnotacionDTO(
                    anotacion));
        } catch (Exception e) {
            log.error(e.getMessage(), e);

            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping(value = "/delete/{idAnotacion}")
    public ResponseEntity<?> delete(
        @PathVariable("idAnotacion")
    Long idAnotacion) throws Exception {
        log.debug("Request to delete Anotacion");

        try {
            Anotacion anotacion = anotacionService.findById(idAnotacion).get();

            anotacionService.delete(anotacion);

            return ResponseEntity.ok().build();
        } catch (Exception e) {
            log.error(e.getMessage(), e);

            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping(value = "/count")
    public ResponseEntity<?> count() {
        return ResponseEntity.ok().body(anotacionService.count());
    }
}
