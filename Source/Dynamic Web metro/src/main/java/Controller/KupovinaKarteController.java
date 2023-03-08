package Controller;

import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import Model.KupovinaKarte;
import Service.KupovinaKarteService;

@ManagedBean
public class KupovinaKarteController {
	private int idKupovine;
	private int idKarte;
	private int idOsobe;
	private KupovinaKarte kupovina=new KupovinaKarte();

	@EJB
	private KupovinaKarteService service;
	
	public KupovinaKarte getKupovina() {
		return kupovina;
	}
	
	public void setKupovina(KupovinaKarte k) {
		this.kupovina=k;
	}
	
	public void setIdKupovine(int id) {
		this.idKupovine=id;
	}
	
	public int getIdKupovine() {
		return this.idKupovine;
	}
	
	public void setIdKarte(int id) {
		this.idKarte=id;
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
	
	public void dodajKupovinu(int idKup, int idKar, int idO) {
		service.setKupovina(idKup, idKar, idO);
	}
	
	public void obrisiKupovinu(int idKupovine) {
		service.obrisiKupovinu(idKupovine);
	}
	
	public void dodajKupovinuKarticom(int idKupovine, int idOsobe){
				
			try {
				service.novaKupovinaKarticom(idKupovine, idOsobe);
				
			}catch(IOException e) {
				e.printStackTrace();
			}		
	}
	
	public List<KupovinaKarte> listaKupljenihKarata(){
		List<KupovinaKarte> kupovinaL=service.listaKupovine();
		return kupovinaL;
	}
}
