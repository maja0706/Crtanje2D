package crtanje;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgDaNe extends JDialog {

	private final JPanel contentPanel = new JPanel();
	public boolean brisi;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgDaNe dialog = new DlgDaNe();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgDaNe() {
		setModal(true);
		setTitle("Brisanje");
		setBounds(100, 100, 380, 144);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JLabel lblDaLiSte = new JLabel("Da li ste sigurni da \u017Eelite da obri\u0161ete selektovani oblik?");
			contentPanel.add(lblDaLiSte, BorderLayout.CENTER);
		}
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Da");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						brisi = true;
						setVisible(false);
					}
				});
				buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Ne");
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
