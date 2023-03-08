package Impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import Model.TipMesecne;
import Services.TipMesecneService;
import javax.ejb.Remote;
import javax.ejb.Stateless;

@Remote(TipMesecneService.class)
@Stateless
public class TipMesecneServiceImpl implements TipMesecneService {
	
	public TipMesecneServiceImpl()
	{
		   EntityManagerFactory emf = Persistence
	               .createEntityManagerFactory("MetroStanica");
	       em = emf.createEntityManager();
	}
	private EntityManager em;
	
	public int vratiVisinuPopusta(int idTipa) {
		TipMesecne tip=em.find(TipMesecne.class, idTipa);
		return tip.getVisinaPopusta();
	}
	
	public String vratiNazivPopusta(int idTipa) {
		TipMesecne tip=em.find(TipMesecne.class, idTipa);
		return tip.getNazivTipa();
	}

	public List<TipMesecne> listaTipova() {
		TypedQuery<TipMesecne> query=em.createQuery("SELECT t FROM TipMesecne t", TipMesecne.class);
		List<TipMesecne> tipoviMesecne=query.getResultList();
		return tipoviMesecne;
	}

	public void noviTip(int idtipMesecne, String naziv, int visina) {
		TipMesecne novi= new TipMesecne(idtipMesecne, naziv, visina);
		em.getTransaction().begin();
		em.persist(novi);
		em.getTransaction().commit();
		
		
	}

}
