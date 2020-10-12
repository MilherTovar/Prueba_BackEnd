package lostreseditores.com.prueba.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import lostreseditores.com.prueba.modelo.Libro;

public interface LibroRepository extends JpaRepository<Libro, Long> {

}
