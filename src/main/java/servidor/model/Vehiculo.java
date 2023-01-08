package servidor.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Vehiculo {

    private String matricula;
    private String marca;
    private String modelo;
    private Parking parkingAsociado;
    private int tipoVehiculo;
    private boolean estacionado;

}
