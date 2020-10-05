package co.edu.usbcali.wordsqa.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import co.edu.usbcali.wordsqa.domain.UsuarioProyecto;
import co.edu.usbcali.wordsqa.dto.UsuarioProyectoDTO;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
* Mapper Build with MapStruct https://mapstruct.org
* MapStruct is a code generator that greatly simplifies the
* implementation of mappings between Java bean type
* based on a convention over configuration approach.
*/
@Mapper
public interface UsuarioProyectoMapper {
    @Mapping(source = "proyecto.idProyecto", target = "idProyecto_Proyecto")
    @Mapping(source = "usuario.emailUsuario", target = "emailUsuario_Usuario")
    public UsuarioProyectoDTO usuarioProyectoToUsuarioProyectoDTO(
        UsuarioProyecto usuarioProyecto) throws Exception;

    @Mapping(source = "idProyecto_Proyecto", target = "proyecto.idProyecto")
    @Mapping(source = "emailUsuario_Usuario", target = "usuario.emailUsuario")
    public UsuarioProyecto usuarioProyectoDTOToUsuarioProyecto(
        UsuarioProyectoDTO usuarioProyectoDTO) throws Exception;

    public List<UsuarioProyectoDTO> listUsuarioProyectoToListUsuarioProyectoDTO(
        List<UsuarioProyecto> usuarioProyectos) throws Exception;

    public List<UsuarioProyecto> listUsuarioProyectoDTOToListUsuarioProyecto(
        List<UsuarioProyectoDTO> usuarioProyectoDTOs) throws Exception;
}
