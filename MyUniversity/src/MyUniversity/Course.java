package MyUniversity;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Course extends JFrame {
	private JPanel contentPane;
	private JTextField id;
	private JTextField nameDe;
	private JTextField hours;
	private JTextField salary;
	private JLabel lblSaatFiyat;
	private JLabel lblHocaAd;
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
					Course frame = new Course();
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
	public Course() {
		setIconImage(new ImageIcon(("src\\img\\GenelIcon.jpg")).getImage());

		setFont(new Font("Times New Roman", Font.PLAIN, 12));
		setResizable(false);
		setTitle("Ders Ekle");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 376, 444);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ders kodu :");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel.setBounds(22, 56, 79, 17);
		contentPane.add(lblNewLabel);
		
		id = new JTextField();
		
		id.setFont(new Font("Tahoma", Font.PLAIN, 13));
		id.setBounds(121, 55, 197, 17);
		contentPane.add(id);
		id.setColumns(10);
		
		JLabel lblDersAd = new JLabel("Ders ad\u0131 :");
		lblDersAd.setForeground(new Color(255, 255, 255));
		lblDersAd.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblDersAd.setBounds(22, 95, 79, 17);
		contentPane.add(lblDersAd);
		
		nameDe = new JTextField();
		nameDe.setFont(new Font("Tahoma", Font.PLAIN, 13));
		nameDe.setColumns(10);
		nameDe.setBounds(121, 93, 197, 17);
		contentPane.add(nameDe);
		
		JLabel lblSaatlarSays = new JLabel("Ders saatleri  :");
		lblSaatlarSays.setForeground(new Color(255, 255, 255));
		lblSaatlarSays.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblSaatlarSays.setBounds(19, 133, 99, 17);
		contentPane.add(lblSaatlarSays);
		
		hours = new JTextField();
		hours.setFont(new Font("Tahoma", Font.PLAIN, 13));
		hours.setColumns(10);
		hours.setBounds(118, 132, 197, 17);
		contentPane.add(hours);
		
		salary = new JTextField();
		salary.setFont(new Font("Tahoma", Font.PLAIN, 13));
		salary.setColumns(10);
		salary.setBounds(120, 170, 197, 17);
		contentPane.add(salary);
		
		lblSaatFiyat = new JLabel("Saat fiyat\u0131 :");
		lblSaatFiyat.setForeground(new Color(255, 255, 255));
		lblSaatFiyat.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblSaatFiyat.setBounds(21, 171, 79, 17);
		contentPane.add(lblSaatFiyat);
		
		lblHocaAd = new JLabel("Hoca ad\u0131 :");
		lblHocaAd.setForeground(new Color(255, 255, 255));
		lblHocaAd.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblHocaAd.setBounds(22, 211, 70, 17);
		contentPane.add(lblHocaAd);
		
		JComboBox nameDo = new JComboBox();
		nameDo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		nameDo.setBounds(121, 209, 197, 22);
		contentPane.add(nameDo);
		
		JLabel lblDnem = new JLabel("D\u00F6nem :");
		lblDnem.setForeground(new Color(255, 255, 255));
		lblDnem.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblDnem.setBounds(20, 255, 55, 17);
		contentPane.add(lblDnem);
		
		JRadioButton bahar = new JRadioButton("Bahar");
		bahar.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		bahar.setBounds(224, 253, 58, 22);
		contentPane.add(bahar);
		
		JRadioButton guz = new JRadioButton("G\u00FCz");
		guz.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		guz.setBounds(121, 253, 58, 23);
		contentPane.add(guz);
		
		JButton ADD = new JButton("");
		ADD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		ADD.setIcon(new ImageIcon("C:\\Users\\anass\\Downloads\\png-transparent-shutdown-computer-icons-reboot-computer-trademark-computer-share-icon (1) (1).png"));
		ADD.setBounds(224, 313, 70, 68);
		contentPane.add(ADD);
		id.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode() == e.VK_ENTER && choose ==2) {	
					if(id.getText().equals("")) {
						JOptionPane.showMessageDialog(null,"Lütfen Ders kodu giriniz !!","Boş",2);		
					}else {
						  try {
				          con =ConnectionDataBase.Connet();
				    	com = con.prepareStatement("select* from Course where idCourse ='"+Integer.parseInt(id.getText())+"'");
			            rst = com.executeQuery();
		            if(rst.next()) {
					            id.setEnabled(false);
					            
					            nameDe.setText(rst.getString(2));	
				            	nameDe.setEnabled(true);
				            	
				            	hours.setText(rst.getString(3));	
				            	hours.setEnabled(true);
					        

				            	salary.setText(rst.getString(5));	
				            	salary.setEnabled(true);
				            	
					            String nameDoctor = rst.getString(4);
					            nameDo.setEnabled(true);
					            //This step is after deleting a doctor
                                 if(nameDoctor.equals("")) {
                                	 nameDo.setSelectedIndex(-1);
                                 }else {
     					            nameDo.setSelectedItem(nameDoctor);
                                 }
					            guz.setEnabled(true);
					            bahar.setEnabled(true);
					            int sem = Integer.parseInt(rst.getString(6));
					            guz.setSelected(true);
					            if(sem ==2) {
					            	bahar.setSelected(true);
					            }
					            
					            }				            	
						  else {
						  JOptionPane.showMessageDialog(null,"Ders Kodu yoktur","yoktur",2 );
				            	}}						  
                catch (SQLException ex){               	
                }finally {	                	
                	try{
                	con.close();
                	}catch(SQLException ex){	                		
                	}
                }			
				}
		}}
			
					
			
		});
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(choose ==1) {
					Insert();
				}else if(choose ==2) {
					Update();
				}else {
					Delet();
				}
			}

			private void Insert() {
				//Check that no field is left blank

				String miss = (" Aşağıdaki verileri girmeyi unuttunuz !! "+"\n");			
                if(id.getText().equals("")) {
                	miss += "Öğrenci Numarası :" +"\n"; 	
                }
                if(nameDe.getText().equals("")) {
                	miss += "Ders adı :" +"\n"; 
                }
                if(hours.getText().equals("")) {
                    miss += "Ders saatleri :" +"\n";
                }
                if(salary.getText().equals("")) {
                    miss += "Saat fiyatı :" +"\n";
                }
                if(!bahar.isSelected() || !guz.isSelected()) {
                	miss += "Dönem :" +"\n"; 
                }	
                if(nameDo.getSelectedIndex()== -1) {
                	miss += "Hoca adı :" +"\n";
                }
                //donem(semster)
                int sem = 1;
            	if(bahar.isSelected()) {
            	sem = 2;
            	}
            if(!id.getText().equals("")&& !nameDe.getText().equals("")&& !hours.getText().equals("") && !salary.getText().equals("")&& nameDo.getSelectedIndex()!= -1 && (bahar.isSelected()|| guz.isSelected())) {
            	
		    	try {
		    		con =ConnectionDataBase.Connet();
	            	//Check if the dersKod number is in the dataBase or not
					com = con.prepareStatement("select*from Course where idCourse ='"+Integer.parseInt(id.getText())+"'");
					rst = com.executeQuery();
					//If the ders kodu(id) not exists, add the ders(lesson)
					if(!rst.next()) {
						con =ConnectionDataBase.Connet();
						com = con.prepareStatement("insert into Course values('"+Integer.parseInt(id.getText())+"','"+nameDe.getText()+"','"+Integer.parseInt(hours.getText())+"','"+nameDo.getSelectedItem()+"','"+Integer.parseInt(salary.getText())+"','"+sem+"')");
					   com.execute();
						JOptionPane.showMessageDialog(null,"Ders başarıyla eklendi","eklendi",JOptionPane.INFORMATION_MESSAGE );
                   Clear();
					}
					//	If the ders kodu(id) exists, do not add the ders(lesson)
					else {
						 JOptionPane.showMessageDialog(null,"Ders kodu daha önecden mevcuttur","mevcut",2 );	
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
            //
               
                					
			}

			private void Clear() {
     id.setText("");	
     nameDe.setText("");				
     salary.setText("");				
     hours.setText("");				
    nameDo.setSelectedIndex(-1);				
    
			}

			private void Update() {
				//Check that no field is left blank

				String miss = (" Aşağıdaki verileri girmeyi unuttunuz !! "+"\n");			

				 if(nameDe.getText().equals("")) {
	                	miss += "Ders adı :" +"\n"; 
	                }
	                if(hours.getText().equals("")) {
	                    miss += "Ders saatleri :" +"\n";
	                }
	                if(salary.getText().equals("")) {
	                    miss += "Saat fiyatı :" +"\n";
	                }
	                if(!bahar.isSelected() || !guz.isSelected()) {
	                	miss += "Dönem :" +"\n"; 
	                }	
	                if(nameDo.getSelectedIndex()== -1) {
	                	miss += "Hoca adı :" +"\n";
	                } 
	                int sem = 1;
	            	if(bahar.isSelected()) {
	            	sem = 2;
	            	}
	                if(!nameDe.getText().equals("")&& !hours.getText().equals("") && !salary.getText().equals("")&& nameDo.getSelectedIndex()!= -1 && (bahar.isSelected()|| guz.isSelected())) {
						try {
		                	con =ConnectionDataBase.Connet();
							com = con.prepareStatement("update Course set nameC ='"+nameDe.getText()+"', hour ='"+Integer.parseInt(hours.getText())+"',nameD ='"+nameDo.getSelectedItem()+"',salaryOneHour='"+Integer.parseInt(salary.getText())+"',semester ='"+sem+"' where idCourse='"+Integer.parseInt(id.getText())+"'");
						    com.execute();
				JOptionPane.showMessageDialog(null,"Ders başarıyla değiştirildi","değiştirildi",JOptionPane.INFORMATION_MESSAGE);
				  id.setEnabled(true);
				   nameDe.setEnabled(false);
				   salary.setEnabled(false);
				   hours.setEnabled(false);
				   nameDo.setEnabled(false);
				   bahar.setEnabled(false);
				   guz.setEnabled(false);
				   Clear();
						} 
						 catch (SQLException e) {
						}
	                }else {
	    				JOptionPane.showMessageDialog(null,miss,"Veriler kaybı etti",JOptionPane.ERROR_MESSAGE );  	
	                }
			}

			private void Delet() {
				//Check that no field is left blank

				String miss = (" Aşağıdaki verileri girmeyi unuttunuz !! "+"\n");	
				 if(nameDe.getText().equals("")) {
	                	miss += "Ders adı :" +"\n"; 
				 }
				 if(!id.getText().equals("")) {
				    	try {
				    		con =ConnectionDataBase.Connet();
			            	//Check if the dersKod number is in the dataBase or not
							com = con.prepareStatement("select*from Course where idCourse ='"+Integer.parseInt(id.getText())+"'");
							rst = com.executeQuery();
							//If the ders kodu(id) exists, do not delete the ders(lesson)
							if(rst.next()) {
								con =ConnectionDataBase.Connet();
								com = con.prepareStatement("delete from Course where idCourse ='"+Integer.parseInt(id.getText())+"'");
								   com.execute();
									JOptionPane.showMessageDialog(null,"Ders başarıyla silmiştir","silmiştir",JOptionPane.INFORMATION_MESSAGE );
			                   id.setText("");                           
						     	}//If the ders kodu(id) not exists, delete the ders(lesson)
							else {	
								 JOptionPane.showMessageDialog(null,"Ders kodu mevcut değildir","mevcut değildir",2 );
							}					
						} catch (SQLException e) {
						}finally {
							try {
								con.close();
							} catch (SQLException e) {
							} }									 
				 }else {
	    				JOptionPane.showMessageDialog(null,miss,"Veriler kaybı etti",JOptionPane.ERROR_MESSAGE );  	
	                }				
						}
			
		});
		btnNewButton_1.setForeground(Color.BLACK);
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\anass\\Downloads\\kisspng-grass-area-symbol-brand-sign-add-5ab0d6e7f2ac17.174482471521538791994 (1).jpg"));
		btnNewButton_1.setBounds(92, 313, 75, 69);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\anass\\Downloads\\653ffdcfebd7acebae53481f85af8ad8.jpg"));
		lblNewLabel_1.setBackground(new Color(0, 128, 128));
		lblNewLabel_1.setForeground(new Color(0, 128, 128));
		lblNewLabel_1.setBounds(0, 0, 360, 405);
		contentPane.add(lblNewLabel_1);
		//ButunGroup çünkü eclipsesd yok
		bg.add(bahar);
		bg.add(guz);
		choose = ManMenue.chC;
		if(choose ==2) {
			this.setTitle("Ders değiştir");
			btnNewButton_1.setIcon(new ImageIcon("src\\img\\deC.png"));
			nameDe.setEnabled(false);
			salary.setEnabled(false);
			hours.setEnabled(false);
			bahar.setEnabled(false);
			guz.setEnabled(false);
		}else if(choose ==3) {
			this.setTitle("Ders sil");
			btnNewButton_1.setIcon(new ImageIcon("src\\img\\silDers.png"));
			nameDe.setEnabled(false);
			salary.setEnabled(false);
			hours.setEnabled(false);
			bahar.setEnabled(false);
			guz.setEnabled(false);
			
		}
		
		//خطأ يطلع لكن ميثود شكل على اسويها اقدر 
		try {
			con =ConnectionDataBase.Connet();
			//Get all the names of the doctors from the dataBase to the interFace
			com = con.prepareStatement("select nameD from Doctor");
			rst = com.executeQuery();
			while(rst.next()) {
				nameDo.addItem(rst.getString("nameD"));
			}	
			nameDo.setSelectedIndex(-1);
		} catch (SQLException e) {
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
			}
		}
	}}
