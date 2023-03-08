package Impl;

import java.util.List;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import Model.KupovinaKarte;
import Model.Osoba;
import Services.KupovinaKarteService;

@Remote(KupovinaKarteService.class)
@Stateless
public class KupovinaKarticeServiceImpl implements KupovinaKarteService {
	
	public KupovinaKarticeServiceImpl()
	{
		   EntityManagerFactory emf = Persistence
	               .createEntityManagerFactory("MetroStanica");
	       em = emf.createEntityManager();
	}
	private EntityManager em;
	
	@Override
	public void novaKupovina(int idKupovine, int idKarte, int idOsobe) {
		KupovinaKarte novakupovna=new KupovinaKarte(idKupovine, idKarte, idOsobe);
		em.getTransaction().begin();
		em.persist(novakupovna);
		em.getTransaction().commit();
	}	

	@Override
	public void obrisiKupovinu(int idKupovine) {
		KupovinaKarte kupovina=em.find(KupovinaKarte.class, idKupovine);
		em.getTransaction().begin();
		em.remove(kupovina);
		em.getTransaction().commit();
	}

	@Override
	public KupovinaKarte vratiKartu(int idKupovine) {
		KupovinaKarte kupac=em.find(KupovinaKarte.class, idKupovine);
		return kupac;
	}

	@Override
	public List<KupovinaKarte> listaKupovine() {
		TypedQuery<KupovinaKarte> query=em.createQuery("SELECT k FROM KupovinaKarte k", KupovinaKarte.class);
		List<KupovinaKarte> kupovine=query.getResultList();
		return kupovine;
	}

	@Override
	public void novaKupovinaKarticom(int idKupovine, int idKarte, int idOsobe, int suma) {
		Osoba kupac=em.find(Osoba.class, idOsobe);
		em.getTransaction().begin();
		kupac.platiKartu(suma);
		em.getTransaction().commit();
	}

	@Override
	public KupovinaKarte vratiOsobu(int idOsobe) {
		KupovinaKarte osoba=em.find(KupovinaKarte.class, idOsobe);
		return osoba;
	}

	@Override
	public KupovinaKarte vratiKupovinu(int idKupovine) {
		KupovinaKarte kupovina=em.find(KupovinaKarte.class, idKupovine);
		return kupovina;
	}

}
