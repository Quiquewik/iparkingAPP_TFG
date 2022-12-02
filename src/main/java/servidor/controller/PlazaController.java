package servidor.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import servidor.model.Plaza;
import servidor.service.PlazaService;
import servidor.service.VehiculoService;

import java.util.List;

@RestController
@RequestMapping("/parking")
public class PlazaController {

    @Autowired
    private PlazaService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Plaza addPlaza(@RequestBody Plaza plaza ){return service.addPlaza(plaza);}

    @GetMapping("/plazas")
    public List<Plaza> getPlazas(){return service.getAllPlazas();}

    @GetMapping("/getById/{id}")
    @ResponseBody
    public Plaza getPlazaById(String id){return service.getPlazaById(id);}

    @GetMapping("/getByTipo/{tipo}")
    public List<Plaza> getPlazasByTipoPlaza(int tipo){return service.getPlazasByTipoPlaza(tipo);}

    @PutMapping
    public Plaza updatePlaza(@PathVariable Plaza plaza){return service.updatePlaza(plaza);}

    @DeleteMapping("/deleteById/{id}")
    public String deletePlaza(@PathVariable String id){return service.deletePlaza(id);}

}
