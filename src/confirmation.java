import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.text.SimpleDateFormat;  
import java.util.Date; 
import javax.swing.ImageIcon;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author shreya
 */
public class confirmation extends javax.swing.JFrame {

    Connection connect= null;
    Date date = new Date();  
    long curr_time = date.getTime();
    String driver_name;
    String driver_phone_number;
    String driver_rating;
    String driver_car_number;
    String driver_car_model;
    String runame;
    String driver_uid;
    String rname; // rname- actual name of the user
    int book_fare;
    int wallet_balance_before;
    int book_est_time;
    int pickup_point;
    int dropto_point;
    int driver_count;
    String[] Locations={"BITS-Pilani","Secunderabad","Hi-Tech_City"};
    /**
     * Creates new form confirmation
     */
    public confirmation(String txt_user_id, String driver_details, int fare, int est_time, int pick, int drop) 
    {
        initComponents();
        runame=txt_user_id;
        driver_uid= driver_details;
        book_fare=fare;
        book_est_time=est_time;
        pickup_point=(pick);
        dropto_point=(drop);
        
        this.setLocationRelativeTo(null);
        this.getRootPane().setDefaultButton(Continue_button);
        connect=dbm.dbconnect();
        String query_ini="select * from cust where txt_user_id=?";
        PreparedStatement ps_ini=null;
        ResultSet rs_ini;
        
        try {
            ps_ini = connect.prepareStatement(query_ini);
            ps_ini.setString(1, txt_user_id);
            rs_ini=ps_ini.executeQuery();
            while(rs_ini.next()) {
                rname = rs_ini.getString("txt_name");
                wallet_balance_before= rs_ini.getInt("wallet_bal");
            }
            hi_name.setText("Hi, "+rname);
            Fare_details.setText("RS. "+book_fare);
            pick_point.setText(Locations[pickup_point]);
            drop_point.setText(Locations[dropto_point]);
            
            Wallet_balance.setText("RS. "+(wallet_balance_before-book_fare));
            est_time_space.setText(book_est_time+" min");
         }catch (SQLException ex) {
            System.out.println("Entered");
            System.out.println(ex.getMessage());                    // DOubt??//
        }    
        
        PreparedStatement ps1=null;
        try{
            String query="update cust set wallet_bal = ?,start_time = ?, end_time = ?, busy = 1 where txt_user_id = ?";
            ps1=connect.prepareStatement(query);
            ps1.setInt(1, (wallet_balance_before-book_fare));
            ps1.setString(2,String.valueOf(curr_time));
            ps1.setString(3,String.valueOf(curr_time+(book_est_time*1000)));
            ps1.setString(4, runame);
            ps1.execute();
        }
         catch(Exception e){
            JOptionPane.showMessageDialog(null ,e);
         }
        
        
        
       //Driver display details 
        
        query_ini="select * from driver where uid=?";
        ps_ini=null;
        
        
        try {
            ps_ini = connect.prepareStatement(query_ini);
            ps_ini.setString(1, driver_uid);
            rs_ini=ps_ini.executeQuery();
            while(rs_ini.next()) {
                driver_name = rs_ini.getString("name");
                  driver_phone_number = rs_ini.getString("phone_no");
                  driver_rating = rs_ini.getString("rating");
                    driver_car_number = rs_ini.getString("car_no");
                      driver_car_model = rs_ini.getString("car_model");
                      driver_count=rs_ini.getInt("count");
            }
            name.setText(driver_name);
            phone_number.setText(driver_phone_number);
            rating.setText(driver_rating);
            car_number.setText(driver_car_number);
            
            car_model.setText(driver_car_model);
           
         }catch (SQLException ex) {
            System.out.println("Entered");
            System.out.println(ex.getMessage());                    // DOubt??//
        }    
        driver_image.setIcon(new ImageIcon("C:\\Users\\shrey\\OneDrive\\Desktop\\shreya\\driver.png"));
        ps1=null;
        try{
            String query="update driver set busy = 1,start_time = ?,count=?, end_time = ?,curr_loc=? where uid = ?";
            ps1=connect.prepareStatement(query);
            driver_count++;
            ps1.setString(1,String.valueOf(curr_time));
            ps1.setInt(2,(driver_count));
            ps1.setString(3,String.valueOf(curr_time+(book_est_time*1000)));
            ps1.setInt(4,dropto_point);
            ps1.setString(5, driver_uid);
            ps1.execute();
        }
         catch(Exception e){
            JOptionPane.showMessageDialog(null ,e);
         }
        
        
        //updating the history database
        
        String []loc_array = new String[]{"BITS-Pilani", "Secundarabad", "Hi-Tech_City"};
        
        ps1=null;
        
        try{
            String query="insert history set txt_user_id = ? ,start_time = ?, end_time = ?, start_pt=?, end_pt=?, name=? ,status=?";
            ps1=connect.prepareStatement(query);
            ps1.setString(1,runame);
            ps1.setString(2,String.valueOf(curr_time));
            ps1.setString(3,String.valueOf(curr_time+(book_est_time*1000)));
            ps1.setString(4,loc_array[pickup_point]);
            ps1.setString(5,loc_array[dropto_point]);
            ps1.setString(6, driver_name);
            ps1.setString(7, "Ongoing");
            
            ps1.execute();
        }
         catch(Exception e){
            JOptionPane.showMessageDialog(null ,e);
        }
        
        
        
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        Continue_button = new javax.swing.JButton();
        hi_name = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        phone_number = new javax.swing.JLabel();
        rating = new javax.swing.JLabel();
        car_number = new javax.swing.JLabel();
        car_model = new javax.swing.JLabel();
        pick_point = new javax.swing.JLabel();
        drop_point = new javax.swing.JLabel();
        Fare_details = new javax.swing.JLabel();
        est_time_space = new javax.swing.JLabel();
        Wallet_balance = new javax.swing.JLabel();
        driver_image = new javax.swing.JLabel();
        name = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(938, 540));
        setMinimumSize(new java.awt.Dimension(938, 540));
        setPreferredSize(new java.awt.Dimension(938, 540));
        getContentPane().setLayout(null);

        jLabel1.setText("                  YOUR BOOKING");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(340, 100, 307, 53);

        jLabel2.setText("Driver Details");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(260, 210, 95, 20);

        jLabel3.setText("Name");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(230, 250, 41, 20);

        jLabel4.setText("Phone Number");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(230, 280, 106, 20);

        jLabel5.setText("Rating");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(230, 310, 45, 20);

        jLabel6.setText("Car Number");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(230, 340, 86, 20);

        jLabel7.setText("Car Model");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(230, 370, 71, 20);

        jLabel8.setText("Ride Details");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(650, 210, 83, 20);

        jLabel9.setText("Pickup Point");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(560, 250, 87, 20);

        jLabel10.setText("Drop Point");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(560, 280, 76, 20);

        jLabel11.setText("Fare");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(560, 310, 30, 20);

        jLabel12.setText("Estimated Time");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(560, 340, 110, 20);

        jLabel13.setText("Wallet Balance after Deduction");
        getContentPane().add(jLabel13);
        jLabel13.setBounds(560, 370, 214, 20);

        Continue_button.setText("Continue");
        Continue_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Continue_buttonActionPerformed(evt);
            }
        });
        getContentPane().add(Continue_button);
        Continue_button.setBounds(410, 470, 151, 55);

        hi_name.setText("Hello XYZ!");
        getContentPane().add(hi_name);
        hi_name.setBounds(850, 30, 73, 20);
        getContentPane().add(jLabel15);
        jLabel15.setBounds(482, 210, 0, 0);

        phone_number.setText("jLabel16");
        getContentPane().add(phone_number);
        phone_number.setBounds(360, 280, 130, 20);

        rating.setText("jLabel15");
        getContentPane().add(rating);
        rating.setBounds(360, 310, 130, 20);

        car_number.setText("jLabel16");
        getContentPane().add(car_number);
        car_number.setBounds(360, 340, 160, 20);

        car_model.setText("jLabel16");
        getContentPane().add(car_model);
        car_model.setBounds(360, 370, 140, 20);

        pick_point.setText("-");
        getContentPane().add(pick_point);
        pick_point.setBounds(800, 250, 120, 20);

        drop_point.setText("-");
        getContentPane().add(drop_point);
        drop_point.setBounds(800, 280, 140, 20);

        Fare_details.setText("0");
        getContentPane().add(Fare_details);
        Fare_details.setBounds(800, 310, 100, 20);

        est_time_space.setText("0");
        getContentPane().add(est_time_space);
        est_time_space.setBounds(800, 340, 110, 20);

        Wallet_balance.setText("0");
        getContentPane().add(Wallet_balance);
        Wallet_balance.setBounds(800, 370, 110, 20);
        getContentPane().add(driver_image);
        driver_image.setBounds(0, 0, 950, 540);

        name.setText("jLabel14");
        getContentPane().add(name);
        name.setBounds(360, 250, 110, 20);

        jLabel14.setFont(new java.awt.Font("Gotham Medium", 1, 36)); // NOI18N
        jLabel14.setText("Book My Cab 3.0");
        getContentPane().add(jLabel14);
        jLabel14.setBounds(350, 10, 360, 90);

        pack();
    }// </editor-fold>//GEN-END:initComponents

   /* private void Continue_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Continue_buttonActionPerformed
        this.setVisible(false);
       //  String runame = "txt_user_id";
        new booking(runame).setVisible(true);
    }*///GEN-LAST:event_Continue_buttonActionPerformed
    private void Continue_buttonActionPerformed(java.awt.event.ActionEvent evt) {
        this.setVisible(false);
        rideover rideOverWindow = new rideover(runame, driver_name);
        rideOverWindow.setVisible(true);
    }


   
   /* public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new confirmation().setVisible(true);
            }
        });
    }*/

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Continue_button;
    private javax.swing.JLabel Fare_details;
    private javax.swing.JLabel Wallet_balance;
    private javax.swing.JLabel car_model;
    private javax.swing.JLabel car_number;
    private javax.swing.JLabel driver_image;
    private javax.swing.JLabel drop_point;
    private javax.swing.JLabel est_time_space;
    private javax.swing.JLabel hi_name;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel name;
    private javax.swing.JLabel phone_number;
    private javax.swing.JLabel pick_point;
    private javax.swing.JLabel rating;
    // End of variables declaration//GEN-END:variables
}
