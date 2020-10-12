package lostreseditores.com.prueba.modelo;

import javax.persistence.*;

@Entity
@Table (name="respuestas")
public class Respuesta {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column (name="respuesta")
	private String respue;
	
	private Long id_contexto;
	private Boolean valor;

	public Respuesta() {
	}
	
	public Boolean getValor() {
		return valor;
	}

	public Long getId_contexto() {
		return id_contexto;
	}

	public void setId_contexto(Long id_contexto) {
		this.id_contexto = id_contexto;
	}

	public void setValor(Boolean valor) {
		this.valor = valor;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRespue() {
		return respue;
	}

	public void setRespue(String respue) {
		this.respue = respue;
	}

	public Respuesta(Long id, String respue,Boolean valor,Long id_contexto) {
		this.id = id;
		this.respue = respue;
		this.valor=valor;
		this.id_contexto=id_contexto;
	}	
	
}
