package servidor.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import servidor.model.Parking;
import servidor.repository.ParkingRepository;

import java.util.List;

@Service
public class ParkingService {

    Logger log = LoggerFactory.getLogger(ParkingService.class);

    @Autowired
    private ParkingRepository repository;

    public Parking addParking(Parking parking) {
        return repository.save(parking);
    }

    public List<Parking> getAllParkings() {
        return repository.findAll();
    }


    public Parking getParkingById(String id) {
        Parking parking = new Parking();

        try {
            parking = repository.findById(id).get();
        } catch (Exception e) {
            log.error(e.getMessage());
        }

        return parking;
    }

    public Parking updateParking(Parking parking) {
        Parking parkingOut = new Parking();

        parkingOut.setNombre(parking.getNombre());
        parkingOut.setProvincia(parking.getProvincia());
        parkingOut.setPlazas(parking.getPlazas());

        return repository.save(parkingOut);
    }

    public Parking updatePlazasParking(Parking parking) {

        Parking parkingOut = new Parking();

        parkingOut.setPlazas(parking.getPlazas());

        return repository.save(parkingOut);
    }

    public String deleteParking(String id) {
        repository.deleteById(id);
        return "Parking eliminado";
    }

    public Parking getParkingByNombre(String nombre) {
        return repository.findParkingByNombre(nombre);
    }
}
