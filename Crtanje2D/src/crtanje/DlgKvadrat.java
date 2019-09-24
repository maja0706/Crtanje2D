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
import oblici.Tacka;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.ComboBoxEditor;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DlgKvadrat extends JDialog {

	private final JPanel contentPanel = new JPanel();
	public JTextField txtX;
	public JTextField txtY;
	public JTextField txtStranica;
	private Kvadrat kvadrat;
	public JTextArea txtBojaUnutrasnjosti;
	public JTextArea txtBojaIvice; 
	public int stranica;
	private Kvadrat kvadratZaModifikaciju;
	public boolean potvrdio;


	/**
	 * Launch the application.
	 */


	/**
	 * Create the dialog.
	 */
	public DlgKvadrat(Kvadrat kvadratZaModifikaciju) {
		setModal(true);
		setTitle("Kvadrat");
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
			JLabel lblStranica = new JLabel("Du\u017Eina stranice:");
			GridBagConstraints gbc_lblStranica = new GridBagConstraints();
			gbc_lblStranica.anchor = GridBagConstraints.WEST;
			gbc_lblStranica.insets = new Insets(0, 0, 5, 5);
			gbc_lblStranica.gridx = 0;
			gbc_lblStranica.gridy = 2;
			contentPanel.add(lblStranica, gbc_lblStranica);
		}
		{
			txtStranica = new JTextField();
			GridBagConstraints gbc_txtStranica = new GridBagConstraints();
			gbc_txtStranica.insets = new Insets(0, 0, 5, 0);
			gbc_txtStranica.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtStranica.gridx = 4;
			gbc_txtStranica.gridy = 2;
			contentPanel.add(txtStranica, gbc_txtStranica);
			txtStranica.setColumns(10);
		}

		JLabel lblBojaUnutrasnjosti = new JLabel("Boja unutra\u0161njosti:");
		GridBagConstraints gbc_lblBojaUnutrasnjosti = new GridBagConstraints();
		gbc_lblBojaUnutrasnjosti.anchor = GridBagConstraints.WEST;
		gbc_lblBojaUnutrasnjosti.insets = new Insets(0, 0, 5, 5);
		gbc_lblBojaUnutrasnjosti.gridx = 0;
		gbc_lblBojaUnutrasnjosti.gridy = 3;
		contentPanel.add(lblBojaUnutrasnjosti, gbc_lblBojaUnutrasnjosti);
		{
			txtBojaUnutrasnjosti = new JTextArea();
			txtBojaUnutrasnjosti.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(kvadratZaModifikaciju!=null) {
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
			gbc_lblBojaIvice.insets = new Insets(0, 0, 0, 5);
			gbc_lblBojaIvice.anchor = GridBagConstraints.WEST;
			gbc_lblBojaIvice.gridx = 0;
			gbc_lblBojaIvice.gridy = 4;
			contentPanel.add(lblBojaIvice, gbc_lblBojaIvice);
		}
		{
			txtBojaIvice = new JTextArea();
			txtBojaIvice.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(kvadratZaModifikaciju!=null) {
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
		if(kvadratZaModifikaciju!=null){
			txtX.setText(kvadratZaModifikaciju.getGoreLevo().getX()+"");
			txtY.setText(kvadratZaModifikaciju.getGoreLevo().getY()+"");
			txtStranica.setText(kvadratZaModifikaciju.getSirina()+"");
			txtBojaIvice.setBackground(kvadratZaModifikaciju.getBoja());
			txtBojaUnutrasnjosti.setBackground(kvadratZaModifikaciju.getBojaUnutrasnjosti());
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
							stranica=Integer.parseInt(txtStranica.getText());
							Tacka tacka=new Tacka(x,y);
							kvadrat=new Kvadrat(tacka,stranica,txtBojaIvice.getBackground(),txtBojaUnutrasnjosti.getBackground());
							if(kvadratZaModifikaciju!=null) {
								kvadratZaModifikaciju.getGoreLevo().setX(x);
								kvadratZaModifikaciju.getGoreLevo().setY(y);
								kvadratZaModifikaciju.setSirina(stranica);
								kvadratZaModifikaciju.setBoja(txtBojaIvice.getBackground());
								kvadratZaModifikaciju.setBojaUnutrasnjosti(txtBojaUnutrasnjosti.getBackground());
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

	public Kvadrat getKvadrat() {
		return kvadrat;
	}

	public void setKvadrat(Kvadrat kvadrat) {
		txtX.setText(""+kvadrat.getGoreLevo().getX());
		txtY.setText(""+kvadrat.getGoreLevo().getY());
		txtStranica.setText(""+kvadrat.getSirina());
		txtBojaUnutrasnjosti.getBackground();
		txtBojaIvice.getBackground();

	}

}
