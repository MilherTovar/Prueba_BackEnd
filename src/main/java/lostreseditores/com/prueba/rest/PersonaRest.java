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

import lostreseditores.com.prueba.modelo.Persona;
import lostreseditores.com.prueba.service.PersonaService;

@RestController
@RequestMapping("/api/persona/")
public class PersonaRest {
	
	@Autowired
	private PersonaService personaService;
	
	@PostMapping
	private ResponseEntity<Persona> guardar(@RequestBody Persona persona){
		Persona temporal=personaService.create(persona);
		try {
			return ResponseEntity.created(new URI("/api/persona"+temporal.getId())).body(temporal);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}	
	
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	private ResponseEntity<Optional<Persona>> listarPersonaId(@RequestParam(value = "id") Long id){
		return ResponseEntity.ok(personaService.findById(id));
	}
	
	@GetMapping
	private ResponseEntity<List<Persona>> listarTodos(){
		return ResponseEntity.ok(personaService.getAllPersonas());
	}
}
