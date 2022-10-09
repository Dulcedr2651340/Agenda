package AgendaFinal.example.Cmon.Repos;
import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import AgendaFinal.example.Cmon.Entity.Rol;
@Repository("rolRepository")
public interface RolRepository extends JpaRepository<Rol, Serializable>{
	
}
