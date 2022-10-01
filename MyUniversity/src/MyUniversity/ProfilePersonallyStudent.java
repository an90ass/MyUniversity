package MyUniversity;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Panel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

public class ProfilePersonallyStudent extends JFrame {

	private JPanel contentPane;
	private JTextField textField_6;

	 Connection con = null;
	    PreparedStatement com = null;
	    ResultSet rst = null;
	    private JLabel Gender;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProfilePersonallyStudent frame = new ProfilePersonallyStudent();
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
	public ProfilePersonallyStudent() {
		setIconImage(new ImageIcon(("src\\img\\GenelIcon.jpg")).getImage());
		setIconImage(new ImageIcon(("src\\img\\GenelIcon.jpg")).getImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 365, 459);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Panel panel_1 = new Panel();
		panel_1.setBackground(new Color(0, 128, 128));
		panel_1.setBounds(0, 56, 357, 371);
		contentPane.add(panel_1);
		
		JLabel lblTelefonNumaras = new JLabel("Telefon numaras\u0131 :");
		lblTelefonNumaras.setForeground(Color.WHITE);
		lblTelefonNumaras.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		JLabel lblAdSoyad = new JLabel("Ad Soyad :");
		lblAdSoyad.setForeground(Color.WHITE);
		lblAdSoyad.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		JLabel lblNewLabel = new JLabel("\u00D6\u011Frenci numaras\u0131  :");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		JLabel lblCinsiyet = new JLabel("Cinsiyet :");
		lblCinsiyet.setForeground(Color.WHITE);
		lblCinsiyet.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		JLabel lblCinsiyet_1_1 = new JLabel("Har\u00E7tan geri kalan :");
		lblCinsiyet_1_1.setForeground(Color.WHITE);
		lblCinsiyet_1_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		JLabel lblCinsiyet_1_2_1 = new JLabel("\u00D6denmi\u015F har\u00E7 :");
		lblCinsiyet_1_2_1.setForeground(Color.WHITE);
		lblCinsiyet_1_2_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		JLabel lblCinsiyet_1_2 = new JLabel("Y\u0131ll\u0131k har\u00E7 :");
		lblCinsiyet_1_2.setForeground(Color.WHITE);
		lblCinsiyet_1_2.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		JLabel lblCinsiyet_1 = new JLabel("Ortalama :");
		lblCinsiyet_1.setForeground(Color.WHITE);
		lblCinsiyet_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		textField_6 = new JTextField();
		textField_6.setText((String) null);
		textField_6.setColumns(10);
		
		JLabel ID = new JLabel("New label");
		ID.setEnabled(false);
		
		JLabel Name = new JLabel("New label");
		Name.setEnabled(false);
		
		JLabel Mobile = new JLabel("New label");
		Mobile.setEnabled(false);
		
		Gender = new JLabel("New label");
		Gender.setEnabled(false);
		
		JLabel Avg = new JLabel("New label");
		Avg.setEnabled(false);
		Avg.setForeground(Color.RED);
		
		JLabel acquiredAmount = new JLabel("New label");
		acquiredAmount.setEnabled(false);
		
		JLabel amountPaid = new JLabel("New label");
		amountPaid.setEnabled(false);
		
		JLabel Fess = new JLabel("New label");
		Fess.setEnabled(false);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(33)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(lblTelefonNumaras)
						.addComponent(lblNewLabel)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(3)
							.addComponent(lblCinsiyet))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(6)
							.addComponent(lblCinsiyet_1_1))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(4)
							.addComponent(lblCinsiyet_1_2_1, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(3)
							.addComponent(lblCinsiyet_1_2))
						.addComponent(lblCinsiyet_1)
						.addComponent(lblAdSoyad, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(Name, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
								.addComponent(ID, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
								.addComponent(Gender, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
								.addComponent(Avg, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
								.addComponent(acquiredAmount, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
								.addComponent(amountPaid, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
								.addComponent(Fess, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE))
							.addGap(53))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, 0, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(Mobile, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
							.addGap(81))))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(24)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(ID))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAdSoyad, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(Name))
					.addGap(19)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTelefonNumaras, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(Mobile))
					.addGap(19)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCinsiyet, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(Gender))
					.addGap(14)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCinsiyet_1, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(Avg))
					.addGap(19)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCinsiyet_1_2, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(acquiredAmount))
					.addGap(17)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCinsiyet_1_2_1, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(amountPaid))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCinsiyet_1_1, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(Fess))
					.addContainerGap(61, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		
		Panel panel = new Panel();
		panel.setBackground(new Color(64, 224, 208));
		panel.setBounds(0, 0, 357, 58);
		contentPane.add(panel);
		
		JLabel lblNewLabel_1 = new JLabel("Profil");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 35));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(123)
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(141, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 36, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		int idD = Integer.parseInt(Login.id);
		//Information(idD);
       //
		try {
    		con =ConnectionDataBase.Connet();
			com = con.prepareStatement("select*from Student where id ='"+idD+"'");
	        rst = com.executeQuery();	
			rst.next();
			ID.setText(rst.getString(1));
			Name.setText(rst.getString(2));
			Mobile.setText(rst.getString(4));
			Avg.setText(rst.getString(5));
			acquiredAmount.setText(rst.getString(6)+" LIRA ");
			amountPaid.setText(rst.getString(7)+" LIRA ");
			Fess.setText(rst.getString(8)+" LIRA ");
            Gender.setText(rst.getString(9));
		} catch (Exception e) {
		}finally {
			try {
				con.close();
			} catch (Exception e) {
			}
		}
		
	}
	//private void Information(int idD) {		
	//}
	
}
