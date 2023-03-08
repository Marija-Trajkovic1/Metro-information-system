
package Model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tipmesecne")
public class TipMesecne {
	
	@Id
	@Column(name="idtipMesecne")
	private int idtipMesecne;
	
	@Column(name="nazivTipa")
	private String nazivTipa;
	
	@Column(name="visinaPopusta")
	private int visinaPopusta;
	
	public TipMesecne() {
		
	}
	
	public TipMesecne(int idtipMesecne, String naziv, int visina) {
		this.setIdTipMesecne(idtipMesecne);
		this.setNazivTipa(naziv);
		this.setVisinaPopusta(visina);
	}
	
	public void setIdTipMesecne(int id) {
		this.idtipMesecne=id;
	}
	
	public void setNazivTipa(String naziv) {
		this.nazivTipa=naziv;
	}
	
	public void setVisinaPopusta(int visina) {
		this.visinaPopusta=visina;
	}
	
	public int getVisinaPopusta() {
		return this.visinaPopusta;
	}
	
	public int getIdTipMesecne() {
		return this.idtipMesecne;
	}
	
	public String getNazivTipa() {
		return this.nazivTipa;
	}
}
