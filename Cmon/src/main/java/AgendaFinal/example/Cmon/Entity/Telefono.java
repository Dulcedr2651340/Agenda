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

@Entity
@Table(name ="telefono")
public class Telefono implements Serializable{
	private static final long serialVersionUID = 6L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional=false)
	@Column(name="idtelefono")
	private Integer idtelefono;
	
	@Column(name="numero")
	private String numero;
	
	@Column(name="contacto_idcontacto")
	private Integer contactoIdcontacto;

	public Integer getIdtelefono() {
		return idtelefono;
	}

	public void setIdtelefono(Integer idtelefono) {
		this.idtelefono = idtelefono;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Integer getContactoIdcontacto() {
		return contactoIdcontacto;
	}

	public void setContactoIdcontacto(Integer contactoIdcontacto) {
		this.contactoIdcontacto = contactoIdcontacto;
	}
 

}
