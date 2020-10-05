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
public class UsuarioProyectoDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(UsuarioProyectoDTO.class);
    private String emailUsuario;
    private Long idProyecto;
    private Long idProyecto_Proyecto;
    private String emailUsuario_Usuario;

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    public Long getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(Long idProyecto) {
        this.idProyecto = idProyecto;
    }

    public Long getIdProyecto_Proyecto() {
        return idProyecto_Proyecto;
    }

    public void setIdProyecto_Proyecto(Long idProyecto_Proyecto) {
        this.idProyecto_Proyecto = idProyecto_Proyecto;
    }

    public String getEmailUsuario_Usuario() {
        return emailUsuario_Usuario;
    }

    public void setEmailUsuario_Usuario(String emailUsuario_Usuario) {
        this.emailUsuario_Usuario = emailUsuario_Usuario;
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
