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
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChangePassword extends JFrame {

	protected static final JLabel Lable = null;
	protected static final Component Label = null;
	protected static final JLabel Label2 = null;
	protected static final JLabel LabelYeniT = null;
	private JPanel contentPane;
	private JPasswordField NewPass;
	private JPasswordField OldPass;
	private JTextField id;
	private JPasswordField Cpass;
    Login login = new Login();
    Connection con = null;
    PreparedStatement com = null;
    ResultSet rst = null;
    int ch;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChangePassword frame = new ChangePassword();
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
	public ChangePassword() {
		setIconImage(new ImageIcon(("src\\img\\GenelIcon.jpg")).getImage());

		setTitle("Öğrenci şifresini değiştir");
		JLabel Label = new JLabel("");
		JLabel Label2 = new JLabel("");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 425);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel changePassword = new JPanel();
		changePassword.setBounds(0, 0, 434, 386);
		changePassword.setForeground(new Color(0, 51, 0));
		changePassword.setBackground(new Color(0, 139, 139));
		contentPane.add(changePassword);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 206, 209));
		
		JLabel lblNewLabel = new JLabel("Şifre Değiştir");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 35));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
					.addGap(111)
					.addComponent(lblNewLabel)
					.addContainerGap(152, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		JLabel lblNewLabel_1 = new JLabel("Kimlik numarası :");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		JLabel LabelEski = new JLabel("Eski şifre :");
		LabelEski.setForeground(Color.WHITE);
		LabelEski.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		JLabel LabelYeni = new JLabel("Yeni şifre :");
		LabelYeni.setForeground(Color.WHITE);
		LabelYeni.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		NewPass = new JPasswordField();
		NewPass.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String OldPassword = String.valueOf(OldPass.getPassword());
				String NewPassword = String.valueOf(NewPass.getPassword());
                if(OldPassword.equals(NewPassword)&&!OldPass.getText().equals("") &&!NewPass.getText().equals("")) {                	 
                	Label.setText("Eski şifre lütfen değiştirin ");
                	Label.setForeground(Color.red);
                	Label.setVisible(true);
                	Cpass.setRequestFocusEnabled(false);                	
                }else {
                	Label.setText("");
                	Label.setForeground(Color.BLACK);
                	Cpass.setRequestFocusEnabled(true);
                	Label.setVisible(false);
                }		
			String ConfPassword = String.valueOf(Cpass.getPassword());
			String NewPassword1 = String.valueOf(NewPass.getPassword());	
			
			if(!Cpass.getText().equals("")&& !NewPass.getText().equals("")) {
				if(ConfPassword.equals(NewPassword1)) {
					Label2.setText("Şifre aynı");
					Label2.setForeground(Color.GREEN);
					Label2.setVisible(true);
                	Cpass.setRequestFocusEnabled(false);                	
                }else {
                	Label2.setText("Şifre aynı değil, lütfen değiştirin");
                	Label2.setForeground(Color.RED);
                	Label2.setVisible(true);
                }	
			}			
			}
		});
		NewPass.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		OldPass = new JPasswordField();
		OldPass.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String OldPassword = String.valueOf(OldPass.getPassword());
				String NewPassword = String.valueOf(NewPass.getPassword());
                if(OldPassword.equals(NewPassword)&&!OldPass.getText().equals("") &&!NewPass.getText().equals("")) {                	 
                	Label.setText("Eski şifre lütfen değiştirin ");
                	Label.setForeground(Color.red);
                	Label.setVisible(true);
                	Cpass.setRequestFocusEnabled(false);                	
                }else {
                	Label.setText("");
                	Label.setForeground(Color.BLACK);
                	Cpass.setRequestFocusEnabled(true);
                	Label.setVisible(false);
                }		
			}
		});
		OldPass.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		id = new JTextField();
		id.setFont(new Font("Tahoma", Font.PLAIN, 13));
		id.setColumns(10);
		
		JButton btnNewButton = new JButton("Şifreyi değiştir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ch==1) {
				ChangePassword("Student");		
				}else {
					ChangePassword("Doctor");		
				}
			}

			private void ChangePassword(String nameTable) {
				String miss = (" Aşağıdaki verileri girmeyi unuttunuz !! "+"\n");
				if(OldPass.getText().equals("")) {
					miss += LabelEski.getText();
			}
				if(NewPass.getText().equals("")){
					miss += LabelYeni.getText();
				}
				if(Cpass.getText().equals("")){
					miss += LabelYeniT.getText();
				}
				if(!OldPass.getText().equals("")&& !NewPass.getText().equals("")&& !Cpass.getText().equals("")) {
					try {
						con =ConnectionDataBase.Connet();
						com = con.prepareStatement("select*from "+nameTable+" where id='"+Integer.parseInt(id.getText())+"'");
			            rst = com.executeQuery();	
			            rst.next();
			            
			            if(OldPass.getText().equals(rst.getString("password"))){
   com = con.prepareStatement("update "+nameTable+" set password ='"+NewPass.getText()+"'where id='"+Integer.parseInt(id.getText())+"'");
   com.execute();
	JOptionPane.showMessageDialog(null,"Şifre başarıyla değiştirildi ","değiştirildi",JOptionPane.INFORMATION_MESSAGE );
	NewPass.setText("");
	OldPass.setText("");
	Cpass.setText("");
			            }else {
							JOptionPane.showMessageDialog(null,"Eski şifre yanlış girdiniz","Hata",JOptionPane.ERROR_MESSAGE );	
			            }      
					} catch (SQLException e1) {
						e1.printStackTrace();
					}finally {
						try {
							con.close();
						} catch (SQLException e1) {
						}
					}
		            }else {	
						JOptionPane.showMessageDialog(null,miss,"Veriler kaybı etti",JOptionPane.ERROR_MESSAGE );
				}					
			}
		});
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnNewButton.setBackground(new Color(50, 205, 50));
		
		JButton btnNewButton_1 = new JButton("Çıkış");
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnNewButton_1.setBackground(new Color(250, 128, 114));
		
		JLabel LabelYeniT = new JLabel("Yeni şifre tekrar :");
		LabelYeniT.setForeground(Color.WHITE);
		LabelYeniT.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		Cpass = new JPasswordField();
		Cpass.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String ConfPassword = String.valueOf(Cpass.getPassword());
				String NewPassword = String.valueOf(NewPass.getPassword());	
				
				if(!Cpass.getText().equals("")&& !NewPass.getText().equals("")) {
					if(ConfPassword.equals(NewPassword)) {
						Label2.setText("Şifre aynı");
						Label2.setForeground(Color.GREEN);
						Label2.setVisible(true);
	                	Cpass.setRequestFocusEnabled(false);	                	
	                }else {
	                	Label2.setText("Şifre aynı değil, lütfen değiştirin");
	                	Label2.setForeground(Color.RED);
	                	Label2.setVisible(true);
	                }
				}								
			}
		});
		Cpass.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		Label2.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		GroupLayout gl_changePassword = new GroupLayout(changePassword);
		gl_changePassword.setHorizontalGroup(
			gl_changePassword.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_changePassword.createSequentialGroup()
					.addGroup(gl_changePassword.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_changePassword.createSequentialGroup()
							.addGap(24)
							.addGroup(gl_changePassword.createParallelGroup(Alignment.LEADING)
								.addComponent(LabelYeniT, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_changePassword.createSequentialGroup()
									.addGap(5)
									.addGroup(gl_changePassword.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNewLabel_1)
										.addComponent(LabelEski)))
								.addComponent(LabelYeni))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_changePassword.createParallelGroup(Alignment.LEADING, false)
								.addComponent(Cpass)
								.addComponent(NewPass, GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
								.addComponent(OldPass, Alignment.TRAILING)
								.addGroup(gl_changePassword.createSequentialGroup()
									.addGap(5)
									.addComponent(Label, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE))
								.addComponent(id, Alignment.TRAILING)
								.addComponent(Label2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
						.addGroup(gl_changePassword.createSequentialGroup()
							.addGap(51)
							.addComponent(btnNewButton)
							.addGap(74)
							.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(55, Short.MAX_VALUE))
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
		);
		gl_changePassword.setVerticalGroup(
			gl_changePassword.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_changePassword.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 49, Short.MAX_VALUE)
					.addGap(26)
					.addGroup(gl_changePassword.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(id, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(22)
					.addGroup(gl_changePassword.createParallelGroup(Alignment.BASELINE)
						.addComponent(LabelEski, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(OldPass, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_changePassword.createParallelGroup(Alignment.BASELINE)
						.addComponent(LabelYeni, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(NewPass, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(Label, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_changePassword.createParallelGroup(Alignment.BASELINE)
						.addComponent(LabelYeniT)
						.addComponent(Cpass, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(Label2, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
					.addGap(38)
					.addGroup(gl_changePassword.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
					.addGap(60))
		);
		changePassword.setLayout(gl_changePassword);
		Label.setVisible(false);
		Label.setFont(new Font(Label.getName(),Font.BOLD,12));
		Label2.setFont(new Font(Label.getName(),Font.BOLD,12));
		id.setText(login.id);
      ch= ManMenue.changePassS_D;
      
      if(ch==2) {
    	  this.setTitle("Eğitmen şifresini değiştir");
    	  
      }
      
	}
}
