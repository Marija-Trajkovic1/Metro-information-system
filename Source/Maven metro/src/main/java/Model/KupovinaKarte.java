package Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="kupovinakarte")
public class KupovinaKarte {
	
	@Id
	@Column(name="idkupovinakarte")
	private int idKupovine;
	
	@Column(name="idKarte")
	private int idKarte;
	
	@Column(name="idOsobe")
	private int idOsobe;
	 
	public KupovinaKarte() {
		
	}
	
	public KupovinaKarte(int idKupovine, int idKarte, int idOsobe) {
		this.setIdKupovine(idKupovine);
		this.setIdKarte(idKarte);
		this.setIdOsobe(idOsobe);
	}
	
	public void setIdKupovine(int id) {
		this.idKupovine=id;
	}
	
	public int getIdKupovine() {
		return this.idKupovine;
	}
	
	public void setIdKarte(int idKarte) {
		this.idKarte=idKarte;
	}
	
	public int getIdKarte() {
		return this.idKarte;
	}
	
	public void setIdOsobe(int id) {
		this.idOsobe=id;
	}
	
	public int getIdOsobe() {
		return this.idOsobe;
	}
}
