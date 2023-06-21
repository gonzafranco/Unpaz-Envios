package ar.com.umpaz.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.com.umpaz.model.Cliente;
import ar.com.umpaz.model.Vehiculo;
import ar.com.umpaz.service.VehiculoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name="Vehiculo controller", description = "API REST Transporte")
@RequestMapping("/vehiculo")
@RestController
public class VehiculoController {

    @Autowired
	private VehiculoService vehiculoService;
	

	@Operation(summary = "Crear un vehiculo")
	@ApiResponses(value = {
				@ApiResponse(responseCode = "200", description = "Se registro un nuevo vehiculo",content={ @Content(mediaType = "application/json",schema=@Schema(implementation = Cliente.class )) }),
				@ApiResponse(responseCode = "400", description = "Error en campos",content = @Content),
				@ApiResponse(responseCode = "403", description = "No autorizado",content = @Content),
				@ApiResponse(responseCode = "500", description = "Error Interno del procesamiento del servidor",content = @Content)

		})
	@PostMapping
	public Vehiculo save(@RequestBody Vehiculo vehiculo) {
    	return vehiculoService.save(vehiculo);
	}


	@Operation(summary = "listar todos los vehiculos")
	@ApiResponses(value = {
				@ApiResponse(responseCode = "200", description = "Se listo todos los vehiculos",content={ @Content(mediaType = "application/json",schema=@Schema(implementation = Cliente.class )) }),
				@ApiResponse(responseCode = "400", description = "Error en campos",content = @Content),
				@ApiResponse(responseCode = "403", description = "No autorizado",content = @Content),
				@ApiResponse(responseCode = "500", description = "Error Interno del procesamiento del servidor",content = @Content)

		})
	@GetMapping
	public ResponseEntity<?>getAll(){
		 Map<String, Object> response = new HashMap<String, Object>();
		 List<Vehiculo> vehiculos = new ArrayList<Vehiculo>();
		 
		 vehiculos = vehiculoService.getAll();
		 response.put("Pedidos",vehiculos);
		 return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	
    
}
