package servidor.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import servidor.model.Parking;

public interface ParkingRepository extends MongoRepository<Parking,String> {
    Parking findParkingByNombre(String nombre);
}
