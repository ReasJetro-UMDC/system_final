/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package forms;
import static forms.appointment.ongoing_table;
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
public class to_ongoing extends javax.swing.JFrame {

    private static final String username = "root" ;
    private static final String password = "1234" ;
    private static final String dataconn = "jdbc:mysql://127.0.0.1:3306/workjob" ;
    
    Connection sql = null;
    PreparedStatement pst  = null;
    ResultSet rs = null;
    int q, i, id;
    /**
     * Creates new form to_ongoing
     */
    public to_ongoing() {
        initComponents();
    }
     public void UpdateDb () {
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        sql = DriverManager.getConnection(dataconn,username,password);
        pst = sql.prepareStatement("select * from ongoing_table");
        rs = pst.executeQuery();
        ResultSetMetaData stdata = rs.getMetaData();
        q = stdata.getColumnCount();
        DefaultTableModel RecordTable = (DefaultTableModel)ongoing_table.getModel();
                RecordTable.setRowCount(0);
        while (rs.next()){
            Vector columnData = new Vector();
            
            for ( i = 1; i < q; i++)
             {  
                 columnData.add(rs.getString("idongoing_table"));
                 columnData.add(rs.getString("ongoing_checkin"));
                 columnData.add(rs.getString("ongoing_time"));
                 columnData.add(rs.getString("ongoing_name"));
                 columnData.add(rs.getString("ongoing_sr"));
                 columnData.add(rs.getString("ongoing_price"));
                 columnData.add(rs.getString("ongoing_employee"));
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        done = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Checked in");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));
        jPanel1.add(txtCheckin2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 130, 30));
        jPanel1.add(txtTime2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 80, 130, 30));

        jLabel2.setText("Time");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 60, -1, -1));

        txtcstname2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcstname2ActionPerformed(evt);
            }
        });
        jPanel1.add(txtcstname2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 130, 30));

        jLabel3.setText("Customer Name");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));
        jPanel1.add(txtsr2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 140, 130, 30));

        jLabel4.setText("Service Rendered");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 120, -1, -1));

        done.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        done.setText("DONE");
        done.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doneActionPerformed(evt);
            }
        });
        jPanel1.add(done, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 270, -1, -1));

        txtprice2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtprice2ActionPerformed(evt);
            }
        });
        jPanel1.add(txtprice2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 130, 30));

        jLabel5.setText("Price");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, -1, -1));

        jLabel6.setText("Employee Assigned");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 190, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("To Ongoing");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 12, 260, 30));

        employ2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Jetro", "Jake", "Clarisse", "Eliza" }));
        employ2.setSelectedItem(null);
        jPanel1.add(employ2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 210, 130, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 310, 310));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtcstname2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcstname2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcstname2ActionPerformed

    private void doneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doneActionPerformed
    
        try {
    Class.forName("com.mysql.cj.jdbc.Driver");
    Connection sql = DriverManager.getConnection(dataconn, username, password);
    PreparedStatement pst = sql.prepareStatement("INSERT INTO ongoing_table (ongoing_checkin, ongoing_time, ongoing_name, ongoing_sr,ongoing_price,ongoing_employee) VALUES (?,?,?,?,?,?) ");
    
    String name = txtCheckin2.getText();
    String work = txtTime2.getText();
    String assignedEmployee = txtcstname2.getText();
    String serviceRendered = txtsr2.getText();
    String price = txtprice2.getText();
    String employee = (String) employ2.getSelectedItem();

    if(name == null || work == null || assignedEmployee == null || serviceRendered == null || price == null || employee == null) {
       
        JOptionPane.showMessageDialog(this, "Please fill in all fields", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
    
    pst.setString(1, name);
    pst.setString(2, work);
    pst.setString(3, assignedEmployee);
    pst.setString(4, serviceRendered);
    pst.setString(5, price);
    pst.setString(6, employee);
    
    pst.executeUpdate();
    JOptionPane.showMessageDialog(this, "Record Added");
    
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

    private void txtprice2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtprice2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtprice2ActionPerformed

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
            java.util.logging.Logger.getLogger(to_ongoing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(to_ongoing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(to_ongoing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(to_ongoing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new to_ongoing().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton done;
    public static final javax.swing.JComboBox<String> employ2 = new javax.swing.JComboBox<>();
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    public static javax.swing.JPanel jPanel1;
    public static final javax.swing.JTextField txtCheckin2 = new javax.swing.JTextField();
    public static final javax.swing.JTextField txtTime2 = new javax.swing.JTextField();
    public static final javax.swing.JTextField txtcstname2 = new javax.swing.JTextField();
    public static final javax.swing.JTextField txtprice2 = new javax.swing.JTextField();
    public static final javax.swing.JTextField txtsr2 = new javax.swing.JTextField();
    // End of variables declaration//GEN-END:variables

    void setId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
