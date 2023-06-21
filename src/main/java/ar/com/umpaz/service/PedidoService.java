package ar.com.umpaz.service;

import java.util.List;

import ar.com.umpaz.generic.GenericCrud;
import ar.com.umpaz.model.Pedido;

public interface PedidoService extends GenericCrud<Pedido>{
	
	List <Pedido> getAll();
	
}
