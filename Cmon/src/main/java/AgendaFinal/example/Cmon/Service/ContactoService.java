package AgendaFinal.example.Cmon.Service;
import java.util.LinkedList;
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

import AgendaFinal.example.Cmon.Entity.Contacto;
import AgendaFinal.example.Cmon.Entity.Correo;
import AgendaFinal.example.Cmon.Entity.Cuenta;
import AgendaFinal.example.Cmon.Entity.Direccion;
import AgendaFinal.example.Cmon.Entity.Factura;
import AgendaFinal.example.Cmon.Entity.Telefono;
import AgendaFinal.example.Cmon.Repos.ContactoRepository;
import AgendaFinal.example.Cmon.Repos.CorreoRepository;
import AgendaFinal.example.Cmon.Repos.DireccionRepository;
import AgendaFinal.example.Cmon.Repos.FacturaRepository;
import AgendaFinal.example.Cmon.Repos.TelefonoRepository;
import AgendaFinal.example.Cmon.Repos.cuentaRepository;
@RestController
@RequestMapping("/contacto")
@CrossOrigin
public class ContactoService {
	@Autowired
	CorreoRepository correoRepository;
	@Autowired
	TelefonoRepository telefonoRepository;
	
	@Autowired
	DireccionRepository direccionRepository;
	
	@Autowired
	ContactoRepository contactoRepository;
	
	@Autowired
	cuentaRepository cuentaRepository;
	
	@GetMapping(path = "/buscar")
	public List<Contacto> getAllContacto(){
		return contactoRepository.findAll();
	}

	@PostMapping(path = "/guardar")
	public Contacto saveContacto(@RequestBody Contacto contacto) {
		
	List<Correo> correos=contacto.getCorreoList();
		List<Direccion> direcciones=contacto.getDireccionList();
		List<Telefono> telefono=contacto.getTelefonoList();
		List<Cuenta> cuenta=contacto.getCuentaList();
		
		
		contacto.setCorreoList(null);
		contacto.setDireccionList(null);
		contacto.setTelefonoList(null);
		contacto.setCuentaList(null);
		
		
		contacto= contactoRepository.save(contacto);
		//estas listas de abajo es para obtener mas precisos ya que con el otro metodo no me retornaba el correo y el id correo.
		//por ahora este es mas viable!
		contacto.setTelefonoList(new LinkedList<>());
		contacto.setCorreoList(new LinkedList<>());
		contacto.setDireccionList(new LinkedList<>());
		
		//si correos esta vacio este lo guardara en la bd
		if(correos!=null) {
			for(Correo c: correos) {
				c.setContactoIdcontacto(contacto.getIdcontacto());
				correoRepository.save(c);
				contacto.getCorreoList().add(c);
			}
		}
		
		//para las direcciones
		if(direcciones!=null) {
			for(Direccion d: direcciones) {
				d.setContactoIdcontacto(contacto.getIdcontacto());
				direccionRepository.save(d);
				contacto.getDireccionList().add(d);
			}
		}
		//para los telefonos
		if(telefono!=null) {
			for(Telefono t: telefono) {
				t.setContactoIdcontacto(contacto.getIdcontacto());
				telefonoRepository.save(t);
				contacto.getTelefonoList().add(t);	
			}
		}
			if(cuenta!=null) {
				for(Cuenta f: cuenta ) {
					f.setContactoIdcontacto(contacto.getIdcontacto());
					cuentaRepository.save(f);
					contacto.getCuentaList().add(f);	
			}
		}	
		return contacto;
		//con esto pódemos retornar el contacto guardando su correo,direcciones y telefonos.
	}
@DeleteMapping(path="/eliminar/{idcontacto}")
	public void deleteContacto(@PathVariable("idcontacto") Integer idcontacto) {
		
		Optional<Contacto>contacto;
		contacto=contactoRepository.findById(idcontacto);
		if(contacto.isPresent()) {
			Contacto borrar =contacto.get();
			for(Telefono t: borrar.getTelefonoList()) {
				telefonoRepository.delete(t);
			}
			for(Direccion d: borrar.getDireccionList()) {
				direccionRepository.delete(d);
			}
			for(Correo c: borrar.getCorreoList()) {
				correoRepository.delete(c);
			}
			for(Cuenta f: borrar.getCuentaList()) {
				cuentaRepository.delete(f);
			}
		contactoRepository.delete(contacto.get());
		}
	}
	@GetMapping(path = "/buscar/correo/{correo}")
	public List<Contacto> findByCorreo(@PathVariable("correo")String correo)	{
	return contactoRepository.findByUsuarioCorreo(correo);
}
}