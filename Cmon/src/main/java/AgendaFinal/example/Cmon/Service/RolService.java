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

import AgendaFinal.example.Cmon.Entity.Rol;
import AgendaFinal.example.Cmon.Repos.RolRepository;
@RestController
@RequestMapping("/rol")
@CrossOrigin
public class RolService {
	
	@Autowired
	private RolRepository rolRepository;
	
	@GetMapping(path = "/buscar")
	public List<Rol> getAllRol(){
		return rolRepository.findAll();
	}
	@PostMapping(path = "/guardar")
	public Rol saveRol(@RequestBody Rol rol) {
		return rolRepository.save(rol);
	}
	
	@DeleteMapping(path="/eliminar/{idrol}")
	public void deleteRol(@PathVariable("idrol") Integer idrol) {
		
		Optional<Rol>rol;
		
		rol=rolRepository.findById(idrol);
		
	//si encuentra el id lo borra con el if
	if(rol.isPresent()) {
		rolRepository.delete(rol.get());
	}
	
}
}