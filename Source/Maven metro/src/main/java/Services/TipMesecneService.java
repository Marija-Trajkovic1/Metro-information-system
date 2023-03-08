package Services;
import Model.TipMesecne;
import java.util.List;

public interface TipMesecneService {
	public void noviTip(int idtipMesecne, String naziv, int visina);
	public int vratiVisinuPopusta(int idTipa);
	public String vratiNazivPopusta(int idTipa);
	public List<TipMesecne>listaTipova();
}
