import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Versiotiedot {

	// luodaan uusi ikkuna ja sen tiedot
	public Versiotiedot() {
		JFrame Versiotiedot = new JFrame("Versiotiedot");
		Versiotiedot.getContentPane().setLayout(null);
		Versiotiedot.setBounds(0, 0, 400, 400);
		Versiotiedot.setLocationRelativeTo(null);
		Versiotiedot.setVisible(true);
		Versiotiedot.setTitle("Tietoja ohjelmasta");
		Versiotiedot.setResizable(false);
		Versiotiedot.setAlwaysOnTop(true);

		JLabel tiedot = new JLabel("<html>JUOMA-AUTOMAATTI V.1.0 <br><br> TEKIJÄ: JUHA SUVANTO");
		Versiotiedot.getContentPane().add(tiedot);
		tiedot.setBounds(120, 70, 300, 200);
		// Sulje nappi joka sulkee tietoja ikkunan ja sen kuutelija
		JButton sulje = new JButton("Sulje");
		sulje.setBounds(170, 300, 70, 20);

		sulje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				Versiotiedot.dispose();

			}
		});
		Versiotiedot.getContentPane().add(sulje, BorderLayout.SOUTH);

	}

}
