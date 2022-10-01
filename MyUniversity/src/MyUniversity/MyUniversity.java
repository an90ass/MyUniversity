package MyUniversity;

import javax.swing.SwingUtilities;

public class MyUniversity {
	public static void main(String[] args) {
    //new Login().setVisible(true);
  
    ChangeStyle cs = new ChangeStyle();
	cs.LookAndFeel(0);
	Login I = new Login();
    I.setVisible(true);
	}
}
