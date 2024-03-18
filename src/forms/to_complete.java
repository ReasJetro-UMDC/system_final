/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package forms;
import static forms.complete.completed_table;
import static forms.history.history_table;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author troy
 */
public class to_complete extends javax.swing.JFrame {
    
 private static final String username = "root" ;
    private static final String password = "1234" ;
    private static final String dataconn = "jdbc:mysql://127.0.0.1:3306/workjob" ; 
    
    Connection sql = null;
    PreparedStatement pst,pst1  = null;
    ResultSet rs = null;
    int q, i;
    
    /**
     * Creates new form to_complete
     */
    public to_complete() {
        initComponents();
    }
public void UpdateDb () {
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        sql = DriverManager.getConnection(dataconn,username,password);
        pst1 = sql.prepareStatement("select * from complete");
        rs = pst1.executeQuery();
        
        ResultSetMetaData stdata = rs.getMetaData();
        
        q = stdata.getColumnCount();
        DefaultTableModel RecordTable = (DefaultTableModel)completed_table.getModel();
                RecordTable.setRowCount(0);
        while (rs.next()){
            Vector columnData = new Vector();
            
            for ( i = 1; i < q; i++)
            
             {  
                
                 columnData.add(rs.getString("Check_in_complete"));
                 columnData.add(rs.getString("time_complete"));
                 columnData.add(rs.getString("Costumer_Name_complete"));
                 columnData.add(rs.getString("Service_Rendered_complete"));
                 columnData.add(rs.getString("price_complete"));
                 columnData.add(rs.getString("Emplooyee_Assigned_complete"));
                 
            }
            RecordTable.addRow(columnData);
        }        
    }
    catch (Exception e) {
        JOptionPane.showMessageDialog(null, e);
    }
    
}
public void UpdateDb1 () {
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        sql = DriverManager.getConnection(dataconn,username,password);
        
        pst = sql.prepareStatement("select * from history");
        rs = pst.executeQuery();
        
        ResultSetMetaData stdata = rs.getMetaData();
        
        q = stdata.getColumnCount();
        DefaultTableModel RecordTable = (DefaultTableModel)history_table.getModel();
                RecordTable.setRowCount(0);
        while (rs.next()){
            Vector columnData = new Vector();
            
            for ( i = 1; i < q; i++)
            
             {  
                
                 columnData.add(rs.getString("Check_in"));
                 columnData.add(rs.getString("time"));
                 columnData.add(rs.getString("Costumer_Name"));
                 columnData.add(rs.getString("Service_Rendered"));
                 columnData.add(rs.getString("price"));
                 columnData.add(rs.getString("Emplooyee_Assigned"));
                 
            }
            RecordTable.addRow(columnData);
        }        
    }
    catch (Exception e) {
        JOptionPane.showMessageDialog(null, e);
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtCheckin3 = new javax.swing.JTextField();
        txtTime3 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtcstname3 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtsr3 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        done = new javax.swing.JButton();
        txtprice3 = new javax.swing.JTextField();
        txtea3 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Checked in");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));
        jPanel1.add(txtCheckin3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 130, 30));
        jPanel1.add(txtTime3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, 130, 30));

        jLabel2.setText("Time");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 60, -1, -1));

        txtcstname3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcstname3ActionPerformed(evt);
            }
        });
        jPanel1.add(txtcstname3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 130, 30));

        jLabel3.setText("Customer Name");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));
        jPanel1.add(txtsr3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 140, 130, 30));

        jLabel4.setText("Service Rendered");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, -1, -1));

        done.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        done.setText("Done");
        done.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doneActionPerformed(evt);
            }
        });
        jPanel1.add(done, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 260, -1, -1));

        txtprice3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtprice3ActionPerformed(evt);
            }
        });
        jPanel1.add(txtprice3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 130, 30));
        jPanel1.add(txtea3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 210, 130, 30));

        jLabel5.setText("Price");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, -1, -1));

        jLabel6.setText("Employee Assigned");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 190, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("To Complete");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 260, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 322, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 310, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 6, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtcstname3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcstname3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcstname3ActionPerformed

    private void doneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doneActionPerformed
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
             sql = DriverManager.getConnection(dataconn, username, password);
             pst1 = sql.prepareStatement("INSERT INTO complete (Check_in_complete, time_complete, Costumer_Name_complete, Service_Rendered_complete,price_complete,Emplooyee_Assigned_complete) VALUES (?,?,?,?,?,?) ");
             pst = sql.prepareStatement("INSERT INTO history (Check_in, time, Costumer_Name, Service_Rendered, price, Emplooyee_Assigned) VALUES (?,?,?,?,?,?) ");
            
            String name = txtCheckin3.getText();
            String work = txtTime3.getText();
            String assignedEmployee = txtcstname3.getText();
            String serviceRendered = txtsr3.getText();
            String price = txtprice3.getText();
            String employee = txtea3.getText();

            if(name == null || work == null || assignedEmployee == null || serviceRendered == null || price == null || employee == null) {

            JOptionPane.showMessageDialog(this, "Please fill in all fields", "Error", JOptionPane.ERROR_MESSAGE);
            return;
            }
   
            pst1.setString(1, name);
            pst1.setString(2, work);
            pst1.setString(3, assignedEmployee);
            pst1.setString(4, serviceRendered);
            pst1.setString(5, price);
            pst1.setString(6, employee);
            
            pst.setString(1, name);
            pst.setString(2, work);
            pst.setString(3, assignedEmployee);
            pst.setString(4, serviceRendered);
            pst.setString(5, price);
            pst.setString(6, employee);

            pst.executeUpdate();
            pst1.executeUpdate();
         
            JOptionPane.showMessageDialog(this, "Record Added");
            
            UpdateDb1();
            UpdateDb();

            dispose();

        } catch (ClassNotFoundException ex) {
            ex.printStackTrace(); 
            JOptionPane.showMessageDialog(this, "Database driver not found", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            ex.printStackTrace(); 
            JOptionPane.showMessageDialog(this, "Error inserting record: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_doneActionPerformed

    private void txtprice3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtprice3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtprice3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(to_complete.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(to_complete.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(to_complete.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(to_complete.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new to_complete().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton done;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    public static javax.swing.JPanel jPanel1;
    public static javax.swing.JTextField txtCheckin3;
    public static javax.swing.JTextField txtTime3;
    public static javax.swing.JTextField txtcstname3;
    public static javax.swing.JTextField txtea3;
    public static javax.swing.JTextField txtprice3;
    public static javax.swing.JTextField txtsr3;
    // End of variables declaration//GEN-END:variables

   
}
