package lostreseditores.com.prueba.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lostreseditores.com.prueba.modelo.Contexto;
import lostreseditores.com.prueba.repository.ContextoRepository;

@Service
public class ContextoService {
	
	@Autowired
	private ContextoRepository contextoRepository;
	
	public Contexto create (Contexto contexto) {
		return contextoRepository.save(contexto);
	}
	
	public List<Contexto> getAllContextos(){
		return contextoRepository.findAll();
	}
	
	public Optional<Contexto> contextoFindId(Long id){
		return contextoRepository.findById(id);
	}

}
