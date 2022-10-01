package MyUniversity;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.sql.*;
import java.awt.event.ItemListener;
import java.awt.print.PrinterException;
import java.awt.event.ItemEvent;
import java.awt.Panel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class DisplayAllStudents extends JFrame {

	private JPanel contentPane;
	private JTable table;
	 Connection con = null;
	    PreparedStatement com = null;
	    ResultSet rst = null;  
	    boolean TrueFalse = false;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DisplayAllStudents frame = new DisplayAllStudents();
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
	@SuppressWarnings("unchecked")
	public DisplayAllStudents() {
		setIconImage(new ImageIcon(("src\\img\\GenelIcon.jpg")).getImage());

		setResizable(false);
		setTitle("Derse kay\u0131tl\u0131 \u00F6\u011Frencileri g\u00F6ster");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 572, 501);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox chooseCourse = new JComboBox();
		chooseCourse.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(TrueFalse) {
			    PreparedStatement com1 = null;
			    ResultSet  rst1 = null;
			    DefaultTableModel model = (DefaultTableModel) table.getModel();
			    model.setRowCount(0);
				 con =ConnectionDataBase.Connet();
					try {
						com = con.prepareStatement("select* from RegisterStudentCourse where nameC ='"+chooseCourse.getSelectedItem().toString()+"'");
						 rst = com.executeQuery();	
						 
				          while(rst.next()) {
				        	  int idStudent = Integer.parseInt(rst.getString(1));
					com1 = con.prepareStatement("select nameS from Student where id ='"+idStudent+"'");
					 rst1 = com1.executeQuery();	
					 rst1.next();
                      model.addRow(new Object[] {idStudent,rst1.getString("nameS"),rst.getString("mark1"),rst.getString("mark2")});
				          }
					} catch (SQLException e1) {
						e1.printStackTrace();
					}finally {
						try {
							con.close();
						} catch (SQLException e1) {
							e1.printStackTrace();
						}}
					}
			}
		});
		chooseCourse.setFont(new Font("Tahoma", Font.PLAIN, 13));
		chooseCourse.setBounds(128, 47, 169, 22);
		contentPane.add(chooseCourse);
		
		JLabel lblNewLabel = new JLabel("Dersi se\u00E7 :");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBounds(10, 45, 95, 22);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 96, 536, 306);
		contentPane.add(scrollPane_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane_1.setViewportView(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u00D6\u011Frenci Numaras\u0131", "\u00D6\u011Frenci Ad\u0131", "Y\u0131ll\u0131k", "Birikimli "
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(97);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(2).setPreferredWidth(40);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(3).setPreferredWidth(49);
	    
		JButton btnNewButton = new JButton("Yazd\u0131r");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					table.print();
				} catch (PrinterException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setForeground(new Color(255, 0, 0));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton.setBounds(431, 48, 89, 23);
		contentPane.add(btnNewButton);
	//	CoursesDoctor();
		try {
	  		 con =ConnectionDataBase.Connet();

	  		  String nameDoctor = Login.userD;
				com = con.prepareStatement("Select*from Course where nameD='"+nameDoctor+"'");
		          rst = com.executeQuery();	
		          while(rst.next()) {
		        	  chooseCourse.addItem(rst.getString("nameC"));
		          }
		          chooseCourse.setSelectedIndex(-1);	          		         
		          TrueFalse = true;
			} catch (SQLException e) {
			}finally {
				try {
					con.close();
			} catch (Exception e) {
				}
			}
	}
}
