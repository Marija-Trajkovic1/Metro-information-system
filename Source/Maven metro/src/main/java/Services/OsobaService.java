package Services;
import java.sql.Date;
import java.util.List;

import Model.Osoba;

public interface OsobaService {
	public void novaOsoba(String ime, String prezime, String jmbg, int brlk, Date datum, int ocena, int stanje);
	public void obrisiOsobu(int idOSobe);
	public Osoba vratiOsobu(int idOsobe);
	public int vratiStanjeNaKartici(int idOsobe);
	public boolean izvrsiUplatu(int idOsobe, int suma);
	public void oceniUslugu(int idOsobe, int ocena);
	public int vratiOcenu(int idOsobe);
	public List<Osoba>listaOsoba();
}
