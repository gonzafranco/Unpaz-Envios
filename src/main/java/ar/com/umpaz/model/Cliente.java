package ar.com.umpaz.model;


import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name="CLIENTES")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CLIENTE_ID")
	public Long id;
	
	@Column(name="NOMBRE")
	public String nombre;
	
	@Column(name="APELLIDO")
	public String apellido;
	
	@Column(name="DNI")
	public String dni;
	
	@Column(name="CUIT")
	public String cuit;
	
	@Column(name="RAZON_SOCIAL")
	public String razonSocial;
	
	@Column(name="DIRECCION")
	public String direccion;

	@Email
	@Column(name="EMAIL")
	public String email;
	
	@Column(name = "ESTADO")
	public Date deleteAt ;
	
	@OneToOne(mappedBy = "cliente" ,cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	public Usuario usuario;
	
	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	public List<Pedido> pedidos;
	
}
