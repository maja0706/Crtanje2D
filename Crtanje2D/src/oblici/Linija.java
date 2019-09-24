package oblici;

import java.awt.Color;
import java.awt.Graphics;

public class Linija extends Oblik{
	private Tacka pocetna;
	private Tacka krajnja;
	
	public Linija() {

	}

	public Linija(Tacka pocetna, Tacka krajnja) {
		this.pocetna = pocetna;
		this.krajnja = krajnja;
	}

	public Linija(Tacka pocetna, Tacka krajnja, Color boja) {
		super(boja);
		this.pocetna = pocetna;
		this.krajnja = krajnja;
	
	}

	public void setPocetna(Tacka novaPocetna) {
		pocetna = novaPocetna;
	}
	
	public Tacka getPocetna() {
		return pocetna;
	}
	
	public void setKrajnja(Tacka novaKrajnja) {
		krajnja = novaKrajnja;
	}
	
	public Tacka getKrajnja() {
		return krajnja;
	}
	
	public void pomeriNa(int novoX, int novoY) {
		int rx = novoX - pocetna.getX();
		int ry = novoY - pocetna.getY();
		pocetna.pomeriNa(novoX, novoY);
		krajnja.pomeriZa(rx, ry);
	}
	
	public void pomeriZa(int novoX, int novoY) {
		pocetna.pomeriZa(novoX, novoY);
		krajnja.pomeriZa(novoX, novoY);
	}
	
	public double duzina() {
		return pocetna.udaljenost(krajnja);
	}
	public String toString() {
		return pocetna.toString() + "->" + krajnja;
	}
	
	/*U klasi Linija kreirati metodu 
	 * public Tacka sredinaLinije() 
	 * koja vraca središnu tacku linije.
	 */
	
	public Tacka sredinaLinije() {
		int xs = (pocetna.getX() + krajnja.getX())/2;
		int ys = (pocetna.getY() + krajnja.getY())/2;
		Tacka sredina = new Tacka(xs,ys);
		return sredina;
	}

	@Override
	public void crtajSe(Graphics g) {
		g.setColor((this.getBoja()));
		g.drawLine(this.pocetna.getX(), 
					this.pocetna.getY(), 
					this.krajnja.getX(), 
					this.krajnja.getY());
		
		if (this.isSelektovan()) {
			this.selektovan(g);
		}
	}

	@Override
	public int compareTo(Object o) {
		if (o instanceof Linija) {
			Linija prosledjena = (Linija)o;
			return (int) (this.duzina() - prosledjena.duzina());
		} else {
			return 0;
		}
		
		
		
	}

	@Override
	public void selektovan(Graphics g) {
		pocetna.selektovan(g);
		this.sredinaLinije().selektovan(g);
		krajnja.selektovan(g);
		
	}

	@Override
	public boolean sadrzi(int x, int y) {
		Tacka kliknuto = new Tacka(x, y);
		double udaljenostPocetna = this.getPocetna().udaljenost(kliknuto);
		double udaljenostKrajnja = this.getKrajnja().udaljenost(kliknuto);
		
		double udaljenost = udaljenostPocetna + udaljenostKrajnja;
		
		if ((udaljenost - this.duzina())<=0.05) {
			return true;
		} else {
			return false;
		}
	}
	
}
