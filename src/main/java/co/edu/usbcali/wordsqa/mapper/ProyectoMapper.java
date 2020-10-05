package co.edu.usbcali.wordsqa.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import co.edu.usbcali.wordsqa.domain.Proyecto;
import co.edu.usbcali.wordsqa.dto.ProyectoDTO;


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
public interface ProyectoMapper {
    public ProyectoDTO proyectoToProyectoDTO(Proyecto proyecto)
        throws Exception;

    public Proyecto proyectoDTOToProyecto(ProyectoDTO proyectoDTO)
        throws Exception;

    public List<ProyectoDTO> listProyectoToListProyectoDTO(
        List<Proyecto> proyectos) throws Exception;

    public List<Proyecto> listProyectoDTOToListProyecto(
        List<ProyectoDTO> proyectoDTOs) throws Exception;
}
