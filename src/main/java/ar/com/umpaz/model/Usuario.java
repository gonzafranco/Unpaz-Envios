package ar.com.umpaz.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name = "USUARIOS")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USUARIO_ID")
	public long id;
	
	@Column(name = "PERFIL")
	public String perfil;
	
	@Column(name = "CLAVE")
	public String clave;
	
    
	@OneToOne()
    @JoinColumn(name = "CLIENTE_ID")
	@JsonIgnore 
    public Cliente cliente;
	
	
	
}
