package servidor.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import servidor.model.Vehiculo;

public interface VehiculoRepository extends MongoRepository<Vehiculo, String> {

    Vehiculo findByMatricula(String matricula);

    void deleteByMatricula(String matricula);
}
