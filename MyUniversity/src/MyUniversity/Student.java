package MyUniversity;

//import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JRadioButton;
import java.awt.Button;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Label;
import java.awt.Color;
import java.sql.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Student extends JFrame {

	private JPanel Ogrenciekle;
	private JTextField id;
	private JTextField name;
	private JTextField mobile;
	private JLabel gender;
    private ButtonGroup bg = new ButtonGroup();
	/**
	 * Launch the application.
	 */
    int choose;
    Connection con = null;
    PreparedStatement com = null;
    ResultSet rst = null;    
    
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Student frame = new Student();
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
	public Student() {
		setIconImage(new ImageIcon(("src\\img\\GenelIcon.jpg")).getImage());

		setTitle("\u00D6\u011Frenci ekleme");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 362, 356);
		Ogrenciekle = new JPanel();
		Ogrenciekle.setToolTipText("Ogrenciekle");
		Ogrenciekle.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(Ogrenciekle);
		
		id = new JTextField();
		
		id.setBounds(181, 31, 139, 20);
		id.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\u00D6\u011Frenci Numaras\u0131 :");
		lblNewLabel.setForeground(new Color(240, 248, 255));
		lblNewLabel.setBounds(40, 34, 131, 17);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel lblAdSoyad = new JLabel("Ad Soyad :");
		lblAdSoyad.setForeground(new Color(240, 248, 255));
		lblAdSoyad.setBounds(40, 72, 75, 17);
		lblAdSoyad.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		name = new JTextField();
		name.setBounds(179, 72, 141, 20);
		name.setColumns(10);
		
		mobile = new JTextField();
		mobile.setBounds(179, 113, 141, 20);
		mobile.setColumns(10);
		
		JLabel lblTelefonNumaras = new JLabel("Telefon Numaras\u0131 :");
		lblTelefonNumaras.setForeground(new Color(240, 248, 255));
		lblTelefonNumaras.setBounds(40, 113, 129, 17);
		lblTelefonNumaras.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JRadioButton erkek = new JRadioButton("Erkek");
		erkek.setBounds(136, 151, 55, 23);
		erkek.setFont(new Font("Tahoma", Font.ITALIC, 12));
		
		//ButtonGroup
		bg.add(erkek);
		
		JRadioButton kadin = new JRadioButton("Kad\u0131n");
		kadin.setBounds(225, 151, 55, 23);
		kadin.setFont(new Font("Tahoma", Font.ITALIC, 12));
		bg.add(kadin);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setBounds(207, 203, 75, 79);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\anass\\Downloads\\png-transparent-shutdown-computer-icons-reboot-computer-trademark-computer-share-icon (1) (1).png"));
		
		JButton ADD = new JButton("");
		ADD.setBounds(62, 203, 79, 79);
		ADD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(choose == 1) {
					insert();
				}else if(choose ==2) {
					Update();	
				}else {
					delet();				
				}
			}

			
			
			
			
			
			private void delet() {
				String miss = (" Aşağıdaki verileri girmeyi unuttunuz !! "+"\n");			
                if(id.getText().equals("")) {
                	miss += "Öğrenci Numarası :" +"\n"; 	
                }if(!id.getText().equals("")) {
			    	try {
	                	con =ConnectionDataBase.Connet();
				    	com = con.prepareStatement("delete from Student where id ='"+Integer.parseInt(id.getText())+"'");
						com.execute();
			    	JOptionPane.showMessageDialog(null,"Öğrenci başarıyla silmiş","silmiş",JOptionPane.INFORMATION_MESSAGE);
			    	id.setText("");
			    	} catch (SQLException e) {
			    	}finally {
			    		try {
							con.close();
						} catch (SQLException e) {
							e.printStackTrace();
						}
			    	}
                
                } else {
					JOptionPane.showMessageDialog(null,miss,"Veriler kaybı etti",JOptionPane.ERROR_MESSAGE );				
			}
			}
			
			
			private void Update() {			
				String miss = (" Aşağıdaki verileri girmeyi unuttunuz !! "+"\n");			
				if(name.getText().equals("")) {
                	miss += "Ad Soyad :" +"\n"; 
                }
                if(mobile.getText().equals("")) {
                miss += "Telefon Numarası :" +"\n";
                }
                if(!erkek.isSelected() || !kadin.isSelected()) {
                	miss += "Cinsiyet :"+"\n";
               }         
                if(!name.getText().equals("")&& !mobile.getText().equals("")  && (erkek.isSelected()|| kadin.isSelected())) {
			    	try {
			    		 String gender = erkek.getText();
			            	if(kadin.isSelected()) {
			            	gender = kadin.getText();
			            	}
	                	con =ConnectionDataBase.Connet();
						com = con.prepareStatement("Update Student set nameS ='"+name.getText()+"', mobile='"+mobile.getText()+"', gender ='"+gender+"'where id='"+Integer.parseInt(id.getText())+"'");
						com.execute();
			    	JOptionPane.showMessageDialog(null,"Öğrenci başarıyla değiştirildi","değiştirildi",JOptionPane.INFORMATION_MESSAGE);
			   
			   id.setEnabled(true);
			   name.setEnabled(false);
			   mobile.setEnabled(false);
			   erkek.setEnabled(false);
			   kadin.setEnabled(false);
			   Clear();
			    	} catch (SQLException e) {
						e.printStackTrace();

					}finally {
						try {
							con.close();
						} catch (SQLException e) {
							e.printStackTrace();

						}
					}           
                }else {
					JOptionPane.showMessageDialog(null,miss,"Veriler kaybı etti",JOptionPane.ERROR_MESSAGE );			
			}}

			
			
			
			
			
			
			
			
			private void insert() {

				String miss = (" Aşağıdaki verileri girmeyi unuttunuz !! "+"\n");			
                if(id.getText().equals("")) {
                	miss += "Öğrenci Numarası :" +"\n"; 	
                }
                if(name.getText().equals("")) {
                	miss += "Ad Soyad :" +"\n"; 
                }
                if(mobile.getText().equals("")) {
                miss += "Telefon Numarası :" +"\n";
                }
                if(!erkek.isSelected() || !kadin.isSelected()) {
                	miss += "Cinsiyet :" +"\n"; 
                	
                	
                	
                }if(!id.getText().equals("")&& !name.getText().equals("")&& !mobile.getText().equals("") && (erkek.isSelected()|| kadin.isSelected())) {
             //To make a connection to transfer data
   	          try {
   	   	          con = ConnectionDataBase.Connet();
				com =con.prepareStatement("select*from Student where id ='"+Integer.parseInt(id.getText())+"'");
				rst = com.executeQuery();
				//Check if the student's information already exists or not in order to add
				String Gender = erkek.getText();
            	if(kadin.isSelected()) {
            	Gender = kadin.getText();               
            	}
            	
				if(rst.next()) {
					  JOptionPane.showMessageDialog(null,"Öğrenci numarası daha önecden mevcuttur","mevcut",2 );

				}				
				else {					
					 com = con.prepareStatement("Insert into Student values('"+Integer.parseInt(id.getText())+"','"+name.getText()+"','123','"+ mobile.getText()+"','0','0','0','0','"+Gender+"')");					
					 com.execute();	
						JOptionPane.showMessageDialog(null,"Öğrenci başarıyla eklendi","eklendi",JOptionPane.INFORMATION_MESSAGE );
					// to clean the fields
			          Clear();		
				}	

			}   catch (SQLException e) {
				e.printStackTrace();
			}
   	          //to close the database
               finally {
            	   try {
					con.close();
				} catch (SQLException e) {
		
				}
               }
                }else {
					JOptionPane.showMessageDialog(null,miss,"Veriler kaybı etti",JOptionPane.ERROR_MESSAGE );  	
                }
			}
         //To delete information from the interface after displaying student information on it	
			private void Clear() {
         id.setText("");
         name.setText("");
         mobile.setText("");
         erkek.setSelected(false);
         kadin.setSelected(false);

         
         
			}
		});
		ADD.setIcon(new ImageIcon("C:\\Users\\anass\\Downloads\\png-transparent-computer-icons-user-icon-design-login-others-miscellaneous-face-hand (1) (1).png"));
		
		gender = new JLabel("Cinsiyet :");
		gender.setForeground(new Color(240, 248, 255));
		gender.setBounds(40, 153, 63, 17);
		gender.setFont(new Font("Tahoma", Font.BOLD, 14));
		Ogrenciekle.setLayout(null);
		Ogrenciekle.add(lblNewLabel);
		Ogrenciekle.add(id);
		Ogrenciekle.add(lblAdSoyad);
		Ogrenciekle.add(name);
		Ogrenciekle.add(lblTelefonNumaras);
		Ogrenciekle.add(mobile);
		Ogrenciekle.add(gender);
		Ogrenciekle.add(erkek);
		Ogrenciekle.add(kadin);
		Ogrenciekle.add(ADD);
		Ogrenciekle.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\anass\\Downloads\\653ffdcfebd7acebae53481f85af8ad8.jpg"));
		lblNewLabel_1.setBounds(0, 0, 354, 327);
		Ogrenciekle.add(lblNewLabel_1);
		
			
		//Change the interface properties according to the chosen function
		choose = ManMenue.ch;
		if(choose == 2) {
			this.setTitle("Öğrenci değiştir");
			ADD.setIcon(new ImageIcon("src\\img\\dd.png"));
			name.setEnabled(false);
			name.setEnabled(false);
			mobile.setEnabled(false);
			erkek.setEnabled(false);
			kadin.setEnabled(false);
		}
		if (choose ==3) {
			this.setTitle("Öğrenci sil");
			ADD.setIcon(new ImageIcon("src\\img\\silS2.png"));
			name.setEnabled(false);
			name.setEnabled(false);
			mobile.setEnabled(false);
			erkek.setEnabled(false);
			kadin.setEnabled(false);
		}
		
		
		//To display the student's data when you press Enter
		id.addKeyListener(new KeyAdapter() {	
			public void keyPressed(KeyEvent e) {
					if(e.getKeyCode() == e.VK_ENTER && choose ==2) {
						if(id.getText().equals("")) {
							JOptionPane.showMessageDialog(null,"Lütfen Kimlik numarası giriniz","Boş",2);		
						}else {
							  try {
					          con =ConnectionDataBase.Connet();
					    	com = con.prepareStatement("select* from Student where id ='"+Integer.parseInt(id.getText())+"'");
				            rst = com.executeQuery();
			            if(rst.next()) {
						            	id.setEnabled(false);
						            	// to show the data in the database
						            name.setText(rst.getString(2));	
					            	name.setEnabled(true);
	 	
					            	 mobile.setText(rst.getString(4));	
						             mobile.setEnabled(true);	
						             
						             String gender = rst.getString(5); 	
						            if(gender.equals(kadin.getText())) {
						            	kadin.setSelected(true);
						            }else {
						            	erkek.setSelected(true);	  
						             erkek.setEnabled(true);
						            kadin.setEnabled(true);
						            }
						            }				            	
							  else {
							  JOptionPane.showMessageDialog(null,"Öğrenci numarası yoktur","yoktur",2 );
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

	}
}
