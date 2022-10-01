package MyUniversity;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Avarge extends JFrame {

	private JPanel contentPane;
	 Connection con = null;
	    PreparedStatement com = null;
	    ResultSet rst = null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Avarge frame = new Avarge();
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
	public Avarge() {
		setIconImage(new ImageIcon(("src\\img\\GenelIcon.jpg")).getImage());

		setTitle("Birikmeli");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 516, 320);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(64, 224, 208));
		panel.setBounds(0, 0, 507, 61);
		contentPane.add(panel);
		
		JLabel lblNewLabel_1 = new JLabel("Öğrenci numarası :");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		JLabel id = new JLabel("------");
		id.setForeground(Color.RED);
		id.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		JLabel lblNewLabel_1_2 = new JLabel("Öğrenci adı :");
		lblNewLabel_1_2.setForeground(Color.BLACK);
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		JLabel name = new JLabel("-------");
		name.setForeground(Color.RED);
		name.setFont(new Font("Times New Roman", Font.BOLD, 18));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(17)
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(id, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
					.addGap(5)
					.addComponent(lblNewLabel_1_2)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(name, GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
					.addGap(24))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(24, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(id, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(name, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNewLabel_1_2, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
							.addGap(13)))
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 139, 139));
		panel_1.setBounds(0, 60, 500, 228);
		contentPane.add(panel_1);
		
		JLabel avg = new JLabel("------");
		avg.setForeground(Color.RED);
		avg.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		JLabel lblNewLabel_1_1 = new JLabel("Öğrencinin Birikmeli ortalaması :");
		lblNewLabel_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		JLabel lblNewLabel_1_2_1 = new JLabel("HBN :");
		lblNewLabel_1_2_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_2_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		JLabel grAvg = new JLabel("-------");
		grAvg.setForeground(Color.RED);
		grAvg.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("Başarılı saatleri :");
		lblNewLabel_1_2_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_2_1_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		JLabel n_S = new JLabel("-------");
		n_S.setForeground(Color.RED);
		n_S.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		JLabel lblNewLabel_1_2_1_1_1 = new JLabel("Başarısız saatleri :");
		lblNewLabel_1_2_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_2_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		JLabel n_F = new JLabel("-------");
		n_F.setForeground(Color.RED);
		n_F.setFont(new Font("Times New Roman", Font.BOLD, 18));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(26)
							.addComponent(lblNewLabel_1_2_1, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(25)
							.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 267, GroupLayout.PREFERRED_SIZE)
							.addGap(27)
							.addComponent(avg, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(27)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_1_2_1_1_1)
								.addComponent(lblNewLabel_1_2_1_1))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
									.addGap(8)
									.addComponent(n_F, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addGap(18)
									.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
										.addComponent(grAvg, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
										.addComponent(n_S, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE))))))
					.addContainerGap(92, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(30)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(7)
							.addComponent(avg, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(15)
							.addComponent(lblNewLabel_1_2_1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(18)
							.addComponent(grAvg, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)))
					.addGap(24)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1_2_1_1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(n_S, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(22)
							.addComponent(n_F, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(18)
							.addComponent(lblNewLabel_1_2_1_1_1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(212, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		id.setText(Login.id);
		name.setText(Login.user);
		//Info();
		

	//private void Info() {
		 con = ConnectionDataBase.Connet();
		 int Total= 0;
		 int hours = 0;
		 int CountFail =0;
			try {
				com =con.prepareStatement("select mark1,mark2,hour from RegisterStudentCourse where idS ='"+Integer.parseInt(Login.id)+"'");
				rst = com.executeQuery();
				while(rst.next()) {
					int sum = Integer.parseInt(rst.getString("mark1"))+ Integer.parseInt(rst.getString("mark2"));
					hours += Integer.parseInt(rst.getString("hour"));
					Total +=(sum *Integer.parseInt(rst.getString("hour")));	
					
					if(sum < 50) {
						CountFail +=Integer.parseInt(rst.getString("hour"));
						 
					}
					
					
				}
				avg.setText((double)(Total/hours)+"Saat");
                grAvg.setText(Transcript.HBN(Total/hours));
                n_S.setText(hours-CountFail+"Saat");
                n_F.setText(CountFail+"");

			} catch (SQLException e) {
				e.printStackTrace();
			}			
	}
}
