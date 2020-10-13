package lostreseditores.com.prueba.modelo;

import javax.persistence.*;

@Entity
@Table (name="resultado")
public class Resultado {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private String persona;
	private String pregunta;
	private int valor;
	
	
	
	public Resultado() {
	}
	
	public Resultado(int id, String persona, String pregunta, int valor) {
		this.id = id;
		this.persona = persona;
		this.pregunta = pregunta;
		this.valor = valor;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPersona() {
		return persona;
	}
	public void setPersona(String persona) {
		this.persona = persona;
	}
	public String getPregunta() {
		return pregunta;
	}
	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}
	public int getValor() {
		return valor;
	}
	public void setValor(int valor) {
		this.valor = valor;
	}
}
