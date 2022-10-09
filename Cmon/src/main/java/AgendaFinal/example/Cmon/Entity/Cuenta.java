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
@Table(name ="cuenta")
public class Cuenta  implements Serializable {

	private static final long serialVersionUID = 5L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional=false)
	@Column(name="idcuenta")
	private Integer idcuenta;
	
	@Column(name="tipo_cliente")
	private String tipocliente;
	
	@Column(name="contacto_idcontacto")
	private Integer contactoIdcontacto;

	public Integer getIdcuenta() {
		return idcuenta;
	}

	public void setIdcuenta(Integer idcuenta) {
		this.idcuenta = idcuenta;
	}

	public String getTipocliente() {
		return tipocliente;
	}

	public void setTipocliente(String tipocliente) {
		this.tipocliente = tipocliente;
	}

	public Integer getContactoIdcontacto() {
		return contactoIdcontacto;
	}

	public void setContactoIdcontacto(Integer contactoIdcontacto) {
		this.contactoIdcontacto = contactoIdcontacto;
	}

	
}
