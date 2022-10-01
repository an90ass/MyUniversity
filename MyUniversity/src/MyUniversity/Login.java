package MyUniversity;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.EtchedBorder;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
//To fetch the database
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Login extends JFrame {
	private JTextField idOname;
	private JPanel contentPane;
    private JCheckBox jCheckBox;
    private JPasswordField pass;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	//Define tasks for each user
       static String id ="";
       static String user;
       static String userD;
       Connection con = null;
       PreparedStatement com = null;
       ResultSet rst = null;
       //ManMenue manmenu = new ManMenue();
	/**
	 * Create the frame.
	 */
	public Login() {
		setIconImage(new ImageIcon(("src\\img\\GenelIcon.jpg")).getImage());
		setTitle("Giriş sayfası");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 636, 397);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Dosya");
		mnNewMenu.setFont(new Font("Segoe UI", Font.BOLD, 14));
		mnNewMenu.setForeground(new Color(0, 0, 0));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Giri\u015F");
		mntmNewMenuItem.setIcon(new ImageIcon("C:\\Users\\anass\\Downloads\\images (1).png"));
		mntmNewMenuItem.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mntmNewMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, InputEvent.CTRL_DOWN_MASK));
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("\u00C7\u0131k\u0131\u015F");
		mntmNewMenuItem_1.setIcon(new ImageIcon("C:\\Users\\anass\\Downloads\\kisspng-computer-icons-x-mark-check-mark-clip-art-red-x-5ac2fb838cc984.9434974115227278115767 (1).jpg"));
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mntmNewMenuItem_1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mntmNewMenuItem_1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_DOWN_MASK));
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenu mnNewMenu_1 = new JMenu("Yard\u0131m");
		mnNewMenu_1.setFont(new Font("Segoe UI", Font.BOLD, 14));
		mnNewMenu_1.setForeground(new Color(0, 0, 0));
		menuBar.add(mnNewMenu_1);
		
		JMenu mnNewMenu_2 = new JMenu("Stil De\u011Fi\u015Ftirme");
		mnNewMenu_2.setFont(new Font("Dialog", Font.BOLD, 14));
		mnNewMenu_1.add(mnNewMenu_2);
		
		JMenuItem S1 = new JMenuItem("Stil 1");
		
		S1.setFont(new Font("Dialog", Font.PLAIN, 14));
		mnNewMenu_2.add(S1);
		
		JMenuItem S2 = new JMenuItem("Stil 2");
		
		S2.setFont(new Font("Dialog", Font.PLAIN, 14));
		mnNewMenu_2.add(S2);
		
		JMenuItem S3 = new JMenuItem("Stil 3");
		
		S3.setFont(new Font("Dialog", Font.PLAIN, 14));
		mnNewMenu_2.add(S3);
		
		JMenuItem S4 = new JMenuItem("Stil 4");
		
		S4.setFont(new Font("Dialog", Font.PLAIN, 14));
		mnNewMenu_2.add(S4);
		
		JMenuItem mntmNewMenuItem_8 = new JMenuItem("İşletim sistemi");
		mntmNewMenuItem_8.setFont(new Font("Dialog", Font.PLAIN, 14));
		mnNewMenu_2.add(mntmNewMenuItem_8);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Yard\u0131m");
		mntmNewMenuItem_3.setIcon(new ImageIcon("C:\\Users\\anass\\Downloads\\png-transparent-button-computer-icons-question-mark-information-blue-trademark-color (1).png"));
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 JOptionPane.showMessageDialog((rootPane),"Üzgünüz, şu anda size yardımcı olamayabiliriz");

			}
		});
		mntmNewMenuItem_3.setFont(new Font("Dialog", Font.PLAIN, 14));
		mntmNewMenuItem_3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, InputEvent.CTRL_DOWN_MASK));
		mnNewMenu_1.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Hakkımda");
		mntmNewMenuItem_4.setIcon(new ImageIcon("C:\\Users\\anass\\Downloads\\png-clipart-rectangle-black-m-quit-button-rectangle-black (1).png"));
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				About about = new About();
				about.setVisible(true);
			}
		});
		mntmNewMenuItem_4.setFont(new Font("Dialog", Font.PLAIN, 14));
		mntmNewMenuItem_4.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, InputEvent.CTRL_DOWN_MASK));
		mnNewMenu_1.add(mntmNewMenuItem_4);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 628, 332);
		panel.setBackground(new Color(0, 139, 139));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 0, 0), new Color(0, 0, 0)));
		panel_1.setBackground(new Color(95, 158, 160));
		
		JLabel lblNewLabel = new JLabel("Giri\u015F Sayfas\u0131");
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\anass\\Desktop\\GitHub\\BSM103_ANASALMAQTARI\\MyUniversity\\src\\img\\295128.png"));
		
		JLabel idlabel = new JLabel("Kimlik numarası :");
		idlabel.setForeground(new Color(0, 0, 0));
		idlabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		JLabel passlabel = new JLabel("\u015Eifre :");
		passlabel.setForeground(new Color(0, 0, 0));
		passlabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		JLabel selectpersonlabel = new JLabel("Ki\u015Fi :");
		selectpersonlabel.setForeground(new Color(0, 0, 0));
		selectpersonlabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		idOname = new JTextField();
		idOname.setColumns(10);
		
		JCheckBox jCheckBox = new JCheckBox("\u015Eifreyi G\u00F6ster");
		jCheckBox.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		jCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(jCheckBox.isSelected()) {
					pass.setEchoChar((char)0);
				}else{
					pass.setEchoChar('*');

					
				}
			}
		});
		jCheckBox.setForeground(new Color(0, 0, 0));
		
		JComboBox selectperson = new JComboBox();
		selectperson.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(selectperson.getSelectedIndex() == 0) {
					idlabel.setText("Kullanıcı adı :");
				}else if(selectperson.getSelectedIndex() == 1 || selectperson.getSelectedIndex() == 2) {
					idlabel.setText("Kimlik numarası :");

				}
			}
		});
		selectperson.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		selectperson.setModel(new DefaultComboBoxModel(new String[] {"Yöntem", "Eğitmen", "Öğrenci"}));
		
		JButton btnNewButton = new JButton("Giri\u015F ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String miss = (" Aşağıdaki verileri girmeyi unuttunuz !! "+"\n");
					if(idOname.getText().equals("")) {
						miss += idlabel.getText();
				}
					if(pass.getText().equals("")){
						miss += passlabel.getText();
					}
					if(selectperson.getSelectedIndex()== -1){
						miss += selectpersonlabel.getText();
					}
					if(!idOname.getText().equals("")&& !pass.getText().equals("")&& selectperson.getSelectedIndex()!= -1) {
					
					if(selectperson.getSelectedIndex() ==0) {
				    AdminLogin();
					}else if(selectperson.getSelectedIndex() ==1) {
						DoctroLogin();
					}else if(selectperson.getSelectedIndex() ==2) {
						StudentLogin();
					}					
					}else {
						JOptionPane.showMessageDialog(null,miss,"Veriler kaybı etti",JOptionPane.ERROR_MESSAGE );
					}
				

			}
	  //Connecting the login interface for each user 

			private void StudentLogin() {
				 id = idOname.getText().trim();
			       String password = pass.getText().trim();
          try {
              con =ConnectionDataBase.Connet();
				com = con.prepareStatement("select* from Student where id='"+Integer.parseInt(id)+"'and password='"+password+"'");
	            rst = com.executeQuery();
	            
	            if(rst.next()) {
	            	 user = rst.getString("nameS");
	            	ManMenue  manMenue = new ManMenue();
	            	//ManMenue.Y.setEnabled(false);
	            	//manMenue.d.setEnableD(false);
	            	manMenue.setVisible(true);
	            	setVisible(false);
	            	JOptionPane.showMessageDialog(null,"Merhaba "+user);
	            }else {
	JOptionPane.showMessageDialog(null,"Şifriyi yada kullanıcı adı yanlış Girdiniz","yanlış bilgiler",JOptionPane.ERROR_MESSAGE);
	            	
	            }
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {	
					try {
						con.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				{
}}}

			private void DoctroLogin() {
        	// Fetching the contact from the ConnectionDataBase class
				  id = idOname.getText().trim();
			       String password = pass.getText().trim();
            try {
                con =ConnectionDataBase.Connet();
				com = con.prepareStatement("select * from Doctor where id ='"+Integer.parseInt(id)+"'and password='"+password+"'");
	            rst = com.executeQuery();
	            
	            if(rst.next()) {
	            	 userD = rst.getString("nameD");
	            	ManMenue  manMenue = new ManMenue();
	            	//manMenue.Y.setEnabled(false);
	             // manMenue.s.setEnabled(false);
	            	manMenue.setVisible(true);
	            	setVisible(false);
	            	JOptionPane.showMessageDialog(null,"Merhaba Dr. "+userD);
	            }else {
	JOptionPane.showMessageDialog(null,"Şifriyi yada kullanıcı adı yanlış Girdiniz","yanlış bilgiler",JOptionPane.ERROR_MESSAGE);
	            	
	            }
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				try {
					con.close();
				} catch (SQLException e) {
				}
			}
            }

			private void AdminLogin() {
        user = idOname.getText().trim();
        String password = pass.getText();
        if(user.equals("admin")&& password.equals("12345")) {
        	ManMenue  manMenue = new ManMenue();
        	manMenue.setVisible(true);
       // manMenue.d.setEnabled(false);
       // manMenue.s.setEnabled(false);
        	setVisible(false);

        	JOptionPane.showMessageDialog(null,"Merhaba admin");
        }else{ 
        	JOptionPane.showMessageDialog(null,"Şifriyi yada kullanıcı adı yanlış Girdiniz","yanlış bilgiler",JOptionPane.ERROR_MESSAGE);
        	
        }
        
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 17));
		btnNewButton.setForeground(Color.BLACK);
		
		JButton btnNewButton_1 = new JButton("\u00C7\u0131k\u0131\u015F");
		btnNewButton_1.setForeground(Color.BLACK);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		contentPane.setLayout(null);
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 17));
		
		pass = new JPasswordField();
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_1)
					.addGap(22)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
							.addGap(60)
							.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(idlabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(idOname, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(selectpersonlabel)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(selectperson, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(passlabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(pass, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
								.addComponent(jCheckBox))))
					.addContainerGap(34, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(34)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(idlabel)
								.addComponent(idOname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(passlabel, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
								.addComponent(pass, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(3)
							.addComponent(jCheckBox, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(selectperson, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(selectpersonlabel, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnNewButton_1)
								.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		panel_1.setLayout(gl_panel_1);
		contentPane.add(panel);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(28)
							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 541, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(38)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(54, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(33)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		);
		panel.setLayout(gl_panel);
		selectperson.setSelectedIndex(-1);
		
		
		
		//************** Change Style *****************
		S1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChangeStyle cs = new ChangeStyle();
				cs.LookAndFeel(0);
				SwingUtilities.updateComponentTreeUI(S1);	
			}
		});
		S2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChangeStyle cs = new ChangeStyle();
				cs.LookAndFeel(1);
				SwingUtilities.updateComponentTreeUI(S2);	
			}
		});
		S3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChangeStyle cs = new ChangeStyle();
				cs.LookAndFeel(2);
				SwingUtilities.updateComponentTreeUI(S3);
			}
		});
		S4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChangeStyle cs = new ChangeStyle();
				cs.LookAndFeel(3);
				SwingUtilities.updateComponentTreeUI(S4);
			}
		});
 //**************************************
	}
}
