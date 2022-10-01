package MyUniversity;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import java.awt.Dialog.ModalExclusionType;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.net.URI;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Desktop;

public class About extends JFrame {
	private JTextField txtniversiteSistemProgram;
	private JTextField txtAnasEskanderAlmaqtari;
	private JTextField txtTrkeybartnmerkez;
	private JTextField textField;
	private JTextField facebook;
	private JTextField email;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					About frame = new About();
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
	public About() {
		setIconImage(new ImageIcon(("src\\img\\GenelIcon.jpg")).getImage());
		setBackground(new Color(0, 0, 0));
		setResizable(false);
		setFont(new Font("Dialog", Font.PLAIN, 12));
		setTitle("Programc\u0131 Hakk\u0131nda Bilgiler");
		getContentPane().setEnabled(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 591, 429);
		
		JPanel panel = new JPanel();
		panel.setForeground(Color.WHITE);
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Hakk\u0131m\u0131zda Bilgiler", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 585, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(102, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 397, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		JLabel lblNewLabel = new JLabel("Program ad\u0131 :");
		lblNewLabel.setBackground(new Color(0, 128, 128));
		lblNewLabel.setBounds(16, 27, 93, 31);
		lblNewLabel.setForeground(new Color(0, 128, 128));
		lblNewLabel.setEnabled(false);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		txtniversiteSistemProgram = new JTextField();
		txtniversiteSistemProgram.setBounds(137, 32, 382, 22);
		txtniversiteSistemProgram.setEnabled(false);
		txtniversiteSistemProgram.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtniversiteSistemProgram.setText("\u00DCniversite Sistem Program\u0131");
		txtniversiteSistemProgram.setColumns(10);
		
		JLabel lblProgramcAd = new JLabel("Programc\u0131 ad\u0131 :");
		lblProgramcAd.setBackground(new Color(0, 128, 128));
		lblProgramcAd.setBounds(16, 76, 103, 31);
		lblProgramcAd.setForeground(new Color(0, 128, 128));
		lblProgramcAd.setEnabled(false);
		lblProgramcAd.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		txtAnasEskanderAlmaqtari = new JTextField();
		txtAnasEskanderAlmaqtari.setBounds(137, 76, 382, 22);
		txtAnasEskanderAlmaqtari.setEnabled(false);
		txtAnasEskanderAlmaqtari.setForeground(new Color(0, 0, 0));
		txtAnasEskanderAlmaqtari.setText("Anas Eskander AL-Maqtari");
		txtAnasEskanderAlmaqtari.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtAnasEskanderAlmaqtari.setColumns(10);
		
		txtTrkeybartnmerkez = new JTextField();
		txtTrkeybartnmerkez.setBounds(137, 134, 382, 22);
		txtTrkeybartnmerkez.setText("T\u00DCRKEY-Bart\u0131n-Merkez");
		txtTrkeybartnmerkez.setForeground(Color.BLACK);
		txtTrkeybartnmerkez.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtTrkeybartnmerkez.setEnabled(false);
		txtTrkeybartnmerkez.setColumns(10);
		
		JLabel lblAdress = new JLabel("Adress :");
		lblAdress.setBackground(new Color(0, 128, 128));
		lblAdress.setBounds(16, 125, 56, 31);
		lblAdress.setForeground(new Color(0, 128, 128));
		lblAdress.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAdress.setEnabled(false);
		
		JLabel eposta = new JLabel("e-posta :");
		eposta.setBackground(new Color(0, 128, 128));
		eposta.setBounds(16, 199, 71, 31);
		eposta.setForeground(new Color(0, 128, 128));
		eposta.setFont(new Font("Tahoma", Font.BOLD, 14));
		eposta.setEnabled(false);
		
		email = new JTextField();
		email.setBounds(137, 206, 165, 22);
		email.setText("anass12976@gmail.com");
		email.setForeground(Color.BLACK);
		email.setFont(new Font("Tahoma", Font.BOLD, 13));
		email.setEnabled(false);
		email.setColumns(10);
		
		JLabel lblTelefonNumaras = new JLabel("Telefon No :");
		lblTelefonNumaras.setBackground(new Color(0, 128, 128));
		lblTelefonNumaras.setBounds(16, 163, 103, 31);
		lblTelefonNumaras.setForeground(new Color(0, 128, 128));
		lblTelefonNumaras.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTelefonNumaras.setEnabled(false);
		
		textField = new JTextField();
		textField.setBounds(137, 168, 129, 22);
		textField.setText("90537924923");
		textField.setForeground(new Color(255, 0, 0));
		textField.setFont(new Font("Tahoma", Font.BOLD, 13));
		textField.setEnabled(false);
		textField.setColumns(10);
		
		JButton label1 = new JButton("Kopya");
		label1.setBounds(452, 205, 72, 25);
		
		label1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JButton btnKapat = new JButton("Kapat");
		btnKapat.setBounds(207, 335, 91, 25);
		btnKapat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnKapat.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel lblFacebook = new JLabel("Facebook :");
		lblFacebook.setBackground(new Color(0, 128, 128));
		lblFacebook.setBounds(16, 241, 75, 31);
		lblFacebook.setForeground(new Color(0, 0, 0));
		lblFacebook.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblFacebook.setEnabled(false);
		
		facebook = new JTextField();
		facebook.setBounds(137, 246, 183, 22);
		facebook.setText("https://www.facebook.com/profile.php?id=100005134514428");
		facebook.setForeground(Color.BLACK);
		facebook.setFont(new Font("Tahoma", Font.BOLD, 13));
		facebook.setEnabled(false);
		facebook.setColumns(10);
		
		JButton label2 = new JButton("A\u00E7");
		label2.setBounds(452, 252, 68, 25);
		label2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Desktop desktop =  Desktop.getDesktop();
					desktop.browse(new URI(facebook.getText()));
				}catch(Exception ex) {
					
				}
			}
		});
		label2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel label3 = new JLabel("Kopyalanm\u0131\u015F");
		label3.setBounds(452, 288, 72, 14);
		label3.setFont(new Font("Tahoma", Font.BOLD, 11));
		label3.setForeground(new Color(128, 0, 128));
		label1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				email.copy();
				label3.setVisible(true);
			}
		});
		panel.setLayout(null);
		panel.add(lblProgramcAd);
		panel.add(lblNewLabel);
		panel.add(lblAdress);
		panel.add(txtTrkeybartnmerkez);
		panel.add(txtAnasEskanderAlmaqtari);
		panel.add(textField);
		panel.add(facebook);
		panel.add(email);
		panel.add(label1);
		panel.add(label3);
		panel.add(label2);
		panel.add(txtniversiteSistemProgram);
		panel.add(lblFacebook);
		panel.add(eposta);
		panel.add(lblTelefonNumaras);
		panel.add(btnKapat);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\anass\\Desktop\\GitHub\\BSM103_ANASALMAQTARI\\MyUniversity\\src\\img\\5ff62df86deaad39e2d605f5e1bf0ffe.jpg"));
		lblNewLabel_1.setBounds(0, 0, 575, 397);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\anass\\Downloads\\5ff62df86deaad39e2d605f5e1bf0ffe.jpg"));
		lblNewLabel_2.setBounds(0, 0, 575, 397);
		panel.add(lblNewLabel_2);
		getContentPane().setLayout(groupLayout);
		label3.setVisible(false);

	}
}
