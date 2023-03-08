package Impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import	javax.persistence.TypedQuery;
import Model.Osoba;
import Service.OsobaService;
import java.util.List;
import javax.ejb.Stateless;

@Stateless
public class OsobaServiceImpl implements OsobaService {
	
	@PersistenceContext(name = "MetroDynamicWeb")
	private EntityManager em;
	
	public void obrisiOsobu(int idOSobe) {
		Osoba osobica=em.find(Osoba.class, idOSobe);
		em.remove(osobica);
	}

	public Osoba getOsoba(int idOsobe) {
		Osoba osobica=em.find(Osoba.class, idOsobe);
		return osobica;
	}
	
	public void oceniUslugu(int idOsobe, int ocena) {
		Osoba osobica=em.find(Osoba.class, idOsobe);
		osobica.setOcenaUsluge(ocena);
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
			kupovina.setStanjeNaKartici(novaVrRacuna);
			return true;
		}	
	}

	public void setOsoba(int id, String ime, String prezime, String jmbg, int brlk, String datum, int stanje) {
		Osoba osobica= new Osoba(id, ime, prezime, jmbg, brlk, datum, stanje);
		em.persist(osobica);
	}

	@Override
	public List<Osoba> Osobe() {
		TypedQuery<Osoba> query = em.createQuery("SELECT o FROM Osoba o", Osoba.class);
        List<Osoba> osobe= query.getResultList();
        return osobe;
	}
	
	

}
