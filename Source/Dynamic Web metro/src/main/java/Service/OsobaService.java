package Service;

import java.util.List;
import Model.Osoba;

public interface OsobaService {
	public void setOsoba(int id, String ime, String prezime, String jmbg, int brlk, String datum, int stanje);
	public void obrisiOsobu(int idOSobe);
	public Osoba getOsoba(int idOsobe);
	public int vratiStanjeNaKartici(int idOsobe);
	public boolean izvrsiUplatu(int idOsobe, int suma);
	public void oceniUslugu(int idOsobe, int ocena);
	public int vratiOcenu(int idOsobe);
	public List<Osoba> Osobe();
}
