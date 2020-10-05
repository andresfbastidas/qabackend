package co.edu.usbcali.wordsqa.service;

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

import co.edu.usbcali.wordsqa.domain.Proyecto;
import co.edu.usbcali.wordsqa.repository.ArchivoRepository;
import co.edu.usbcali.wordsqa.repository.ProyectoRepository;
import co.edu.usbcali.wordsqa.repository.UsuarioRepository;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
@Scope("singleton")
@Service
public class ProyectoServiceImpl implements ProyectoService {
	@Autowired
	ProyectoRepository proyectoRepository;
	
	@Autowired
	ArchivoRepository arhcivoRepository;
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired
	Validator validator;

	@Override
	@Transactional(readOnly = true)
	public List<Proyecto> findAll() {
		return proyectoRepository.findAll(Sort.by("idProyecto"));
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Proyecto> findById(Long id) {
		return proyectoRepository.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Long count() {
		return proyectoRepository.count();
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public Proyecto save(Proyecto entity) throws Exception {
		validate(entity);
	  
	    
	   
	    proyectoRepository.save(entity);
		return entity;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public Proyecto update(Proyecto entity) throws Exception {
		validate(entity);
		
	    
		
		    proyectoRepository.save(entity);
		return entity;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void delete(Proyecto entity) throws Exception {
		validate(entity);
		 if (proyectoRepository.findById(entity.getIdProyecto()).isPresent()==true) {
				throw new Exception("el proyecto con id: " + entity.getIdProyecto()+ "Ya existe");
			}
	    
	    entity=findById(entity.getIdProyecto()).get();
	    
	  

	    proyectoRepository.delete(entity);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void deleteById(Long id) throws Exception {
		if (id == null) {
			 throw new Exception("el id es obligatorio");
		}

      if (proyectoRepository.findById(id).isPresent()==false) {
      	throw new Exception("el proyecto con id " + id + "no existe");
		}
      delete(proyectoRepository.findById(id).get());

	}

	@Override
	public void validate(Proyecto entity) throws Exception {
		if (entity==null) {
			throw new Exception("el proyecto es nulo");
		}
		
		Set<ConstraintViolation<Proyecto>> constraintViolations = validator.validate(entity);

        if (constraintViolations.size() > 0) {
            StringBuilder strMessage = new StringBuilder();

            for (ConstraintViolation<Proyecto> constraintViolation : constraintViolations) {
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


