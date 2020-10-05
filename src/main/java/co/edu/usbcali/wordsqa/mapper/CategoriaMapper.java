package co.edu.usbcali.wordsqa.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import co.edu.usbcali.wordsqa.domain.Categoria;
import co.edu.usbcali.wordsqa.dto.CategoriaDTO;


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
public interface CategoriaMapper {
    public CategoriaDTO categoriaToCategoriaDTO(Categoria categoria)
        throws Exception;

    public Categoria categoriaDTOToCategoria(CategoriaDTO categoriaDTO)
        throws Exception;

    public List<CategoriaDTO> listCategoriaToListCategoriaDTO(
        List<Categoria> categorias) throws Exception;

    public List<Categoria> listCategoriaDTOToListCategoria(
        List<CategoriaDTO> categoriaDTOs) throws Exception;
}
