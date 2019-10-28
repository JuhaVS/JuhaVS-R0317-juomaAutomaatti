import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class GUI_Automaatti extends JFrame {

	// Luokkamuuttujat
	// Esitellään täällä jotta komponentteihin voidaan viitata mistä tahansa luokan
	// sisältä

	JPanel contentPane;
	private JLabel kahvinTila;
	private JLabel teenTila;
	private JLabel kaakaonTila;

	/**
	 * Main-metodi, joka käynnistää sovelluksen
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// Luodaan ensmin uusi JuomaAutomaatti-olio
					JuomaAutomaatti ja = new JuomaAutomaatti();

					// Käyttöliittymä saa parametrina olion, jonka tiedot se näyttää
					GUI_Automaatti frame = new GUI_Automaatti(ja);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Konstruktorissa rakennetaan käyttöliittymä. Huomaa, että otetaan parametrina
	 * vastaan alussa luotu juoma-automaatti. Tämä siksi, että voidaan näyttää sen
	 * tiedot GUI:ssa
	 */
	public GUI_Automaatti(JuomaAutomaatti ja) {

		// Ikkunan otsikko ja koko

		setTitle("Kahviautomaatti GUI v. 1.0");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 465, 705);
		setResizable(false);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnYllpito = new JMenu("Yll\u00E4pito");
		menuBar.add(mnYllpito);

		JMenuItem mntmAsetaKahvinMr = new JMenuItem("Aseta kahvin m\u00E4\u00E4r\u00E4");
		mntmAsetaKahvinMr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String uusiArvo = JOptionPane.showInputDialog(null, "Anna kahvin uusi arvo: ");
				int uusiKahvi = Integer.parseInt(uusiArvo);
				ja.setKahvi(uusiKahvi);
				kahvinPäivitys(ja);
				
				
			}
		});
		mnYllpito.add(mntmAsetaKahvinMr);

		JMenuItem mntmAsetaTeenMr = new JMenuItem("Aseta teen m\u00E4\u00E4r\u00E4");
		mntmAsetaTeenMr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String uusiArvo = JOptionPane.showInputDialog(null, "Anna teen uusi arvo: ");
				int uusiTee = Integer.parseInt(uusiArvo);
				ja.setTee(uusiTee);
				teenPäivitys(ja);
				
			}
		});
		mnYllpito.add(mntmAsetaTeenMr);

		JMenuItem mntmAsetaKaakaonMr = new JMenuItem("Aseta kaakaon m\u00E4\u00E4r\u00E4");
		mntmAsetaKaakaonMr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String uusiArvo = JOptionPane.showInputDialog(null, "Anna kaakaon uusi arvo: ");
				int uusiKaakao = Integer.parseInt(uusiArvo);
				ja.setKaakao(uusiKaakao);
				kaakaonPäivitys(ja);
			}
		});
		mnYllpito.add(mntmAsetaKaakaonMr);

		JMenuItem mntmTallennaAutomaatinTila_1 = new JMenuItem("Tallenna automaatin tila");
		mntmTallennaAutomaatinTila_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Sarjallistamista.kirjoitaTiedostoon(ja);
				} catch (IOException e1) {
					
					e1.printStackTrace();
				}
				
			}
		});
		mnYllpito.add(mntmTallennaAutomaatinTila_1);

		JMenuItem mntmLataaAutomaatti_1 = new JMenuItem("Lataa automaatti");
		mntmLataaAutomaatti_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					JuomaAutomaatti uusi = Sarjallistamista.lueTiedostosta();
					ja.setKaakao(uusi.getKaakao());
					ja.setTee(uusi.getTee());
					ja.setKahvi(uusi.getKahvi());
					
					kaakaonPäivitys(ja);
					teenPäivitys(ja);
					kahvinPäivitys(ja);
					
					
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mnYllpito.add(mntmLataaAutomaatti_1);

		JMenuItem mntmLopeta = new JMenuItem("Lopeta");
		mntmLopeta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnYllpito.add(mntmLopeta);

		JMenu mnTietojaOhjelmasta = new JMenu("Tietoja ohjelmasta");
		menuBar.add(mnTietojaOhjelmasta);

		JMenuItem mntmVersiotiedot = new JMenuItem("Versiotiedot");
		mntmVersiotiedot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Versiotiedot();
			}
		});
		mnTietojaOhjelmasta.add(mntmVersiotiedot);

		JMenuItem mntmOhje = new JMenuItem("Ohje");
		mntmOhje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 
				JFrame Ohje = new JFrame("Ohje");
				Ohje.getContentPane().setLayout(null);
				Ohje.setBounds(0, 0, 400, 400);
				Ohje.setLocationRelativeTo(null);
				Ohje.setVisible(true);
				Ohje.setTitle("Ohjeet");
				Ohje.setResizable(false);
				Ohje.setAlwaysOnTop(true);

				JLabel ohjeet = new JLabel("<html>Paina kuvaa tilataksesi juoma <br><br> Helppoa eikö vain?");
				Ohje.getContentPane().add(ohjeet);
				ohjeet.setBounds(120, 70, 300, 200);
				// Sulje nappi joka sulkee ohjeet ikkunan ja sen kuutelija
				JButton sulje = new JButton("Sulje");
				sulje.setBounds(170, 300, 70, 20);

				sulje.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {

						Ohje.dispose();

					}
				});
				Ohje.getContentPane().add(sulje, BorderLayout.SOUTH);

				
			}
		});
		mnTietojaOhjelmasta.add(mntmOhje);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton kahviNappi = new JButton("Kahvi");
		kahviNappi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ja.valmistaKahvi();
				kahvinPäivitys(ja);

			}
		});
		kahviNappi.setIcon(new ImageIcon(GUI_Automaatti.class.getResource("/images/coffee.jpg")));
		kahviNappi.setBounds(10, 34, 126, 130);
		contentPane.add(kahviNappi);

		JButton teeNappi = new JButton("Tee");
		teeNappi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ja.valmistaTee();
				teenPäivitys(ja);

			}
		});
		teeNappi.setIcon(new ImageIcon(GUI_Automaatti.class.getResource("/images/tea.jpg")));
		teeNappi.setBounds(10, 230, 126, 130);
		contentPane.add(teeNappi);

		JButton kaakaoNappi = new JButton("Kaakao");
		kaakaoNappi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ja.valmistaKaakao();
				kaakaonPäivitys(ja);

			}
		});
		kaakaoNappi.setIcon(new ImageIcon(GUI_Automaatti.class.getResource("/images/cocoa.jpg")));
		kaakaoNappi.setBounds(10, 429, 126, 130);
		contentPane.add(kaakaoNappi);

		JLabel lblKahvi = new JLabel("Kahvi");
		lblKahvi.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblKahvi.setBounds(54, 175, 46, 14);
		contentPane.add(lblKahvi);

		JLabel lblTee = new JLabel("Tee");
		lblTee.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblTee.setBounds(54, 371, 46, 14);
		contentPane.add(lblTee);

		JLabel lblKaakao = new JLabel("Kaakao");
		lblKaakao.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblKaakao.setBounds(50, 570, 62, 14);
		contentPane.add(lblKaakao);

		kahvinTila = new JLabel("Kahvia: " + ja.getKahvi());
		kahvinTila.setFont(new Font("Times New Roman", Font.BOLD, 14));
		kahvinTila.setBounds(247, 86, 100, 26);
		contentPane.add(kahvinTila);

		teenTila = new JLabel("Teetä: " + ja.getTee());
		teenTila.setFont(new Font("Times New Roman", Font.BOLD, 14));
		teenTila.setBounds(247, 282, 100, 26);
		contentPane.add(teenTila);

		kaakaonTila = new JLabel("Kaakaota " + ja.getKaakao());
		kaakaonTila.setFont(new Font("Times New Roman", Font.BOLD, 14));
		kaakaonTila.setBounds(247, 481, 100, 26);
		contentPane.add(kaakaonTila);

	}

	public void kahvinPäivitys(JuomaAutomaatti ja) {
		kahvinTila.setText("Kahvia: " + ja.getKahvi());
		if (ja.getKahvi() < 20)
			kahvinTila.setForeground(Color.RED);
		else
			kahvinTila.setForeground(Color.BLACK);
	}

	public void teenPäivitys(JuomaAutomaatti ja) {
		teenTila.setText("Teetä: " + ja.getTee());
		if (ja.getTee() < 20)
			teenTila.setForeground(Color.RED);
		else
			teenTila.setForeground(Color.BLACK);
	}

	public void kaakaonPäivitys(JuomaAutomaatti ja) {
		kaakaonTila.setText("Kaakaota: " + ja.getKaakao());
		if (ja.getKaakao() < 20)
			kaakaonTila.setForeground(Color.RED);
		else
			kaakaonTila.setForeground(Color.BLACK);
	}

}
