package AgendaFinal.example.Cmon.Entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.context.annotation.ComponentScan;
@ComponentScan(basePackages={"controllers"})
@Entity
@Table(name ="direccion")
public class Direccion implements Serializable{
private static final long serialVersionUID = 7L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional=false)
	@Column(name="iddireccion")
	private Integer iddireccion;
	
	@Column(name="descripcion")
	private String descripcion;
	
	@Column(name="contacto_idcontacto")
	private Integer contactoIdcontacto;

	public Integer getIddireccion() {
		return iddireccion;
	}

	public void setIddireccion(Integer iddireccion) {
		this.iddireccion = iddireccion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getContactoIdcontacto() {
		return contactoIdcontacto;
	}

	public void setContactoIdcontacto(Integer contactoIdcontacto) {
		this.contactoIdcontacto = contactoIdcontacto;
	}

	
	

	
}