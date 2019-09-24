package crtanje;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import oblici.Kvadrat;
import oblici.Pravougaonik;
import oblici.Tacka;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DlgPravougaonik extends JDialog {

	private final JPanel contentPanel = new JPanel();
	public JTextField txtX;
	public JTextField txtY;
	public JTextField txtSirina;
	public JTextField txtVisina;
	public JTextArea txtBojaUnutrasnjosti;
	public JTextArea txtBojaIvice;
	public int visina;
	public int sirina;
	private Pravougaonik pravougaonikZaModifikaciju;
	public boolean potvrdio;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the dialog.
	 */
	public DlgPravougaonik(Pravougaonik pravougaonikZaModifikaciju) {
		setModal(true);
		setTitle("Pravougaonik");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblX = new JLabel("X koordinata ta\u010Dke gore levo:");
			GridBagConstraints gbc_lblX = new GridBagConstraints();
			gbc_lblX.anchor = GridBagConstraints.WEST;
			gbc_lblX.insets = new Insets(0, 0, 5, 5);
			gbc_lblX.gridx = 0;
			gbc_lblX.gridy = 0;
			contentPanel.add(lblX, gbc_lblX);
		}
		{
			txtX = new JTextField();
			GridBagConstraints gbc_txtX = new GridBagConstraints();
			gbc_txtX.insets = new Insets(0, 0, 5, 0);
			gbc_txtX.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtX.gridx = 4;
			gbc_txtX.gridy = 0;
			contentPanel.add(txtX, gbc_txtX);
			txtX.setColumns(10);
		}
		{
			JLabel lblY = new JLabel("Y koordinata ta\u010Dke gore levo:");
			GridBagConstraints gbc_lblY = new GridBagConstraints();
			gbc_lblY.anchor = GridBagConstraints.WEST;
			gbc_lblY.insets = new Insets(0, 0, 5, 5);
			gbc_lblY.gridx = 0;
			gbc_lblY.gridy = 1;
			contentPanel.add(lblY, gbc_lblY);
		}
		{
			txtY = new JTextField();
			GridBagConstraints gbc_txtY = new GridBagConstraints();
			gbc_txtY.insets = new Insets(0, 0, 5, 0);
			gbc_txtY.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtY.gridx = 4;
			gbc_txtY.gridy = 1;
			contentPanel.add(txtY, gbc_txtY);
			txtY.setColumns(10);
		}
		{
			JLabel lblVisina = new JLabel("\u0160irina:");
			GridBagConstraints gbc_lblVisina = new GridBagConstraints();
			gbc_lblVisina.anchor = GridBagConstraints.WEST;
			gbc_lblVisina.insets = new Insets(0, 0, 5, 5);
			gbc_lblVisina.gridx = 0;
			gbc_lblVisina.gridy = 2;
			contentPanel.add(lblVisina, gbc_lblVisina);
		}
		{
			txtSirina = new JTextField();
			GridBagConstraints gbc_txtSirina = new GridBagConstraints();
			gbc_txtSirina.insets = new Insets(0, 0, 5, 0);
			gbc_txtSirina.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtSirina.gridx = 4;
			gbc_txtSirina.gridy = 2;
			contentPanel.add(txtSirina, gbc_txtSirina);
			txtSirina.setColumns(10);
		}
		{
			JLabel lblSirina = new JLabel("Visina:");
			GridBagConstraints gbc_lblSirina = new GridBagConstraints();
			gbc_lblSirina.anchor = GridBagConstraints.WEST;
			gbc_lblSirina.insets = new Insets(0, 0, 5, 5);
			gbc_lblSirina.gridx = 0;
			gbc_lblSirina.gridy = 3;
			contentPanel.add(lblSirina, gbc_lblSirina);
		}
		{
			txtVisina = new JTextField();
			GridBagConstraints gbc_txtVisina = new GridBagConstraints();
			gbc_txtVisina.insets = new Insets(0, 0, 5, 0);
			gbc_txtVisina.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtVisina.gridx = 4;
			gbc_txtVisina.gridy = 3;
			contentPanel.add(txtVisina, gbc_txtVisina);
			txtVisina.setColumns(10);
		}
		{
			JLabel lblBojaIvice = new JLabel("Boja ivice:");
			GridBagConstraints gbc_lblBojaIvice = new GridBagConstraints();
			gbc_lblBojaIvice.anchor = GridBagConstraints.WEST;
			gbc_lblBojaIvice.insets = new Insets(0, 0, 5, 5);
			gbc_lblBojaIvice.gridx = 0;
			gbc_lblBojaIvice.gridy = 4;
			contentPanel.add(lblBojaIvice, gbc_lblBojaIvice);
		}
		{
			txtBojaIvice = new JTextArea();
			txtBojaIvice.setEditable(false);
			txtBojaIvice.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(pravougaonikZaModifikaciju!=null) {
						JColorChooser jCC=new JColorChooser();
						Color c=jCC.showDialog(txtBojaIvice, "Izaberite boju...", Color.BLACK);
						if(c!=null) {
							txtBojaIvice.setBackground(c);
						}
					}
				}
			});
			GridBagConstraints gbc_txtBojaIvice = new GridBagConstraints();
			gbc_txtBojaIvice.insets = new Insets(0, 0, 5, 0);
			gbc_txtBojaIvice.fill = GridBagConstraints.BOTH;
			gbc_txtBojaIvice.gridx = 4;
			gbc_txtBojaIvice.gridy = 4;
			contentPanel.add(txtBojaIvice, gbc_txtBojaIvice);
		}
		{
			JLabel lblBojaUnutrasnjosti = new JLabel("Boja unutra\u0161njosti:");
			GridBagConstraints gbc_lblBojaUnutrasnjosti = new GridBagConstraints();
			gbc_lblBojaUnutrasnjosti.anchor = GridBagConstraints.WEST;
			gbc_lblBojaUnutrasnjosti.insets = new Insets(0, 0, 0, 5);
			gbc_lblBojaUnutrasnjosti.gridx = 0;
			gbc_lblBojaUnutrasnjosti.gridy = 5;
			contentPanel.add(lblBojaUnutrasnjosti, gbc_lblBojaUnutrasnjosti);
		}
		{
			txtBojaUnutrasnjosti = new JTextArea();
			txtBojaUnutrasnjosti.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(pravougaonikZaModifikaciju!=null) {
						JColorChooser jCC=new JColorChooser();
						Color c=jCC.showDialog(txtBojaUnutrasnjosti, "Izaberite boju...", Color.BLACK);
						if(c!=null) {
							txtBojaUnutrasnjosti.setBackground(c);

						}
					}
				}
			});
			txtBojaUnutrasnjosti.setEditable(false);
			GridBagConstraints gbc_txtBojaUnutrasnjosti = new GridBagConstraints();
			gbc_txtBojaUnutrasnjosti.fill = GridBagConstraints.BOTH;
			gbc_txtBojaUnutrasnjosti.gridx = 4;
			gbc_txtBojaUnutrasnjosti.gridy = 5;
			contentPanel.add(txtBojaUnutrasnjosti, gbc_txtBojaUnutrasnjosti);
		}

		if(pravougaonikZaModifikaciju!=null){
			txtX.setText(pravougaonikZaModifikaciju.getGoreLevo().getX()+"");
			txtY.setText(pravougaonikZaModifikaciju.getGoreLevo().getY()+"");
			txtSirina.setText(pravougaonikZaModifikaciju.getSirina()+"");
			txtVisina.setText(pravougaonikZaModifikaciju.getVisina()+"");
			txtBojaIvice.setBackground(pravougaonikZaModifikaciju.getBoja());
			txtBojaUnutrasnjosti.setBackground(pravougaonikZaModifikaciju.getBojaUnutrasnjosti());

		}

		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Potvrdi");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							int x=Integer.parseInt(txtX.getText());
							int y=Integer.parseInt(txtY.getText());
							visina=Integer.parseInt(txtVisina.getText());
							sirina=Integer.parseInt(txtSirina.getText());
							if(pravougaonikZaModifikaciju!=null) {
								pravougaonikZaModifikaciju.getGoreLevo().setX(x);
								pravougaonikZaModifikaciju.getGoreLevo().setY(y);
								pravougaonikZaModifikaciju.setSirina(sirina);
								pravougaonikZaModifikaciju.setVisina(visina);
								pravougaonikZaModifikaciju.setBoja(txtBojaIvice.getBackground());
								pravougaonikZaModifikaciju.setBojaUnutrasnjosti(txtBojaUnutrasnjosti.getBackground());
							}
							potvrdio=true;
							setVisible(false);
						}
						catch(NumberFormatException ee) {
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

	public Pravougaonik getPravougaonikZaModifikaciju() {
		return pravougaonikZaModifikaciju;
	}

	public void setPravougaonikZaModifikaciju(Pravougaonik pravougaonikZaModifikaciju) {
		this.pravougaonikZaModifikaciju = pravougaonikZaModifikaciju;
	}

}
