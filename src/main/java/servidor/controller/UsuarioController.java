package servidor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import servidor.model.Usuario;
import servidor.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService service;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario addUsuario(@RequestBody Usuario usuario) {return service.addUsuario(usuario);}

	@GetMapping("/usuarios")
	public List<Usuario> getUsuarios() {
		return service.findAllUsuarios();
	}

	@GetMapping("/usuario/{id}")
	public Usuario getUsuarioById(@PathVariable String id) {
		return service.getUsuarioById(id);
	}

	@GetMapping("/usuario/dni/{dni}")
	public Usuario getUsuarioByDni(@PathVariable String dni) {
		return service.getUsuarioByDni(dni);
	}

	@PutMapping
	public Usuario updateUsuario(@RequestBody Usuario usuarioOld) {
		return service.updateUsuario(usuarioOld);
	}

	@DeleteMapping("/{id}")
	public String deleteusuario(@PathVariable String id) {
		return service.deleteUsuario(id);
	}
}
