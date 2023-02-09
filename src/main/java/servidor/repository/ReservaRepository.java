package servidor.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import servidor.model.Reserva;

import java.util.List;

public interface ReservaRepository extends MongoRepository<Reserva,String> {
    Reserva findReservasByMatriculaVehiculo(String matricula);
    List<Reserva> findReservaByDniUsuario(String dni);
}
