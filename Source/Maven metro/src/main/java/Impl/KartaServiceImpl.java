package Impl;

import java.sql.Date;
import java.util.List;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import Model.Karta;
import Services.KartaService;

@Remote(KartaService.class)
@Stateless
public class KartaServiceImpl implements KartaService {

	public KartaServiceImpl()
	{
		   EntityManagerFactory emf = Persistence
	               .createEntityManagerFactory("MetroStanica");
	       em = emf.createEntityManager();
	}
	private EntityManager em;
	
	public void novaKarta(int idKarte, Date vazenje, int cena, Date vreme, String validna, String tip) {
		Karta kartica= new Karta(idKarte, vazenje, cena, vreme, validna, tip);
		em.getTransaction().begin();
		em.persist(kartica);
		em.getTransaction().commit();
	}

	public void obrisiKartu(int id) {
		Karta karta=em.find(Karta.class, id);
		em.getTransaction().begin();
		em.remove(karta);
		em.getTransaction().commit();
	}

	public Karta vratiKartu(int id) {
		Karta karta=em.find(Karta.class, id);
		return karta;
	}

	public void postaviTipMesecne(int idKarte, int idtipa) {
		Karta karta=em.find(Karta.class, idKarte);
		em.getTransaction().begin();
		karta.setIdTipMesecne(idtipa);
		em.getTransaction().commit();
	}

	public void izmeniValidnost(int id, String validnost) {
		Karta karta=em.find(Karta.class, id);
		em.getTransaction().begin();
		karta.setValidnostKarte(validnost);
		em.getTransaction().commit();
	}

	public List<Karta> listaKarti() {
		TypedQuery<Karta> query=em.createQuery("SELECT k FROM Karta k", Karta.class);
		List<Karta> svekarte=query.getResultList();
		return svekarte;
	}

}
