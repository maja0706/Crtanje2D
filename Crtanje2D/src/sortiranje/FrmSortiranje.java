package sortiranje;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import crtanje.DlgKvadrat;
import oblici.Kvadrat;
import oblici.Tacka;

import java.awt.GridBagLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.UIManager;

public class FrmSortiranje extends JFrame {

	private JPanel contentPane;
	DefaultListModel<Kvadrat>dlm=new DefaultListModel<Kvadrat>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmSortiranje frame = new FrmSortiranje();
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
	public FrmSortiranje() {
		setTitle("Maja Jovanovi\u0107 IM189-2016");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 674, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{44, 44, 44, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);

		JButton btnDodaj = new JButton("Dodaj");
		btnDodaj.setBackground(UIManager.getColor("Button.background"));
		btnDodaj.setForeground(Color.BLACK);
		btnDodaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DlgKvadrat dlgKvadrat=new DlgKvadrat(new Kvadrat(new Tacka(),0,Color.BLACK, Color.WHITE));
				dlgKvadrat.setVisible(true);
				dlm.add(0, dlgKvadrat.getKvadrat());

			}
		});
		GridBagConstraints gbc_btnDodaj = new GridBagConstraints();
		gbc_btnDodaj.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnDodaj.insets = new Insets(0, 0, 5, 5);
		gbc_btnDodaj.gridx = 0;
		gbc_btnDodaj.gridy = 0;
		contentPane.add(btnDodaj, gbc_btnDodaj);

		JScrollPane scrollPaneKvadrati = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 3;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 0;
		contentPane.add(scrollPaneKvadrati, gbc_scrollPane);

		JList listKvadrati = new JList();
		scrollPaneKvadrati.setViewportView(listKvadrati);
		listKvadrati.setModel(dlm);

		JButton btnIzuzmi = new JButton("Izuzmi");
		btnIzuzmi.setBackground(UIManager.getColor("Button.background"));
		btnIzuzmi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(dlm.size()!=0) {
					DlgKvadrat dlgKvadrat=new DlgKvadrat(dlm.get(0));
					dlgKvadrat.txtX.setEditable(false);
					dlgKvadrat.txtY.setEditable(false);
					dlgKvadrat.txtStranica.setEditable(false);
					dlgKvadrat.setVisible(true);
					if(dlgKvadrat.potvrdio) {
						dlm.removeElementAt(0);
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Lista je prazna!");
				}
			}
		});
		GridBagConstraints gbc_btnIzuzmi = new GridBagConstraints();
		gbc_btnIzuzmi.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnIzuzmi.insets = new Insets(0, 0, 5, 5);
		gbc_btnIzuzmi.gridx = 0;
		gbc_btnIzuzmi.gridy = 1;
		contentPane.add(btnIzuzmi, gbc_btnIzuzmi);

		JButton btnSortiraj = new JButton("Sortiraj");
		btnSortiraj.setBackground(UIManager.getColor("Button.background"));
		btnSortiraj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(dlm.size()!=0) {
					Object [] niz=dlm.toArray();
					Arrays.sort(niz);
					dlm.clear();
					for(int i=0;i<niz.length;i++) {
						dlm.addElement((Kvadrat)niz[i]);
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Lista je prazna!");
				}
			}
		});
		GridBagConstraints gbc_btnSortiraj = new GridBagConstraints();
		gbc_btnSortiraj.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnSortiraj.insets = new Insets(0, 0, 0, 5);
		gbc_btnSortiraj.gridx = 0;
		gbc_btnSortiraj.gridy = 2;
		contentPane.add(btnSortiraj, gbc_btnSortiraj);
	}

}
