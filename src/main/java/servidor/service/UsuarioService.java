package servidor.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import servidor.model.Usuario;
import servidor.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
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
			System.out.println(e.getMessage());
		}
		return  usuario;
	}
	
	public Usuario getUsuarioByDni(String dni) {
		return repository.findByDni(dni);
	}
	
	public Usuario updateUsuario (Usuario usuarioOld) {
		Usuario usuarioNew = new Usuario();
		usuarioNew.setApellidos(usuarioOld.getApellidos());
		usuarioNew.setCorreo(usuarioOld.getCorreo());
		usuarioNew.setDireccion(usuarioOld.getDireccion());
		usuarioNew.setNombre(usuarioOld.getNombre());
		
		return repository.save(usuarioNew);
	}
	
	public String deleteUsuario (String dni) {
		repository.deleteByDni(dni);
		return "Usuario con DNI: "+dni+" eliminado.";
	}
	
}
