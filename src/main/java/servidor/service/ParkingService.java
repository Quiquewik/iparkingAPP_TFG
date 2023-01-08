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

        parkingOut.setNombreParking(parking.getNombreParking());
        parkingOut.setProvincia(parking.getProvincia());
        parkingOut.setPlazas(parking.getPlazas());

        return repository.save(parkingOut);
    }

    public Parking updatePlazasFromParking(Parking parking) {

        Parking parkingOut = new Parking();

        parkingOut.setPlazas(parkingOut.getPlazas());

        return repository.save(parkingOut);
    }

    public String deleteParking(String id) {
        repository.deleteById(id);
        return "Parking eliminado";
    }

    public Parking getParkingByNombreParking(String nombre) {
        return repository.getParkingByNombreParking(nombre);
    }
}
