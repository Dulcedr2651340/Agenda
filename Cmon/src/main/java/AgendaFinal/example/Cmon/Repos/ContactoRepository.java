package AgendaFinal.example.Cmon.Repos;

import java.io.Serializable;
import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import AgendaFinal.example.Cmon.Entity.Contacto;

@ComponentScan(basePackages={"controllers"})
@Repository("contactoRepository")
public interface ContactoRepository extends JpaRepository<Contacto, Serializable>{
	public List<Contacto> findByUsuarioCorreo(String usuarioCorreo);
	
}
