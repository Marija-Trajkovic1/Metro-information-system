package Service;

import Model.Karta;
import java.sql.Date;
import java.util.List;

public interface KartaService {
	public void novaKarta(int idKarte, Date vazenje, int cena, Date vreme, String validna, String tip);
	public void obrisiKartu(int id);
	public Karta getKarta(int id);
	public void postaviTipMesecne(int idKarte, int idtipa);
	public void izmeniValidnost(int id, String validnost);
	public List<Karta> listaKarti();
}
