package MyUniversity;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class ChangeStyle {
   String style[] = {"com.jtattoo.plaf.smart.SmartLookAndFeel","com.jtattoo.plaf.aluminium.AluminiumLookAndFeel","com.jtattoo.plaf.acryl.AcrylLookAndFeel","com.jtattoo.plaf.aero.AeroLookAndFeel"};
     
   public void LookAndFeel(int index) {
	   try {
		UIManager.setLookAndFeel(style[index]);
	} catch (Exception e) {		
	}
	}
	   
	   public void LookAndFeel() {
		   try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {	
		}	   
   }
       }
