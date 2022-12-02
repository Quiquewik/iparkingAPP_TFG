package servidor.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import servidor.model.Plaza;
import servidor.repository.PlazaRepository;

import java.util.List;

@Service
public class PlazaService {
    Logger log = LoggerFactory.getLogger(PlazaService.class);

    @Autowired
    private PlazaRepository repository;

    public Plaza addPlaza( Plaza plaza){return repository.save(plaza);}

    public List<Plaza> getAllPlazas(){return repository.findAll();}

    public Plaza getPlazaById(String id){
        Plaza plaza = new Plaza();

        try{
            plaza = repository.findById(id).get();
        }catch (Exception e){
            log.error(e.getMessage());
        }

        return plaza;
    }

    public List<Plaza> getPlazasByTipoPlaza(int tipo){
        return repository.findByTipoPlaza(tipo);
    }

    public Plaza updatePlaza (Plaza plazaIn){

        Plaza plazaOut = new Plaza();

        plazaOut.setId(plazaIn.getId());
        plazaOut.setInicioAparcamiento(plazaIn.getInicioAparcamiento());
        plazaOut.setOcupado(plazaIn.isOcupado());

        return repository.save(plazaOut);
    }

    public String deletePlaza(String id){
        repository.deleteById(id);
        return "Plaza eliminada";
    }
}
