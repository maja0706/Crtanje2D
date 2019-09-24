package oblici;

import java.awt.Color;
import java.awt.Graphics;

public class Pravougaonik extends Kvadrat{
	private int visina;
	
	public Pravougaonik() {
		
	}

	public Pravougaonik(Tacka goreLevo, int visina, int sirina) {
		this.goreLevo = goreLevo;
		this.visina = visina;
		setSirina(sirina);
	}

	public Pravougaonik(Tacka goreLevo, int visina, int sirina, Color boja) {
		this(goreLevo, visina, sirina);
		setBoja(boja);
	}
	
	public Pravougaonik(Tacka goreLevo, int visina, int sirina, Color boja, Color bojaUnutrasnjosti) {
		this(goreLevo, visina, sirina);
		setBoja(boja);
		this.setBojaUnutrasnjosti(bojaUnutrasnjosti);
	}

	public int getVisina() {
		return visina;
	}
	
	public void setVisina(int novaVisina) {
		visina = novaVisina;
	}
	
	public double obim() {
		double obim = 2*visina + 2*getSirina();
		return obim;
	}
	
	public double povrsina() {
		return visina*getSirina();
	}
	
	public String toString() {
		return "Tacka goreLevo=" + goreLevo
		+", sirina="+getSirina()+", visina="+visina;
	}
	
	public Linija dijagonala() {
		Tacka goreDesno = new Tacka(goreLevo.getX() + getSirina(),
									goreLevo.getY());
		Tacka doleLevo = new Tacka(goreLevo.getX(),
									goreLevo.getY() + visina);
		Linija dijagonala = new Linija(goreDesno, doleLevo);
		return dijagonala;
	}
	
	public void crtajSe(Graphics g) {
		popuni(g);
		g.setColor((this.getBoja()));
		g.drawRect(this.goreLevo.getX(), 
					this.goreLevo.getY(), 
					getSirina(), visina);
		
		if(this.isSelektovan()) {
			this.selektovan(g);
		}
	}
	
	public void popuni(Graphics g) {
		g.setColor((this.getBojaUnutrasnjosti()));
		g.fillRect(this.goreLevo.getX(), 
					this.goreLevo.getY(), 
					getSirina(), visina);
	}
	
	public void selektovan(Graphics g) {
		this.goreLevo.selektovan(g);
		this.dijagonala().getPocetna().selektovan(g);
		this.dijagonala().getKrajnja().selektovan(g);
		
		Tacka doleDesno = new Tacka(goreLevo.getX() + getSirina(), 
									goreLevo.getY() + visina);
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
	
	public boolean sadrzi(int x, int y) {
		if(this.getGoreLevo().getX()<=x 
				&& x<=(this.getGoreLevo().getX() + getSirina())
				&& this.getGoreLevo().getY()<=y 
				&& y<=(this.getGoreLevo().getY() + visina))
			return true;
		else 
			return false;
	}

	
}
