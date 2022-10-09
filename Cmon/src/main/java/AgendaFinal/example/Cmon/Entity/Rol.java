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
@Table(name ="rol")
public class Rol implements Serializable {
		private static final long serialVersionUID=1L;
		
		@Id
		@GeneratedValue(strategy =GenerationType.IDENTITY)
		@Basic(optional=false)
		@Column(name ="idrol")
		private Integer idrol;
		
		@Column(name="nombre")
		private String nombre;



		public Integer getIdrol() {
			return idrol;
		}

		public void setIdrol(Integer idrol) {
			this.idrol = idrol;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
	
}
