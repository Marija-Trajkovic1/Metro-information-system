package Controller;

import java.sql.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import Model.Karta;
import Service.KartaService;

@ManagedBean
public class KartaController {
	private int idKarte=0;
	private Date vazenjeKarteDo;
	private String validnostKarte="";
	private String tip="";
	private int idTipMesecne=0;
	private Karta karta=new Karta();
	
	@EJB
	private KartaService service;
	
	public Karta getKarta() {
		return karta;
	}
	
	public void setKarta(Karta k) {
		this.karta=k;
	}
	
	public void novaKarta(Karta k) {
		service.novaKarta(k.getIdKarte(), k.getVazenjeKarteDo(), k.getCenaKarte(), k.getVremeKupovine(), k.getValidnostKarte(), k.getTip());
	}
	
	public int getIdKarte() {
		return this.idKarte;
	}
	
	public void setIdKarte(int id) {
		this.idKarte=id;
	}
	
	public Date getVazenjeKarteDo() {
		return this.vazenjeKarteDo;
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
	
	public void setIdTipMsecne(int id) {
		this.idTipMesecne=id;
	}
	
	public int getIdTipMesecne() {
		return this.idTipMesecne;
	}
	
	public List<Karta> listaKarti(){
		List<Karta> listaKarata=service.listaKarti();
		return listaKarata;
	}
}
