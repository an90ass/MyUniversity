package MyUniversity;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.*;

public class ManMenue extends JFrame {

	protected static final String a = null;
	private JPanel contentPane;
	  public static  Object s;
	public static Object d;
	 public static Object y;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManMenue frame = new ManMenue();
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
	static int sem;
	public static int ch; 
     static int changePassS_D;
     static int chC;
     static int chD;
	public ManMenue() {
		setIconImage(new ImageIcon(("src\\img\\GenelIcon.jpg")).getImage());

		setTitle("My University");
		SelectSemester();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 803, 536);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu y = new JMenu("Y\u00F6netim");
		y.setFont(new Font("Segoe UI", Font.BOLD, 14));
		y.setForeground(Color.BLACK);
		menuBar.add(y);
		
		JMenu student = new JMenu("\u00D6\u011Frenci");
		student.setFont(new Font("Dialog", Font.BOLD, 12));
		y.add(student);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("\u00D6\u011Frenci ekle");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ch =1;
				Student s = new Student();
				s.setVisible(true);
				//this.       (نفسها الصفحة بايغلق لأنه) راضية مش لكن
				
				
			}
		});
		mntmNewMenuItem.setIcon(new ImageIcon("C:\\Users\\anass\\Downloads\\pngtree-green-plus-sign-simple-logo-image_1082145 (1).jpg"));
		mntmNewMenuItem.setFont(new Font("Dialog", Font.PLAIN, 14));
		student.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("\u00D6\u011Frenciyi d\u00FCzenle");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ch =2;
				Student s = new Student();
				s.setVisible(true);
				//this.       (نفسها الصفحة بايغلق لأنه) راضية مش لكن
			}
		});
		mntmNewMenuItem_2.setIcon(new ImageIcon("C:\\Users\\anass\\Downloads\\1555241-200 (1).png"));
		mntmNewMenuItem_2.setFont(new Font("Dialog", Font.PLAIN, 14));
		student.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("\u00D6\u011Frenci sil");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ch = 3;
				Student s = new Student();
				s.setVisible(true);
				//this.       (نفسها الصفحة بايغلق لأنه) راضية مش لكن
			}
		});
		mntmNewMenuItem_1.setIcon(new ImageIcon("C:\\Users\\anass\\Downloads\\png-clipart-computer-icons-delete-icon-white-text (1).png"));
		mntmNewMenuItem_1.setFont(new Font("Dialog", Font.PLAIN, 14));
		student.add(mntmNewMenuItem_1);
		
		JMenu doctor = new JMenu("E\u011Fitmen");
		doctor.setFont(new Font("Dialog", Font.BOLD, 12));
		y.add(doctor);
		
		JMenuItem mntmEitmenEkle = new JMenuItem("E\u011Fitmen ekle");
		mntmEitmenEkle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chD =1;
			Doctor d = new Doctor();
			d.setVisible(true);
				
			}
		});
		mntmEitmenEkle.setIcon(new ImageIcon("C:\\Users\\anass\\Downloads\\pngtree-green-plus-sign-simple-logo-image_1082145 (1).jpg"));
		mntmEitmenEkle.setFont(new Font("Dialog", Font.PLAIN, 14));
		doctor.add(mntmEitmenEkle);
		
		JMenuItem mntmNewMenuItem_2_1 = new JMenuItem("E\u011Fitmen d\u00FCzenle");
		mntmNewMenuItem_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chD=2;
				Doctor d = new Doctor();
				d.setVisible(true);
					
			}
		});
		mntmNewMenuItem_2_1.setIcon(new ImageIcon("C:\\Users\\anass\\Downloads\\1555241-200 (1).png"));
		mntmNewMenuItem_2_1.setFont(new Font("Dialog", Font.PLAIN, 14));
		doctor.add(mntmNewMenuItem_2_1);
		
		JMenuItem mntmNewMenuItem_1_1 = new JMenuItem("E\u011Fitmen sil");
		mntmNewMenuItem_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chD =3;
				Doctor d = new Doctor();
				d.setVisible(true);
					
			}
		});
		mntmNewMenuItem_1_1.setIcon(new ImageIcon("C:\\Users\\anass\\Downloads\\png-clipart-computer-icons-delete-icon-white-text (1).png"));
		mntmNewMenuItem_1_1.setFont(new Font("Dialog", Font.PLAIN, 14));
		doctor.add(mntmNewMenuItem_1_1);
		
		JMenu ders = new JMenu("Ders");
		ders.setFont(new Font("Dialog", Font.BOLD, 12));
		y.add(ders);
		
		JMenuItem mntmCourseEkle = new JMenuItem("Ders ekle");
		mntmCourseEkle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chC=1;
				Course cou = new Course();
				cou.setVisible(true);			}
		});
		mntmCourseEkle.setIcon(new ImageIcon("C:\\Users\\anass\\Downloads\\pngtree-green-plus-sign-simple-logo-image_1082145 (1).jpg"));
		mntmCourseEkle.setFont(new Font("Dialog", Font.PLAIN, 14));
		ders.add(mntmCourseEkle);
		
		JMenuItem mntmNewMenuItem_2_1_1 = new JMenuItem("Ders d\u00FCzenle");
		mntmNewMenuItem_2_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chC =2;
				Course cou = new Course();
				cou.setVisible(true);

			}
		});
		mntmNewMenuItem_2_1_1.setIcon(new ImageIcon("C:\\Users\\anass\\Downloads\\1555241-200 (1).png"));
		mntmNewMenuItem_2_1_1.setFont(new Font("Dialog", Font.PLAIN, 14));
		ders.add(mntmNewMenuItem_2_1_1);
		
		JMenuItem mntmNewMenuItem_1_1_1 = new JMenuItem("Ders sil");
		mntmNewMenuItem_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chC =3;
				Course cou = new Course();
				cou.setVisible(true);		
				}
		});
		mntmNewMenuItem_1_1_1.setIcon(new ImageIcon("C:\\Users\\anass\\Downloads\\png-clipart-computer-icons-delete-icon-white-text (1).png"));
		mntmNewMenuItem_1_1_1.setFont(new Font("Dialog", Font.PLAIN, 14));
		ders.add(mntmNewMenuItem_1_1_1);
		
		JMenuItem mntmDnemiSein = new JMenuItem("D\u00F6nemi se\u00E7");
		mntmDnemiSein.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SelectSemester cs = new SelectSemester();
                 cs.setVisible(true);
			}
		});
		mntmDnemiSein.setIcon(new ImageIcon("C:\\Users\\anass\\Downloads\\images (1).png"));
		mntmDnemiSein.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		y.add(mntmDnemiSein);
		
		JMenuItem mntmNewMenuItem_2_1_1_1 = new JMenuItem("Har\u00E7lar \u00F6deme");
		mntmNewMenuItem_2_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PaymentOfFees pf = new PaymentOfFees();
				pf.setVisible(true);
			}
		});
		mntmNewMenuItem_2_1_1_1.setIcon(new ImageIcon("C:\\Users\\anass\\Downloads\\kisspng-computer-icons-payment-desktop-wallpaper-salary-earn-money-icon-5b12f16c5cc460.25595378152796810838 (1).jpg"));
		mntmNewMenuItem_2_1_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		y.add(mntmNewMenuItem_2_1_1_1);
		
		JMenuItem mntmNewMenuItem_1_1_1_1 = new JMenuItem("Öğrencinin dersini kaydetme veya silme");
		mntmNewMenuItem_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Res_Del_Course rdc = new Res_Del_Course();
				rdc.setVisible(true);
			}
		});
		mntmNewMenuItem_1_1_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		y.add(mntmNewMenuItem_1_1_1_1);
		
		JMenu d = new JMenu("E\u011Fitmen");
		d.setHorizontalAlignment(SwingConstants.CENTER);
		d.setFont(new Font("Dialog", Font.BOLD, 14));
		d.setForeground(Color.BLACK);
		menuBar.add(d);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Profil");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FileDoctor fd = new FileDoctor();
				fd.setVisible(true);
			}
		});
		mntmNewMenuItem_3.setIcon(new ImageIcon("C:\\Users\\anass\\Downloads\\png-clipart-user-profile-computer-icons-avatar-avatar-heroes-hand (1).png"));
		mntmNewMenuItem_3.setFont(new Font("Dialog", Font.PLAIN, 14));
		d.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Derse kay\u0131tl\u0131 \u00F6\u011Frencileri g\u00F6ster");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DisplayAllStudents das = new DisplayAllStudents();
				das.setVisible(true);
				
			}
		});
		mntmNewMenuItem_4.setIcon(new ImageIcon("C:\\Users\\anass\\Downloads\\png-clipart-eye-symbol-computer-icons-sign-eye-people-logo (1).png"));
		mntmNewMenuItem_4.setFont(new Font("Dialog", Font.PLAIN, 14));
		d.add(mntmNewMenuItem_4);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Not ekle");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddMarkStudent ams = new AddMarkStudent();
			}
		});
		mntmNewMenuItem_5.setIcon(new ImageIcon("C:\\Users\\anass\\Downloads\\pngtree-green-plus-sign-simple-logo-image_1082145 (1).jpg"));
		mntmNewMenuItem_5.setFont(new Font("Dialog", Font.PLAIN, 14));
		d.add(mntmNewMenuItem_5);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("\u015Eifre de\u011Fi\u015Ftir");
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Eğitmen password değiştirme
				 changePassS_D =2;

				new ChangePassword().setVisible(true);
           
			}
		});
		mntmNewMenuItem_6.setIcon(new ImageIcon("C:\\Users\\anass\\Downloads\\kisspng-computer-icons-password-strength-padlock-5acc767c6f2953.6138651915233491164553 (1).jpg"));
		mntmNewMenuItem_6.setFont(new Font("Dialog", Font.PLAIN, 14));
		d.add(mntmNewMenuItem_6);
		
		JMenu s = new JMenu("\u00D6\u011Frenci");
		s.setHorizontalAlignment(SwingConstants.CENTER);
		s.setFont(new Font("Dialog", Font.BOLD, 14));
		s.setForeground(Color.BLACK);
		menuBar.add(s);
		
		JMenuItem mntmNewMenuItem_8 = new JMenuItem("Profil");
		mntmNewMenuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ProfilePersonallyStudent().setVisible(true);
			}
		});
		mntmNewMenuItem_8.setIcon(new ImageIcon("C:\\Users\\anass\\Downloads\\png-clipart-user-profile-computer-icons-avatar-avatar-heroes-hand (1).png"));
		mntmNewMenuItem_8.setFont(new Font("Dialog", Font.PLAIN, 14));
		s.add(mntmNewMenuItem_8);
		
		JMenuItem mntmNewMenuItem_9 = new JMenuItem("Ders se\u00E7imi");
		mntmNewMenuItem_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Res_Course_Student rcs = new Res_Course_Student();
				rcs.setVisible(true);
			}
		});
		mntmNewMenuItem_9.setIcon(new ImageIcon("C:\\Users\\anass\\Downloads\\pngtree-green-plus-sign-simple-logo-image_1082145 (1).jpg"));
		mntmNewMenuItem_9.setFont(new Font("Dialog", Font.PLAIN, 14));
		s.add(mntmNewMenuItem_9);
		
		JMenuItem mntmNewMenuItem_10 = new JMenuItem("Transkript");
		mntmNewMenuItem_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Transcript().setVisible(true);
			}
		});
		mntmNewMenuItem_10.setIcon(new ImageIcon("C:\\Users\\anass\\Downloads\\pngtree-rate-icon-png-image_1869801 (1).jpg"));
		mntmNewMenuItem_10.setFont(new Font("Dialog", Font.PLAIN, 14));
		s.add(mntmNewMenuItem_10);
		
		JMenuItem mntmNewMenuItem_11 = new JMenuItem("Birikmeli");
		mntmNewMenuItem_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Avarge().setVisible(true);

			}
		});
		mntmNewMenuItem_11.setIcon(new ImageIcon("C:\\Users\\anass\\Downloads\\percent-sign-percentage-computer-icons-symbol-clip-art-png-favpng-hXHujmpjgKhVpVxLk2EpMwvNL (1).jpg"));
		mntmNewMenuItem_11.setFont(new Font("Dialog", Font.PLAIN, 14));
		s.add(mntmNewMenuItem_11);
		
		JMenuItem mntmNewMenuItem_12 = new JMenuItem("\u015Eifre de\u011Fi\u015Ftir");
		mntmNewMenuItem_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Öğrenci password değiştirme
				 changePassS_D =1;
				new ChangePassword().setVisible(true);
			}
		});
		mntmNewMenuItem_12.setIcon(new ImageIcon("C:\\Users\\anass\\Downloads\\kisspng-computer-icons-password-strength-padlock-5acc767c6f2953.6138651915233491164553 (1).jpg"));
		mntmNewMenuItem_12.setFont(new Font("Dialog", Font.PLAIN, 14));
		s.add(mntmNewMenuItem_12);
		
		JMenu yardim = new JMenu("Yard\u0131m");
		yardim.setForeground(Color.BLACK);
		yardim.setFont(new Font("Segoe UI", Font.BOLD, 14));
		menuBar.add(yardim);
		
		JMenu mnNewMenu_2_1 = new JMenu("Stil De\u011Fi\u015Ftirme");
		mnNewMenu_2_1.setFont(new Font("Dialog", Font.BOLD, 12));
		yardim.add(mnNewMenu_2_1);
		
		JMenuItem S1 = new JMenuItem("Stil 1");	
		JMenuItem S2 = new JMenuItem("Stil 2");		
		JMenuItem S3 = new JMenuItem("Stil 3");		
		JMenuItem S4 = new JMenuItem("Stil 4");
	
		S1.setFont(new Font("Dialog", Font.PLAIN, 14));
		mnNewMenu_2_1.add(S1);
		
		
		S2.setFont(new Font("Dialog", Font.PLAIN, 14));
		mnNewMenu_2_1.add(S2);
		
		
		S3.setFont(new Font("Dialog", Font.PLAIN, 14));
		mnNewMenu_2_1.add(S3);
		
		
		S4.setFont(new Font("Dialog", Font.PLAIN, 14));
		mnNewMenu_2_1.add(S4);
		
		JMenuItem mntmNewMenuItem_8_1 = new JMenuItem("İşletim sistemi");
		mntmNewMenuItem_8_1.setFont(new Font("Dialog", Font.PLAIN, 14));
		mnNewMenu_2_1.add(mntmNewMenuItem_8_1);
		
		JMenuItem mntmNewMenuItem_3_1 = new JMenuItem("Yard\u0131m");
		mntmNewMenuItem_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		 JOptionPane.showMessageDialog(rootPane,"Üzgünüz, şu anda size yardımcı olamayabiliriz");

			}
		});
		mntmNewMenuItem_3_1.setIcon(new ImageIcon("C:\\Users\\anass\\Downloads\\png-transparent-button-computer-icons-question-mark-information-blue-trademark-color (1).png"));
		mntmNewMenuItem_3_1.setFont(new Font("Dialog", Font.PLAIN, 14));
		yardim.add(mntmNewMenuItem_3_1);
		
		JMenuItem mntmNewMenuItem_4_1 = new JMenuItem("Hakk\u0131mda Bilgiler");
		mntmNewMenuItem_4_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				About about = new About();
				about.setVisible(true);
			}
			
		});
		mntmNewMenuItem_4_1.setIcon(new ImageIcon("C:\\Users\\anass\\Downloads\\png-clipart-rectangle-black-m-quit-button-rectangle-black (1).png"));
		mntmNewMenuItem_4_1.setFont(new Font("Dialog", Font.PLAIN, 14));
		yardim.add(mntmNewMenuItem_4_1);
		
		JMenu mnNewMenu_4 = new JMenu("\u00C7\u0131k\u0131\u015F");
		mnNewMenu_4.setForeground(Color.BLACK);
		mnNewMenu_4.setFont(new Font("Segoe UI", Font.BOLD, 14));
		menuBar.add(mnNewMenu_4);
		
		JMenuItem logOff = new JMenuItem("\u00C7\u0131k\u0131\u015F yap");
		logOff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Thread.sleep(1000);
				} catch (Exception e1) {
					
				}
			Login login = new Login();
			login.setVisible(true);
		//this.
			setVisible(false);
			
		}
		});
		logOff.setIcon(new ImageIcon("C:\\Users\\anass\\Desktop\\GitHub\\BSM103_ANASALMAQTARI\\MyUniversity\\src\\img\\\u0131\u0131\u0131\u0131\u0131.jpg"));
		logOff.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnNewMenu_4.add(logOff);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(0, -28, 1605, 839);
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\anass\\Downloads\\IMG_1568.jpg"));
		contentPane.add(lblNewLabel_1);
		setExtendedState(MAXIMIZED_BOTH);
		// *********** Change Style ************
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
		//**********************************************
	}
	private void SelectSemester() {
		Connection con = ConnectionDataBase.Connet();
		try {
			PreparedStatement com = con.prepareStatement("select* from Semester");
			 ResultSet rst =  com.executeQuery();
			 rst.next();
			 if(Integer.parseInt(rst.getString(1))==1) {
				 sem =1;
				 }else {
					 sem =1;
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
