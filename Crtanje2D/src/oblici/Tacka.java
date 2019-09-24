package oblici;

import java.awt.Color;
import java.awt.Graphics;

public class Tacka extends Oblik{
	private int x;
	private int y;
	
	public Tacka() {
		
	}
	
	public Tacka(int x, int y) {
		this.x=x;
		this.y=y;
	}
	
	public Tacka(int x, int y, Color boja) {
		super(boja);		
		this.x=x;
		this.y=y;
	}
	
	public void setX(int novoX) {
		x = novoX;
	}
	
	public int getX() {
		return x;
	}
	
	public void setY(int novoY) {
		y = novoY;
	}
	
	public int getY() {
		return y;
	}
	
	
	public double udaljenost(Tacka druga) {
		int rx = x - druga.getX(); 
		int ry = y - druga.getY();
		double rezultat = Math.sqrt(rx*rx+ry*ry);
		return rezultat;
	}
	
	public String toString() {
		return "(" + x + "," + y + ")";
	}
	
	public boolean equals(Object obj) {
		if (obj instanceof Tacka) {
			Tacka prosledjena = (Tacka)obj;
			if(x==prosledjena.getX() &&
			   y==prosledjena.getY() &&
			   getBoja().equals(prosledjena.getBoja())) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	
	}

	@Override
	public void crtajSe(Graphics g) {
		g.setColor((this.getBoja()));
		g.drawLine(x-1, y-1, x+1, y+1);
		g.drawLine(x+1, y-1, x-1, y+1);
		
		if(this.isSelektovan()) {
			this.selektovan(g);
		}
	}

	public void pomeriNa(int novoX, int novoY) {
		x = novoX;
		y = novoY;
	}
	
	public void pomeriZa(int novoX, int novoY) {
		x = x + novoX;
		y = y + novoY;
	}

	@Override
	public int compareTo(Object o) {
		if (o instanceof Tacka) {
			Tacka prosledjena = (Tacka)o;
			return (int) (this.udaljenost(new Tacka(0,0))-
					prosledjena.udaljenost(new Tacka(0,0)));
		} else {
			return 0;
		}
	}

	@Override
	public void selektovan(Graphics g) {
		g.setColor(Color.BLUE);
		g.drawRect(x-3, y-3, 6, 6);
	}

	@Override
	public boolean sadrzi(int x, int y) {
		Tacka kliknuto = new Tacka(x, y);
		if (this.udaljenost(kliknuto)<=3) {
			return true;
		} else {
			return false;
		}
	}
	

}
