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
import javax.swing.JTextField;
import java.awt.Font;
import java.sql.*;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddMarkStudent extends JFrame {

	private JPanel contentPane;
	private JTextField mark1;
	private JTextField mark2;
 int ID;
 Connection con = null;
 PreparedStatement com = null;
 ResultSet rst = null; 
 boolean TrueFalse = false ;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddMarkStudent frame = new AddMarkStudent();
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
	public AddMarkStudent() {
		setIconImage(new ImageIcon(("src\\img\\GenelIcon.jpg")).getImage());

		setTitle("Puan ekle");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 496, 313);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(64, 224, 208));
		panel.setBounds(0, 0, 487, 61);
		contentPane.add(panel);
		
		JLabel lblNewLabel_1 = new JLabel("\u00D6\u011Frenci numaras\u0131 :");
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		JLabel id = new JLabel("----------");
		id.setForeground(new Color(255, 0, 0));
		id.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		JLabel name = new JLabel("----------");
		name.setForeground(new Color(255, 0, 0));
		name.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		JLabel lblNewLabel_1_2 = new JLabel("\u00D6\u011Frenci ad\u0131  :");
		lblNewLabel_1_2.setForeground(Color.BLACK);
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.BOLD, 18));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(28)
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(id)
					.addGap(24)
					.addComponent(lblNewLabel_1_2, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(name)
					.addContainerGap(75, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(22)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1_2, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(name, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(15, Short.MAX_VALUE))
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(22, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(id, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
					.addGap(15))
		);
		JComboBox chooseCourse = new JComboBox();
		panel.setLayout(gl_panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 139, 139));
		panel_1.setBounds(0, 59, 487, 215);
		contentPane.add(panel_1);
		
		JLabel lblNewLabel_1_3 = new JLabel("Y\u0131ll\u0131k  :");
		lblNewLabel_1_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_3.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		JLabel lblNewLabel_1_3_1 = new JLabel("Birikimli :");
		lblNewLabel_1_3_1.setForeground(Color.WHITE);
		lblNewLabel_1_3_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		mark1 = new JTextField();
		mark1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		mark1.setColumns(10);
		
		mark2 = new JTextField();
		mark2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		mark2.setColumns(10);
		
		JButton btnNewButton = new JButton("Kaydet");
		
	//In order to change or add a mark for the student according to the student number and the name of the chosen course
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int m1=0,m2=0;
				if(!mark1.getText().equals("")){
					m1= Integer.parseInt(mark1.getText());
				} if(!mark2.getText().equals("")){
					m2= Integer.parseInt(mark2.getText());
				}
				con =ConnectionDataBase.Connet();
				try {
					com = con.prepareStatement("Update RegisterStudentCourse set mark1 ='"+m1+"', mark2 ='"+m2+"' where idS='"+ID+"'and nameC='"+chooseCourse.getSelectedItem().toString()+"'");
				    com.execute();
			    	JOptionPane.showMessageDialog(null,"Öğrenci puanı başarıyla eklendi","eklendi",JOptionPane.INFORMATION_MESSAGE);
                    
			    	mark1.setText("");
                    mark2.setText("");
                    
                    mark1.setEnabled(false);
                    mark2.setEnabled(false);
  		          chooseCourse.setSelectedIndex(-1);	

				} catch (SQLException e1) {
				}finally {
					try {
						con.close();				
					}catch (SQLException e1) {			
					}}
			}
		});
		//
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
	//In order to display the student's scores already in the database
		chooseCourse.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(TrueFalse && chooseCourse.getSelectedIndex() !=-1 ) {
					con =ConnectionDataBase.Connet();
					try {
						com = con.prepareStatement("select mark1, mark2 from RegisterStudentCourse where nameC ='"+chooseCourse.getSelectedItem().toString()+"' and idS ='"+ID+"'");
						 rst = com.executeQuery();	
						 
				          if(rst.next()) {
                                 mark1.setText(rst.getString("mark1"));	
                                 mark2.setText(rst.getString("mark2"));	

                                 mark1.setEnabled(true);
                                 mark2.setEnabled(true);

				          }} catch (SQLException e1) {
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
		//
		chooseCourse.setSelectedIndex(-1);
		chooseCourse.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblNewLabel = new JLabel("Dersi se\u00E7 :");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(23)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(1)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(chooseCourse, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(lblNewLabel_1_3)
									.addGap(50)
									.addComponent(mark1, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.RELATED, 44, Short.MAX_VALUE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(lblNewLabel_1_3_1, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
							.addGap(29)
							.addComponent(mark2, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 44, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, 181, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(176, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
					.addGap(21)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(chooseCourse, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(lblNewLabel_1_3, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
							.addGap(13)
							.addComponent(lblNewLabel_1_3_1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(3)
							.addComponent(mark1, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
							.addGap(22)
							.addComponent(mark2, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)))
					.addGap(23)
					.addComponent(btnNewButton)
					.addGap(23))
		);
		panel_1.setLayout(gl_panel_1);
		String idSt = JOptionPane.showInputDialog(null,"Kimlik numarası giriniz","",2);
        ID = Integer.parseInt(idSt);
        //INFO();
        //To make sure that the student is in the database or not, and if there is, his name and student number appear
    	con =ConnectionDataBase.Connet();
    	try {
			com = con.prepareStatement("select nameS from Student where id ='"+ID+"'");
			rst = com.executeQuery();
			rst = com.executeQuery();
            if(rst.next()) {
            	id.setText(ID+"");
    			name.setText(rst.getString("nameS"));
    			setVisible(true);
            }else{
				  JOptionPane.showMessageDialog(null,"Öğrenci numarası daha önceden yoktur","yoktur",2 );
	    			setVisible(false);
            }			
 		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
    	//
    	
    	
    	//In order to fill the comobox with the lessons recorded for the student whose doctor entered his number (display the mark for the lesson followed by the doctor who registered in the login)
    	//CoursesDoctor();
    	try {
	  		 con =ConnectionDataBase.Connet();
	  	    PreparedStatement com1= null;
	  	    ResultSet rst1 = null;    

	  		  String nameDoctor = Login.userD;
				com = con.prepareStatement("Select*from Course where nameD='"+nameDoctor+"'");
		          rst = com.executeQuery();	
		          while(rst.next()) {
		        	  //To check whether the student is enrolled in this lesson or not
					com1 = con.prepareStatement("Select*from RegisterStudentCourse where idS='"+ID+"' and nameC='"+rst.getString("nameC")+"'");
			          rst1 = com.executeQuery();	
			          if(rst1.next()) {
			        	  chooseCourse.addItem(rst.getString("nameC"));
			          }		        	  
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
//I could not write the code above inside these methods because it shows an error
	/*private void CoursesDoctor() {			
	}
	
	private void INFO() {	
}*/
	
}
