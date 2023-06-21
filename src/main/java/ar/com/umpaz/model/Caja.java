package ar.com.umpaz.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import lombok.Data;

@Data
@Entity
@Table(name = "CAJAS")
public class Caja {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="CAJA_ID")
	public long id;
	
	@Column(name = "TIPO_CAJA")
	public String tipo;
	
	
	@Fetch(FetchMode.JOIN)
	@ManyToMany(mappedBy = "cajas")
    public List<PedidoDetalle> pedidoDetalles;
	
	

}
