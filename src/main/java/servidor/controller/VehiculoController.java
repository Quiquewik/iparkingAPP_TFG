package servidor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import servidor.model.Vehiculo;
import servidor.service.VehiculoService;

import java.util.List;

@RestController
@RequestMapping("/vehiculo")
public class VehiculoController {

    @Autowired
    private VehiculoService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Vehiculo addVehiculo(@RequestBody Vehiculo vehiculo){return service.addVehiculo(vehiculo);}

    @GetMapping("/vehiculos")
    public List<Vehiculo> getVehiculos(){return service.findAllVehiculos();}

    @GetMapping("/getById/{id}")
    @ResponseBody
    public Vehiculo getVehiculoById(@PathVariable String id){return service.getVehiculoById(id);}

    @GetMapping("/getByMatricula/{matricula}")
    @ResponseBody
    public Vehiculo getVehiculoByMatricula(@PathVariable String matricula){return service.getVehiculoByMatricula(matricula);}

    @PutMapping
    public Vehiculo updateVehiculo(@RequestBody Vehiculo vehiculo){return service.updateVehiculo(vehiculo);}

    @DeleteMapping("/deleteById/{id}")
    public String deleteVehiculo(@PathVariable String id){ return service.deleteVehiculo(id);}

    @DeleteMapping("/deleteByMatricula/{matricula}")
    public String deleteVehiculoByMatricula(@PathVariable String matricula){ return service.deleteVehiculoByMatricula(matricula);}

}
