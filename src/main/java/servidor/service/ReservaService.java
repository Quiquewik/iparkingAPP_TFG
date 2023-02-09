package servidor.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import servidor.model.Reserva;
import servidor.repository.ReservaRepository;

import java.util.List;

@Service
public class ReservaService {

    Logger log = LoggerFactory.getLogger(ReservaService.class);

    @Autowired
    private ReservaRepository repository;

    public Reserva addReserva(Reserva Reserva) {
        return repository.save(Reserva);
    }

    public List<Reserva> getAllReservas() {
        return repository.findAll();
    }


    public Reserva getReservaById(String id) {
        Reserva Reserva = new Reserva();

        try {
            Reserva = repository.findById(id).get();
        } catch (Exception e) {
            log.error(e.getMessage());
        }

        return Reserva;
    }

    public Reserva updateReserva(Reserva Reserva) {
        Reserva reservaOut = new Reserva();

        reservaOut.setHoraReserva(Reserva.getHoraReserva());
        reservaOut.setFinReserva(Reserva.getFinReserva());
        reservaOut.setMatriculaVehiculo(Reserva.getMatriculaVehiculo());

        return repository.save(reservaOut);
    }

    public String deleteReserva(String id) {
        repository.deleteById(id);
        return "Reserva eliminado";
    }

    public Reserva getReservaByMatricula(String matricula) {
        return repository.findReservasByMatriculaVehiculo(matricula);
    }

    public List<Reserva> getReservaByDniUsuario(String dni){
        return repository.findReservaByDniUsuario(dni);
    }
}
