package co.edu.usbcali.wordsqa.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import co.edu.usbcali.wordsqa.domain.Archivo;
import co.edu.usbcali.wordsqa.dto.ArchivoDTO;


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
public interface ArchivoMapper {
    @Mapping(source = "proyecto.idProyecto", target = "idProyecto")
    public ArchivoDTO archivoToArchivoDTO(Archivo archivo)
        throws Exception;

    @Mapping(source = "idProyecto", target = "proyecto.idProyecto")
    public Archivo archivoDTOToArchivo(ArchivoDTO archivoDTO)
        throws Exception;

    public List<ArchivoDTO> listArchivoToListArchivoDTO(List<Archivo> archivos)
        throws Exception;

    public List<Archivo> listArchivoDTOToListArchivo(
        List<ArchivoDTO> archivoDTOs) throws Exception;
}
