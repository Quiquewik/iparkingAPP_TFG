package servidor.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import servidor.model.Plaza;

import java.util.List;

public interface PlazaRepository extends MongoRepository<Plaza,String> {


    List<Plaza> findByTipoPlaza(int tipo);
}
