package co.edu.usbcali.wordsqa.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

import java.sql.*;

import java.util.Date;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
public class AnotacionDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(AnotacionDTO.class);
    private String descripcionAnotacion;
    private Long idAnotacion;
    private Long idArchivo_Archivo;
    private Long idCategoria_Categoria;

    public String getDescripcionAnotacion() {
        return descripcionAnotacion;
    }

    public void setDescripcionAnotacion(String descripcionAnotacion) {
        this.descripcionAnotacion = descripcionAnotacion;
    }

    public Long getIdAnotacion() {
        return idAnotacion;
    }

    public void setIdAnotacion(Long idAnotacion) {
        this.idAnotacion = idAnotacion;
    }

    public Long getIdArchivo_Archivo() {
        return idArchivo_Archivo;
    }

    public void setIdArchivo_Archivo(Long idArchivo_Archivo) {
        this.idArchivo_Archivo = idArchivo_Archivo;
    }

    public Long getIdCategoria_Categoria() {
        return idCategoria_Categoria;
    }

    public void setIdCategoria_Categoria(Long idCategoria_Categoria) {
        this.idCategoria_Categoria = idCategoria_Categoria;
    }

    @Override
    public String toString() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        try {
            return mapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            log.error(e.getMessage());

            return super.toString();
        }
    }
}
