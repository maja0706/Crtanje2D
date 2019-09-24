package oblici;

import java.awt.Color;
import java.awt.Graphics;

public class Kvadrat extends PovrsinskiOblik{
	protected Tacka goreLevo;
	private int sirina;

	public Kvadrat() {

	}

	public Kvadrat(Tacka goreLevo, int stranica) {
		this.goreLevo = goreLevo;
		this.sirina = stranica;
	}

	public Kvadrat(Tacka goreLevo, int stranica, Color boja) {
		this(goreLevo, stranica);
		this.setBoja(boja);
	}

	public Kvadrat(Tacka goreLevo, int stranica, Color boja, Color bojaUnutrasnjosti) {
		this(goreLevo, stranica);
		this.setBoja(boja);
		this.setBojaUnutrasnjosti(bojaUnutrasnjosti);
	}


	public void setGoreLevo(Tacka novoGoreLevo) {
		goreLevo=novoGoreLevo;
	}
	public Tacka getGoreLevo() {
		return goreLevo;
	}
	public void setSirina(int novaStranica) {
		sirina=novaStranica;
	}
	public int getSirina() {
		return sirina;

	} 

	public void pomeriZa(int x,int y) {
		this.goreLevo.pomeriZa(x, y);
	}
	public void pomeriNa(int x,int y) {
		this.goreLevo.pomeriNa(x, y);
	}
	public double povrsina() {
		double povrsina= sirina*sirina;
		return povrsina;

	}
	public double obim() {
		double obim=sirina*4;
		return obim;
	}
	/*U klasi Kvadrat kreirati metodu 
	 * public Linija dijagonala() 
	 * koja vraca dijagonalu 
	 * od gore desno do dole levo 
	 * kvadrata.
	 */

	public Linija dijagonala() {
		Tacka goreDesno = new Tacka(goreLevo.getX() + sirina,
				goreLevo.getY());
		Tacka doleLevo = new Tacka(goreLevo.getX(),
				goreLevo.getY() + sirina);
		Linija dijagonala = new Linija(goreDesno, doleLevo);
		return dijagonala;
	}

	/*U klasi Kvadrat kreirati 
	 * metodu public Tacka centar() 
	 * koja vraca centralnu tacku kvadrata.
	 */

	public Tacka centar() {
		return dijagonala().sredinaLinije();
	}

	@Override
	public void crtajSe(Graphics g) {
		popuni(g);
		g.setColor((this.getBoja()));
		g.drawRect(this.goreLevo.getX(), 
				this.goreLevo.getY(), 
				sirina, sirina);

		if (this.isSelektovan()) {
			this.selektovan(g);
		}

	}

	@Override
	public int compareTo(Object o) {
		if (o instanceof Kvadrat) {
			Kvadrat prosledjen = (Kvadrat)o;
			return this.sirina - prosledjen.sirina;
		} else {
			return 0;
		}
	}

	@Override
	public void popuni(Graphics g) {
		g.setColor((this.getBojaUnutrasnjosti()));
		g.fillRect(this.goreLevo.getX(), 
				this.goreLevo.getY(), 
				sirina, sirina);
	}

	@Override
	public void selektovan(Graphics g) {
		this.goreLevo.selektovan(g);
		this.dijagonala().getPocetna().selektovan(g);
		this.dijagonala().getKrajnja().selektovan(g);

		Tacka doleDesno = new Tacka(goreLevo.getX() + sirina, 
				goreLevo.getY() + sirina);
		doleDesno.selektovan(g);

		Linija gore = new Linija(goreLevo,
				dijagonala().getPocetna());
		gore.sredinaLinije().selektovan(g);

		Linija dole = new Linija(dijagonala().getKrajnja(),
				doleDesno);
		dole.sredinaLinije().selektovan(g);

		Linija levo = new Linija(goreLevo,
				dijagonala().getKrajnja());
		levo.sredinaLinije().selektovan(g);

		Linija desno = new Linija(dijagonala().getPocetna(),
				doleDesno);
		desno.sredinaLinije().selektovan(g);
	}

	@Override
	public boolean sadrzi(int x, int y) {
		if(this.getGoreLevo().getX()<=x 
				&& x<=(this.getGoreLevo().getX() + sirina)
				&& this.getGoreLevo().getY()<=y 
				&& y<=(this.getGoreLevo().getY() + sirina))
			return true;
		else 
			return false;
	}



	public String toString() {
		return "Tacka gore levo=" + goreLevo + ", stranica = " + sirina+", boja unutrasnjosti: "+getBojaUnutrasnjosti()+", boja ivice: "+getBoja();
	}

}
