
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author shreya
 */
public class rides extends javax.swing.JFrame {

    Connection connect= null;
    String runame;
    String rname;
    String driver_name;
    boolean flag=false; 
     PreparedStatement st1=null,smt=null,pst1=null,ps=null,pstmt=null,pst2=null;
    ResultSet rs1,rs,rs2,rs3;
    public rides(String txt_user_id) {
        initComponents();
        runame=txt_user_id;
        this.setLocationRelativeTo(null);
        this.getRootPane().setDefaultButton(back);
        connect=dbm.dbconnect();
         String query2="select * from cust where txt_user_id=?";
        PreparedStatement ps1=null;
        try {
            ps1 = connect.prepareStatement(query2);
            ps1.setString(1, txt_user_id);
            rs3=ps1.executeQuery();
             while(rs3.next()) {
                rname = rs3.getString("txt_name");
            }
            //rname=rs3.getString("name");
            hi_name.setText("Hi, "+rname);}
         catch (SQLException ex) {
           // System.out.println("Entered");
            System.out.println(ex.getMessage());                    // DOubt??//
        }
        //get_status();
        updateRideStatus();
        updateTable();
    }
    void updateTable(){
        String sql="select start_pt as Pickup_Location,end_pt as Drop_Location,start_time as Date,name as Driver_Name, status as Status from history where txt_user_id=? order by start_time desc";
        try {
            smt=connect.prepareStatement(sql);
            smt.setString(1, runame);
            rs=smt.executeQuery();
            
            jTable1.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        changeTimeFormat();
        jTable1.setEnabled(false);
    }
    
    void updateRideStatus(){
        Date date = new Date();
        long curr_time = date.getTime();
        try 
        {
            String query7 = "select * from history where txt_user_id=? and status = \"Ongoing\"";
            PreparedStatement ps_update_cust = connect.prepareStatement(query7);
            ps_update_cust.setString(1, runame);
            ResultSet rs_update_cust = ps_update_cust.executeQuery();
            String cust_end_time;
            
            while(rs_update_cust.next()){
                    
                   cust_end_time = rs_update_cust.getString("end_time");
                    String txt_user_id = rs_update_cust.getString("txt_user_id");
                    
                    //System.out.print(cust_end_time+ " ");
                    //System.out.println(curr_time);
                    if(Long.parseLong(cust_end_time) < curr_time)
                    {   
                        
                        try{
                             //flag=true;
                             String query = "update history set status = \"Completed\" where txt_user_id = ? and end_time=?";
                             ps_update_cust = connect.prepareStatement(query);
                             ps_update_cust.setString(1, txt_user_id);
                             ps_update_cust.setString(2, cust_end_time); 
                             ps_update_cust.execute();
                             
                             
                           } catch(Exception e){
                                JOptionPane.showMessageDialog(null ,e);
                           }
                       
                    }
                    
                }
            //if(!rs_update_cust.next())
                driver_name=rs_update_cust.getString("name");
        }catch(Exception e){
            //System.out.println("hello");
        }
        
        
       // return false;
    }
    
    void changeTimeFormat(){
        int column = 2;
        
        try{
            for(int row=0;row<1000;++row){
                String value = jTable1.getModel().getValueAt(row, column).toString();
                Date start_time = new Date(Long.parseLong(value));
                String time_hours= ((String.valueOf(start_time.getHours())).length()>1)?String.valueOf(start_time.getHours()):("0"+String.valueOf(start_time.getHours()));
                String time_minutes= ((String.valueOf(start_time.getMinutes())).length()>1)?String.valueOf(start_time.getMinutes()):("0"+String.valueOf(start_time.getMinutes()));
                String todaycheck=String.valueOf(start_time.getDate()+2)+"/"+String.valueOf(start_time.getMonth()+1)+"/"+String.valueOf(1900+start_time.getYear())+"  "+ time_hours +":"+time_minutes;
                jTable1.setValueAt(todaycheck, row, column);
            }
        }catch(Exception ex){
            
        }
            
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    
    public class check_status extends Thread
    {
     public void run()
      {
          
        try
        { 
           while(!flag)
           {
               updateRideStatus();
               updateTable();
               if(flag)
               {
                   updateRideStatus();
                   updateTable();
                   break;
               }
               
               Thread.sleep(1000);
               
           }
           //System.out.println(flag);
           
        } 
        
        catch (Exception e) 
        { 
            // Throwing an exception 
            System.out.println ("Exception is caught"); 
        } 
     }
    }
    Thread object;
    public void get_status()
    {
        object = new Thread(new check_status()); 
        object.start();
       
        
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        hi_name = new javax.swing.JLabel();
        back = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(938, 540));
        setMinimumSize(new java.awt.Dimension(938, 540));
        setPreferredSize(new java.awt.Dimension(938, 540));
        getContentPane().setLayout(null);

        jButton2.setText("Wallet");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(20, 40, 99, 42);

        jButton4.setText("Logout");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(140, 40, 96, 42);

        hi_name.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        hi_name.setForeground(new java.awt.Color(255, 255, 255));
        hi_name.setText("Hello XYZ!");
        getContentPane().add(hi_name);
        hi_name.setBounds(730, 30, 200, 29);

        back.setText("Back");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        getContentPane().add(back);
        back.setBounds(610, 430, 109, 46);

        jTable1.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(90, 120, 737, 286);

        jButton1.setText("Refresh");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(200, 430, 121, 46);

        jLabel10.setFont(new java.awt.Font("Gotham Medium", 1, 36)); // NOI18N
        jLabel10.setText("Book My Cab 3.0");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(300, 10, 360, 90);

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\shrey\\OneDrive\\Desktop\\shreya\\driver_blur.png")); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, -30, 1060, 590);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.setVisible(false);
        new wallet(runame).setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        this.setVisible(false);
        new login().setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
    	/*this.setVisible(false);
    	rideover rideOverWindow = new rideover(runame, driver_name);
        rideOverWindow.setVisible(true);  */  	

        this.setVisible(false);
        new booking(runame).setVisible(true);
    }//GEN-LAST:event_backActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        updateRideStatus();
        updateTable();
    }//GEN-LAST:event_jButton1ActionPerformed

   
   /* public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new rides().setVisible(true);
            }
        });
    }*/

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JLabel hi_name;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
