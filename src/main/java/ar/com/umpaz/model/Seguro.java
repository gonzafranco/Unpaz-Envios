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
@Table(name = "SEGUROS")
public class Seguro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SEGURO_ID")
    public Long id;

    @Column(name = "DESCRIPCION")
    public String descripcion;

    @Fetch(FetchMode.JOIN)
	@ManyToMany(mappedBy = "seguros")
	public List<Vehiculo> vehiculos;
    


    
}
