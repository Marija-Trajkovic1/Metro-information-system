package Controller;


import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import Model.Osoba;
import Service.OsobaService;

@ManagedBean
public class OsobaController {
	
	private int idOsobe;
	private String imeOsobe="";
	private String prezimeOsobe="";
	private String jmbgOsobe="";
	private int brlkOsobe;
	private String datumRodjenja="";
	private int ocenaUsluge;
	private int stanjeNaKartici;	
	
	private Osoba osoba=new Osoba();
	
	@EJB
	private OsobaService service;
	
	public Osoba getOsoba() {
		return osoba;
	}
	
	public void setOsoba(Osoba o) {
		this.osoba=o;
	}
	
	public int getIdOsobe() {
		return this.idOsobe;
	}
	
	public void setIdOsobe(int id) {
		this.idOsobe=id;
	}
	
	public String getImeOsobe() {
		return this.imeOsobe;
	}
	
	public void setImeOsobe(String ime) {
		this.imeOsobe=ime;
	}
	
	public String getPrezimeOsobe() {
		return this.prezimeOsobe;
	}
	
	public void setPrezimeOsobe(String prezime) {
		this.prezimeOsobe=prezime;
	}
	
	public void setJmbgOsobe(String jmbg) {
		this.jmbgOsobe=jmbg;
	}
	
	public String getJmbgOsobe() {
		return this.jmbgOsobe;
	}
	
	public void setBrlkOsobe(int brlk) {
		this.brlkOsobe=brlk;
	}
	
	public int getBrlkOsobe() {
		return this.brlkOsobe;
	}
	
	public void setDatumRodjenja(String datum) {
		this.datumRodjenja=datum;
	}
	
	public String getDatumRodjenja() {
		return this.datumRodjenja;
	}
	
	public int getOcenaUsluge() {
		return this.ocenaUsluge;
	}
	
	public void setOcenaUasluge(int ocena) {
		this.ocenaUsluge=ocena;
	}
	
	public int getStanjeNaKartici() {
		return this.stanjeNaKartici;
	}
	
	public void setStanjeNaKartici(int stanje) {
		this.stanjeNaKartici=stanje;
	}
	
	public List<Osoba> listaOsoba(){
		List<Osoba> listaOsoba=service.Osobe();
		return listaOsoba;
	}
	
	public void obrisiOsobu(int id) {
		this.service.obrisiOsobu(id);
	}
	
	public void dodajOsobu(int id, String ime, String prezime, String jmbg, int brlk, String datumRodj, int stanje) {
		service.setOsoba(id, ime, prezime, jmbg, brlk, datumRodj, stanje);
	}
	
	public int vratiStanje(int id) {
		return this.service.vratiStanjeNaKartici(id);
	}
	
	
	public void oceniUslugu(int id, int ocena) {
		if( ocena<1 || ocena>5)
			System.out.println("Unesite ocenu u opsegu od 1 do 5!");
		else 
			this.service.oceniUslugu(id, ocena);
	}
	 
}

