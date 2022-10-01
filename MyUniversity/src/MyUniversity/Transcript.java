package MyUniversity;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.awt.event.ActionEvent;

public class Transcript extends JFrame {

	private JPanel contentPane;
	private JTable table;
	
	Connection con = null;
    PreparedStatement com = null;
    ResultSet rst = null; 
    int CountHour =0 ;
    int TOTAL = 0;
    
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Transcript frame = new Transcript();
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
	public Transcript() {
		setTitle("Transcript");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 837, 507);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(64, 224, 208));
		panel.setBounds(0, 0, 825, 61);
		contentPane.add(panel);
		
		JLabel lblNewLabel_1 = new JLabel("Öğrenci numarası :");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		JLabel id = new JLabel("");
		id.setForeground(Color.RED);
		id.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		JLabel lblNewLabel_1_2 = new JLabel("Öğrenci adı  :");
		lblNewLabel_1_2.setForeground(Color.BLACK);
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		JLabel name = new JLabel((String) null);
		name.setForeground(Color.RED);
		name.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		JButton btnNewButton = new JButton("Yazdır");
		btnNewButton.setForeground(Color.RED);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					table.print();
				} catch (PrinterException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(54)
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(id, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_1_2, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(name, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE)
					.addGap(47)
					.addComponent(btnNewButton)
					.addContainerGap(56, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(19, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnNewButton)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
							.addComponent(name, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lblNewLabel_1_2, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
							.addComponent(id, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
					.addGap(15))
		);
		panel.setLayout(gl_panel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 90, 801, 289);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"Ders kodu", "Ders ad\u0131", "Ders saatleri", "Y\u0131ll\u0131k", "Birikimli ", "Toplam", "HBN"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		
		JLabel lblNewLabel_1_1 = new JLabel("Dönem ortalaması :");
		lblNewLabel_1_1.setForeground(Color.RED);
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1_1.setBounds(62, 410, 155, 24);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel avg = new JLabel("");
		avg.setForeground(Color.RED);
		avg.setFont(new Font("Times New Roman", Font.BOLD, 18));
		avg.setBounds(221, 416, 135, 17);
		contentPane.add(avg);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("HBN  :");
		lblNewLabel_1_1_1.setForeground(Color.RED);
		lblNewLabel_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1_1_1.setBounds(526, 410, 62, 24);
		contentPane.add(lblNewLabel_1_1_1);
		
		JLabel great = new JLabel("");
		great.setForeground(Color.RED);
		great.setFont(new Font("Times New Roman", Font.BOLD, 18));
		great.setBounds(598, 416, 90, 17);
		contentPane.add(great);
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(4).setResizable(false);
		table.getColumnModel().getColumn(5).setResizable(false);
		table.getColumnModel().getColumn(6).setResizable(false);
		id.setText(Login.id);
		name.setText(Login.user);
		//Marks();
		con =ConnectionDataBase.Connet();
		DefaultTableModel model =(DefaultTableModel) table.getModel();
		  	try {
				com = con.prepareStatement("select* from RegisterStudentCourse where idS ='"+Integer.parseInt(Login.id)+"'");
		        rst = com.executeQuery();	
		        while(rst.next()) {
		        	int m1= Integer.parseInt(rst.getString("mark1"));
		        	int m2= Integer.parseInt(rst.getString("mark2"));
		        	int total = m1 + m2;
		        	String gr = HBN(total);
		        	int hour= Integer.parseInt(rst.getString("hour"));
		        	CountHour +=Integer.parseInt(rst.getString("hour")); 
		        	TOTAL +=(total * hour); 
       	model.addRow(new Object[] {rst.getString("idCourse"),rst.getString("nameC"),hour,m1,m2,total,gr});		        	
		        }
		        float avgD = TOTAL/CountHour;
		        avg.setText(avgD+"");
		        great.setText(HBN((int)avgD));
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					con.close();
				} catch (Exception e) {
				}
			}
		  	
	}
//
	
	public static String HBN(int total) {
		if(total >=95) {
			return "AA";
		}else if(total >= 80) {
			return "BA";
		}else if(total >= 70) {
			return "BB";
		}else if(total >= 65) {
			return "CB";
		}else if(total >= 60) {
			return "CC";			
		}else if(total >= 50) {
			return "DC";			
		}else {
			return "DD";

		}
		
	}
	
}
