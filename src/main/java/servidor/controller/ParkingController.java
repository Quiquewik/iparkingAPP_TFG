package servidor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import servidor.model.Parking;
import servidor.service.ParkingService;

import java.util.List;

@RestController
@RequestMapping("/parking")
public class ParkingController {

    @Autowired
    private ParkingService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Parking addParking(@RequestBody Parking parking ){return service.addParking(parking);}


    @GetMapping("/getAll")
    public List<Parking> getParking(){return service.getAllParkings();}

    @GetMapping("/getById/{id}")
    @ResponseBody
    public Parking getParkingById(@PathVariable String id){return service.getParkingById(id);}

    @GetMapping("/getByNombreParking/{nombre}")
    @ResponseBody
    public Parking getParkingByNombre(@PathVariable String nombre){return service.getParkingByNombre(nombre);}


    @PutMapping
    public Parking updateParking(@PathVariable Parking parking){return service.updateParking(parking);}

    @PutMapping("/updatePlazas/")
    public Parking updatePlazasParking(@PathVariable Parking parking){return service.updatePlazasParking(parking);}


    @DeleteMapping("/deleteById/{id}")
    public String deleteParking(@PathVariable String id){return service.deleteParking(id);}


}
