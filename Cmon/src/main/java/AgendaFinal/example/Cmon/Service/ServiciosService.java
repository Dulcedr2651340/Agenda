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
import AgendaFinal.example.Cmon.Entity.Servicios;
import AgendaFinal.example.Cmon.Repos.CategoriaDeudaRepository;
import AgendaFinal.example.Cmon.Repos.ServiciosRepository;
@RestController
@RequestMapping("/servicios")
@CrossOrigin
public class ServiciosService {
	@Autowired
	private ServiciosRepository serviciosRepository;
	
	@GetMapping(path = "/buscar")
	public List<Servicios> getServiciosAll(){
		return serviciosRepository.findAll();
	}
	@PostMapping(path = "/guardar")
	public Servicios saveServicios(@RequestBody Servicios servicios) {
		return serviciosRepository.save(servicios);
	}
	
	@DeleteMapping(path="/eliminar/{idServicios}")
	public void deleteServicios(@PathVariable("idServicios") Integer idServicios) {
		
		Optional<Servicios>servicios;
		
		servicios=serviciosRepository.findById(idServicios);
		
	//si encuentra el id lo borra con el if
	if(servicios.isPresent()) {
		serviciosRepository.delete(servicios.get());
	}
}
}
