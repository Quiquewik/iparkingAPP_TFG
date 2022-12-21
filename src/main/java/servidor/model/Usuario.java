package servidor.model;

import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "usuarios")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Usuario {
	
	@Id
	private String id;
	private String nombreUsuario;
	private String password;
	@Indexed(unique = true)
	private String dni;
	private String nombre;
	private String apellidos;
	private String direccion;
	@Indexed(unique = true)
	private String correo;
	private int	tipoUsuario;

}
