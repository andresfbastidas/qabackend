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

import co.edu.usbcali.wordsqa.domain.Categoria;
import co.edu.usbcali.wordsqa.dto.CategoriaDTO;
import co.edu.usbcali.wordsqa.mapper.CategoriaMapper;
import co.edu.usbcali.wordsqa.service.CategoriaService;


@RestController
@RequestMapping("/api/categoria")
@CrossOrigin(origins = "*")
public class CategoriaRestController {
    private static final Logger log = LoggerFactory.getLogger(CategoriaRestController.class);
    @Autowired
    private CategoriaService categoriaService;
    @Autowired
    private CategoriaMapper categoriaMapper;

    @GetMapping(value = "/findById/{idCategoria}")
    public ResponseEntity<?> findById(
        @PathVariable("idCategoria")
    Long idCategoria) {
        log.debug("Request to findById() Categoria");

        try {
            Categoria categoria = categoriaService.findById(idCategoria).get();

            return ResponseEntity.ok()
                                 .body(categoriaMapper.categoriaToCategoriaDTO(
                    categoria));
        } catch (Exception e) {
            log.error(e.getMessage(), e);

            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping(value = "/findAll")
    public ResponseEntity<?> findAll() {
        log.debug("Request to findAll() Categoria");

        try {
            return ResponseEntity.ok()
                                 .body(categoriaMapper.listCategoriaToListCategoriaDTO(
                    categoriaService.findAll()));
        } catch (Exception e) {
            log.error(e.getMessage(), e);

            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping(value = "/save")
    public ResponseEntity<?> save(@RequestBody
    CategoriaDTO categoriaDTO) {
        log.debug("Request to save Categoria: {}", categoriaDTO);

        try {
            Categoria categoria = categoriaMapper.categoriaDTOToCategoria(categoriaDTO);
            categoria = categoriaService.save(categoria);

            return ResponseEntity.ok()
                                 .body(categoriaMapper.categoriaToCategoriaDTO(
                    categoria));
        } catch (Exception e) {
            log.error(e.getMessage(), e);

            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping(value = "/update")
    public ResponseEntity<?> update(@RequestBody
    CategoriaDTO categoriaDTO) {
        log.debug("Request to update Categoria: {}", categoriaDTO);

        try {
            Categoria categoria = categoriaMapper.categoriaDTOToCategoria(categoriaDTO);
            categoria = categoriaService.update(categoria);

            return ResponseEntity.ok()
                                 .body(categoriaMapper.categoriaToCategoriaDTO(
                    categoria));
        } catch (Exception e) {
            log.error(e.getMessage(), e);

            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping(value = "/delete/{idCategoria}")
    public ResponseEntity<?> delete(
        @PathVariable("idCategoria")
    Long idCategoria) throws Exception {
        log.debug("Request to delete Categoria");

        try {
            Categoria categoria = categoriaService.findById(idCategoria).get();

            categoriaService.delete(categoria);

            return ResponseEntity.ok().build();
        } catch (Exception e) {
            log.error(e.getMessage(), e);

            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping(value = "/count")
    public ResponseEntity<?> count() {
        return ResponseEntity.ok().body(categoriaService.count());
    }
}
