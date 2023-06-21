package ar.com.umpaz.service;

import java.util.List;

import ar.com.umpaz.generic.GenericCrud;
import ar.com.umpaz.model.Cliente;

public interface ClienteService  extends  GenericCrud<Cliente>{

	List<Cliente> getAll();
	
}
