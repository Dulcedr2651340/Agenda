package AgendaFinal.example.Cmon.Repos;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import AgendaFinal.example.Cmon.Entity.CategoriaDeuda;
import AgendaFinal.example.Cmon.Entity.Contacto;
import AgendaFinal.example.Cmon.Entity.Factura;
@ComponentScan(basePackages={"controllers"})
@Repository("facturaRepository")
public interface FacturaRepository extends JpaRepository<Factura, Serializable>{
	public List<Factura> findByFechar(Date fechar);
}
