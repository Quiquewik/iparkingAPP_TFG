package servidor.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

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

	@GetMapping("usuario/{id}")
	@ResponseBody
	public Usuario getUsuarioById(@PathVariable String id) {
		return service.getUsuarioById(id);
	}

	@GetMapping("/usuario/dni/{dni}")
	@ResponseBody
	public Usuario getUsuarioByDni(@PathVariable String dni) {
		return service.getUsuarioByDni(dni);
	}

	@PutMapping
	public Usuario updateUsuario(@RequestBody Usuario usuarioOld) {
		return service.updateUsuario(usuarioOld);
	}

	@DeleteMapping("usuario/{id}")
	public String deleteusuario(@PathVariable String id) {
		return service.deleteUsuario(id);
	}
}
