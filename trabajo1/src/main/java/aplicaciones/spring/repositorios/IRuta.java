package aplicaciones.spring.repositorios;
import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import aplicaciones.spring.modelo.Ruta;
@Repository
public interface IRuta extends JpaRepository<Ruta, Serializable>{
	public abstract Ruta findById(Long id);
}
