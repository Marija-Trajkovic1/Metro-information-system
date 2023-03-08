package Impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import Model.Osoba;
import Services.OsobaService;
import java.sql.Date;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;

@Remote(OsobaService.class)
@Stateless
public class OsobaServiceImpl implements OsobaService {
	
	public OsobaServiceImpl()
	{
		   EntityManagerFactory emf = Persistence
	               .createEntityManagerFactory("MetroStanica");
	       em = emf.createEntityManager();
	}
	private EntityManager em;
	
	public void obrisiOsobu(int idOSobe) {
		Osoba osobica=em.find(Osoba.class, idOSobe);
		em.getTransaction().begin();
		em.remove(osobica);
		em.getTransaction().commit();
	}

	public Osoba vratiOsobu(int idOsobe) {
		Osoba osobica=em.find(Osoba.class, idOsobe);
		return osobica;

	}
	
	public void oceniUslugu(int idOsobe, int ocena) {
		Osoba osobica=em.find(Osoba.class, idOsobe);
		em.getTransaction().begin();
		osobica.setOcenaUsluge(ocena);
		em.getTransaction().commit();
	}

	public int vratiOcenu(int idOsobe) {
		Osoba osobica=em.find(Osoba.class, idOsobe);
		return osobica.getOcenaUsluge();
	}

	public int vratiStanjeNaKartici(int idOsobe) {
		Osoba kupovina=em.find(Osoba.class, idOsobe);
		return kupovina.getStanjeNaKartici();
	}

	public boolean izvrsiUplatu(int idOsobe, int suma) {
		
		Osoba kupovina=em.find(Osoba.class, idOsobe);
		int novaVrRacuna=kupovina.getStanjeNaKartici();
		if(novaVrRacuna<suma)
		{
			System.out.println("Nema dovoljno racuna na novcu!");
			return false;
		}
		else {
			novaVrRacuna=novaVrRacuna-suma;
			em.getTransaction().begin();
			kupovina.setStanjeNaKartici(novaVrRacuna);
			em.getTransaction().commit();
			return true;
		}	
	}

	public void novaOsoba(String ime, String prezime, String jmbg, int brlk, Date datum, int ocenaUsluge, int stanje) {
		Osoba osobica= new Osoba(ime, prezime, jmbg, brlk, datum, ocenaUsluge, stanje);
		em.getTransaction().begin();
		em.persist(osobica);
		em.getTransaction().commit();
	}

	@Override
	public List<Osoba> listaOsoba() {
		TypedQuery<Osoba> query=em.createQuery("SELECT o FROM Osoba o", Osoba.class);
		List<Osoba> sveOsobe=query.getResultList();
		return sveOsobe;
	}
	
	

}
