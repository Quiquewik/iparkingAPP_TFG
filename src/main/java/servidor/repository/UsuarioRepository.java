package servidor.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import servidor.model.Usuario;

public interface UsuarioRepository extends MongoRepository<Usuario,String>{

	Usuario findByDni(String dni);

	void deleteByDni(String dni);

	
}
