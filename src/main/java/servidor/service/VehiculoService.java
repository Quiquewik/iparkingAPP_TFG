package servidor.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import servidor.model.Vehiculo;
import servidor.repository.VehiculoRepository;

import java.util.List;

@Service
public class VehiculoService {
    Logger log = LoggerFactory.getLogger(VehiculoService.class);

    @Autowired
    private VehiculoRepository repository;

    public Vehiculo addVehiculo (Vehiculo vehiculo){return repository.save(vehiculo);}

    public List<Vehiculo> findAllVehiculos() {return repository.findAll(); }

    public Vehiculo getVehiculoById(String id){
        Vehiculo vehiculo = new Vehiculo();

        try{
            vehiculo = repository.findById(id).get();
        }catch (Exception e){
            log.error(e.getMessage());
        }

        return vehiculo;
    }
    public Vehiculo getVehiculoByMatricula(String matricula){
        return repository.findByMatricula(matricula);
    }

    public Vehiculo updateVehiculo (Vehiculo vehiculoIn){

        Vehiculo vehiculoOut = new Vehiculo();

        vehiculoOut.setId_plaza(vehiculoIn.getId_plaza());
        vehiculoOut.setTipoVehiculo(vehiculoIn.getTipoVehiculo());
        vehiculoOut.setEstacionado(vehiculoIn.isEstacionado());
        vehiculoOut.setModelo(vehiculoIn.getModelo());
        vehiculoOut.setMarca(vehiculoIn.getMarca());

        return repository.save(vehiculoOut);
    }

    public String deleteVehiculo(String id){
        repository.deleteById(id);
        return "Vehiculo eliminado";
    }

    public String deleteVehiculoByMatricula(String matricula){
        repository.deleteByMatricula(matricula);
        return "Vehiculo eliminado";
    }

}
