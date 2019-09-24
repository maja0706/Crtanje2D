package crtanje;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import oblici.Krug;
import oblici.Kvadrat;
import oblici.Tacka;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DlgKrug extends JDialog {

	private final JPanel contentPanel = new JPanel();
	public JTextField txtX;
	public JTextField txtY;
	public JTextField txtRadijus;
	public JTextArea txtBojaUnutrasnjosti;
	public JTextArea txtBojaIvice;
	public int radijus;
	private Krug krugZaModifikaciju;
	public boolean potvrdio;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the dialog.
	 */
	public DlgKrug(Krug krugZaModifikaciju) {
		setModal(true);
		setTitle("Krug");
		setBounds(100, 100, 450, 300);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{434, 0};
		gridBagLayout.rowHeights = new int[]{228, 33, 0};
		gridBagLayout.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		GridBagConstraints gbc_contentPanel = new GridBagConstraints();
		gbc_contentPanel.fill = GridBagConstraints.BOTH;
		gbc_contentPanel.insets = new Insets(0, 0, 5, 0);
		gbc_contentPanel.gridx = 0;
		gbc_contentPanel.gridy = 0;
		getContentPane().add(contentPanel, gbc_contentPanel);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblX = new JLabel("X koordinata centra:");
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
			JLabel lblY = new JLabel("Y koordinata centra:");
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
			gbc_txtY.anchor = GridBagConstraints.NORTH;
			gbc_txtY.insets = new Insets(0, 0, 5, 0);
			gbc_txtY.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtY.gridx = 4;
			gbc_txtY.gridy = 1;
			contentPanel.add(txtY, gbc_txtY);
			txtY.setColumns(10);

		}
		{
			JLabel lblRadijus = new JLabel("Radijus:");
			GridBagConstraints gbc_lblRadijus = new GridBagConstraints();
			gbc_lblRadijus.anchor = GridBagConstraints.WEST;
			gbc_lblRadijus.insets = new Insets(0, 0, 5, 5);
			gbc_lblRadijus.gridx = 0;
			gbc_lblRadijus.gridy = 2;
			contentPanel.add(lblRadijus, gbc_lblRadijus);
		}
		{
			txtRadijus = new JTextField();
			GridBagConstraints gbc_txtRadijus = new GridBagConstraints();
			gbc_txtRadijus.insets = new Insets(0, 0, 5, 0);
			gbc_txtRadijus.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtRadijus.gridx = 4;
			gbc_txtRadijus.gridy = 2;
			contentPanel.add(txtRadijus, gbc_txtRadijus);
			txtRadijus.setColumns(10);

		}
		{
			JLabel lblBojaUnutrasnjosti = new JLabel("Boja unutra\u0161njosti:");
			GridBagConstraints gbc_lblBojaUnutrasnjosti = new GridBagConstraints();
			gbc_lblBojaUnutrasnjosti.anchor = GridBagConstraints.WEST;
			gbc_lblBojaUnutrasnjosti.insets = new Insets(0, 0, 5, 5);
			gbc_lblBojaUnutrasnjosti.gridx = 0;
			gbc_lblBojaUnutrasnjosti.gridy = 3;
			contentPanel.add(lblBojaUnutrasnjosti, gbc_lblBojaUnutrasnjosti);
		}
		{
			txtBojaUnutrasnjosti = new JTextArea();
			txtBojaUnutrasnjosti.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					if(krugZaModifikaciju!=null) {
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
			gbc_txtBojaUnutrasnjosti.insets = new Insets(0, 0, 5, 0);
			gbc_txtBojaUnutrasnjosti.fill = GridBagConstraints.BOTH;
			gbc_txtBojaUnutrasnjosti.gridx = 4;
			gbc_txtBojaUnutrasnjosti.gridy = 3;
			contentPanel.add(txtBojaUnutrasnjosti, gbc_txtBojaUnutrasnjosti);
		}
		{
			JLabel lblBojaIvice = new JLabel("Boja ivice:");
			GridBagConstraints gbc_lblBojaIvice = new GridBagConstraints();
			gbc_lblBojaIvice.anchor = GridBagConstraints.WEST;
			gbc_lblBojaIvice.insets = new Insets(0, 0, 0, 5);
			gbc_lblBojaIvice.gridx = 0;
			gbc_lblBojaIvice.gridy = 4;
			contentPanel.add(lblBojaIvice, gbc_lblBojaIvice);
		}
		{
			txtBojaIvice = new JTextArea();
			txtBojaIvice.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {

					if(krugZaModifikaciju!=null) {
						JColorChooser jCC=new JColorChooser();
						Color c=jCC.showDialog(txtBojaIvice, "Izaberite boju...", Color.BLACK);
						if(c!=null) {
							txtBojaIvice.setBackground(c);
						}
					}

				}
			});
			txtBojaIvice.setEditable(false);
			GridBagConstraints gbc_txtBojaIvice = new GridBagConstraints();
			gbc_txtBojaIvice.fill = GridBagConstraints.BOTH;
			gbc_txtBojaIvice.gridx = 4;
			gbc_txtBojaIvice.gridy = 4;
			contentPanel.add(txtBojaIvice, gbc_txtBojaIvice);
		}
		if(krugZaModifikaciju!=null){
			txtX.setText(krugZaModifikaciju.getCentar().getX()+"");
			txtY.setText(krugZaModifikaciju.getCentar().getY()+"");
			txtRadijus.setText(krugZaModifikaciju.getPoluprecnik()+"");
			txtBojaUnutrasnjosti.setBackground(krugZaModifikaciju.getBojaUnutrasnjosti());
			txtBojaIvice.setBackground(krugZaModifikaciju.getBoja());

		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			GridBagConstraints gbc_buttonPane = new GridBagConstraints();
			gbc_buttonPane.anchor = GridBagConstraints.NORTH;
			gbc_buttonPane.fill = GridBagConstraints.HORIZONTAL;
			gbc_buttonPane.gridx = 0;
			gbc_buttonPane.gridy = 1;
			getContentPane().add(buttonPane, gbc_buttonPane);
			{
				JButton okButton = new JButton("Potvrdi");
				okButton.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {
						try {
							int x=Integer.parseInt(txtX.getText());
							int y=Integer.parseInt(txtY.getText());
							radijus=Integer.parseInt(txtRadijus.getText());
							if(krugZaModifikaciju!=null) {
								krugZaModifikaciju.getCentar().setX(x);
								krugZaModifikaciju.getCentar().setY(y);
								krugZaModifikaciju.setPoluprecnik(radijus);
								krugZaModifikaciju.setBoja(txtBojaIvice.getBackground());
								krugZaModifikaciju.setBojaUnutrasnjosti(txtBojaUnutrasnjosti.getBackground());
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

	public Krug getKrugZaModifikaciju() {
		return krugZaModifikaciju;
	}

	public void setKrugZaModifikaciju(Krug krugZaModifikaciju) {
		this.krugZaModifikaciju = krugZaModifikaciju;
	}

}
