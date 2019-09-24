package oblici;

import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Crtez extends JPanel{

	public static void main(String[] args) {
		JFrame prozor = new JFrame();
		Crtez c = new Crtez();
		prozor.getContentPane().add(c);
		prozor.setVisible(true);
		prozor.setSize(600, 400);
		prozor.setTitle("Vidi prozor...");
		prozor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	/*public void paint(Graphics g) {
		Tacka t1 = new Tacka(10,10, "crvena");
		Linija l1 = new Linija(new Tacka(20,20),
								new Tacka(30,30),
								"plava");
		Kvadrat k = new Kvadrat(new Tacka(40,40), 10, "zuta", "crvena");
		Pravougaonik p = new Pravougaonik(new Tacka(60,60),
											30, 20, "zelena", "zuta");
		Krug kr = new Krug(new Tacka(120,120), 10, "crna", "zuta");
		
		t1.setSelektovan(true);
		t1.crtajSe(g);
		l1.setSelektovan(true);
		l1.crtajSe(g);
		
		k.setSelektovan(true);
		k.popuni(g);
		k.crtajSe(g);
		
		p.setSelektovan(true);
		p.popuni(g);
		p.crtajSe(g);
		
		kr.setSelektovan(true);
		kr.popuni(g);
		kr.crtajSe(g);
	}*/

}
