package Services;

import java.util.List;

import Model.KupovinaKarte;

public interface KupovinaKarteService {
	public void novaKupovina(int idKupovine, int idKarte, int idOsobe);
	public void novaKupovinaKarticom(int idKupovine, int idKarte, int idOsobe, int suma);
	public void obrisiKupovinu(int idKupovine);
	public KupovinaKarte vratiKupovinu(int idKupovine);
	public KupovinaKarte vratiKartu(int idKupovine);	
	public KupovinaKarte vratiOsobu(int idOsobe);
	public List<KupovinaKarte>listaKupovine();
}
