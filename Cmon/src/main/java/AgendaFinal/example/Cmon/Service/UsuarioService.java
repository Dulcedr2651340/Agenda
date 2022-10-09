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
import AgendaFinal.example.Cmon.Entity.Usuario;
import AgendaFinal.example.Cmon.Repos.CorreoRepository;
import AgendaFinal.example.Cmon.Repos.UsuarioRepository;


@RestController
@RequestMapping("/usuario")
@CrossOrigin
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@GetMapping(path = "/buscar")
	public List<Usuario> getAllRol(){
		return usuarioRepository.findAll();
	}
	@PostMapping(path = "/guardar")
	public Usuario saveUsuario(@RequestBody Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	
	@DeleteMapping(path="/eliminar/{correo}")
	public void deleteUsuario(@PathVariable("correo") String correo) {
		
		Optional<Usuario>usuario;
		
		usuario=usuarioRepository.findById(correo);
		
	//si encuentra el id lo borra con el if
	if(usuario.isPresent()) {
		usuarioRepository.delete(usuario.get());
	}
	
	}
	//crear servicio para devolver si el usuario existe devolviendo este
	//con postmaping sera para devolver al usuario
	@PostMapping(path= "/login")
	public Usuario login(@RequestBody Usuario usuario) {
List<Usuario>usuarios =usuarioRepository.findByCorreoAndPassword(usuario.getCorreo(),usuario.getPassword());
	
		if(!usuarios.isEmpty()) {
			return usuarios.get(0);
		}
		//no devuelve nada aunque si quisiera puedo poner un elf y mandar mensaje de error
		return null;
		
		//yyy ya mapeamos el add one to delete add
	}
	@GetMapping(value = "/editar/{correo}")
	public void editUsuario(@PathVariable("correo") String correo) {
		Optional<Usuario>usuario;
		
		usuario=usuarioRepository.findById(correo);
		if(usuario.isPresent()) {
			usuarioRepository.save(usuario.get());
		}
		
		}
	
}
