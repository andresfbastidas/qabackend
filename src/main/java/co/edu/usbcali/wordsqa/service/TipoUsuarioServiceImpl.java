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


import co.edu.usbcali.wordsqa.domain.TipoUsuario;
import co.edu.usbcali.wordsqa.repository.TipoUsuarioRepository;

@Service
@Scope("singleton")
public class TipoUsuarioServiceImpl implements TipoUsuarioService {

	@Autowired
	TipoUsuarioRepository tipoUsuarioRepository;
	
	@Autowired
	Validator validator;

	@Override
	@Transactional(readOnly = true)
	public List<TipoUsuario> findAll() {
		return tipoUsuarioRepository.findAll(Sort.by("idTipoUsuario"));
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<TipoUsuario> findById(Long id) {
		return tipoUsuarioRepository.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Long count() {
		return tipoUsuarioRepository.count();
	}

	@Override
	@Transactional(readOnly = false,propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
	public TipoUsuario save(TipoUsuario entity) throws Exception {
		validate(entity);
		tipoUsuarioRepository.save(entity);
		return entity;
	}

	@Override
	@Transactional(readOnly = false,propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
	public TipoUsuario update(TipoUsuario entity) throws Exception {
		validate(entity);
	    if (tipoUsuarioRepository.findById(entity.getIdTipoUsuario()).isPresent()==false) {
			throw new Exception("el userType con id: " + entity.getIdTipoUsuario()+ "No existe");
		}
	    tipoUsuarioRepository.save(entity);
		return entity;
	}

	@Override
	@Transactional(readOnly = false,propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
	public void delete(TipoUsuario entity) throws Exception {
		validate(entity);
		if (tipoUsuarioRepository.findById(entity.getIdTipoUsuario()).isPresent()==false) {
			throw new Exception("el tipoUsuario con id: " + entity.getIdTipoUsuario()+ "No existe");
		}
		 
		 entity=findById(entity.getIdTipoUsuario()).get();
		 
		 if (entity.getUsuarios().size()>0) {
			 throw new Exception("El tipodeUsuario tiene usuarios asociados");
			
		}
				
		 tipoUsuarioRepository.delete(entity);

	}

	@Override
	@Transactional(readOnly = false,propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
	public void deleteById(Long id) throws Exception {
		if (id == null || id<1) {
			 throw new Exception("el id es obligatorio");
		}

      if (tipoUsuarioRepository.findById(id).isPresent()==false) {
      	throw new Exception("El tipoUsuario con id " + id + "no existe");
		}
      delete(tipoUsuarioRepository.findById(id).get());

	}

	@Override
	public void validate(TipoUsuario entity) throws Exception {
		if(entity==null) {
			throw new Exception("El tipoUsuario es nulo");
		}
		
		Set<ConstraintViolation<TipoUsuario>> constraintViolations = validator.validate(entity);

        if (constraintViolations.size() > 0) {
            StringBuilder strMessage = new StringBuilder();

            for (ConstraintViolation<TipoUsuario> constraintViolation : constraintViolations) {
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
