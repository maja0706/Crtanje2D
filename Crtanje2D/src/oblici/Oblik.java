package oblici;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Oblik implements Pomerljiv, Comparable {
	private Color boja;
	private boolean selektovan;
	
	public boolean isSelektovan() {
		return selektovan;
	}
	
	public void setSelektovan(boolean selektovan) {
		this.selektovan = selektovan;
	}
	
	public Oblik() {
		
	}
	
	public Oblik(Color boja) {
		this.boja = boja;
	}

	public Color getBoja() {
		return boja;
	}

	public void setBoja(Color boja) {
		this.boja = boja;
	}
	
	public static Color pronadjiBoju(String boja) {
		switch(boja) {
		case "zuta":
			return Color.YELLOW;
		case "zelena":
			return Color.GREEN;
		case "plava":
			return Color.BLUE;
		case "crvena":
			return Color.RED;
		case "bela":
			return Color.WHITE;
		default:
			return Color.BLACK;
		}
	}
	
	public abstract void crtajSe(Graphics g);
	
	public abstract void selektovan(Graphics g);
	
	public abstract boolean sadrzi(int x, int y);

}
