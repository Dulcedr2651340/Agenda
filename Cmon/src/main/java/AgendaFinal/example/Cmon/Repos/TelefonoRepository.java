package AgendaFinal.example.Cmon.Repos;

import java.io.Serializable;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import AgendaFinal.example.Cmon.Entity.Telefono;
@ComponentScan(basePackages={"controllers"})
@Repository("telefonodireccionRepository")
public interface TelefonoRepository extends JpaRepository<Telefono, Serializable>{

}
