package aplicaciones.spring.modelo;


import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import com.sun.istack.NotNull;

@Entity
@Table(name="VUELOS")
public class Vuelo {
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private Long id;
		@NotNull
		private String cliente;
		@NotNull
		private String pasaje;
		@NotNull
		private String ruta;
		@NotNull
		private String aerolinea;
		@NotNull
		private String tipo;
		@NotNull
		private String precio;
		@NotNull
		private String origen;
		@NotNull
		private String destino;
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
		public String getRuta() {
			return ruta;
		}
		public void setRuta(String ruta) {
			this.ruta = ruta;
		}
		public String getAerolinea() {
			return aerolinea;
		}
		public void setAerolinea(String aerolinea) {
			this.aerolinea = aerolinea;
		}
		public String getTipo() {
			return tipo;
		}
		public void setTipo(String tipo) {
			this.tipo = tipo;
		}
		public String getPrecio() {
			return precio;
		}
		public void setPrecio(String precio) {
			this.precio = precio;
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
		@Override
		public String toString() {
			return "Vuelo [id=" + id + ", cliente=" + cliente + ", pasaje=" + pasaje + ", ruta=" + ruta + ", aerolinea="
					+ aerolinea + ", tipo=" + tipo + ", precio=" + precio + ", origen=" + origen + ", destino="
					+ destino + "]";
		}
		
		
}