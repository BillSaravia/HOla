package aplicaciones.spring.servicios;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import aplicaciones.spring.modelo.Pasaje;
import aplicaciones.spring.repositorios.IPasaje;
@Service("pasaje")
public class PasajeService {
	@Autowired
	private IPasaje iPasaje;
	public void guardar(Pasaje pasaje) {
		iPasaje.save(pasaje);
	}	
	public List<Pasaje> listar (){
		 return iPasaje.findAll();
	}	
	public  Pasaje buscar(Long id) {
		return  iPasaje.findById(id);
	}	
	public boolean eliminar (Long id) {
		try {
			iPasaje.delete(iPasaje.findById(id));
			return true;
		} catch (Exception e) {
			return false;
		}		
	}
}
