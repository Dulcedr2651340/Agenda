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
@Table(name ="correo")
public class Correo implements Serializable{
	private static final long serialVersionUID = 4L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional=false)
	@Column(name="idcorreo")
	private Integer idcorreo;
	
	@Column(name="correo")
	private String correo;
	
	@Column(name="contacto_idcontacto")
	private Integer contactoIdcontacto;

	public Integer getIdcorreo() {
		return idcorreo;
	}

	public void setIdcorreo(Integer idcorreo) {
		this.idcorreo = idcorreo;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public Integer getContactoIdcontacto() {
		return contactoIdcontacto;
	}

	public void setContactoIdcontacto(Integer contactoIdcontacto) {
		this.contactoIdcontacto = contactoIdcontacto;
	}

	
}