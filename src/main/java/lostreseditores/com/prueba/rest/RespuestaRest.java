package lostreseditores.com.prueba.rest;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lostreseditores.com.prueba.modelo.Respuesta;
import lostreseditores.com.prueba.service.RespuestaService;

@RestController
@RequestMapping("/api/resp/")
public class RespuestaRest {

	@Autowired
	private RespuestaService respuestaService;
	
	@PostMapping
	private ResponseEntity<Respuesta> guardar(@RequestBody Respuesta respuesta){
		Respuesta temporal=respuestaService.create(respuesta);
		try {
			return ResponseEntity.created(new URI("/api/resp"+temporal.getId())).body(temporal);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@RequestMapping(value = "/res", method = RequestMethod.GET)
	private ResponseEntity<Optional<Respuesta>> listarRespuestaId(@RequestParam(value = "id") Long id){
		return ResponseEntity.ok(respuestaService.RespuestaFindId(id));
	}
	
	@GetMapping
	private ResponseEntity<List<Respuesta>> listarTodos(){
		return ResponseEntity.ok(respuestaService.getAllRespuesta());
	}
	
	@RequestMapping(value = "/resc", method = RequestMethod.GET)
	private ResponseEntity<List<Respuesta>>listarRepuestaContex(@RequestParam(value="id") Long id){
		return ResponseEntity.ok(respuestaService.findContexto(id));
	}
}
