package co.edu.usbcali.wordsqa.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import co.edu.usbcali.wordsqa.domain.Anotacion;
import co.edu.usbcali.wordsqa.dto.AnotacionDTO;


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
public interface AnotacionMapper {
    @Mapping(source = "archivo.idArchivo", target = "idArchivo_Archivo")
    @Mapping(source = "categoria.idCategoria", target = "idCategoria_Categoria")
    public AnotacionDTO anotacionToAnotacionDTO(Anotacion anotacion)
        throws Exception;

    @Mapping(source = "idArchivo_Archivo", target = "archivo.idArchivo")
    @Mapping(source = "idCategoria_Categoria", target = "categoria.idCategoria")
    public Anotacion anotacionDTOToAnotacion(AnotacionDTO anotacionDTO)
        throws Exception;

    public List<AnotacionDTO> listAnotacionToListAnotacionDTO(
        List<Anotacion> anotacions) throws Exception;

    public List<Anotacion> listAnotacionDTOToListAnotacion(
        List<AnotacionDTO> anotacionDTOs) throws Exception;
}
