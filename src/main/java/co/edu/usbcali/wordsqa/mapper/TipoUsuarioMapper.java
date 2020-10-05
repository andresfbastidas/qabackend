package co.edu.usbcali.wordsqa.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import co.edu.usbcali.wordsqa.domain.TipoUsuario;
import co.edu.usbcali.wordsqa.dto.TipoUsuarioDTO;


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
public interface TipoUsuarioMapper {
    public TipoUsuarioDTO tipoUsuarioToTipoUsuarioDTO(TipoUsuario tipoUsuario)
        throws Exception;

    public TipoUsuario tipoUsuarioDTOToTipoUsuario(
        TipoUsuarioDTO tipoUsuarioDTO) throws Exception;

    public List<TipoUsuarioDTO> listTipoUsuarioToListTipoUsuarioDTO(
        List<TipoUsuario> tipoUsuarios) throws Exception;

    public List<TipoUsuario> listTipoUsuarioDTOToListTipoUsuario(
        List<TipoUsuarioDTO> tipoUsuarioDTOs) throws Exception;
}
