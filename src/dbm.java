import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;


public class dbm {
    static Connection conn=null;
    public static Connection dbconnect(){   
    try
    {
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/car_book","root","Shreya@123");
        return conn;
    }catch(Exception e){
        JOptionPane.showMessageDialog(null ,e);
        System.out.println("wfferwf");
        return null;
    }
    }
}