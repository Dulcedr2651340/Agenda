package AgendaFinal.example.Cmon.Entity;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="CategoriaDeuda")

public class CategoriaDeuda implements Serializable {
	private static final long serialVersionUID=10L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Basic(optional=false)
	
	@Column(name="idcategoriadeuda")
	private Integer idcategoriadeuda;
	@Column(name="nombrecategoria")
	private String NombreCategoria;

	@Column(name="factura_codfactura")
	private Integer facturaCodfactura;

	public Integer getFacturaCodfactura() {
		return facturaCodfactura;
	}

	public void setFacturaCodfactura(Integer facturaCodfactura) {
		this.facturaCodfactura = facturaCodfactura;
	}



	public Integer getIdcategoriadeuda() {
		return idcategoriadeuda;
	}

	public void setIdcategoriadeuda(Integer idcategoriadeuda) {
		this.idcategoriadeuda = idcategoriadeuda;
	}

	public String getNombreCategoria() {
		return NombreCategoria;
	}

	public void setNombreCategoria(String nombreCategoria) {
		NombreCategoria = nombreCategoria;
	}




}
