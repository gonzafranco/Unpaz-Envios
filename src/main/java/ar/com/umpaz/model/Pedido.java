package ar.com.umpaz.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import lombok.Data;
import lombok.ToString;


@Data
@Entity
@Table(name="PEDIDO")
@ToString
public class Pedido {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="PEDIDO_ID")
	public Long id;
	
	@Column(name="FECHA_PEDIDO")
	public String fecha_pedido;
	
	@Column(name="DIRECCION_PEDIDO")
	public String direccion_pedido;
	
	@ManyToOne
	@JoinColumn(name="ESTADO_ID")
	public Estado estado;
	
	@ManyToOne( fetch = FetchType.LAZY)
	@JoinColumn(name="CLIENTE_ID")
	public Cliente cliente;
	
	@OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
	public List<PedidoDetalle> detalle;
	
	
	
   
}
