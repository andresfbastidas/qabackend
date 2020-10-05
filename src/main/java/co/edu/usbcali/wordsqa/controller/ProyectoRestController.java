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

import co.edu.usbcali.wordsqa.domain.Proyecto;
import co.edu.usbcali.wordsqa.dto.ProyectoDTO;
import co.edu.usbcali.wordsqa.mapper.ProyectoMapper;
import co.edu.usbcali.wordsqa.service.ProyectoService;


@RestController
@RequestMapping("/api/proyecto")
@CrossOrigin(origins = "*")
public class ProyectoRestController {
    private static final Logger log = LoggerFactory.getLogger(ProyectoRestController.class);
    @Autowired
    private ProyectoService proyectoService;
    @Autowired
    private ProyectoMapper proyectoMapper;

    @GetMapping(value = "/findById/{idProyecto}")
    public ResponseEntity<?> findById(
        @PathVariable("idProyecto")
    Long idProyecto) {
        log.debug("Request to findById() Proyecto");

        try {
            Proyecto proyecto = proyectoService.findById(idProyecto).get();

            return ResponseEntity.ok()
                                 .body(proyectoMapper.proyectoToProyectoDTO(
                    proyecto));
        } catch (Exception e) {
            log.error(e.getMessage(), e);

            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping(value = "/findAll")
    public ResponseEntity<?> findAll() {
        log.debug("Request to findAll() Proyecto");

        try {
            return ResponseEntity.ok()
                                 .body(proyectoMapper.listProyectoToListProyectoDTO(
                    proyectoService.findAll()));
        } catch (Exception e) {
            log.error(e.getMessage(), e);

            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping(value = "/save")
    public ResponseEntity<?> save(@RequestBody
    ProyectoDTO proyectoDTO) {
        log.debug("Request to save Proyecto: {}", proyectoDTO);

        try {
            Proyecto proyecto = proyectoMapper.proyectoDTOToProyecto(proyectoDTO);
            proyecto = proyectoService.save(proyecto);

            return ResponseEntity.ok()
                                 .body(proyectoMapper.proyectoToProyectoDTO(
                    proyecto));
        } catch (Exception e) {
            log.error(e.getMessage(), e);

            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping(value = "/update")
    public ResponseEntity<?> update(@RequestBody
    ProyectoDTO proyectoDTO) {
        log.debug("Request to update Proyecto: {}", proyectoDTO);

        try {
            Proyecto proyecto = proyectoMapper.proyectoDTOToProyecto(proyectoDTO);
            proyecto = proyectoService.update(proyecto);

            return ResponseEntity.ok()
                                 .body(proyectoMapper.proyectoToProyectoDTO(
                    proyecto));
        } catch (Exception e) {
            log.error(e.getMessage(), e);

            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping(value = "/delete/{idProyecto}")
    public ResponseEntity<?> delete(@PathVariable("idProyecto")
    Long idProyecto) throws Exception {
        log.debug("Request to delete Proyecto");

        try {
            Proyecto proyecto = proyectoService.findById(idProyecto).get();

            proyectoService.delete(proyecto);

            return ResponseEntity.ok().build();
        } catch (Exception e) {
            log.error(e.getMessage(), e);

            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping(value = "/count")
    public ResponseEntity<?> count() {
        return ResponseEntity.ok().body(proyectoService.count());
    }
}
