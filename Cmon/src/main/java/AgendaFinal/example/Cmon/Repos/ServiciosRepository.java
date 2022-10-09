package AgendaFinal.example.Cmon.Repos;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import AgendaFinal.example.Cmon.Entity.Servicios;
@Repository("servicios")
public interface ServiciosRepository  extends JpaRepository<Servicios, Serializable>{

}

