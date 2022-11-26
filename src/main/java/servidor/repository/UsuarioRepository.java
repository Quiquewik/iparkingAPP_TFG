package servidor.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import servidor.model.Usuario;

import java.util.Optional;

public interface UsuarioRepository extends MongoRepository<Usuario,String>{

	Optional<Usuario> findById(String id);
	Usuario findByDni(String dni);

	void deleteByDni(String dni);

	
}
