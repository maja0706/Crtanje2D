package crtanje;

import javax.swing.JPanel;

import oblici.Krug;
import oblici.Kvadrat;
import oblici.Linija;
import oblici.Oblik;
import oblici.Pravougaonik;
import oblici.Tacka;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;

public class PnlCrtez extends JPanel {
	private FrmCrtez frmCrtez;
	private ArrayList<Oblik> oblici=new ArrayList<Oblik>();
	private Tacka pocetnaTackaLinije;
	private Oblik selektovanOblik;

	/**
	 * Create the panel.
	 */
	public PnlCrtez() {
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent mestoKlika) {
				if(frmCrtez.tglbtnTacka.isSelected()) {
					Tacka t=new Tacka(mestoKlika.getX(), mestoKlika.getY(), frmCrtez.txtAktivnaBojaIvice.getBackground());
					oblici.add(t);
					repaint();
				}
				else if(frmCrtez.tglbtnLinija.isSelected()) {
					if(pocetnaTackaLinije==null) {
						pocetnaTackaLinije=new Tacka(mestoKlika.getX(),mestoKlika.getY());
					}
					else {
						Tacka krajnjaTackaLinije=new Tacka(mestoKlika.getX(),mestoKlika.getY());
						Linija l=new Linija(pocetnaTackaLinije,krajnjaTackaLinije,frmCrtez.txtAktivnaBojaIvice.getBackground());
						oblici.add(l);
						pocetnaTackaLinije=null;
					}

				}
				else if(frmCrtez.tglbtnKrug.isSelected()) {
					DlgKrug dlgKrug=new DlgKrug(null);
					dlgKrug.txtX.setText(mestoKlika.getX()+"");
					dlgKrug.txtY.setText(mestoKlika.getY()+"");
					dlgKrug.txtX.setEditable(false);
					dlgKrug.txtY.setEditable(false);
					dlgKrug.txtBojaUnutrasnjosti.setBackground(frmCrtez.txtAktivnaBojaUnutrasnjosti.getBackground());
					dlgKrug.txtBojaIvice.setBackground(frmCrtez.txtAktivnaBojaIvice.getBackground());
					dlgKrug.setVisible(true);
					if(dlgKrug.potvrdio) {
						Krug k=new Krug(new Tacka(mestoKlika.getX(),mestoKlika.getY()),dlgKrug.radijus,frmCrtez.txtAktivnaBojaIvice.getBackground(),frmCrtez.txtAktivnaBojaUnutrasnjosti.getBackground());
						oblici.add(k);
					}
				}

				else if(frmCrtez.tglbtnKvadrat.isSelected()) {
					DlgKvadrat dlgKvadrat=new DlgKvadrat(null);
					dlgKvadrat.txtX.setText(mestoKlika.getX()+"");
					dlgKvadrat.txtY.setText(mestoKlika.getY()+"");
					dlgKvadrat.txtX.setEditable(false);
					dlgKvadrat.txtY.setEditable(false);
					dlgKvadrat.txtBojaUnutrasnjosti.setBackground(frmCrtez.txtAktivnaBojaUnutrasnjosti.getBackground());
					dlgKvadrat.txtBojaIvice.setBackground(frmCrtez.txtAktivnaBojaIvice.getBackground());
					dlgKvadrat.setVisible(true);
					if(dlgKvadrat.potvrdio) {
						Kvadrat kv=new Kvadrat(new Tacka(mestoKlika.getX(),mestoKlika.getY()),dlgKvadrat.stranica, frmCrtez.txtAktivnaBojaIvice.getBackground(), frmCrtez.txtAktivnaBojaUnutrasnjosti.getBackground());
						oblici.add(kv);
					}
				}
				else if(frmCrtez.tglbtnPravougaonik.isSelected()) {
					DlgPravougaonik dlgPravougaonik=new DlgPravougaonik(null);
					dlgPravougaonik.txtX.setText(mestoKlika.getX()+"");
					dlgPravougaonik.txtY.setText(mestoKlika.getY()+"");
					dlgPravougaonik.txtX.setEditable(false);
					dlgPravougaonik.txtY.setEditable(false);
					dlgPravougaonik.txtBojaIvice.setBackground(frmCrtez.txtAktivnaBojaIvice.getBackground());
					dlgPravougaonik.txtBojaUnutrasnjosti.setBackground(frmCrtez.txtAktivnaBojaUnutrasnjosti.getBackground());
					dlgPravougaonik.setVisible(true);
					if(dlgPravougaonik.potvrdio) {
						Pravougaonik p=new Pravougaonik(new Tacka(mestoKlika.getX(), mestoKlika.getY()), dlgPravougaonik.visina,dlgPravougaonik.sirina, frmCrtez.txtAktivnaBojaIvice.getBackground(), frmCrtez.txtAktivnaBojaUnutrasnjosti.getBackground());
						oblici.add(p);
					}
				}
				else if(frmCrtez.tglbtnSelekcija.isSelected()) {
					Iterator<Oblik> it = oblici.iterator();

					if(selektovanOblik!=null) {
						selektovanOblik.setSelektovan(false);
						selektovanOblik=null;
					}
					while (it.hasNext()) {
						Oblik pomocna=it.next();
						pomocna.setSelektovan(false);

						if(pomocna.sadrzi(mestoKlika.getX(), mestoKlika.getY())) {
							selektovanOblik = pomocna;

						}
					}
					if(selektovanOblik!=null) {
						selektovanOblik.setSelektovan(true);
					}
				}
				repaint();
			}
		});

	}
	
	
	public void paint(Graphics g) {
		super.paint(g);
		Iterator<Oblik> it = oblici.iterator();
		while (it.hasNext()) {
			it.next().crtajSe(g);
		}
	}
	
	

	public FrmCrtez getFrmCrtez() {
		return frmCrtez;
	}

	public void setFrmCrtez(FrmCrtez frmCrtez) {
		this.frmCrtez = frmCrtez;
	}

	public Oblik getSelektovanOblik() {
		return selektovanOblik;
	}

	public void setSelektovanOblik(Oblik selektovanOblik) {
		this.selektovanOblik = selektovanOblik;
	}

	public ArrayList<Oblik> getOblici() {
		return oblici;
	}

	public void setOblici(ArrayList<Oblik> oblici) {
		this.oblici = oblici;
	}

}
