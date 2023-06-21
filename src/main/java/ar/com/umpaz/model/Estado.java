package ar.com.umpaz.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import lombok.Data;

@Data
@Entity
@Table(name = "ESTADOS")
public class Estado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ESTADO_ID")
    public Long id;

    @Column(name = "ESTADO_DESCRIPCION")
    public String estado;

    @OneToMany(mappedBy = "estado", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	public List<Pedido> pedidos;
    
}
