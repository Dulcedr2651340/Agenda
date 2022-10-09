package AgendaFinal.example.Cmon.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import AgendaFinal.example.Cmon.Entity.CategoriaDeuda;
import AgendaFinal.example.Cmon.Entity.Rol;
import AgendaFinal.example.Cmon.Repos.CategoriaDeudaRepository;
import AgendaFinal.example.Cmon.Repos.RolRepository;
@RestController
@RequestMapping("/categoria")
@CrossOrigin
public class CategoriaService {
	@Autowired
	private CategoriaDeudaRepository categoriaDeudaRepository;
	
	@GetMapping(path = "/buscar")
	public List<CategoriaDeuda> getAllCategoriaDeudas(){
		return categoriaDeudaRepository.findAll();
	}
	@PostMapping(path = "/guardar")
	public CategoriaDeuda saveCategoriaDeuda(@RequestBody CategoriaDeuda categoriaDeuda) {
		return categoriaDeudaRepository.save(categoriaDeuda);
	}
	
	@DeleteMapping(path="/eliminar/{idCategorial}")
	public void deleteCategoria(@PathVariable("idCategoria") Integer idCategoria) {
		
		Optional<CategoriaDeuda>categoriaDeuda;
		
		categoriaDeuda=categoriaDeudaRepository.findById(idCategoria);
		
	//si encuentra el id lo borra con el if
	if(categoriaDeuda.isPresent()) {
		categoriaDeudaRepository.delete(categoriaDeuda.get());
	}
	
}
}
