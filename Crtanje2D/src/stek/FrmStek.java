package stek;

import java.awt.BorderLayout;
import java.awt.Color;
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
import java.awt.Point;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.ListModel;

import java.awt.event.ActionListener;
import java.util.Arrays;
import java.awt.event.ActionEvent;

public class FrmStek extends JFrame {

	private JPanel contentPane;
	DefaultListModel<Kvadrat> dlm = new DefaultListModel<Kvadrat>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmStek frame = new FrmStek();
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
	public FrmStek() {
		setTitle("Maja Jovanovi\u0107 IM189-2016");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 775, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);

		JScrollPane scrollPaneKvadrati = new JScrollPane();
		GridBagConstraints gbc_scrollPaneKvadrati = new GridBagConstraints();
		gbc_scrollPaneKvadrati.fill = GridBagConstraints.BOTH;
		gbc_scrollPaneKvadrati.gridheight = 3;
		gbc_scrollPaneKvadrati.gridx = 1;
		gbc_scrollPaneKvadrati.gridy = 0;
		contentPane.add(scrollPaneKvadrati, gbc_scrollPaneKvadrati);
		
		JList listKvadrati = new JList();
		scrollPaneKvadrati.setViewportView(listKvadrati);
		listKvadrati.setModel(dlm);

		JButton btnDodaj = new JButton("Dodaj");
		btnDodaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DlgKvadrat dlgKvadrat=new DlgKvadrat(new Kvadrat(new Tacka(),0,Color.BLACK, Color.WHITE));
				dlgKvadrat.setVisible(true);
				dlm.add(0, dlgKvadrat.getKvadrat());

			}
		});
		GridBagConstraints gbc_btnDodaj = new GridBagConstraints();
		gbc_btnDodaj.insets = new Insets(0, 0, 5, 5);
		gbc_btnDodaj.gridx = 0;
		gbc_btnDodaj.gridy = 1;
		contentPane.add(btnDodaj, gbc_btnDodaj);

		JButton btnIzuzmi = new JButton("Izuzmi");
		btnIzuzmi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(dlm.size() != 0) {
					DlgKvadrat dlgKvadrat=new DlgKvadrat(dlm.get(0)); 
					dlgKvadrat.txtX.setEditable(false);
					dlgKvadrat.txtY.setEditable(false);
					dlgKvadrat.txtStranica.setEditable(false);
					dlgKvadrat.setVisible(true);
					if(dlgKvadrat.potvrdio) {
						dlm.removeElementAt(0);
					}
				}
				else
					JOptionPane.showMessageDialog(null,"Stek je prazan!", "Upozorenje", JOptionPane.WARNING_MESSAGE);

			}
		});
		GridBagConstraints gbc_btnIzuzmi = new GridBagConstraints();
		gbc_btnIzuzmi.insets = new Insets(0, 0, 0, 5);
		gbc_btnIzuzmi.gridx = 0;
		gbc_btnIzuzmi.gridy = 2;
		contentPane.add(btnIzuzmi, gbc_btnIzuzmi);

	}

}
