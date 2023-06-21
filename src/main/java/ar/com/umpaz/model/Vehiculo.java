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
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "VEHICULOS")
public class Vehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "VEHICULO_ID")
    public Long id;

    @Column(name = "MODELO")
    public String modelo;

    @Column(name = "PATENTE")
    public String patente;

    @JoinTable(
				name="VEHICULO_X_SEGURO",
				joinColumns = @JoinColumn(name="VEHICULO_ID"),
				inverseJoinColumns = @JoinColumn(name="SEGURO_ID")
			)
	@ManyToMany(fetch = FetchType.LAZY)
	public List<Seguro> seguros;
    
}
