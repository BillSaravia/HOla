package aplicaciones.spring.repositorios;
import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import aplicaciones.spring.modelo.Pasaje;
@Repository
public interface IPasaje extends JpaRepository<Pasaje, Serializable>{
	public abstract Pasaje findById(Long id);
}
