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

import co.edu.usbcali.wordsqa.domain.Categoria;
import co.edu.usbcali.wordsqa.repository.CategoriaRepository;

/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
* 
*/

@Scope("singleton")
@Service
public class CategoriaServiceImpl implements CategoriaService{
	
	@Autowired
	CategoriaRepository categoriaRepository;

	@Autowired
	Validator validator;

	@Override
	@Transactional(readOnly = true)
	public List<Categoria> findAll() {
		return categoriaRepository.findAll(Sort.by("idCategoria"));
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Categoria> findById(Long id) {
		return categoriaRepository.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Long count() {
		return categoriaRepository.count();
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public Categoria save(Categoria entity) throws Exception {
		validate(entity);
	    categoriaRepository.save(entity);
		return entity;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public Categoria update(Categoria entity) throws Exception {
		validate(entity);
		 if (categoriaRepository.findById(entity.getIdCategoria()).isPresent()==true) {
				throw new Exception("la categoria con id: " + entity.getIdCategoria()+ "Ya existe");
			}
	    
		
		 categoriaRepository.save(entity);
		return entity;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void delete(Categoria entity) throws Exception {
		validate(entity);
		 if (categoriaRepository.findById(entity.getIdCategoria()).isPresent()==true) {
				throw new Exception("la categoria con id: " + entity.getIdCategoria()+ "Ya existe");
			}
	    
	    entity=findById(entity.getIdCategoria()).get();
	    
	    if (entity.getAnotacions().size()>0) {
			 throw new Exception("La categoria tiene anotaciones asociadas");
			
		}

	    categoriaRepository.delete(entity);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void deleteById(Long id) throws Exception {
		if (id == null) {
			 throw new Exception("el id es obligatorio");
		}

      if (categoriaRepository.findById(id).isPresent()==false) {
      	throw new Exception("la categoria " + id + "no existe");
		}
      delete(categoriaRepository.findById(id).get());

	}

	@Override
	public void validate(Categoria entity) throws Exception {
		if (entity==null) {
			throw new Exception("la categoria es nula");
		}
		
		Set<ConstraintViolation<Categoria>> constraintViolations = validator.validate(entity);

        if (constraintViolations.size() > 0) {
            StringBuilder strMessage = new StringBuilder();

            for (ConstraintViolation<Categoria> constraintViolation : constraintViolations) {
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
