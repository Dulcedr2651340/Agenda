package AgendaFinal.example.Cmon.Service;

import java.sql.Date;
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

import AgendaFinal.example.Cmon.Entity.CategoriaDeuda;
import AgendaFinal.example.Cmon.Entity.Contacto;
import AgendaFinal.example.Cmon.Entity.Correo;
import AgendaFinal.example.Cmon.Entity.Direccion;
import AgendaFinal.example.Cmon.Entity.Factura;
import AgendaFinal.example.Cmon.Entity.Servicios;
import AgendaFinal.example.Cmon.Entity.Telefono;
import AgendaFinal.example.Cmon.Repos.CategoriaDeudaRepository;
import AgendaFinal.example.Cmon.Repos.ContactoRepository;
import AgendaFinal.example.Cmon.Repos.CorreoRepository;
import AgendaFinal.example.Cmon.Repos.DireccionRepository;
import AgendaFinal.example.Cmon.Repos.FacturaRepository;
import AgendaFinal.example.Cmon.Repos.ServiciosRepository;
import AgendaFinal.example.Cmon.Repos.TelefonoRepository;

@RestController
@RequestMapping("/factura")
@CrossOrigin
public class FacturaService {
	@Autowired
	FacturaRepository facturaRepository;
	@Autowired
	CategoriaDeudaRepository categoriaDeudaRepository;
	@Autowired
	ServiciosRepository ServiciosRepository;
	@Autowired
	ContactoRepository contactoRepository;
	
	
	@GetMapping(path = "/buscar")
	public List<Factura> getAllFacturas(){
		return facturaRepository.findAll();
	}

	@PostMapping(path = "/guardar")
	public Factura saveFactura(@RequestBody Factura factura) {
		
	List<Servicios> servicios=factura.getServiciosList();
    List<CategoriaDeuda>categoriaDeudas=factura.getCategoriadeudaList();
    List<Contacto>contacto=factura.getContactoList();
    
    factura.setCategoriadeudaList(null);
	factura.setServiciosList(null);
	factura.setContactoList(null);
	
		factura= facturaRepository.save(factura);


		factura.setCategoriadeudaList(new LinkedList<>());
		factura.setServiciosList(new LinkedList<>());
		factura.setContactoList(new LinkedList<>());
		
		//si correos esta vacio este lo guardara en la bd
		if(categoriaDeudas!=null) {
			for(CategoriaDeuda f: categoriaDeudas) {
				f.setFacturaCodfactura(factura.getCodfactura());
				categoriaDeudaRepository.save(f);
				factura.getCategoriadeudaList().add(f);
			}
			if(servicios!=null) {
				for(Servicios s: servicios) {
					s.setFacturaCodfactura(factura.getCodfactura());
					ServiciosRepository.save(s);
					factura.getServiciosList().add(s);
				}
			if(contacto!=null) {
					for(Contacto c: contacto) {
						c.setFacturaCodfactura(factura.getCodfactura());
						contactoRepository.save(c);
						factura.getContactoList().add(c);
					}
		
	}
				}
	
		}
		return factura;
	}
@DeleteMapping(path="/eliminar/{codfactura}")
	public void deleteContacto(@PathVariable("codfactura") Integer codfactura) {
		
		Optional<Factura>factura;
		factura=facturaRepository.findById(codfactura);
		if(factura.isPresent()) {
			Factura borrar =factura.get();
			for(CategoriaDeuda f: borrar.getCategoriadeudaList()) {
				categoriaDeudaRepository.delete(f);
			}
			for(Servicios s: borrar.getServiciosList()) {
				ServiciosRepository.delete(s);
			}
			for(Contacto c: borrar.getContactoList()) {
				contactoRepository.delete(c);
			}
		
		facturaRepository.delete(factura.get());
	}
}
}

