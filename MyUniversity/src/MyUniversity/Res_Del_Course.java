package MyUniversity;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Component;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.LayoutStyle.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.text.ComponentView;

import java.awt.Scrollbar;
import java.awt.Dimension;
import javax.swing.DropMode;
import java.awt.ComponentOrientation;
import javax.swing.ListSelectionModel;
import java.sql.*;
import javax.swing.JScrollPane;

public class Res_Del_Course extends JFrame {
	Connection con = null;
    PreparedStatement com = null;
    ResultSet rst = null; 
     int val;
    private JTable table;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Res_Del_Course frame = new Res_Del_Course();
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
	public Res_Del_Course() {
		setIconImage(new ImageIcon(("src\\img\\GenelIcon.jpg")).getImage());

		//TableDataBase();
		setTitle("\u00D6\u011Frencinin dersini kaydetme veya silme");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 830, 521);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(64, 224, 208));
		panel.setBounds(0, 0, 814, 75);
		getContentPane().add(panel);
		
		JLabel lblNewLabel = new JLabel("\u00D6\u011Frencinin dersini kaydetme veya silme");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 28));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(118)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 520, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(176, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap(26, Short.MAX_VALUE)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		
		JButton res = new JButton("Kaydetme");
		
		res.setFont(new Font("Times New Roman", Font.BOLD, 20));
		res.setBounds(22, 84, 224, 25);
		getContentPane().add(res);
		
		JButton del = new JButton("Silme");
		
		del.setFont(new Font("Times New Roman", Font.BOLD, 20));
		del.setBounds(280, 86, 261, 25);
		getContentPane().add(del);
		
		JButton cancel = new JButton("\u0130ptal");
		
		cancel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		cancel.setEnabled(false);
		cancel.setBounds(573, 86, 231, 23);
		getContentPane().add(cancel);
		
		JButton inistal = new JButton("Yap");
		inistal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(inistal.getText().equals("Kaydetme Yap")) {
					InstallInsert();
				}else {
					InstallDelet();
				}
			}
			private void InstallInsert() {
		          con =ConnectionDataBase.Connet();
                try {
                	//To cross row by row To see all the rows
                     for (int row = 0; row< table.getRowCount();row++) {
                    	 //(row,0)         means get chekBox in the table
                    	 if(table.getModel().getValueAt(row,0).equals(true)) {                   	 
                    		 String nameC = table.getModel().getValueAt(row,2).toString();
                             //                                                       (where) means check if the student is registered for the lesson or not
 					  	com = con.prepareStatement("select* from RegisterStudentCourse where idS ='"+val+"' and nameC= '"+nameC+"'" );
			            rst = com.executeQuery();
                         if(!rst.next()) {
                    		 int idC = Integer.parseInt(table.getModel().getValueAt(row,1).toString());
                    		 String hour = table.getModel().getValueAt(row,3).toString();
                    		 String nameD = table.getModel().getValueAt(row,4).toString();

      		 	com = con.prepareStatement("insert into RegisterStudentCourse(idS,idCourse,nameC,hour,nameD,mark1,mark2) values('"+val+"' ,'"+idC+"', '"+nameC+"','"+hour+"','"+nameD+"','0','0')");
      		 	com.execute();
                         }
                    	 }						
					}
                     JOptionPane.showMessageDialog(null,"Başarıyla kaydetti");               	
                }catch(Exception e) {
                   JOptionPane.showMessageDialog(rootPane,e.getMessage());
					e.printStackTrace();
                }finally {
						try {
							con.close();
						} catch (SQLException e) {
							e.printStackTrace();
							}										
                }
			}

			private void InstallDelet() {
				 con =ConnectionDataBase.Connet();	
				 try {
	                	//To cross row by row To see all the rows
	                     for (int row = 0; row< table.getRowCount();row++) {
	                    	 //(row,0)         means get chekBox in the table
	                    	 if(table.getModel().getValueAt(row,0).equals(false)) {
	                    		 String nameC = table.getModel().getValueAt(row,2).toString();
	      	  	
					com = con.prepareStatement("delete from RegisterStudentCourse where idS ='"+val+"' and nameC= '"+nameC+"'");
	      		 	com.execute();
	                    	 }}
	                     JOptionPane.showMessageDialog(null," Başarıyla silmiştir");
	      	  	} catch (Exception e) {
					e.printStackTrace();
				}finally {
					try {
						con.close();
					} catch (Exception e) {
					}
				}

	                    	 				
			}
		});
		inistal.setEnabled(false);
		inistal.setFont(new Font("Times New Roman", Font.BOLD, 18));
		inistal.setBounds(299, 448, 198, 23);
		getContentPane().add(inistal);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 120, 782, 300);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setSelectionBackground(new Color(224, 255, 255));
		table.setBackground(new Color(64, 224, 208));
		table.setFont(new Font("Tahoma", Font.PLAIN, 13));
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Ders Se\u00E7me", "Ders Kodu", "Ders Ad\u0131", "Ders Saatleri", "Hoca"
			}
		) {
			Class[] columnTypes = new Class[] {
				Boolean.class, Object.class, Object.class, Object.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(4).setResizable(false);
		
		
		 res.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
					String value = JOptionPane.showInputDialog(null,"Lütfen öğrencinin numarası giriniz","Ders Kaydetme",JOptionPane.QUESTION_MESSAGE);
				       val = Integer.parseInt(value);
				    if(JOptionPane.OK_OPTION == 0) {
	                      int result = TableDataBase(val);
                         if(result ==1) {
				    	res.setEnabled(false);
				    	del.setEnabled(false);
				    	cancel.setEnabled(true);
				    	inistal.setEnabled(true);
                        inistal.setText("Kaydetme Yap");
                         }
				    }
					}catch(Exception ex){
				}}
			});
		 del.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						String value = JOptionPane.showInputDialog(null,"Lütfen öğrencinin numarası giriniz","Ders Silme",JOptionPane.QUESTION_MESSAGE);
					    int val = Integer.parseInt(value);
					    if(JOptionPane.OK_OPTION == 0) {
					    	  int result = DeletCourseFromStudrnt(val);
		                         if(result ==1) {
						    	res.setEnabled(false);
						    	del.setEnabled(false);
						    	cancel.setEnabled(true);
						    	inistal.setEnabled(true);				    	
	                        inistal.setText("Silme Yap");
					    }}
						}catch(Exception ex){					    	
					}}

						
			});
		 cancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					res.setEnabled(true);
			    	del.setEnabled(true);
			    	cancel.setEnabled(false);
			    	inistal.setEnabled(false);	
                    inistal.setText("Yap");
                   DefaultTableModel model1 = (DefaultTableModel) table.getModel();
                   model1.setRowCount(0);
				}
				
			});

			
	

		 
		
	
		 //ben yaptim eclipseden degil
		 table.getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer(){
			 public Component getTableCellRendererComponent(JTable Table,Object value,boolean isSelected,boolean hasFoucse,int row,int col) {
				 super.getTableCellRendererComponent(Table,value,isSelected,hasFoucse,row,col);
				 setBackground(Color.green); 
				 setFont(new Font(table.getFont().getFamily(),Table.getFont().getStyle(),15));

			return this;	 
			 }		 
		 });
	}
		 
		 
	

	public int TableDataBase(int id) {
		con =ConnectionDataBase.Connet();
			try {	
				//To find out if the student number is in the database or not
				com = con.prepareStatement("select* from Student where id ='"+id+"'");
		         rst = com.executeQuery();
	        	 if(rst.next()) {
				
		   		 int sem = ManMenue.sem;
					com = con.prepareStatement("select* from Course where semester ='"+sem+"'");
			         rst = com.executeQuery();
			         DefaultTableModel model =(DefaultTableModel)table.getModel();
			         while(rst.next()){
			        	 PreparedStatement  com1 = con.prepareStatement("select*from RegisterStudentCourse where idS ='"+id+"'and nameC='"+rst.getString(2)+"'");
			        	 ResultSet rst1=com1.executeQuery();
			        	 if(rst1.next()) {              //true,
				        	 model.addRow(new Object[]{true,rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4)}); 		 		        	 

			        	 } else {
			        		                           //false
				        	 model.addRow(new Object[]{false,rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4)}); 		 		        	 
			        	 }
			         }}else {
						  JOptionPane.showMessageDialog(null,"Öğrenci numarası yoktur","yoktur",2 );	
						  return 0;
			        	 }			         
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(rootPane,e.getMessage());
					e.printStackTrace();
				}finally {
						try {
							con.close();
						} catch (SQLException e) {
							e.printStackTrace();
							}		}
			return 1;																	
			}	
	
	
	
	private int DeletCourseFromStudrnt(int id) {
		con =ConnectionDataBase.Connet();	
        DefaultTableModel mod =(DefaultTableModel)table.getModel();
			try {
				//To find out if the student number is in the database or not
				com = con.prepareStatement("select* from Student where id ='"+id+"'");
		         rst = com.executeQuery();
		         if(rst.next()) {
		        	 //View all lessons recorded by the student
						com = con.prepareStatement("select* from RegisterStudentCourse where idS ='"+id+"'");
				         rst = com.executeQuery();
                          while(rst.next()) {
 		        	 mod.addRow(new Object[]{true,rst.getString("idCourse"),rst.getString("nameC"),rst.getString("hour"),rst.getString("nameD")}); 		 		        	 
   	  
                          }
		        	 
		         }else {
		        	 JOptionPane.showMessageDialog(null,"Öğrenci numarası yoktur","yoktur",2 );	
					  return 0;	 
		         }
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				try {
					con.close();
				} catch (SQLException e) {
				}
			}
        	 return 1;
        	 }
				
	}


/*
 * 	 try {		
			 con =ConnectionDataBase.Connet();
	   		 int sem = ManMenue.sem;
				com = con.prepareStatement("select* from Course where semester ='"+sem+"'");
		         rst = com.executeQuery();
		         DefaultTableModel model =(DefaultTableModel)table.getModel();
		         while(rst.next()){
		        	 model.addRow(new Object[]{rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4)}); 		 		        	 
		         }
			} catch (SQLException e) {}
		 
	}
 */
