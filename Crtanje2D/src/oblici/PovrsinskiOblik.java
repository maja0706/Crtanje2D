package oblici;

import java.awt.Color;
import java.awt.Graphics;

public abstract class PovrsinskiOblik extends Oblik{
	private Color bojaUnutrasnjosti;
	
	public Color getBojaUnutrasnjosti() {
		return bojaUnutrasnjosti;
	}
	
	public void setBojaUnutrasnjosti(Color bojaUnutrasnjosti) {
		this.bojaUnutrasnjosti = bojaUnutrasnjosti;
	}
	
	public abstract double povrsina();
	public abstract double obim();
	
	public abstract void popuni(Graphics g);
	

}
