package Impl;

import java.sql.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import Model.Karta;
import Service.KartaService;

@Stateless
public class KartaServiceImpl implements KartaService {

	@PersistenceContext(name="MetroDynamicWeb")
	private EntityManager em;
	
	public void novaKarta(int idKarte, Date vazenje, int cena, Date vreme, String validna, String tip) {
		Karta kartica= new Karta(idKarte, vazenje, cena, vreme, validna, tip);
		em.persist(kartica);
	}

	public void obrisiKartu(int id) {
		Karta karta=em.find(Karta.class, id);
		em.remove(karta);
	}

	public Karta getKarta(int id) {
		Karta karta=em.find(Karta.class, id);
		return karta;
	}

	public void postaviTipMesecne(int idKarte, int idtipa) {
		Karta karta=em.find(Karta.class, idKarte);
		karta.setIdTipMesecne(idtipa);
	}

	public void izmeniValidnost(int id, String validnost) {
		Karta karta=em.find(Karta.class, id);
		karta.setValidnostKarte(validnost);
	}
	
	public List<Karta> listaKarti() {
		List<Karta> svekarte=em.createQuery("SELECT k FROM Karta k", Karta.class).getResultList();
		return svekarte;
		
	}

}
