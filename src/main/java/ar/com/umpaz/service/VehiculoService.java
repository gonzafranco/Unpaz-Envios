package ar.com.umpaz.service;

import java.util.List;

import ar.com.umpaz.generic.GenericCrud;
import ar.com.umpaz.model.Vehiculo;

public interface VehiculoService  extends GenericCrud<Vehiculo>{

    	List <Vehiculo> getAll();

    
}
