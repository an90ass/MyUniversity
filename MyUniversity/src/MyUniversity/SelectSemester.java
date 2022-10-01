package MyUniversity;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.sql.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class SelectSemester extends JFrame {

	private JPanel contentPane;
    private ButtonGroup bg = new ButtonGroup();
    Connection con = null;
    PreparedStatement com = null;
    ResultSet rst = null; 
    String sem ;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SelectSemester frame = new SelectSemester();
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
	public SelectSemester() {
		setIconImage(new ImageIcon(("src\\img\\GenelIcon.jpg")).getImage());

		StartRun();
		setTitle("D\u00F6nem se\u00E7");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 352, 213);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 206, 209));
		panel.setBounds(0, 0, 344, 52);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("D\u00F6nem se\u00E7");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 28));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(99)
					.addComponent(lblNewLabel)
					.addContainerGap(119, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap(18, Short.MAX_VALUE)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 139, 139));
		panel_1.setBounds(0, 51, 344, 123);
		contentPane.add(panel_1);
		
		JRadioButton bahar = new JRadioButton("Bahar");
		bahar.setForeground(new Color(0, 0, 255));
		bahar.setFont(new Font("Times New Roman", Font.BOLD, 15));
		
		JRadioButton guz = new JRadioButton("G\u00FCz");
		guz.setForeground(new Color(0, 0, 255));
		guz.setFont(new Font("Times New Roman", Font.BOLD, 15));
		
		JButton btnNewButton = new JButton("Kaydet");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(guz.isSelected()) {
				if(guz.getText().equals(sem)) {
					  JOptionPane.showMessageDialog(null,"Değişmesi mümkün değil çünkü gerçekten içinde bulunduğumuz dönem","",2);
				}else {
				UpdateGuz();	
				}
				}else if(bahar.isSelected()) {					
				if(bahar.getText().equals(sem)) {
					  JOptionPane.showMessageDialog(null,"Değişmesi mümkün değil çünkü gerçekten içinde bulunduğumuz dönem","",2);
				}else {
					UpdateBahar();	
				}
			}
			}
			private void UpdateGuz() {
		    	try {
					con =ConnectionDataBase.Connet();
					com = con.prepareStatement("Update Semester set first='1' , second= '0'");
		            com.execute();
					  JOptionPane.showMessageDialog(null,"Güz döneme başarıyla değiştirildii");
					  ManMenue.sem=1;
				} catch (SQLException e) {
				}finally {
					try {
						con.close();
					} catch (SQLException e) {
				}
			}
			}	
			
			private void UpdateBahar() {
				try {
					con =ConnectionDataBase.Connet();
					com = con.prepareStatement("Update Semester set first='0' , second= '1'");
		            com.execute();
					  JOptionPane.showMessageDialog(null,"Bahar döneme başarıyla değiştirildi");
					  ManMenue.sem=2;
				} catch (SQLException e) {
				}finally {
					try {
						con.close();
					} catch (SQLException e) {
				}
			}				
			}
		
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(74)
							.addComponent(guz)
							.addGap(64)
							.addComponent(bahar))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(111)
							.addComponent(btnNewButton)))
					.addContainerGap(90, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(29)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(bahar)
						.addComponent(guz))
					.addGap(18)
					.addComponent(btnNewButton)
					.addContainerGap(48, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		bg.add(bahar);
		bg.add(guz);
		try {
	   		 con =ConnectionDataBase.Connet();
				com = con.prepareStatement("select* from Semester");
		         rst = com.executeQuery();
		         rst.next();
		         if(Integer.parseInt(rst.getString(1)) ==1) {
		        	 sem = guz.getText();
		        	 guz.setSelected(true);
		         }else {
		        	 sem = bahar.getText();
		        	 bahar.setSelected(true);
		         }
			} catch (SQLException e) {
			}finally {
				try {
					con.close();
				} catch (SQLException e) {
				}	}
	
	}

	private void StartRun() {
	}
}
