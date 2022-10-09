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
@Table(name ="servicios")
public class Servicios implements Serializable{

	private static final long serialVersionUID=9L;
		@Id
		@Basic(optional=false)
		@GeneratedValue(strategy= GenerationType.IDENTITY)
		@Column(name="idservicios")
		private Integer idservicios;
	
		@Column(name="nombreservicio")
		private String nombreservicio;

	
		
		@Column (name="factura_codfactura")
		private Integer facturaCodfactura;



		public Integer getIdservicios() {
			return idservicios;
		}



		public void setIdservicios(Integer idservicios) {
			this.idservicios = idservicios;
		}



		public String getNombreservicio() {
			return nombreservicio;
		}



		public void setNombreservicio(String nombreservicio) {
			this.nombreservicio = nombreservicio;
		}



		public Integer getFacturaCodfactura() {
			return facturaCodfactura;
		}



		public void setFacturaCodfactura(Integer facturaCodfactura) {
			this.facturaCodfactura = facturaCodfactura;
		}



		


		
	
}
