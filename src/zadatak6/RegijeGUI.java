package zadatak6;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.LinkedList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


public class RegijeGUI extends JFrame {

	private JPanel contentPane;
	private JTextField jtfNaziv;
	private JTextField jtfNatalitet;
	private JTextField jtfMortalitet;
	private JTextField jtfMigracioniSaldo;
	
	private LinkedList<Regija> regioni = new LinkedList<Regija>();

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegijeGUI frame = new RegijeGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public RegijeGUI() {
		setTitle("Demografski podaci po regionima");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(150, 100));
		contentPane.add(panel, BorderLayout.WEST);
		
		JLabel lblNaziv = new JLabel("Naziv");
		panel.add(lblNaziv);
		
		jtfNaziv = new JTextField();
		panel.add(jtfNaziv);
		jtfNaziv.setColumns(10);
		
		JLabel lblNatalitet = new JLabel("Natalitet");
		panel.add(lblNatalitet);
		
		jtfNatalitet = new JTextField();
		panel.add(jtfNatalitet);
		jtfNatalitet.setColumns(10);
		
		JLabel lblMortalitet = new JLabel("Mortalitet");
		panel.add(lblMortalitet);
		
		jtfMortalitet = new JTextField();
		panel.add(jtfMortalitet);
		jtfMortalitet.setColumns(10);
		
		JLabel lblMigracioniSaldo = new JLabel("Migracioni saldo");
		panel.add(lblMigracioniSaldo);
		
		jtfMigracioniSaldo = new JTextField();
		panel.add(jtfMigracioniSaldo);
		jtfMigracioniSaldo.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		final JTextArea textArea = new JTextArea();
		contentPane.add(textArea, BorderLayout.CENTER);
		
		JButton btnDodaj = new JButton("Dodaj");
		btnDodaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String naziv = jtfNaziv.getText();
					int natalitet = Integer.parseInt(jtfNatalitet.getText());
					int mortalitet = Integer.parseInt(jtfMortalitet.getText());
					int migracioniSaldo = Integer.parseInt(jtfMigracioniSaldo.getText());

					Regija novaRegija = new Regija();
					novaRegija.setNaziv(naziv);
					novaRegija.setNatalitet(natalitet);
					novaRegija.setMortalitet(mortalitet);
					novaRegija.setMigracioniSaldo(migracioniSaldo);
					
					boolean regijaPostoji = false;
					
					
					for (int i = 0; i < regioni.size(); i++) {
						if (naziv.equals(regioni.get(i).getNaziv())) {
							regijaPostoji = true;
							break;
						}
					}
					
					if (!regijaPostoji) {
						
						boolean unesena = false;
						
						for (int i = 0; i < regioni.size(); i++) {
							if (novaRegija.getNatalitet() > regioni.get(i).getNatalitet()) {
								regioni.add(i, novaRegija);
								unesena = true;
								break;
							}
						}
						
						if (!unesena) {
							regioni.add(novaRegija);
						}
					} else {
						textArea.setText("GRESKA");
					}
				} catch (Exception ex) {
					textArea.setText("GRESKA");
				}
			}
		});
		panel_1.add(btnDodaj);
		
		JButton btnSacuvaj = new JButton("Sacuvaj");
		btnSacuvaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					PrintWriter rastuceRegijeOut = new PrintWriter(new BufferedWriter(new FileWriter("rastuce_regije.txt")));
                                        PrintWriter umiruceRegijeOut = new PrintWriter(new BufferedWriter(new FileWriter("umiruce_regije.txt")));
					for (int i = 0; i < regioni.size(); i++) {
						int promena = regioni.get(i).getNatalitet() - regioni.get(i).getMortalitet() + regioni.get(i).getMigracioniSaldo();
						
						if (promena > 0) {
							rastuceRegijeOut.print(regioni.get(i));
						} else {
							umiruceRegijeOut.print(regioni.get(i));
						}
					}
					
					
					rastuceRegijeOut.close();
					umiruceRegijeOut.close();
				} catch (Exception ex) {
					System.out.println("Greska: " + ex.getMessage());
				}
			}
		});
		panel_1.add(btnSacuvaj);
		
		JButton btnObrisi = new JButton("Obrisi");
		btnObrisi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				jtfNaziv.setText(null);
				jtfNatalitet.setText(null);
				jtfMortalitet.setText(null);
				jtfMigracioniSaldo.setText(null);
				textArea.setText(null);
			}
		});
		panel_1.add(btnObrisi);
	}
}