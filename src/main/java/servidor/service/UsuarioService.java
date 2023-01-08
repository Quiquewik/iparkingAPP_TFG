package servidor.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.aggregation.ArithmeticOperators;
import org.springframework.stereotype.Service;

import servidor.model.Usuario;
import servidor.repository.UsuarioRepository;

@Service
public class UsuarioService {

	Logger log = LoggerFactory.getLogger(UsuarioService.class);

	@Autowired
	private UsuarioRepository repository;
	
	public Usuario addUsuario(Usuario usuario) {
		
		return repository.save(usuario);
	}
	
	public List<Usuario> findAllUsuarios (){
		return repository.findAll();
	}
	
	public Usuario getUsuarioById(String id) {
		Usuario usuario = new Usuario();
		try{
			usuario = repository.findById(id).get();
		}catch(Exception e){
			log.error(e.getMessage());
		}
		return  usuario;
	}
	
	public Usuario getUsuarioByDni(String dni) {
		return repository.findByDni(dni);
	}
	
	public Usuario updateUsuario (Usuario usuarioOld) {

		Usuario usuarioNew = new Usuario();
		usuarioNew.setNombreUsuario(usuarioOld.getNombreUsuario());
		usuarioNew.setApellidos(usuarioOld.getApellidos());
		usuarioNew.setCorreo(usuarioOld.getCorreo());
		usuarioNew.setDireccion(usuarioOld.getDireccion());
		usuarioNew.setNombre(usuarioOld.getNombre());
		
		return repository.save(usuarioNew);
	}

	public String deleteUsuario(String id){
		repository.deleteById(id);
		return "Usuario eliminado.";
	}

}
