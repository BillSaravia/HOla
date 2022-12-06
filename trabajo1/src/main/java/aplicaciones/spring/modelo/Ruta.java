package aplicaciones.spring.modelo;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name="RUTAS")
public class Ruta {
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private Long id;
		@NotNull
		private String cliente;
		@NotNull
		private String pasaje;
		@NotNull
		private String origen;
		@NotNull
		private String destino;
		@NotNull		
		private Date fechaini;
		@NotNull
		private Date fechafin;
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getCliente() {
			return cliente;
		}
		public void setCliente(String cliente) {
			this.cliente = cliente;
		}
		public String getPasaje() {
			return pasaje;
		}
		public void setPasaje(String pasaje) {
			this.pasaje = pasaje;
		}
		public String getOrigen() {
			return origen;
		}
		public void setOrigen(String origen) {
			this.origen = origen;
		}
		public String getDestino() {
			return destino;
		}
		public void setDestino(String destino) {
			this.destino = destino;
		}
		public Date getFechaini() {
			return fechaini;
		}
		public void setFechaini(Date fechaini) {
			this.fechaini = fechaini;
		}
		public Date getFechafin() {
			return fechafin;
		}
		public void setFechafin(Date fechafin) {
			this.fechafin = fechafin;
		}
		@Override
		public String toString() {
			return "Ruta [id=" + id + ", cliente_id=" + cliente + ", pasaje_id=" + pasaje + ", origen=" + origen
					+ ", destino=" + destino + ", fechaini=" + fechaini + ", fechafin=" + fechafin + "]";
		}
		
		
		
}