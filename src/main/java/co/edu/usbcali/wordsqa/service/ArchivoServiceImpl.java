package  co.edu.usbcali.wordsqa.service;


import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import co.edu.usbcali.wordsqa.domain.Archivo;
import co.edu.usbcali.wordsqa.repository.AnotacionRepository;
import co.edu.usbcali.wordsqa.repository.ArchivoRepository;
import co.edu.usbcali.wordsqa.repository.ProyectoRepository;

/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
* 
*/

@Scope("singleton")
@Service
public class ArchivoServiceImpl implements ArchivoService{

	@Autowired
	ArchivoRepository archivoRepository;
	
	@Autowired
	ProyectoRepository proyectoRepository;
	
	@Autowired
	Validator validator;

	@Override
	@Transactional(readOnly = true)
	public List<Archivo> findAll() {
		return archivoRepository.findAll(Sort.by("idArchivo"));
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Archivo> findById(Long id) {
		return archivoRepository.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Long count() {
		return archivoRepository.count();
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public Archivo save(Archivo entity) throws Exception {
		validate(entity);
	   
	    
	    if (entity.getProyecto()== null || proyectoRepository.findById(entity.getProyecto().getIdProyecto()).isPresent()==false) {
			throw new Exception("El proyecto no existe: ");
		}
	    archivoRepository.save(entity);
		return entity;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public Archivo update(Archivo entity) throws Exception {
		validate(entity);
		if (archivoRepository.findById(entity.getIdArchivo()).isPresent()==true) {
			throw new Exception("el archivo con id: " + entity.getIdArchivo()+ "Ya existe");
		}
	    
		 if (entity.getProyecto()== null || proyectoRepository.findById(entity.getProyecto().getIdProyecto()).isPresent()==false) {
				throw new Exception("El proyecto no existe: ");
			}
		 archivoRepository.save(entity);
		return entity;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void delete(Archivo entity) throws Exception {
		validate(entity);
	    if (archivoRepository.findById(entity.getIdArchivo()).isPresent()==false) {
			throw new Exception("el archivo con id: " + entity.getIdArchivo()+ "No existe");
		}
	    
	    entity=findById(entity.getIdArchivo()).get();
	    
	    if (entity.getAnotacions().size()>0) {
			 throw new Exception("El archivo ya tiene anotaciones asociadas");
			
		}

	    archivoRepository.delete(entity);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void deleteById(Long id) throws Exception {
		if (id == null) {
			 throw new Exception("el id es obligatorio");
		}

      if (archivoRepository.findById(id).isPresent()==false) {
      	throw new Exception("el archivo con id " + id + "no existe");
		}
      delete(archivoRepository.findById(id).get());

	}

	@Override
	public void validate(Archivo entity) throws Exception {
		if (entity==null) {
			throw new Exception("el archivo es nulo");
		}
		
		Set<ConstraintViolation<Archivo>> constraintViolations = validator.validate(entity);

        if (constraintViolations.size() > 0) {
            StringBuilder strMessage = new StringBuilder();

            for (ConstraintViolation<Archivo> constraintViolation : constraintViolations) {
                strMessage.append(constraintViolation.getPropertyPath()
                                                     .toString());
                strMessage.append(" - ");
                strMessage.append(constraintViolation.getMessage());
                strMessage.append(". \n");
            }

            throw new Exception(strMessage.toString());
        }


	}
}
