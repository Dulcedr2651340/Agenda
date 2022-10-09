package AgendaFinal.example.Cmon.Repos;

import java.io.Serializable;
import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import AgendaFinal.example.Cmon.Entity.CategoriaDeuda;

@ComponentScan(basePackages={"controllers"})
@Repository("categoriaDeudaRepository")
public interface CategoriaDeudaRepository extends JpaRepository<CategoriaDeuda, Serializable>{
	
}
