import java.awt.Color;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.*;
import java.util.regex.Pattern;
import java.util.*;



public class signup extends javax.swing.JFrame {
    
    Connection connect =null;
    public signup() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.getRootPane().setDefaultButton(proceed);
        connect=dbm.dbconnect();
    }

    /**
     * Creates new form signup
     */
   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        proceed = new javax.swing.JButton();
        cancel = new javax.swing.JButton();
        txt_name = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txt_phone_number = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txt_email = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_user_id = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        txt_password = new javax.swing.JPasswordField();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(938, 540));
        setMinimumSize(new java.awt.Dimension(938, 540));
        setPreferredSize(new java.awt.Dimension(938, 540));
        getContentPane().setLayout(null);

        proceed.setFont(new java.awt.Font("Montserrat", 1, 20)); // NOI18N
        proceed.setText("PROCEED");
        proceed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                proceedActionPerformed(evt);
            }
        });
        getContentPane().add(proceed);
        proceed.setBounds(300, 420, 148, 40);

        cancel.setFont(new java.awt.Font("Montserrat", 1, 20)); // NOI18N
        cancel.setText("CANCEL");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });
        getContentPane().add(cancel);
        cancel.setBounds(600, 420, 136, 40);

        txt_name.setForeground(new java.awt.Color(204, 204, 204));
        txt_name.setText("Enter Name");
        txt_name.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_nameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_nameFocusLost(evt);
            }
        });
        txt_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nameActionPerformed(evt);
            }
        });
        getContentPane().add(txt_name);
        txt_name.setBounds(480, 120, 165, 26);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Name");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(300, 120, 60, 22);

        txt_phone_number.setForeground(new java.awt.Color(204, 204, 204));
        txt_phone_number.setText("Enter Phone Number");
        txt_phone_number.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_phone_numberFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_phone_numberFocusLost(evt);
            }
        });
        getContentPane().add(txt_phone_number);
        txt_phone_number.setBounds(480, 170, 165, 26);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Phone Number");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(300, 170, 140, 22);

        txt_email.setForeground(new java.awt.Color(204, 204, 204));
        txt_email.setText("Enter Email ID");
        txt_email.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_emailFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_emailFocusLost(evt);
            }
        });
        getContentPane().add(txt_email);
        txt_email.setBounds(480, 220, 165, 26);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Email-ID");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(300, 220, 90, 20);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("User-ID");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(300, 270, 70, 20);

        txt_user_id.setForeground(new java.awt.Color(204, 204, 204));
        txt_user_id.setText("Enter User ID");
        txt_user_id.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_user_idFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_user_idFocusLost(evt);
            }
        });
        getContentPane().add(txt_user_id);
        txt_user_id.setBounds(480, 270, 165, 26);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Password");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(300, 330, 90, 20);

        jCheckBox1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jCheckBox1.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox1.setText("Show Password");
        jCheckBox1.setOpaque(false);
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });
        getContentPane().add(jCheckBox1);
        jCheckBox1.setBounds(610, 330, 160, 29);
        getContentPane().add(txt_password);
        txt_password.setBounds(480, 330, 103, 26);

        jLabel7.setFont(new java.awt.Font("Gotham Medium", 1, 36)); // NOI18N
        jLabel7.setText("Book My Cab 2.0");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(320, 10, 360, 90);

        jLabel6.setIcon(new javax.swing.ImageIcon("C:\\Users\\shrey\\OneDrive\\Desktop\\shreya\\driver_blur.png")); // NOI18N
        getContentPane().add(jLabel6);
        jLabel6.setBounds(-490, 0, 1470, 550);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_nameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_nameFocusGained
        if(txt_name.getText().equals("Enter Name")){
        txt_name.setText(null);
        txt_name.setForeground(Color.BLACK);}
    }//GEN-LAST:event_txt_nameFocusGained

    private void txt_nameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_nameFocusLost
        if(txt_name.getText().equals("")){
        txt_name.setForeground(new Color(204,204,204));
        txt_name.setText("Enter Name");}
    }//GEN-LAST:event_txt_nameFocusLost

    private void txt_phone_numberFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_phone_numberFocusGained
         if(txt_phone_number.getText().equals("Enter Phone Number")){
        txt_phone_number.setText(null);
        txt_phone_number.setForeground(Color.BLACK);}
    }//GEN-LAST:event_txt_phone_numberFocusGained

    private void txt_phone_numberFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_phone_numberFocusLost
        if(txt_phone_number.getText().equals("")){
        txt_phone_number.setForeground(new Color(204,204,204));
        txt_phone_number.setText("Enter Phone Number");}
    }//GEN-LAST:event_txt_phone_numberFocusLost

    private void txt_user_idFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_user_idFocusGained
         if(txt_user_id.getText().equals("Enter User ID")){
        txt_user_id.setText(null);
        txt_user_id.setForeground(Color.BLACK);}
    }//GEN-LAST:event_txt_user_idFocusGained

    private void txt_user_idFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_user_idFocusLost
        if(txt_user_id.getText().equals("")){
        txt_user_id.setForeground(new Color(204,204,204));
        txt_user_id.setText("Enter User ID");}
    }//GEN-LAST:event_txt_user_idFocusLost

    private void txt_emailFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_emailFocusGained
         if(txt_email.getText().equals("Enter Email ID")){
        txt_email.setText(null);
        txt_email.setForeground(Color.BLACK);}
    }//GEN-LAST:event_txt_emailFocusGained

    private void txt_emailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_emailFocusLost
        if(txt_email.getText().equals("")){
        txt_email.setForeground(new Color(204,204,204));
        txt_email.setText("Enter Email ID");}
    }//GEN-LAST:event_txt_emailFocusLost

    private void txt_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nameActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        if(jCheckBox1.isSelected()){
    txt_password.setEchoChar((char)0);
    }else
    txt_password.setEchoChar('*');
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void proceedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_proceedActionPerformed
        boolean name_flag=true,phone_flag=true,add=true,coun=true;
        Long num;
        
        try {
             num = Long.parseLong(txt_phone_number.getText());
             System.out.println("num is set");
        } catch (NumberFormatException e) {
            coun = false;
            System.out.println(e.getMessage());
        }
        
        if("Enter Name".equals(txt_name.getText()) || !(Pattern.matches("[a-zA-Z]+", txt_name.getText()))){
        name_flag=false;
        JOptionPane.showMessageDialog(null, "Enter Valid Name");}
        
        else if( !coun || "Enter Phone Number".equals(txt_phone_number.getText()) || (txt_phone_number.getText()).length()!=10){
             JOptionPane.showMessageDialog(null, "Enter Valid Phone Number");}
                   
             else if("Enter Email ID".equals(txt_email.getText()) || !verify_email(txt_email.getText())){
                  JOptionPane.showMessageDialog(null, "Enter a Valid Email-ID");}
                       
                
                            
                            
                        else if("Enter User ID".equals(txt_user_id.getText())){
                             JOptionPane.showMessageDialog(null, "Enter Valid User ID");}
                            
                             else if(txt_password.getPassword().length==0){
                                  JOptionPane.showMessageDialog(null, "Enter Valid Password");}
                                      
                                      
                                  else{  
                                      String name = txt_name.getText();   
                                      String phone =txt_phone_number.getText();
                                      String email = txt_email.getText();
                                      String username = txt_user_id.getText();
                                      String password = String.valueOf(txt_password.getPassword());
                                      String zero =String.valueOf(0);
                             
                                      try{
                                            String query="insert into cust values(?,?,?,?,?,?,?,?,?)";
                                             PreparedStatement ps=null;
                                             ps=connect.prepareStatement(query);
                                             ps.setString(1, name);
                                             ps.setString(2, username);
                                             ps.setString(3, email);
                                             ps.setString(4, password);
                                             ps.setString(5, phone);
                                             ps.setInt(6, 0);
                                             ps.setInt(7, 0);
                                             ps.setString(8, zero);
                                             ps.setString(9, zero);
                                             ps.execute();
                                             this.setVisible(false);
                                             new login().setVisible(true);
                                            JOptionPane.showMessageDialog(null, "Signup Successful");
                                            }catch (java.sql.SQLException e){
                                                System.out.println(e.getMessage());
                                            JOptionPane.showMessageDialog(null, "Username Already Taken");
                                            }
                                            catch(Exception e){
                                            JOptionPane.showMessageDialog(null ,e);
                                            }
                             
                             
                                      }
                                      
                                    
                            
                            
                       
                       
               
                                
        
                
                
                        
                    
               
                  
       
        
        
        
        
    }//GEN-LAST:event_proceedActionPerformed

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
       this.setVisible(false);
        new login().setVisible(true);
        
    }//GEN-LAST:event_cancelActionPerformed
    
    public boolean verify_email(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+ 
                            "[a-zA-Z0-9_+&*-]+)*@" + 
                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
                            "A-Z]{2,7}$";
        Pattern pat = Pattern.compile(emailRegex); 
        if (email == null) 
            return false;
        return pat.matcher(email).matches();
    }
    /**
     * @param args the command line arguments
     */
   /* public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new signup().setVisible(true);
            }
        });
    }*/

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancel;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JButton proceed;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_name;
    private javax.swing.JPasswordField txt_password;
    private javax.swing.JTextField txt_phone_number;
    private javax.swing.JTextField txt_user_id;
    // End of variables declaration//GEN-END:variables
}
