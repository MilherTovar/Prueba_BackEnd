package lostreseditores.com.prueba.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lostreseditores.com.prueba.modelo.Respuesta;
import lostreseditores.com.prueba.repository.RespuestaRepository;

@Service
public class RespuestaService {
	
	@Autowired
	private RespuestaRepository respuestaRepository;
	
	@PersistenceContext
	private EntityManager em;
	
	public Respuesta create (Respuesta respuesta) {
		return respuestaRepository.save(respuesta);
	}
	
	public List<Respuesta> getAllRespuesta(){
		return respuestaRepository.findAll();
	}
	
	public Optional<Respuesta> RespuestaFindId(Long id){
		return respuestaRepository.findById(id);
	}
	
	public List<Respuesta> findContexto(Long id){
		Query nativequ=em.createNativeQuery("select * from respuesta where id_contexto=:id");
		nativequ.setParameter("id",id);
		@SuppressWarnings("unchecked")
		List<Respuesta> retornar=nativequ.getResultList();
		return retornar;
	}

}
