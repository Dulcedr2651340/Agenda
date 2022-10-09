package AgendaFinal.example.Cmon.Entity;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name ="factura")
public class Factura {

	private static final long serialVersionUID=8L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional=false)
	
	@Column(name="codfactura")
	private Integer codfactura;
	
	@Column(name="fechar")
	private Date fechar ;
	
	@Column(name="anulado")
	private String anulado;
	
	@Column(name="transferido")
	private String transferido;
	
	@Column(name="descuento")
	private String descuento;
	
	@Column(name="igv")
	private  Integer igv;
	
	@Column (name="subtotal")
	private Integer subtotal;
	
	@Column (name="total")
	private Integer total;
	
	@OneToMany(mappedBy="facturaCodfactura")
	private List<Contacto> contactoList;
	
	@OneToMany(mappedBy="facturaCodfactura")
	private List<CategoriaDeuda> categoriadeudaList;
	
	@OneToMany(mappedBy="facturaCodfactura")
	private List<Servicios> serviciosList;

	public Integer getCodfactura() {
		return codfactura;
	}

	public void setCodfactura(Integer codfactura) {
		this.codfactura = codfactura;
	}

	public Date getFecha() {
		return fechar;
	}

	public void setFecha(Date fecha) {
		this.fechar = fecha;
	}

	public String getAnulado() {
		return anulado;
	}

	public void setAnulado(String anulado) {
		this.anulado = anulado;
	}

	public String getTransferido() {
		return transferido;
	}

	public void setTransferido(String transferido) {
		this.transferido = transferido;
	}

	public String getDescuento() {
		return descuento;
	}

	public void setDescuento(String descuento) {
		this.descuento = descuento;
	}

	public Integer getIgv() {
		return igv;
	}

	public void setIgv(Integer igv) {
		this.igv = igv;
	}

	public Integer getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(Integer subtotal) {
		this.subtotal = subtotal;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public List<Contacto> getContactoList() {
		return contactoList;
	}

	public void setContactoList(List<Contacto> contactoList) {
		this.contactoList = contactoList;
	}

	public List<CategoriaDeuda> getCategoriadeudaList() {
		return categoriadeudaList;
	}

	public void setCategoriadeudaList(List<CategoriaDeuda> categoriadeudaList) {
		this.categoriadeudaList = categoriadeudaList;
	}

	public List<Servicios> getServiciosList() {
		return serviciosList;
	}

	public void setServiciosList(List<Servicios> serviciosList) {
		this.serviciosList = serviciosList;
	}
	

	
	
}

