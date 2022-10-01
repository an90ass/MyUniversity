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
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Res_Course_Student extends JFrame {

	private JPanel contentPane;
	private JTable table;
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
					Res_Course_Student frame = new Res_Course_Student();
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
	public Res_Course_Student() {
		setTitle("Dersi seçimi");
		setIconImage(new ImageIcon(("src\\img\\GenelIcon.jpg")).getImage());

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 841, 489);
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
		
		JLabel id = new JLabel("----------");
		id.setForeground(Color.RED);
		id.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		JLabel lblNewLabel_1_2 = new JLabel("Öğrenci adı  :");
		lblNewLabel_1_2.setForeground(Color.BLACK);
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		JLabel name = new JLabel("----------");
		name.setForeground(Color.RED);
		name.setFont(new Font("Times New Roman", Font.BOLD, 18));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(28)
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(id, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
					.addGap(22)
					.addComponent(lblNewLabel_1_2, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(name, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(172, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(22, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_1_2, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addComponent(name, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
							.addGap(14))
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(id, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE))
							.addGap(15))))
		);
		panel.setLayout(gl_panel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(31, 72, 747, 276);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setBackground(new Color(255, 255, 255));
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{Boolean.FALSE, null, null, null, null},
				{Boolean.FALSE, null, null, null, null},
				{Boolean.FALSE, null, null, null, null},
				{Boolean.FALSE, null, null, null, null},
			},
			new String[] {
				"Ders se\u00E7imi", "Ders kodu", "Ders ad\u0131", "Ders saatleri", "Hoca"
			}
		) {
			Class[] columnTypes = new Class[] {
				Boolean.class, Object.class, Object.class, Object.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		
		JButton btnNewButton = new JButton("Kaydet");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				con =ConnectionDataBase.Connet();
                try {
                	//To cross row by row To see all the rows
                     for (int row = 0; row< table.getRowCount();row++) {
                    	 //(row,0)         means get chekBox in the table
                    	 if(table.getModel().getValueAt(row,0).equals(true)) {                   	 
                    		 String nameC = table.getModel().getValueAt(row,2).toString();
                             //                                                       (where) means check if the student is registered for the lesson or not
 					  	com = con.prepareStatement("select* from RegisterStudentCourse where idS ='"+Login.id+"' and nameC= '"+nameC+"'" );
			            rst = com.executeQuery();
                         if(!rst.next()) {
                    		 int idC = Integer.parseInt(table.getModel().getValueAt(row,1).toString());
                    		 String hour = table.getModel().getValueAt(row,3).toString();
                    		 String nameD = table.getModel().getValueAt(row,4).toString();

      		 	com = con.prepareStatement("insert into RegisterStudentCourse(idS,idCourse,nameC,hour,nameD,mark1,mark2) values('"+Login.id+"' ,'"+idC+"', '"+nameC+"','"+hour+"','"+nameD+"','0','0')");
      		 	com.execute();
                         }
                    	 }						
					}
                     JOptionPane.showMessageDialog(null,"Başarıyla kaydetti");    
                     setVisible(false);
                }catch(Exception ex) {
                   JOptionPane.showMessageDialog(rootPane,ex.getMessage());
					ex.printStackTrace();
                }finally {
						try {
							con.close();
						} catch (SQLException ex) {
							ex.printStackTrace();
							}										
                }
			}
		});
		btnNewButton.setForeground(Color.RED);
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnNewButton.setBounds(358, 398, 107, 29);
		contentPane.add(btnNewButton);
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(15);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(15);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(2).setPreferredWidth(61);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(3).setPreferredWidth(15);
		table.getColumnModel().getColumn(4).setResizable(false);
		table.getColumnModel().getColumn(4).setPreferredWidth(15);
		
		//In order to display the student's name and student number the first time the student enters
		id.setText(Login.id);
		name.setText(Login.user);
		DisaplayCourse();

	}

	private void DisaplayCourse() {
		con =ConnectionDataBase.Connet();
		 PreparedStatement com1 = null;
		    ResultSet rst1 = null;
	        DefaultTableModel model = (DefaultTableModel) table.getModel();
		try {
			//In order to show the lessons of the selected semester only
			com = con.prepareStatement("select* from Course where semester ='"+ManMenue.sem+"'");
	        rst = com.executeQuery();
	        while(rst.next()) {
	        	//To check whether the student is enrolled in this lesson or not
				com1 = con.prepareStatement("select* from RegisterStudentCourse where idS ='"+Login.id+"' and nameC='"+rst.getString("nameC")+"'");
		        rst1 = com1.executeQuery();
               if(rst1.next()) {
            	   model.addRow(new Object[] {true,rst.getString("idCourse"),rst.getString("nameC"),rst.getString("hour"),rst.getString("nameD")});
               }else {
            	   model.addRow(new Object[] {false,rst.getString("idCourse"),rst.getString("nameC"),rst.getString("hour"),rst.getString("nameD")}); 
               }	        	
	        }
		} catch (SQLException e) {
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
			}
		}
	}
}
