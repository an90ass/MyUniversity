package MyUniversity;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.sql.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Doctor extends JFrame {

	private JPanel contentPane;
	private JTextField id;
	private JTextField name;
	private JTextField mobile;
	private JTextField address;
    private ButtonGroup bg = new ButtonGroup();
     int choose;
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
					Doctor frame = new Doctor();
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
	public Doctor() {
		setIconImage(new ImageIcon(("src\\img\\GenelIcon.jpg")).getImage());
		setTitle("E\u011Fitmen ekle");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 367, 435);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 128, 128));
		panel.setBounds(0, 0, 351, 396);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("");
		
		JLabel lblNewLabel_1 = new JLabel("Hoca Numaras\u0131 :");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		
		id = new JTextField();
		
		id.setFont(new Font("Dialog", Font.BOLD, 11));
		id.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Hoca ad\u0131 :");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		
		name = new JTextField();
		name.setFont(new Font("Tahoma", Font.PLAIN, 13));
		name.setColumns(10);
		
		JLabel lblNewLabel_1_2 = new JLabel("Telefon Numaras\u0131 :");
		lblNewLabel_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		
		mobile = new JTextField();
		mobile.setFont(new Font("Tahoma", Font.PLAIN, 13));
		mobile.setColumns(10);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Adres :");
		lblNewLabel_1_2_1.setForeground(Color.WHITE);
		lblNewLabel_1_2_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		
		address = new JTextField();
		address.setFont(new Font("Tahoma", Font.PLAIN, 13));
		address.setColumns(10);
		
		JLabel gender = new JLabel("Cinsiyet :");
		gender.setForeground(new Color(240, 248, 255));
		gender.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JRadioButton erkek = new JRadioButton("Erkek");
		erkek.setFont(new Font("Times New Roman", Font.BOLD, 11));
		
		JRadioButton kadin = new JRadioButton("Kadın");
		kadin.setFont(new Font("Times New Roman", Font.BOLD, 11));
		
		JButton ADD = new JButton("");
		ADD.setIcon(new ImageIcon("C:\\Users\\anass\\Desktop\\GitHub\\BSM103_ANASALMAQTARI\\MyUniversity\\src\\img\\docEkle (1).png"));
		
		
		id.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == e.VK_ENTER && choose ==2) {
					if(id.getText().equals("")) {
						JOptionPane.showMessageDialog(null,"Lütfen Hoca numarası giriniz","Boş",2);		
					}else {
						  try {
				          con =ConnectionDataBase.Connet();
				    	com = con.prepareStatement("select* from Doctor where id ='"+Integer.parseInt(id.getText())+"'");
			            rst = com.executeQuery();
		            if(rst.next()) {
					            id.setEnabled(false);
					            	// to show the data in the database
					            name.setText(rst.getString(2));	
				            	name.setEnabled(true);
 	
				            	 mobile.setText(rst.getString(4));	
					             mobile.setEnabled(true);	
					             
					             address.setText(rst.getString(5));	
					             address.setEnabled(true);
					             
					          String gender = rst.getString(6); 
					          erkek.setSelected(true);
					            if(kadin.getText().equals(gender)) {
					            	kadin.setSelected(true);
					            }
					            	erkek.setSelected(true);	  
					            kadin.setEnabled(true);
					            
					            }				            	
						  else {
						  JOptionPane.showMessageDialog(null,"Hoca numarası yoktur","yoktur",2 );
				            	}}
						  
                catch (SQLException ex){               	
                }finally {	                	
                	try{
                	con.close();
                	}catch(SQLException ex){	                		
                	}
                }			
					}				
				}	
			}
		});
		
		
		ADD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(choose==1) {
					Insert();
				}else if (choose ==2){
					Update();
				}else {
					Delet();
				}
				
				
			}

			private void Insert() {
				//Check that no field is left blank
				String miss = (" Aşağıdaki verileri girmeyi unuttunuz !! "+"\n");			
                if(id.getText().equals("")) {
                	miss += "Hoca Numarası :" +"\n"; 	
                }
                if(name.getText().equals("")) {
                	miss += "Hoca adı :" +"\n"; 
                }
                if(mobile.getText().equals("")) {
                    miss += "Telefon Numarası :" +"\n";
                }
                if(address.getText().equals("")) {
                    miss += "Saat fiyatı :" +"\n";
                }
                if(!erkek.isSelected() || !kadin.isSelected()) {
                	miss += "Cinsiyet :" +"\n"; 
                }	
                String gender = erkek.getText();
            	if(kadin.isSelected()) {
            	gender = kadin.getText();
            	}
           if(!id.getText().equals("")&& !name.getText().equals("")&& !mobile.getText().equals("") &&!address.getText().equals("") && (erkek.isSelected() || kadin.isSelected())) {     
				try {
		        	 con = ConnectionDataBase.Connet();
					com =con.prepareStatement("select*from Doctor where id ='"+Integer.parseInt(id.getText())+"'");
					rst = com.executeQuery();

					if(!rst.next()) {
						com = con.prepareStatement("Insert into Doctor values('"+Integer.parseInt(id.getText())+"','"+name.getText()+"','123','"+ mobile.getText()+"','"+address.getText()+"','"+gender+"')");					
						 com.execute();	
						JOptionPane.showMessageDialog(null,"Hoca başarıyla eklendi","eklendi",JOptionPane.INFORMATION_MESSAGE );	
						Clear();
					}
					else {
						  JOptionPane.showMessageDialog(null,"Hoca numarası daha önecden mevcuttur","mevcut",2 );						
					}
				} catch (SQLException e) {
				}finally {
					try {
						con.close();
					} catch (SQLException e) {
					}
				}          
           }else {
			JOptionPane.showMessageDialog(null,miss,"Veriler kaybı etti",JOptionPane.ERROR_MESSAGE );  	

           }
							
			}

			private void Clear() {
		         id.setText("");
		         name.setText("");
		         mobile.setText("");
		         address.setText("");
		         erkek.setSelected(false);
		         kadin.setSelected(false);

			}

			private void Update() {
				//Check that no field is left blank
				String miss = (" Aşağıdaki verileri girmeyi unuttunuz !! "+"\n");			
                if(name.getText().equals("")) {
                	miss += "Hoca adı :" +"\n"; 
                }
                if(mobile.getText().equals("")) {
                    miss += "Telefon Numarası :" +"\n";
                }
                if(address.getText().equals("")) {
                    miss += "Saat fiyatı :" +"\n";
                }
                if(!erkek.isSelected() || !kadin.isSelected()) {
                	miss += "Cinsiyet :" +"\n"; 
                }	
                String gender = erkek.getText();
            	if(erkek.isSelected()) {
            	gender = kadin.getText();
            	}
            	String gen = erkek.getText();
            	if(kadin.isSelected()) {
            		gen = kadin.getText();
            	}
           if(!name.getText().equals("")&& !mobile.getText().equals("") &&!address.getText().equals("") &&(erkek.isSelected()|| kadin.isSelected())) {     
				try {
		            con =ConnectionDataBase.Connet();
					com = con.prepareStatement("Update Doctor set nameD ='"+name.getText()+"',mobile='"+mobile.getText()+"', address='"+address.getText()+"', gender='"+gen+"'where id ='"+Integer.parseInt(id.getText())+"'");
		            com.execute();
			    	JOptionPane.showMessageDialog(null,"Hoca başarıyla değiştirildi","değiştirildi",JOptionPane.INFORMATION_MESSAGE);
                    Clear();
                    id.setEnabled(true);
                    name.setEnabled(false);
                    mobile.setEnabled(false);
                    address.setEnabled(false);
                    erkek.setEnabled(false);
                    kadin.setEnabled(false);

				}catch (SQLException e) {
				}finally {
					try {
						con.close();
					} catch (SQLException e) {
					}
				}
        	   
        	   
           }else {
			JOptionPane.showMessageDialog(null,miss,"Veriler kaybı etti",JOptionPane.ERROR_MESSAGE );  	

           }
											
			}

			private void Delet() {
				//Check that no field is left blank
				String miss = (" Aşağıdaki verileri girmeyi unuttunuz !! "+"\n");			
                if(id.getText().equals("")) {
                	miss += "Hoca Numarası :" +"\n"; 	
                }
                         	
           if(!id.getText().equals("")) {     
        	   try {
		        	 con = ConnectionDataBase.Connet();
					com =con.prepareStatement("select*from Doctor where id ='"+Integer.parseInt(id.getText())+"'");
					rst = com.executeQuery();

					if(rst.next()) {
						String doctor = rst.getString("nameD");
						 //Delete the doctor's name from the lesson only
							com =con.prepareStatement("select*from Course where nameD ='"+doctor+"'");
							rst=com.executeQuery();
						 while(rst.next()) {
					 //In order to reach all the lessons registered in the name of the doctor whose name we want to delete
							 //هنا الماده من الدكتور اسم حذف عدم خطأ 
					com =con.prepareStatement("Update Course set nameD = '' where nameD = '"+doctor+"'");
                    com.execute();							 
						 }
					com =con.prepareStatement("Delete from Doctor where id ='"+Integer.parseInt(id.getText())+"'");
                    com.execute();							 
					JOptionPane.showMessageDialog(null,"Hoca başarıyla silmiştir","silmiştir",JOptionPane.INFORMATION_MESSAGE );
					id.setText("");
					}
					else {
						  JOptionPane.showMessageDialog(null,"Hoca numarası daha önecden mevcuttur","mevcut",2 );
					}
				} catch (SQLException e) {
				}finally {
					try {
						con.close();
					} catch (SQLException e) {
					}}}
           else {
			JOptionPane.showMessageDialog(null,miss,"Veriler kaybı etti",JOptionPane.ERROR_MESSAGE );  	

           }
											
			}
		});
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\anass\\Downloads\\png-transparent-shutdown-computer-icons-reboot-computer-trademark-computer-share-icon (1) (1).png"));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(28)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNewLabel_1_2)
										.addComponent(lblNewLabel_1_2_1)
										.addComponent(gender, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)))
								.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_1_1))
							.addGap(18)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
								.addComponent(name)
								.addComponent(mobile)
								.addComponent(address)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(erkek, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
									.addGap(28)
									.addComponent(kadin, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE))
								.addComponent(id, Alignment.TRAILING))
							.addGap(212)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(86)
							.addComponent(ADD, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
							.addGap(47)
							.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(51)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
							.addComponent(id, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(name, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel_1_2, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(mobile, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1_2_1, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(address, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
					.addGap(35)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(gender, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(erkek)
						.addComponent(kadin))
					.addGap(30)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(ADD, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
							.addGap(1)))
					.addContainerGap(46, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		bg.add(erkek);
		bg.add(kadin);
		choose = ManMenue.chD;
		
		if(choose == 2) {
			this.setTitle("Eğitmen değiştir");
			ADD.setIcon(new ImageIcon("src\\img\\deDo.png"));
			name.setEnabled(false);
			address.setEnabled(false);
			mobile.setEnabled(false);
			erkek.setEnabled(false);
			kadin.setEnabled(false);
		}else if(choose ==3) {
			this.setTitle("Eğitmen sil");
			ADD.setIcon(new ImageIcon("src\\img\\silDers.png"));
			name.setEnabled(false);
			address.setEnabled(false);
			mobile.setEnabled(false);
			erkek.setEnabled(false);
			kadin.setEnabled(false);
			
		}

	}
}
