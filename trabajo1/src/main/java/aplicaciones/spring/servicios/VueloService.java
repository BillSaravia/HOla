package aplicaciones.spring.servicios;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import aplicaciones.spring.modelo.Vuelo;
import aplicaciones.spring.repositorios.IVuelo;
@Service("vuelo")
public class VueloService {
	@Autowired
	private IVuelo iVuelo;
	public void guardar(Vuelo vuelo) {
		iVuelo.save(vuelo);
	}	
	public List<Vuelo> listar (){
		 return iVuelo.findAll();
	}	
	public  Vuelo buscar(Long id) {
		return  iVuelo.findById(id);
	}	
	public boolean eliminar (Long id) {
		try {
			iVuelo.delete(iVuelo.findById(id));
			return true;
		} catch (Exception e) {
			return false;
		}		
	}
}
