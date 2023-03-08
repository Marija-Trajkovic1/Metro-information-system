package Service;

import java.io.IOException;
import java.util.List;

import Model.KupovinaKarte;

public interface KupovinaKarteService {
	public void setKupovina(int idKupovine, int idKarte, int idOsobe);
	public void novaKupovinaKarticom(int idKupovine, int idOsobe) throws IOException;
	public void obrisiKupovinu(int idKupovine);
	public KupovinaKarte getKupovinaKarte(int idKupovine);
	public int getIdKarte(int idKupovine);	
	public int getIdOsobe(int idKupovine);
	public List<KupovinaKarte> listaKupovine();
	public String generisiTipKarte() throws IOException;
}
