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

import co.edu.usbcali.wordsqa.domain.Anotacion;
import co.edu.usbcali.wordsqa.repository.AnotacionRepository;
import co.edu.usbcali.wordsqa.repository.CategoriaRepository;

/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
* 
*/

@Scope("singleton")
@Service
public class AnotacionServiceImpl implements AnotacionService{

	@Autowired
	AnotacionRepository anotacionRepository;
	
	@Autowired
	CategoriaRepository categoriaRepository;
	
	@Autowired
	Validator validator;

	@Override
	@Transactional(readOnly = true)
	public List<Anotacion> findAll() {
		return anotacionRepository.findAll(Sort.by("idAnotacion"));
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Anotacion> findById(Long id) {
		return anotacionRepository.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Long count() {
		return anotacionRepository.count();
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public Anotacion save(Anotacion entity) throws Exception {
		validate(entity);
	    
	    
	    if (entity.getCategoria()== null || categoriaRepository.findById(entity.getCategoria().getIdCategoria()).isPresent()==false) {
			throw new Exception("la categoria no existe: ");
		}
	    anotacionRepository.save(entity);
		return entity;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public Anotacion update(Anotacion entity) throws Exception {
		validate(entity);
		if (anotacionRepository.findById(entity.getIdAnotacion()).isPresent()==true) {
			throw new Exception("la anotacion con id: " + entity.getIdAnotacion()+ "Ya existe");
		}
	    
		 if (entity.getCategoria()== null || anotacionRepository.findById(entity.getCategoria().getIdCategoria()).isPresent()==false) {
				throw new Exception("la categoria no existe: ");
			}
		 anotacionRepository.save(entity);
		return entity;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void delete(Anotacion entity) throws Exception {
		validate(entity);
	    if (anotacionRepository.findById(entity.getIdAnotacion()).isPresent()==false) {
			throw new Exception("el archivo con id: " + entity.getIdAnotacion()+ "No existe");
		}
	    
	    entity=findById(entity.getIdAnotacion()).get();
	    
	  

	    anotacionRepository.delete(entity);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void deleteById(Long id) throws Exception {
		if (id == null) {
			 throw new Exception("el id es obligatorio");
		}

      if (anotacionRepository.findById(id).isPresent()==false) {
      	throw new Exception("la categoria con id " + id + "no existe");
		}
      delete(anotacionRepository.findById(id).get());

	}

	@Override
	public void validate(Anotacion entity) throws Exception {
		if (entity==null) {
			throw new Exception("el archivo es nulo");
		}
		
		Set<ConstraintViolation<Anotacion>> constraintViolations = validator.validate(entity);

        if (constraintViolations.size() > 0) {
            StringBuilder strMessage = new StringBuilder();

            for (ConstraintViolation<Anotacion> constraintViolation : constraintViolations) {
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
