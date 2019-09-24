package crtanje;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import oblici.Tacka;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgTacka extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtX;
	private JTextField txtY;
	private Tacka tackaZaModifikaciju;
	private JTextArea txtBoja;

	/**
	 * Create the dialog.
	 */

	public DlgTacka(Tacka tackaZaModifikaciju) {
		setModal(true);
		setTitle("Ta\u010Dka");
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
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblX = new JLabel("X koordinata ta\u010Dke:");
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
			txtX.setText(tackaZaModifikaciju.getX()+"");
		}
		{
			JLabel lblY = new JLabel("Y koordinata ta\u010Dke:");
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
			txtY.setText(tackaZaModifikaciju.getY()+"");
		}
		{
			JLabel lblBoja = new JLabel("Boja:");
			GridBagConstraints gbc_lblBoja = new GridBagConstraints();
			gbc_lblBoja.anchor = GridBagConstraints.WEST;
			gbc_lblBoja.insets = new Insets(0, 0, 0, 5);
			gbc_lblBoja.gridx = 0;
			gbc_lblBoja.gridy = 2;
			contentPanel.add(lblBoja, gbc_lblBoja);
		}
		{
			txtBoja = new JTextArea();
			txtBoja.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					JColorChooser jCC=new JColorChooser();
					Color c=jCC.showDialog(txtBoja, "Izaberite boju...", Color.BLACK);
					if(c!=null) {
						txtBoja.setBackground(c);
					}
				}
			});
			txtBoja.setEditable(false);
			GridBagConstraints gbc_txtBoja = new GridBagConstraints();
			gbc_txtBoja.fill = GridBagConstraints.BOTH;
			gbc_txtBoja.gridx = 4;
			gbc_txtBoja.gridy = 2;
			contentPanel.add(txtBoja, gbc_txtBoja);
			txtBoja.setBackground(tackaZaModifikaciju.getBoja());
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
					public void actionPerformed(ActionEvent arg0) {
						try {
							int x=Integer.parseInt(txtX.getText());
							int y=Integer.parseInt(txtY.getText());
							tackaZaModifikaciju.setX(x);
							tackaZaModifikaciju.setY(y);
							tackaZaModifikaciju.setBoja(txtBoja.getBackground()); 
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

	public Tacka getTackaZaModifikaciju() {
		return tackaZaModifikaciju;
	}

	public void setTackaZaModifikaciju(Tacka tackaZaModifikaciju) {
		this.tackaZaModifikaciju = tackaZaModifikaciju;
	}

}
