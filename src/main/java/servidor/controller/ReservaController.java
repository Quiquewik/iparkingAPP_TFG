package servidor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import servidor.model.Reserva;
import servidor.service.ReservaService;

import java.util.List;

@RestController
@RequestMapping("/reserva")
public class ReservaController {

    @Autowired
    private ReservaService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Reserva addReserva(@RequestBody Reserva reserva) {
        return service.addReserva(reserva);
    }


    @GetMapping("/getAll")
    public List<Reserva> getReserva() {
        return service.getAllReservas();
    }

    @GetMapping("/getById/{id}")
    @ResponseBody
    public Reserva getReservaById(@PathVariable String id) {
        return service.getReservaById(id);
    }

    @GetMapping("/getReservaByMatricula/{matricula}")
    @ResponseBody
    public Reserva getReservaByMatricula(@PathVariable String matricula) {
        return service.getReservaByMatricula(matricula);
    }

    @GetMapping("/getReservaByDni/{dni}")
    @ResponseBody
    public List<Reserva> getReservaByDniUsuario(@PathVariable String dni) {
        return service.getReservaByDniUsuario(dni);
    }

    @PutMapping
    public Reserva updateParking(@PathVariable Reserva reserva) {
        return service.updateReserva(reserva);
    }

    @DeleteMapping("/deleteById/{id}")
    public String deleteReserva(@PathVariable String id) {
        return service.deleteReserva(id);
    }


}
