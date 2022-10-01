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
import javax.swing.JTextField;
import java.awt.Dialog.ModalExclusionType;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class PaymentOfFees extends JFrame {

	private JPanel contentPane;
	private JTextField id;
	private JTextField amountIt;
	private JTextField paid;
	private JTextField rest_fees;
	private JTextField dafee;
	private JTextField name;
	//private JButton btnNewButton;

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
					PaymentOfFees frame = new PaymentOfFees();
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
	public PaymentOfFees() {
		setIconImage(new ImageIcon(("src\\img\\GenelIcon.jpg")).getImage());

		setAlwaysOnTop(true);
		setResizable(false);
		setTitle("\u00D6\u011Frenim har\u00E7lar \u00F6deme");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 414, 403);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 206, 209));
		panel.setBounds(0, 0, 405, 66);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("\u00D6\u011Frenim har\u00E7lar \u00F6deme");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(77)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 262, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(97, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap(20, Short.MAX_VALUE)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
					.addGap(17))
		);
		
		panel.setLayout(gl_panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 139, 139));
		panel_1.setBounds(-1, 66, 406, 298);
		contentPane.add(panel_1);
		
		JLabel lblNewLabel_1 = new JLabel("\u00D6\u011Frenci Numaras\u0131 :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setForeground(Color.RED);
		
		id = new JTextField();
		
		id.setFont(new Font("Tahoma", Font.PLAIN, 13));
		id.setColumns(10);
		
		JLabel lblCinsiyet_1_2 = new JLabel("Y\u0131ll\u0131k har\u00E7 :");
		lblCinsiyet_1_2.setForeground(Color.WHITE);
		lblCinsiyet_1_2.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		JLabel lblCinsiyet_1_2_1 = new JLabel("\u00D6denmi\u015F har\u00E7 :");
		lblCinsiyet_1_2_1.setForeground(Color.WHITE);
		lblCinsiyet_1_2_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		JLabel lblCinsiyet_1_1 = new JLabel("Har\u00E7tan geri kalan :");
		lblCinsiyet_1_1.setForeground(Color.WHITE);
		lblCinsiyet_1_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		amountIt = new JTextField();
		amountIt.setForeground(Color.BLACK);
		amountIt.setBackground(Color.WHITE);
		amountIt.setEnabled(false);
		amountIt.setFont(new Font("Dialog", Font.BOLD, 15));
		amountIt.setColumns(10);
		
		paid = new JTextField();
		paid.setForeground(Color.BLACK);
		paid.setBackground(new Color(153, 255, 153));
		paid.setEnabled(false);
		paid.setFont(new Font("Dialog", Font.BOLD, 15));
		paid.setColumns(10);
		
		rest_fees = new JTextField();
		rest_fees.setForeground(Color.BLACK);
		rest_fees.setBackground(new Color(255, 102, 153));
		rest_fees.setEnabled(false);
		rest_fees.setFont(new Font("Dialog", Font.BOLD, 15));
		rest_fees.setColumns(10);
		
		JLabel dafe = new JLabel("\u00D6deme :");
		dafe.setForeground(Color.WHITE);
		dafe.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		dafee = new JTextField();
		
		dafee.setEnabled(false);
		dafee.setFont(new Font("Tahoma", Font.PLAIN, 13));
		dafee.setColumns(10);
		
		JButton btnNewButton = new JButton("Har\u00E7lar \u00F6deme");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						if(Integer.parseInt(dafee.getText()) > 1 && !dafee.getText().equals("")) {
							
					    	try {
					    		con =ConnectionDataBase.Connet();
								// تعديل المبلغ المتبقى (المبلغ المدفوع من قبل زائد المبلغ المدفوع)					
								int paidDataPase= Integer.parseInt(paid.getText()) + Integer.parseInt(dafee.getText());
								//تالرسوم باقي تعديل (المطلوب المبلغ ناقص المدفوع المبلغ )
								int restFessDataBase = Integer.parseInt(amountIt.getText()) - paidDataPase;
								com = con.prepareStatement("Update Student set amountPaid ='"+paidDataPase+"', restOfTheFees ='"+restFessDataBase+"'where id ='"+Integer.parseInt(id.getText())+"'");
					            com.execute();
						    	JOptionPane.showMessageDialog(null," Başarıyla ödenmiş","ödenmiş",JOptionPane.INFORMATION_MESSAGE);

					               name.setText("");
					              amountIt.setText("");
					              paid.setText("");
					              rest_fees.setText("");
					              id.setText("");
					              id.setEditable(true);
					              id.setEnabled(true);

					              dafee.setEnabled(false);
					              dafee.setText("");
					              btnNewButton.setEnabled(false);
					    	} catch (SQLException e1) {
							}finally {
								try {
									con.close();
								} catch (SQLException e1) {
								}
							}
							
						}else {
						JOptionPane.showMessageDialog(null,"Ödemek istediğiniz harç doğru bir şekilde giriniz");	
						}
					}
				});
	
			
		
		btnNewButton.setEnabled(false);
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
		
		JLabel lblNewLabel_1_2 = new JLabel("Ad Soyad :");
		lblNewLabel_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		name = new JTextField();
		name.setBackground(Color.WHITE);
		name.setEnabled(false);
		name.setFont(new Font("Tahoma", Font.PLAIN, 13));
		name.setColumns(10);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(27)
					.addComponent(dafe, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(dafee, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
					.addComponent(btnNewButton)
					.addGap(52))
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(20)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(1)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(lblCinsiyet_1_2, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_panel_1.createSequentialGroup()
										.addGap(3)
										.addComponent(lblCinsiyet_1_1, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
										.addGap(31)
										.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING, false)
											.addComponent(paid, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
											.addComponent(rest_fees, 0, 0, Short.MAX_VALUE)
											.addComponent(amountIt, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)))
									.addGroup(gl_panel_1.createSequentialGroup()
										.addGap(1)
										.addComponent(lblCinsiyet_1_2_1, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)))))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(lblNewLabel_1_2, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
							.addGap(35)
							.addComponent(name, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(169)
							.addComponent(id, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(64, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(24)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(id, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_1_2, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(2)
							.addComponent(name, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)))
					.addGap(11)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCinsiyet_1_2, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(amountIt, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
					.addGap(17)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCinsiyet_1_2_1, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(paid, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCinsiyet_1_1, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(rest_fees, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(dafe, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(dafee, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton))
					.addGap(23))
		);
		
	
		panel_1.setLayout(gl_panel_1);
		id.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == e.VK_ENTER ) {
					if(id.getText().equals("")) {
						JOptionPane.showMessageDialog(null,"Lütfen Kimlik numarası giriniz","boş",2);		
					}else {
					    	try {
								 con =ConnectionDataBase.Connet();
								com = con.prepareStatement("select* from Student where id ='"+Integer.parseInt(id.getText())+"'");
					            rst = com.executeQuery();
					            if(rst.next()) {
					              name.setText(rst.getString(2));
					              amountIt.setText(rst.getString(6));
					              paid.setText(rst.getString(7));
					              rest_fees.setText(rst.getString(8));
                                  
					              dafee.setEnabled(true);
					              btnNewButton.setEnabled(true);
					              id.setEnabled(false);
					            }else {
							  JOptionPane.showMessageDialog(null,"Öğrenci numarası yoktur","yoktur",JOptionPane.ERROR_MESSAGE );
 	
					            }
							} catch (SQLException e1) {
							}finally {
								try {
									con.close();
								} catch (SQLException e1) {
								}
							}
				}}	}
					
		});
			}
	
}
