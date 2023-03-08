package Model;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="osoba")
public class Osoba {
	
	@Id
	@Column(name="idOsobe")
	private int idOsobe;
	
	@Column(name="imeOsobe")
	private String imeOsobe;
	
	@Column(name="prezimeOsobe")
	private String prezimeOsobe;
	
	@Column(name="jmbgOsobe")
	private String jmbgOsobe;
	
	@Column(name="brlkOsobe")
	private int brlkOsobe;
	
	@Column(name="datumRodjenja")
	private Date datumRodjenja;
	
	@Column(name="ocenaUsluge")
	private int ocenaUsluge;
	
	@Column(name="stanjeNaKartici")
	private int stanjeNaKartici;
	
	public Osoba() {
		
	}
	
	public Osoba(int idOsobe, String ime, String prezime, String jmbg, int brlk, Date datum, int stanje) {
		this.setIdOsobe(idOsobe);
		this.setImeOsobe(ime);
		this.setPrezimeOsobe(prezime);
		this.setJmbgOsobe(jmbg);
		this.setBrlkOsobe(brlk);
		this.setDatumRodjenja(datum);	
		this.setStanjeNaKartici(stanje);
	}
	
	public Osoba(String ime, String prezime, String jmbg, int brlk, Date datum,int ocena, int stanje) {
		this.setImeOsobe(ime);
		this.setPrezimeOsobe(prezime);
		this.setJmbgOsobe(jmbg);
		this.setBrlkOsobe(brlk);
		this.setDatumRodjenja(datum);	
		this.setOcenaUsluge(ocena);
		this.setStanjeNaKartici(stanje);
	}
	
	public void setIdOsobe(int id) {
		this.idOsobe=id;
	}
	
	public int getIdOsobe() {
		return this.idOsobe;
	}
	
	public void setDatumRodjenja(Date datum) {
		this.datumRodjenja=datum;
	}
	
	public Date getDatumRodjenja() {
		return this.datumRodjenja;
	}

	public void setBrlkOsobe(int brlk) {
		this.brlkOsobe=brlk;
	}
	
	public int getBrlkOsobe() {
		return this.brlkOsobe;
	}

	public void setJmbgOsobe(String jmbg) {
		this.jmbgOsobe=jmbg;
	}
	
	public String getJmbgOsobe() {
		return this.jmbgOsobe;
	}

	public void setPrezimeOsobe(String prezime) {
		this.prezimeOsobe=prezime;		
	}
	
	public String getPrezime() {
		return this.prezimeOsobe;
	}

	public void setImeOsobe(String ime) {
		this.imeOsobe=ime;		
	}
	
	public String getImeOsobe() {
		return this.imeOsobe;
	}
	
	public void setOcenaUsluge(int ocena) {
		this.ocenaUsluge=ocena;
	}

	public int getOcenaUsluge() {
		return this.ocenaUsluge;
	}
	
	public void setStanjeNaKartici(int stanje) {
		this.stanjeNaKartici=stanje;
	}
	
	public int getStanjeNaKartici() {
		return this.stanjeNaKartici;
	}
	
	public boolean platiKartu(int suma) {
		if (this.stanjeNaKartici <suma) {
			return false;
		}
		else {
			this.stanjeNaKartici=this.stanjeNaKartici-suma;
			return true;
		}
	}
	
	

}
