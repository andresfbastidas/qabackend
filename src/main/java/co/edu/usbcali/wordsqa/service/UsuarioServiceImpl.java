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

import co.edu.usbcali.wordsqa.domain.Usuario;
import co.edu.usbcali.wordsqa.repository.TipoUsuarioRepository;
import co.edu.usbcali.wordsqa.repository.UsuarioRepository;
@Service
@Scope("singleton")
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired
	TipoUsuarioRepository tipoUsuarioRepository;
	
	@Autowired
	Validator validator;

	@Override
	@Transactional(readOnly = true)
	public List<Usuario> findAll() {
		return usuarioRepository.findAll(Sort.by("emailUsuario"));
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Usuario> findById(String id) {
		return usuarioRepository.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Long count() {
		return usuarioRepository.count();
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public Usuario save(Usuario entity) throws Exception {
		validate(entity);
	    if (usuarioRepository.findById(entity.getEmailUsuario()).isPresent()==true) {
			throw new Exception("el usuario con id: " + entity.getEmailUsuario()+ "Ya existe");
		}
	    
	    if (entity.getContrasena()== null ) {
			throw new Exception("la contraseña no puede ser nula ");
		}
	    
	    if (entity.getTipoUsuario()== null || tipoUsuarioRepository.findById(entity.getTipoUsuario().getIdTipoUsuario()).isPresent()==false) {
			throw new Exception("el tipoUsuario no existe: ");
		}
	    usuarioRepository.save(entity);
		return entity;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public Usuario update(Usuario entity) throws Exception {
		validate(entity);
	    if (usuarioRepository.findById(entity.getEmailUsuario()).isPresent()==false) {
			throw new Exception("el usuario con id: " + entity.getEmailUsuario()+ "No existe");
		}
	    
	    if (entity.getTipoUsuario()== null || tipoUsuarioRepository.findById(entity.getTipoUsuario().getIdTipoUsuario()).isPresent()==false) {
			throw new Exception("el userType no existe: ");
		}
	    usuarioRepository.save(entity);
		return entity;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void delete(Usuario entity) throws Exception {
		validate(entity);
	    if (usuarioRepository.findById(entity.getEmailUsuario()).isPresent()==false) {
			throw new Exception("el usuario con id: " + entity.getEmailUsuario()+ "No existe");
		}
	    
	    entity=findById(entity.getEmailUsuario()).get();
	    
	    if (entity.getProyectos().size()>0) {
			 throw new Exception("El usuario ya tiene proyectos asociados");
			
		}

	    usuarioRepository.delete(entity);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void deleteById(String id) throws Exception {
		if (id == null) {
			 throw new Exception("el id es obligatorio");
		}

      if (usuarioRepository.findById(id).isPresent()==false) {
      	throw new Exception("el usuario con id " + id + "no existe");
		}
      delete(usuarioRepository.findById(id).get());

	}

	@Override
	public void validate(Usuario entity) throws Exception {
		if (entity==null) {
			throw new Exception("el usuario es nulo");
		}
		
		Set<ConstraintViolation<Usuario>> constraintViolations = validator.validate(entity);

        if (constraintViolations.size() > 0) {
            StringBuilder strMessage = new StringBuilder();

            for (ConstraintViolation<Usuario> constraintViolation : constraintViolations) {
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
