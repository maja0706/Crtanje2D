package crtanje;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import oblici.Krug;
import oblici.Kvadrat;
import oblici.Linija;
import oblici.Pravougaonik;
import oblici.Tacka;

import javax.swing.JToggleButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JColorChooser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.ButtonGroup;
import java.awt.FlowLayout;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

public class FrmCrtez extends JFrame {

	private JPanel contentPane;
	private PnlCrtez pnlCrtez = new PnlCrtez();
	private final ButtonGroup buttonGroup = new ButtonGroup();
	public JToggleButton tglbtnTacka=new JToggleButton("Ta\u010Dka");
	public JTextArea txtAktivnaBojaUnutrasnjosti;
	public JTextArea txtAktivnaBojaIvice;
	public JToggleButton tglbtnLinija = new JToggleButton("Linija");
	public JToggleButton tglbtnKrug = new JToggleButton("Krug");
	public JToggleButton tglbtnKvadrat;
	public JToggleButton tglbtnPravougaonik = new JToggleButton("Pravougaonik");
	public JToggleButton tglbtnSelekcija;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmCrtez frame = new FrmCrtez();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmCrtez() {

		setTitle("Maja Jovanovi\u0107 IM189-2016");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1030, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		pnlCrtez.setBackground(Color.WHITE);
		pnlCrtez.setFrmCrtez(this);

		JPanel pnlSever = new JPanel();
		contentPane.add(pnlSever, BorderLayout.NORTH);

		JButton btnBojaUnutrasnjosti = new JButton("Boja unutra\u0161njosti");
		btnBojaUnutrasnjosti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JColorChooser jCC=new JColorChooser();
				Color c=jCC.showDialog(btnBojaUnutrasnjosti, "Izaberite boju...", Color.WHITE);
				if(c!=null) {
					txtAktivnaBojaUnutrasnjosti.setBackground(c);
				}
			}
		});

		buttonGroup.add(tglbtnTacka);
		tglbtnTacka.setHorizontalAlignment(SwingConstants.LEFT);
		tglbtnTacka.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnBojaUnutrasnjosti.setEnabled(false);
			}
		});
		pnlSever.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		pnlSever.add(tglbtnTacka);


		buttonGroup.add(tglbtnLinija);
		tglbtnLinija.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnBojaUnutrasnjosti.setEnabled(false);
			}
		});
		pnlSever.add(tglbtnLinija);


		buttonGroup.add(tglbtnKrug);
		tglbtnKrug.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnBojaUnutrasnjosti.setEnabled(true);
			}
		});
		pnlSever.add(tglbtnKrug);

		tglbtnKvadrat = new JToggleButton("Kvadrat");
		buttonGroup.add(tglbtnKvadrat);
		tglbtnKvadrat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnBojaUnutrasnjosti.setEnabled(true);
			}
		});
		pnlSever.add(tglbtnKvadrat);


		buttonGroup.add(tglbtnPravougaonik);
		tglbtnPravougaonik.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnBojaUnutrasnjosti.setEnabled(true);
			}
		});
		pnlSever.add(tglbtnPravougaonik);

		tglbtnSelekcija = new JToggleButton("Selekcija");
		buttonGroup.add(tglbtnSelekcija);
		tglbtnSelekcija.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		JSeparator separator = new JSeparator();
		pnlSever.add(separator);
		pnlSever.add(tglbtnSelekcija);

		JButton btnModifikacija = new JButton("Modifikacija");
		btnModifikacija.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(pnlCrtez.getSelektovanOblik() instanceof Tacka) {
					DlgTacka dlgTacka=new DlgTacka((Tacka)pnlCrtez.getSelektovanOblik());
					dlgTacka.setVisible(true);
				}
				else if(pnlCrtez.getSelektovanOblik()instanceof Linija) {
					DlgLinija dlgLinija=new DlgLinija((Linija)pnlCrtez.getSelektovanOblik());
					dlgLinija.setVisible(true);
				}
				else if(pnlCrtez.getSelektovanOblik()instanceof Krug) {
					DlgKrug dlgKrug=new DlgKrug((Krug)pnlCrtez.getSelektovanOblik());
					dlgKrug.setVisible(true);
				}
				else if(pnlCrtez.getSelektovanOblik()instanceof Pravougaonik) {
					DlgPravougaonik dlgPravougaonik=new DlgPravougaonik((Pravougaonik)pnlCrtez.getSelektovanOblik());
					dlgPravougaonik.setVisible(true);
				}
				else if(pnlCrtez.getSelektovanOblik()instanceof Kvadrat) {
					DlgKvadrat dlgKvadrat=new DlgKvadrat((Kvadrat)pnlCrtez.getSelektovanOblik());
					dlgKvadrat.setVisible(true);
				}
				pnlCrtez.repaint();
			}
		});
		pnlSever.add(btnModifikacija);

		JButton btnBrisanje = new JButton("Brisanje");
		btnBrisanje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(pnlCrtez.getSelektovanOblik()!=null) {
					DlgDaNe dlgDaNe=new DlgDaNe();
					dlgDaNe.setVisible(true);
					if(dlgDaNe.brisi) {
						pnlCrtez.getOblici().remove(pnlCrtez.getSelektovanOblik());
						pnlCrtez.repaint();
					}

				}
			}
		});
		pnlSever.add(btnBrisanje);

		JPanel pnlZapad = new JPanel();
		contentPane.add(pnlZapad, BorderLayout.WEST);
		GridBagLayout gbl_pnlZapad = new GridBagLayout();
		gbl_pnlZapad.columnWidths = new int[]{119, 0};
		gbl_pnlZapad.rowHeights = new int[]{23, 0, 0, 0, 0, 0, 0};
		gbl_pnlZapad.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_pnlZapad.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		pnlZapad.setLayout(gbl_pnlZapad);
		GridBagConstraints gbc_btnBojaIvice = new GridBagConstraints();
		gbc_btnBojaIvice.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnBojaIvice.insets = new Insets(0, 0, 5, 0);
		gbc_btnBojaIvice.anchor = GridBagConstraints.NORTH;
		gbc_btnBojaIvice.gridx = 0;
		gbc_btnBojaIvice.gridy = 4;

		txtAktivnaBojaUnutrasnjosti = new JTextArea();
		txtAktivnaBojaUnutrasnjosti.setEditable(false);
		GridBagConstraints gbc_txtAktivnaBojaUnutrasnjosti = new GridBagConstraints();
		gbc_txtAktivnaBojaUnutrasnjosti.anchor = GridBagConstraints.SOUTH;
		gbc_txtAktivnaBojaUnutrasnjosti.insets = new Insets(0, 0, 5, 0);
		gbc_txtAktivnaBojaUnutrasnjosti.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtAktivnaBojaUnutrasnjosti.gridx = 0;
		gbc_txtAktivnaBojaUnutrasnjosti.gridy = 3;
		pnlZapad.add(txtAktivnaBojaUnutrasnjosti, gbc_txtAktivnaBojaUnutrasnjosti);

		txtAktivnaBojaIvice = new JTextArea();
		txtAktivnaBojaIvice.setBackground(Color.BLACK);
		txtAktivnaBojaIvice.setEditable(false);
		GridBagConstraints gbc_txtAktivnaBojaIvice = new GridBagConstraints();
		gbc_txtAktivnaBojaIvice.fill = GridBagConstraints.BOTH;
		gbc_txtAktivnaBojaIvice.gridx = 0;
		gbc_txtAktivnaBojaIvice.gridy = 5;
		pnlZapad.add(txtAktivnaBojaIvice, gbc_txtAktivnaBojaIvice);


		GridBagConstraints gbc_btnBojaUnutrasnjosti = new GridBagConstraints();
		gbc_btnBojaUnutrasnjosti.fill = GridBagConstraints.VERTICAL;
		gbc_btnBojaUnutrasnjosti.insets = new Insets(0, 0, 5, 0);
		gbc_btnBojaUnutrasnjosti.gridx = 0;
		gbc_btnBojaUnutrasnjosti.gridy = 2;
		pnlZapad.add(btnBojaUnutrasnjosti, gbc_btnBojaUnutrasnjosti);

		JButton btnBojaIvice = new JButton("Boja ivice");
		btnBojaIvice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JColorChooser jCC=new JColorChooser();
				Color c=jCC.showDialog(btnBojaIvice, "Izaberite boju...", Color.BLACK);
				if(c!=null) {
					txtAktivnaBojaIvice.setBackground(c);
				}
			}
		});




		pnlZapad.add(btnBojaIvice, gbc_btnBojaIvice);



		contentPane.add(pnlCrtez, BorderLayout.CENTER);
	}

}
