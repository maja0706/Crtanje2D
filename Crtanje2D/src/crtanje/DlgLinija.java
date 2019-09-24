package crtanje;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import oblici.Linija;
import oblici.Tacka;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgLinija extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtXPocetna;
	private JTextField txtYPocetna;
	private JTextField txtXKrajnja;
	private JTextField txtYKrajnja;
	private Linija linijaZaModifikaciju;
	private JTextArea txtBojaLinije;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the dialog.
	 */
	public DlgLinija(Linija linijaZaModifikaciju) {
		setTitle("Linija");
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblXPocetna = new JLabel("X koordinata po\u010Detne ta\u010Dke:");
			GridBagConstraints gbc_lblXPocetna = new GridBagConstraints();
			gbc_lblXPocetna.anchor = GridBagConstraints.WEST;
			gbc_lblXPocetna.insets = new Insets(0, 0, 5, 5);
			gbc_lblXPocetna.gridx = 0;
			gbc_lblXPocetna.gridy = 0;
			contentPanel.add(lblXPocetna, gbc_lblXPocetna);
		}
		{
			txtXPocetna = new JTextField();
			GridBagConstraints gbc_txtXPocetna = new GridBagConstraints();
			gbc_txtXPocetna.insets = new Insets(0, 0, 5, 0);
			gbc_txtXPocetna.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtXPocetna.gridx = 4;
			gbc_txtXPocetna.gridy = 0;
			contentPanel.add(txtXPocetna, gbc_txtXPocetna);
			txtXPocetna.setColumns(10);
			txtXPocetna.setText(linijaZaModifikaciju.getPocetna().getX()+"");
		}
		{
			JLabel lblYPocetna = new JLabel("Y koordinata po\u010Detne ta\u010Dke:");
			GridBagConstraints gbc_lblYPocetna = new GridBagConstraints();
			gbc_lblYPocetna.anchor = GridBagConstraints.WEST;
			gbc_lblYPocetna.insets = new Insets(0, 0, 5, 5);
			gbc_lblYPocetna.gridx = 0;
			gbc_lblYPocetna.gridy = 1;
			contentPanel.add(lblYPocetna, gbc_lblYPocetna);
		}
		{
			txtYPocetna = new JTextField();
			GridBagConstraints gbc_txtYPocetna = new GridBagConstraints();
			gbc_txtYPocetna.insets = new Insets(0, 0, 5, 0);
			gbc_txtYPocetna.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtYPocetna.gridx = 4;
			gbc_txtYPocetna.gridy = 1;
			contentPanel.add(txtYPocetna, gbc_txtYPocetna);
			txtYPocetna.setColumns(10);
			txtYPocetna.setText(linijaZaModifikaciju.getPocetna().getY()+"");
		}
		{
			JLabel lblXKrajnja = new JLabel("X koordinata krajnje ta\u010Dke:");
			GridBagConstraints gbc_lblXKrajnja = new GridBagConstraints();
			gbc_lblXKrajnja.anchor = GridBagConstraints.WEST;
			gbc_lblXKrajnja.insets = new Insets(0, 0, 5, 5);
			gbc_lblXKrajnja.gridx = 0;
			gbc_lblXKrajnja.gridy = 2;
			contentPanel.add(lblXKrajnja, gbc_lblXKrajnja);
		}
		{
			txtXKrajnja = new JTextField();
			GridBagConstraints gbc_txtXKrajnja = new GridBagConstraints();
			gbc_txtXKrajnja.insets = new Insets(0, 0, 5, 0);
			gbc_txtXKrajnja.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtXKrajnja.gridx = 4;
			gbc_txtXKrajnja.gridy = 2;
			contentPanel.add(txtXKrajnja, gbc_txtXKrajnja);
			txtXKrajnja.setColumns(10);
			txtXKrajnja.setText(linijaZaModifikaciju.getKrajnja().getX()+"");
		}
		{
			JLabel lblYKrajnja = new JLabel("Y koordinata krajnje ta\u010Dke:");
			GridBagConstraints gbc_lblYKrajnja = new GridBagConstraints();
			gbc_lblYKrajnja.anchor = GridBagConstraints.WEST;
			gbc_lblYKrajnja.insets = new Insets(0, 0, 5, 5);
			gbc_lblYKrajnja.gridx = 0;
			gbc_lblYKrajnja.gridy = 3;
			contentPanel.add(lblYKrajnja, gbc_lblYKrajnja);
		}
		{
			txtYKrajnja = new JTextField();
			GridBagConstraints gbc_txtYKrajnja = new GridBagConstraints();
			gbc_txtYKrajnja.insets = new Insets(0, 0, 5, 0);
			gbc_txtYKrajnja.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtYKrajnja.gridx = 4;
			gbc_txtYKrajnja.gridy = 3;
			contentPanel.add(txtYKrajnja, gbc_txtYKrajnja);
			txtYKrajnja.setColumns(10);
			txtYKrajnja.setText(linijaZaModifikaciju.getKrajnja().getY()+"");
		}
		{
			JLabel lblBojaLinije = new JLabel("Boja:");
			GridBagConstraints gbc_lblBojaLinije = new GridBagConstraints();
			gbc_lblBojaLinije.anchor = GridBagConstraints.WEST;
			gbc_lblBojaLinije.insets = new Insets(0, 0, 0, 5);
			gbc_lblBojaLinije.gridx = 0;
			gbc_lblBojaLinije.gridy = 4;
			contentPanel.add(lblBojaLinije, gbc_lblBojaLinije);
		}
		{
			txtBojaLinije = new JTextArea();
			txtBojaLinije.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					JColorChooser jCC=new JColorChooser();
					Color c=jCC.showDialog(txtBojaLinije, "Izaberite boju...", Color.BLACK);
					if(c!=null) {
						txtBojaLinije.setBackground(c);
					}
				}

			});
			txtBojaLinije.setEditable(false);
			GridBagConstraints gbc_txtBojaLinije = new GridBagConstraints();
			gbc_txtBojaLinije.fill = GridBagConstraints.BOTH;
			gbc_txtBojaLinije.gridx = 4;
			gbc_txtBojaLinije.gridy = 4;
			contentPanel.add(txtBojaLinije, gbc_txtBojaLinije);
			txtBojaLinije.setBackground(linijaZaModifikaciju.getBoja());
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Potvrdi");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						try {
							int xPocetna=Integer.parseInt(txtXPocetna.getText());
							int yPocetna=Integer.parseInt(txtYPocetna.getText());
							int xKrajnja=Integer.parseInt(txtXKrajnja.getText());
							int yKrajnja=Integer.parseInt(txtYKrajnja.getText());
							Tacka pocetna= new Tacka(xPocetna,yPocetna);
							Tacka krajnja= new Tacka(xKrajnja,yKrajnja);
							linijaZaModifikaciju.setPocetna(pocetna);
							linijaZaModifikaciju.setKrajnja(krajnja);
							linijaZaModifikaciju.setBoja(txtBojaLinije.getBackground()); 
							setVisible(false);
						} catch (Exception e) {
							JOptionPane.showMessageDialog(null, "Unesite cele brojeve!");
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Odustani");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
