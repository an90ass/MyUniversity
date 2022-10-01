package MyUniversity;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level; 
import java.util.logging.Logger; 
import javax.swing.JOptionPane;


public class ConnectionDataBase {
	static Connection con= null;
	
 public static Connection Connet() {
	 try {
		Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		 con = DriverManager.getConnection("jdbc:ucanaccess://university.accdb");
        // JOptionPane.showMessageDialog(null,"Connected");

	} catch (Exception ex) {
           JOptionPane.showMessageDialog(null,ex.getMessage());
	}
	 return con;
 }
 public static void main(String[] args) {
	 con = Connet();
	 
 }
}
