package lostreseditores.com.prueba.rest;

import java.io.FileNotFoundException;
import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lostreseditores.com.prueba.modelo.Resultado;
import lostreseditores.com.prueba.service.ResultadoService;
import net.sf.jasperreports.engine.JRException;

@RestController
@RequestMapping("/api/resul/")
public class ResultadoRest {
	
	@Autowired
	private ResultadoService resultadoService;
	
	@PostMapping
	private ResponseEntity<Resultado> guardar(@RequestBody Resultado resultado){
		Resultado temporal=resultadoService.create(resultado);
		try {
			return ResponseEntity.created(new URI("/api/resul"+temporal.getId())).body(temporal);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@GetMapping("/report/{format}")
    public String generateReport(@PathVariable String format) throws FileNotFoundException, JRException {
        return resultadoService.exportReport(format);
    }

}
