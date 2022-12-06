package aplicaciones.spring.servicios;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import aplicaciones.spring.modelo.Ruta;
import aplicaciones.spring.repositorios.IRuta;
@Service("ruta")
public class RutaService {
	@Autowired
	private IRuta iRuta;
	public void guardar(Ruta ruta) {
		iRuta.save(ruta);
	}	
	public List<Ruta> listar (){
		 return iRuta.findAll();
	}	
	public  Ruta buscar(Long id) {
		return  iRuta.findById(id);
	}	
	public boolean eliminar (Long id) {
		try {
			iRuta.delete(iRuta.findById(id));
			return true;
		} catch (Exception e) {
			return false;
		}		
	}
}
