package servidor.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Reserva {

    private String idReserva;
    private String matriculaVehiculo;
    private String idPlaza;
    private Date horaReserva;
    private Date finReserva;


}
