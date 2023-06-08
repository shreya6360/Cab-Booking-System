import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.text.SimpleDateFormat;  
import java.util.Date; 
import java.util.Random;


public class booking extends javax.swing.JFrame {

    Connection connect= null;
    boolean modify_flag=false;
    boolean book_flag=false;
    int book_fare;
    int book_est_time;
    String selected_driver_uid;
    int [][]  est_time= {{0,40,50},{40,0,20},{50,20,0}};
    int [][]  est_fare={{0,100,150},{100,0,200},{150,200,0}};
    int [][]  nearest_loc= est_time;
    String runame;
    String rname;
    int rbalance;
     PreparedStatement st1=null,smt=null,pst1=null,ps=null,pstmt=null,pst2=null;
    ResultSet rs1,rs,rs2,rs3;
    
    public booking(String txt_user_id) {
        initComponents();
        book.setEnabled(false);
        runame=txt_user_id;
        this.setLocationRelativeTo(null);
        this.getRootPane().setDefaultButton(book);
        connect=dbm.dbconnect();
         String query2="select * from cust where txt_user_id=?";
         
        PreparedStatement ps1=null;
        try {
            ps1 = connect.prepareStatement(query2);
            ps1.setString(1, txt_user_id);
            rs3=ps1.executeQuery();
            while(rs3.next()) {
                rname = rs3.getString("txt_name");
                rbalance= rs3.getInt("wallet_bal");
              
            }
            hi_name.setText("Hi, "+rname);
            balance.setText("RS."+rbalance);}
         catch (SQLException ex) {
            System.out.println("Entered");
            System.out.println(ex.getMessage());                    // DOubt??//
        }    
        /*try {
            Thread.sleep(400);
        } catch (InterruptedException ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        hi_name = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        pickup_dropdown = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        drop_dropdown = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        book = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        fare = new javax.swing.JLabel();
        time = new javax.swing.JLabel();
        balance = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        modify = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(938, 540));
        setMinimumSize(new java.awt.Dimension(938, 540));
        setPreferredSize(new java.awt.Dimension(938, 540));
        getContentPane().setLayout(null);

        hi_name.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        hi_name.setForeground(new java.awt.Color(255, 255, 255));
        hi_name.setText("Hi X!");
        getContentPane().add(hi_name);
        hi_name.setBounds(790, 60, 73, 29);

        jButton1.setText("Rides");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(20, 50, 80, 40);

        jButton2.setText("Wallet");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(110, 50, 80, 40);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Where can we pick you up?");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(180, 140, 310, 30);

        pickup_dropdown.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        pickup_dropdown.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "BITS-Pilani", "Secundarabad", "Hi-Tech_City" }));
        pickup_dropdown.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                pickup_dropdownFocusGained(evt);
            }
        });
        pickup_dropdown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pickup_dropdownActionPerformed(evt);
            }
        });
        getContentPane().add(pickup_dropdown);
        pickup_dropdown.setBounds(200, 190, 180, 40);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Where can we drop you?");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(190, 260, 267, 30);

        drop_dropdown.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        drop_dropdown.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "BITS-Pilani", "Secundarabad", "Hi-Tech_City" }));
        drop_dropdown.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                drop_dropdownFocusGained(evt);
            }
        });
        drop_dropdown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                drop_dropdownActionPerformed(evt);
            }
        });
        getContentPane().add(drop_dropdown);
        drop_dropdown.setBounds(200, 310, 180, 40);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Fare");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(530, 160, 48, 29);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Estimated Time");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(530, 200, 164, 29);

        book.setText("Book");
        book.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookActionPerformed(evt);
            }
        });
        getContentPane().add(book);
        book.setBounds(520, 450, 150, 40);

        jButton4.setText("Logout");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(200, 50, 90, 40);

        fare.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        fare.setForeground(new java.awt.Color(255, 255, 255));
        fare.setText("Rs. 0");
        getContentPane().add(fare);
        fare.setBounds(730, 170, 120, 20);

        time.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        time.setForeground(new java.awt.Color(255, 255, 255));
        time.setText("0 min");
        getContentPane().add(time);
        time.setBounds(730, 200, 130, 20);

        balance.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        balance.setForeground(new java.awt.Color(255, 255, 255));
        balance.setText("Rs. 120");
        getContentPane().add(balance);
        balance.setBounds(730, 240, 130, 20);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Wallet Balance");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(530, 240, 170, 29);

        modify.setText("Get Estimate");
        modify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifyActionPerformed(evt);
            }
        });
        getContentPane().add(modify);
        modify.setBounds(280, 450, 162, 40);

        jLabel9.setFont(new java.awt.Font("Gotham Medium", 1, 36)); // NOI18N
        jLabel9.setText("Book My Cab 3.0");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(350, 10, 360, 90);

        jLabel5.setIcon(new javax.swing.ImageIcon("C:\\Users\\shrey\\OneDrive\\Desktop\\shreya\\driver_blur.png")); // NOI18N
        getContentPane().add(jLabel5);
        jLabel5.setBounds(0, 0, 950, 540);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        this.setVisible(false);
        new login().setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       this.setVisible(false);
        new wallet(runame).setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.setVisible(false);
        new rides(runame).setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void pickup_dropdownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pickup_dropdownActionPerformed
           
    }//GEN-LAST:event_pickup_dropdownActionPerformed

    private void drop_dropdownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_drop_dropdownActionPerformed
   
    }//GEN-LAST:event_drop_dropdownActionPerformed
     /* Date date1 = new Date();
    long curr_time = date1.getTime();
    */
    public void update_driver()
    {
        Date date = new Date();
        long curr_time = date.getTime();
        try 
        {
            String query5 = "select * from driver ";
            PreparedStatement ps_update_driver =connect.prepareStatement(query5);
            ResultSet rs_update_driver=ps_update_driver.executeQuery();
            String driver_end_time;
            while(rs_update_driver.next()){
                    driver_end_time=rs_update_driver.getString("end_time");
                    String uid =rs_update_driver.getString("uid");
                    
                    if(Long.parseLong(driver_end_time)<=curr_time)
                    { 
                        try{
                             String query="update driver set busy = ? where uid = ?";
                             ps_update_driver=connect.prepareStatement(query);
                             ps_update_driver.setInt(1, 0);
                             ps_update_driver.setString(2, uid);
                             ps_update_driver.execute();
                           } catch(Exception e)
                           {
                                JOptionPane.showMessageDialog(null ,e);
                           }
                    }
                }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void update_customer()
    {
        Date date = new Date();
        long curr_time = date.getTime();
        try 
        {
            String query7 = "select * from cust ";
            PreparedStatement ps_update_cust =connect.prepareStatement(query7);
            ResultSet rs_update_cust=ps_update_cust.executeQuery();
            String cust_end_time;
            while(rs_update_cust.next()){
                    cust_end_time=rs_update_cust.getString("end_time");
                    String  txt_user_id =rs_update_cust.getString("txt_user_id");
                    
                    if(Long.parseLong(cust_end_time)<=curr_time)
                    { 
                        try{
                             String query="update cust set busy = ? where txt_user_id = ?";
                             ps_update_cust=connect.prepareStatement(query);
                             ps_update_cust.setInt(1, 0);
                             ps_update_cust.setString(2, txt_user_id);
                             ps_update_cust.execute();
                           } catch(Exception e)
                           {
                                JOptionPane.showMessageDialog(null ,e);
                           }
                    }
                    
                }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public String get_driver(int given_location)
    {
       try 
        {
            String query_get_driver = "select * from driver where curr_loc=? and busy=? ";
            PreparedStatement ps_get_driver =connect.prepareStatement(query_get_driver);
            ps_get_driver.setInt(1,given_location);
            ps_get_driver.setInt(2,0);
            ResultSet rs_get_driver=ps_get_driver.executeQuery();
            if(rs_get_driver==null) return null;
            double max_rating=0.0;
            while(rs_get_driver.next())
            {   
                    if(rs_get_driver.getDouble("rating")>max_rating)
                    {
                         selected_driver_uid =rs_get_driver.getString("uid"); 
                         max_rating=rs_get_driver.getDouble("rating");
                    }
            }
            
            
        }catch(Exception e)
        {
            //JOptionPane.showMessageDialog(null ,"Request Timed Out! No Drivers are  currently available.. ");
            //System.out.println(e.getMessage());
        }
       
       return selected_driver_uid;
    }
    
    public int get_nearest_location(int given_location)
    {
        int min=500;//500 just max time possible
        int min_index=given_location;
        for(int i=0;i<est_time[given_location].length;i++)
        {
            if(est_time[given_location][i]<min && est_time[given_location][i]!=0)
            {
                min = est_time[given_location][i];
                min_index=i;
            }
        }
        nearest_loc[given_location][min_index]=0;
        return min_index;
    }
    
    public void refresh_drivers()
    {
        try 
        {
            String query5 = "select * from history ";
            PreparedStatement ps_update_driver =connect.prepareStatement(query5);
            ResultSet rs_update_driver=ps_update_driver.executeQuery();
            int count=0;
            while(rs_update_driver.next()){
                    count++;
                    
            }
            System.out.println(count+"hello");
            query5 = "select * from driver where busy=0 ";
            ps_update_driver =connect.prepareStatement(query5);
            rs_update_driver=ps_update_driver.executeQuery();
            String[] avai_driver_refresh = new String[10];
            Random rand = new Random();
            int i=0;
            while(rs_update_driver.next()){
                   avai_driver_refresh[i]= rs_update_driver.getString("uid");
                   i++; 
            }
           
           
            if(count%15==0) 
            {
                query5 = "update driver set curr_loc=? where uid=? ";
                ps_update_driver =connect.prepareStatement(query5);
                
                for(int j=0;j<i;j++)
                {
                    ps_update_driver.setInt(1,(j%3));
                    ps_update_driver.setString(2,avai_driver_refresh[j]);
                    ps_update_driver.execute();
                   
                }
                
            }   
                    
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    private void bookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookActionPerformed
      /*if(modify_flag==false)
      {JOptionPane.showMessageDialog(null ,"Please modify your search");}
      else*/ 
      int user_status=0;
      update_driver();
      update_customer();
      refresh_drivers();
     
      String query10="select * from cust where txt_user_id=?";
      PreparedStatement ps1=null;
        try {
            ps1 = connect.prepareStatement(query10);
            ps1.setString(1, runame);
            rs3=ps1.executeQuery();
            if(rs3.next()) {
                user_status= rs3.getInt("busy"); 
                System.out.println(user_status);
            }
        }
         catch (SQLException ex) {
            System.out.println("Entered");
            System.out.println(ex.getMessage());                    // DOubt??//
        } 
    
      
      if(user_status==1)
      {
          JOptionPane.showMessageDialog(null ,"You are on a ride now.Please try again after completing your trip.");
      }
       else if(book_flag==false)
      {
          JOptionPane.showMessageDialog(null ,"Pickup and drop locations cannot be same");
      }
      else if(rbalance<=300)
      {
          JOptionPane.showMessageDialog(null ,"Minimum required balance is RS/-300.Please update your wallet.");
      }
      
    else  
      {
      int count_of_search_driver = est_fare.length-1;
      nearest_loc= est_time;
      String driver_details=get_driver(pickup_dropdown.getSelectedIndex());
      
      while(driver_details == null && count_of_search_driver>0)
      {
          driver_details=get_driver(get_nearest_location(pickup_dropdown.getSelectedIndex()));
          count_of_search_driver--;
      }
      if(driver_details == null)
          JOptionPane.showMessageDialog(null ,"Request Timed Out! No drivers are available right now.. Please try after some time.");
      else
      {
           this.setVisible(false);
           new confirmation(runame,driver_details,book_fare,book_est_time,pickup_dropdown.getSelectedIndex(),drop_dropdown.getSelectedIndex()).setVisible(true);
      }
      
      
      
     // System.out.println(driver_details);
     //if no driver available, get driver returns null, also returns driver of max rating
      
    
      }  
        
    }//GEN-LAST:event_bookActionPerformed

    private void modifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifyActionPerformed
         
       
       //update_customer();
       //update_driver();
       //refresh_drivers();
       if(pickup_dropdown.getSelectedIndex() == drop_dropdown.getSelectedIndex())
         book_flag=false;
       else
           book_flag=true;
       
       book_fare=est_fare[pickup_dropdown.getSelectedIndex()][drop_dropdown.getSelectedIndex()];
       book_est_time= est_time[pickup_dropdown.getSelectedIndex()][drop_dropdown.getSelectedIndex()];
       
        //JOptionPane.showMessageDialog(null ,"Pickup and Drop location cannot be same");
       fare.setText("RS. "+book_fare);
       time.setText(book_est_time+" min");
       modify_flag=true;
       book.setEnabled(true);
    }//GEN-LAST:event_modifyActionPerformed

    private void pickup_dropdownFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pickup_dropdownFocusGained
        modify_flag=false;
        book.setEnabled(false);
        
    }//GEN-LAST:event_pickup_dropdownFocusGained

    private void drop_dropdownFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_drop_dropdownFocusGained
       modify_flag=false;
       book.setEnabled(false);
       
       
    }//GEN-LAST:event_drop_dropdownFocusGained

   
   /* public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new booking().setVisible(true);
            }
        });
    }*/

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel balance;
    private javax.swing.JButton book;
    private javax.swing.JComboBox<String> drop_dropdown;
    private javax.swing.JLabel fare;
    private javax.swing.JLabel hi_name;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JButton modify;
    private javax.swing.JComboBox<String> pickup_dropdown;
    private javax.swing.JLabel time;
    // End of variables declaration//GEN-END:variables
}
