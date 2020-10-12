package lostreseditores.com.prueba.modelo;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table (name="contexto")
public class Contexto {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column (name="contexto")
	private String context;
	
	private String pregunta;

	public String getPregunta() {
		return pregunta;
	}

	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public Contexto(Long id, String context) {
		this.id = id;
		this.context = context;
	}
		
	public Contexto() {
	}
	
	/*@ManyToMany
	@JoinTable(name="contexto_respuesta"
		,joinColumns=@JoinColumn(name="contexto_id")
		,inverseJoinColumns=@JoinColumn(name="respuesta_id")
	)
	private Set<Respuesta> respuestas;*/
}
