package Impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import Model.TipMesecne;
import Service.TipMesecneService;
import javax.ejb.Stateless;

@Stateless
public class TipMesecneServiceImpl implements TipMesecneService {
	
	@PersistenceContext(name="MetroDynamicWeb")
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
		List<TipMesecne> listaT=em.createQuery("SELECT k from TipMesecne k", TipMesecne.class).getResultList();
		return listaT;
	}

	public void noviTip(int idtipMesecne, String naziv, int visina) {
		TipMesecne novi= new TipMesecne(idtipMesecne, naziv, visina);
		em.persist(novi);	
	}

}
