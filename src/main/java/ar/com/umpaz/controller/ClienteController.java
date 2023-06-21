package ar.com.umpaz.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import ar.com.umpaz.model.Cliente;
import ar.com.umpaz.model.Usuario;
import ar.com.umpaz.service.ClienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name="Cliente controller", description = "API REST Transporte")
@RequestMapping("/cliente")
@RestController
public class ClienteController {

	@Autowired
	private ClienteService clienteService;


	@Operation(summary = "Crear un cliente")
	@ApiResponses(value = {
				@ApiResponse(responseCode = "200", description = "Se registro un nuevo cliente",content={ @Content(mediaType = "application/json",schema=@Schema(implementation = Cliente.class )) }),
				@ApiResponse(responseCode = "400", description = "Error en campos",content = @Content),
				@ApiResponse(responseCode = "403", description = "No autorizado",content = @Content),
				@ApiResponse(responseCode = "500", description = "Error Interno del procesamiento del servidor",content = @Content)

		})
	@PostMapping
	public ResponseEntity<?> save(@RequestBody Cliente cliente) {
		Map<String, Object> response = new HashMap<>();
		try {
			Usuario aux = cliente.getUsuario();
			aux.setCliente(cliente);
			cliente.setUsuario(aux);

			Cliente savedCliente = clienteService.save(cliente);

			response.put("cliente", savedCliente);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			response.put("message", "Paso un error, que no se que es.");
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Operation(summary = "Listar un cliente por id")
	@ApiResponses(value = {
				@ApiResponse(responseCode = "200", description = "Se encontro al cliente",content={ @Content(mediaType = "application/json",schema=@Schema(implementation = Cliente.class )) }),
				@ApiResponse(responseCode = "400", description = "Error en campos",content = @Content),
				@ApiResponse(responseCode = "403", description = "No autorizado",content = @Content),
				@ApiResponse(responseCode = "500", description = "Error Interno del procesamiento del servidor",content = @Content)

		})
	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable Long id) {
		Map<String, Object> response = new HashMap<String, Object>();
		Cliente sCliente = new Cliente();
		try {

			sCliente.id = id;
			sCliente = clienteService.getById(sCliente);
			response.put("cliente", sCliente);

		} catch (Exception e) {
			response.put("cliente", sCliente);
			response.put("Error", "Paso un error, que no se que es ");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);

	}

	@Operation(summary = "modificar el nombre y apellido de un cliente por id")
	@ApiResponses(value = {
				@ApiResponse(responseCode = "200", description = "Se modifico correctamente al cliente",content={ @Content(mediaType = "application/json",schema=@Schema(implementation = Cliente.class )) }),
				@ApiResponse(responseCode = "400", description = "Error en campos",content = @Content),
				@ApiResponse(responseCode = "403", description = "No autorizado",content = @Content),
				@ApiResponse(responseCode = "500", description = "Error Interno del procesamiento del servidor",content = @Content)

		})
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable Long id,@RequestBody Cliente clienteData) {
		Map<String, Object> response = new HashMap<String, Object>();
		Cliente sCliente = new Cliente();
		try {

			sCliente.id = id;
			sCliente = clienteService.getById(sCliente);

			sCliente.setNombre(clienteData.nombre);
			sCliente.setApellido(clienteData.apellido);
			//Demas atributos. Alguna forma de automatica de identificar atributos del request?
			
			
			clienteService.update(sCliente);
			response.put("cliente", sCliente);

		} catch (Exception e) {
			response.put("cliente", sCliente);
			response.put("Error", "Paso un error, que no se que es ");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);

	}

	@Operation(summary = "Listar todos los  cliente")
	@ApiResponses(value = {
				@ApiResponse(responseCode = "200", description = "Se listo todos los clientes",content={ @Content(mediaType = "application/json",schema=@Schema(implementation = Cliente.class )) }),
				@ApiResponse(responseCode = "400", description = "Error en campos",content = @Content),
				@ApiResponse(responseCode = "403", description = "No autorizado",content = @Content),
				@ApiResponse(responseCode = "500", description = "Error Interno del procesamiento del servidor",content = @Content)

		})
	@GetMapping
	public ResponseEntity<?> getAll() {
		Map<String, Object> response = new HashMap<String, Object>();
		List<Cliente> clientes = new ArrayList<Cliente>();

		clientes = clienteService.getAll();
		response.put("clientes", clientes);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

	@GetMapping("/all")
	public List<Cliente> getList() {
		return clienteService.getAll();
	}


	@Operation(summary = "borrar logicamente a un cliente por id")
	@ApiResponses(value = {
				@ApiResponse(responseCode = "200", description = "Se borro correctamente al cliente",content={ @Content(mediaType = "application/json",schema=@Schema(implementation = Cliente.class )) }),
				@ApiResponse(responseCode = "400", description = "Error en campos",content = @Content),
				@ApiResponse(responseCode = "403", description = "No autorizado",content = @Content),
				@ApiResponse(responseCode = "500", description = "Error Interno del procesamiento del servidor",content = @Content)

		})
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Long id) {
		Map<String, Object> response = new HashMap<String, Object>();
		Cliente sCliente = new Cliente();
		try {

			sCliente.id = id;
			sCliente = clienteService.getById(sCliente);


			if (sCliente.getDeleteAt() != null) {
           		response.put("Error", "El cliente ya está borrado");
            	return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
       		 }

			sCliente.setDeleteAt(new Date());
			clienteService.update(sCliente);

			response.put("cliente", sCliente);

		} catch (Exception e) {
			response.put("cliente", sCliente);
			response.put("Error", "Paso un error, que no se que es ");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);

	}

}
