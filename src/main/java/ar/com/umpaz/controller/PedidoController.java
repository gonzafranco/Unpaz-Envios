package ar.com.umpaz.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.aspectj.lang.annotation.AfterReturning;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.com.umpaz.model.Estado;
import ar.com.umpaz.model.Pedido;
import ar.com.umpaz.model.PedidoDetalle;
import ar.com.umpaz.service.PedidoService;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Pedido controller", description = "API REST Transporte")
@RequestMapping("/pedido")
@RestController
public class PedidoController {

	@Autowired
	private PedidoService pedidoService;

	@PostMapping
	public Pedido save(@RequestBody Pedido pedido) {

		for (PedidoDetalle detalle : pedido.getDetalle()) {
			detalle.setPedido(pedido);
		}
		return pedidoService.save(pedido);
	}

	@GetMapping
	public ResponseEntity<?> getAll() {
		Map<String, Object> response = new HashMap<String, Object>();
		List<Pedido> pedidos = new ArrayList<Pedido>();

		pedidos = pedidoService.getAll();
		response.put("Pedidos", pedidos);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

	@PutMapping("/confirmar/{id}")
	public ResponseEntity<?> confirmar(@PathVariable Long id) {

		Map<String, Object> response = new HashMap<String, Object>();
		Pedido sPedido = new Pedido();
		try {
			sPedido.id = id;
			sPedido = pedidoService.getById(sPedido);

			if (sPedido.getEstado().getId() == 2) {
				response.put("Error", "El pedido ya esta confirmado");
				return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
			}

			Estado estado = new Estado();
			estado.setId((long) 2);

			sPedido.setEstado(estado);

			pedidoService.save(sPedido);
			response.put("Se confirmo el pedido", sPedido);

		} catch (Exception e) {
			response.put("Pedido", sPedido);
			response.put("Error", "Paso un error, que no se que es ");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);

	}

}
