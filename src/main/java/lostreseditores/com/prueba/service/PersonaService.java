package lostreseditores.com.prueba.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lostreseditores.com.prueba.modelo.Persona;
import lostreseditores.com.prueba.repository.PersonaRepository;

@Service
public class PersonaService {
	
	@Autowired
	private PersonaRepository personaRepository;
	
	public Persona create (Persona persona) {
		return personaRepository.save(persona);
	}
	
	public List<Persona> getAllPersonas(){
		return personaRepository.findAll();
	}
	
	public Optional<Persona> findById(Long id) {
		return personaRepository.findById(id);
	}

}
