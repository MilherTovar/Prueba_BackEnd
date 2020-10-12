package lostreseditores.com.prueba.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import lostreseditores.com.prueba.modelo.Persona;

public interface PersonaRepository extends JpaRepository<Persona, Long> {

}
