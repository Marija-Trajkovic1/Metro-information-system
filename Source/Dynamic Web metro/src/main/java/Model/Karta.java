package Model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="karta")
public class Karta {
	
	@Column(name="idKarte")
	@Id
	private int idKarte;
	
	@Column(name="vazenjeKarteDo")
	private Date vazenjeKarteDo;//koliko dugo karta vazi
	
	@Column(name="cenaKarte")
	private int cenaKarte;
	
	@Column(name="vremeKupovine")
	private Date vremeKupovine;
	
	@Column(name="validnostKarte")
	private String validnostKarte;
	
	@Column(name="tip")
	private String tip;
	
	@Column(name="idTipMesecne")
	private int idTipMesecne;
	
	public Karta() {
		
	}
	
	public Karta(int idKarte, Date vazenje, int cena, Date vreme, String validna, String tip) {
		this.setIdKarte(idKarte);
		this.setVazenjeKarteDo(vazenje);
		this.setCenaKarte(cena);
		this.setVremeKupovine(vreme);
		this.setValidnostKarte(validna);
		this.setTip(tip);
	}

	public int getIdKarte() {
        return idKarte;
    }
	
	public void setIdKarte(int idKarte) {
		this.idKarte=idKarte;
	}
	
	public void setCenaKarte(int cena) {
		this.cenaKarte=cena;
	}
	
	public int getCenaKarte() {
		return this.cenaKarte;
	}
	
	public void setVremeKupovine(Date vreme) {
		this.vremeKupovine=vreme;
	}
	
	public Date getVremeKupovine() {
		return this.vremeKupovine;
	}
	
	public void setValidnostKarte(String validna) {
		this.validnostKarte=validna;
	}
	
	public String getValidnostKarte() {
		return this.validnostKarte;
	}
	
	public void setTip(String tip) {
		this.tip=tip;
	}
	
	public String getTip() {
		return this.tip;
	}
	
	public void setVazenjeKarteDo(Date vazenje) {
		this.vazenjeKarteDo=vazenje;
	}
	
	public Date getVazenjeKarteDo() {
		return this.vazenjeKarteDo;
	}
	
	public void setIdTipMesecne(int idtip) {
		this.idTipMesecne=idtip;
	}
	
	public int getIdTipMesecne() {
		return this.idTipMesecne;
	}

}
