package aplicaciones.spring.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name="PASAJES")
public class Pasaje {
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private Long id;
		@NotNull
		private String clase;
		@NotNull
		private Integer asiento;
		@NotNull
		private Double precio;
		@NotNull
		private String cliente;
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getClase() {
			return clase;
		}
		public void setClase(String clase) {
			this.clase = clase;
		}
		public Integer getAsiento() {
			return asiento;
		}
		public void setAsiento(Integer asiento) {
			this.asiento = asiento;
		}
		public Double getPrecio() {
			return precio;
		}
		public void setPrecio(Double precio) {
			this.precio = precio;
		}
		public String getCliente() {
			return cliente;
		}
		public void setCliente(String cliente) {
			this.cliente = cliente;
		}
		@Override
		public String toString() {
			return "Pasaje [id=" + id + ", clase=" + clase + ", asiento=" + asiento + ", precio=" + precio
					+ ", cliente=" + cliente + "]";
		}

		
}