package aplicaciones.spring.repositorios;
import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import aplicaciones.spring.modelo.Vuelo;
@Repository
public interface IVuelo extends JpaRepository<Vuelo, Serializable>{
	public abstract Vuelo findById(Long id);
}
