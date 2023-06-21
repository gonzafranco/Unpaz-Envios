package ar.com.umpaz.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.umpaz.model.Pedido;
import ar.com.umpaz.respository.PedidoRepository;
import ar.com.umpaz.service.PedidoService;

@Service
public class PedidoServiceImp implements PedidoService{
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Override
	public Pedido save(Pedido Obj) {
		return pedidoRepository.save(Obj);
	}

	@Override
	public List<Pedido> listAllById(Pedido Obj) {
		return null;
	}

	@Override
	public Pedido update(Pedido Obj) {
		return null;
	}

	@Override
	public void delete(Pedido Objt) {
		pedidoRepository.delete(Objt);
		
	}

	@Override
	public Pedido getById(Pedido Obj) {
		return pedidoRepository.findById(Obj.id).get();
	}

	@Override
	public List<Pedido> getAll() {
		return  (List<Pedido>) pedidoRepository.findAll();
	}

}
