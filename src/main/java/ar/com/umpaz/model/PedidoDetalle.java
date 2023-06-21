package ar.com.umpaz.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import lombok.Data;

@Entity
@Data
@Table(name="PEDIDO_DETALLE")
public class PedidoDetalle {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="DETALLE_ID")
	public long id;
	
	@Column(name = "CANTIDAD")
	public int cantidad;
	
	@ManyToOne
	@JoinColumn(name="PEDIDO_ID")
	public Pedido pedido;
	
	@JoinTable(
				name="DETALLE_X_CAJA",
				joinColumns = @JoinColumn(name="DETALLE_ID"),
				inverseJoinColumns = @JoinColumn(name="CAJA_ID")
			)
	@ManyToMany(fetch = FetchType.LAZY)
    public List<Caja> cajas;

}
