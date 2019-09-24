package oblici;

import java.awt.Color;
import java.awt.Graphics;

public class Krug extends PovrsinskiOblik{
	private Tacka centar;
	private int poluprecnik;
	
	public Krug() {
		
	}
	
	public Krug(Tacka centar, int poluprecnik) {
		this.centar = centar;
		this.poluprecnik = poluprecnik;
	}

	public Krug(Tacka centar, int poluprecnik, Color boja) {
		this(centar, poluprecnik);
		this.setBoja(boja);
	}
	
	public Krug(Tacka centar, int poluprecnik, Color boja, Color bojaUnutrasnjosti) {
		this(centar, poluprecnik);
		this.setBoja(boja);
		this.setBojaUnutrasnjosti(bojaUnutrasnjosti);
	}

	public Tacka getCentar() {
		return centar;
	}
	public void setCentar(Tacka centar) {
		this.centar = centar;
	}
	public int getPoluprecnik() {
		return poluprecnik;
	}
	public void setPoluprecnik(int poluprecnik) {
		this.poluprecnik = poluprecnik;
	}

	public double obim() {
		double obim = 2*poluprecnik*Math.PI;
				return obim;
	}
	public double povrsina() {
		double povrsina = poluprecnik*poluprecnik*Math.PI;
		return povrsina;
	}
	
	public void pomeriNa(int novoX, int novoY) {
		centar.pomeriNa(novoX, novoY);
	}
	
	public void pomeriZa(int novoX, int novoY) {
		centar.pomeriZa(novoX, novoY);
	}

	@Override
	public void crtajSe(Graphics g) {
		popuni(g);
		g.setColor((this.getBoja()));
		
		g.drawOval(centar.getX()-poluprecnik, 
					centar.getY()-poluprecnik, 
					2*poluprecnik, 
					2*poluprecnik);
		
		if(this.isSelektovan()) {
			this.selektovan(g);
		}
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void popuni(Graphics g) {
		g.setColor((this.getBojaUnutrasnjosti()));
		g.fillOval(centar.getX()-poluprecnik, 
					centar.getY()-poluprecnik, 
					2*poluprecnik, 
					2*poluprecnik);
		
	}

	@Override
	public void selektovan(Graphics g) {
		centar.selektovan(g);
		
		Tacka gore = new Tacka(centar.getX(), 
								centar.getY()-poluprecnik);
		Tacka dole = new Tacka(centar.getX(),
								centar.getY()+poluprecnik);
		Tacka levo = new Tacka(centar.getX()-poluprecnik,
								centar.getY());
		Tacka desno = new Tacka(centar.getX()+poluprecnik,
								centar.getY());
		
		gore.selektovan(g);
		dole.selektovan(g);
		levo.selektovan(g);
		desno.selektovan(g);
		
	}

	@Override
	public boolean sadrzi(int x, int y) {
		if(new Tacka(x, y).udaljenost(getCentar()) <= poluprecnik)
			return true;
		else
		return false;
	}

}
