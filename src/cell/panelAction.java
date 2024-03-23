/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package cell;


import static forms.appointment.pending_table;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Jake Marson Nable
 */
public class panelAction extends javax.swing.JPanel {

   private static final String username = "root" ;
    private static final String password = "1234" ;
    private static final String dataconn = "jdbc:mysql://127.0.0.1:3306/workjob" ; 
    
    Connection sql = null;
    PreparedStatement pst  = null;
    ResultSet rs = null;
    int i, q, id, deleteitem;
    
  /**
     * Creates new form panelAction
     */
    public panelAction() {
        initComponents();
    }
 public void UpdateDb() {
     try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        sql = DriverManager.getConnection(dataconn, username, password);
        pst = sql.prepareStatement("SELECT * FROM workjob");
        rs = pst.executeQuery();
        
        DefaultTableModel RecordTable = (DefaultTableModel) pending_table.getModel();
        RecordTable.setRowCount(0); 
        
        while (rs.next()) {
            
            Vector<Object> rowData = new Vector<>();
            rowData.add(rs.getInt("id"));
            rowData.add(rs.getString("check_in"));
            rowData.add(rs.getString("Time"));
            rowData.add(rs.getString("Customer_name"));
            rowData.add(rs.getString("Service_rendered"));
            rowData.add(rs.getString("Price"));
            rowData.add(rs.getString("Employee_Assigned"));
            RecordTable.addRow(rowData); 
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e.getMessage());
        e.printStackTrace(); 
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

        TAB_edit = new cell.actionButton();
        TAB_delete = new cell.actionButton();

        setBackground(new java.awt.Color(255, 255, 255));

        TAB_edit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-edit-24.png"))); // NOI18N
        TAB_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TAB_editActionPerformed(evt);
            }
        });

        TAB_delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-delete-24.png"))); // NOI18N
        TAB_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TAB_deleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(TAB_edit, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TAB_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TAB_delete, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TAB_edit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void TAB_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TAB_deleteActionPerformed

 
   DefaultTableModel recordTable = (DefaultTableModel) pending_table.getModel();
int selectedRows = pending_table.getSelectedRow();

try {
    if (selectedRows != -1) { 
        int id = Integer.parseInt(recordTable.getValueAt(selectedRows, 0).toString());

        int deleteItem = JOptionPane.showConfirmDialog(null, "Confirm if you want to delete item", "Warning", JOptionPane.YES_NO_OPTION);
        if (deleteItem == JOptionPane.YES_OPTION) {
            
            try (Connection connection = DriverManager.getConnection(dataconn, username, password)) {
                
                String deleteQuery = "DELETE FROM workjob WHERE id = ?";
                try (PreparedStatement pst = connection.prepareStatement(deleteQuery)) {
                    pst.setInt(1, id);
                    int rowsAffected = pst.executeUpdate();
                    if (rowsAffected > 0) {
                        JOptionPane.showMessageDialog(this, "Record deleted");
                        UpdateDb(); 
                    } else {
                        JOptionPane.showMessageDialog(this, "No record with ID " + id + " found.", "Warning", JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
        }
    } else {
        JOptionPane.showMessageDialog(this, "Please select a row to delete.", "Warning", JOptionPane.WARNING_MESSAGE);
    }
} catch (SQLException ex) {
    JOptionPane.showMessageDialog(this, "SQL Error: " + ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
    ex.printStackTrace(); 
} catch (NumberFormatException ex) {
    JOptionPane.showMessageDialog(this, "Invalid ID format.", "ERROR", JOptionPane.ERROR_MESSAGE);
} catch (Exception ex) {
    JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
    ex.printStackTrace(); 
}



    }//GEN-LAST:event_TAB_deleteActionPerformed

    private void TAB_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TAB_editActionPerformed

    try {
    Class.forName("com.mysql.cj.jdbc.Driver");
    Connection sql = DriverManager.getConnection(dataconn, username, password);
    
    DefaultTableModel model = (DefaultTableModel) pending_table.getModel();
    int rowCount = model.getRowCount();
     
    for (int i = 0; i < rowCount; i++) {
        int id = (int) model.getValueAt(i, 0); 
        String checkIn = (String) model.getValueAt(i, 1);
        String time = (String) model.getValueAt(i, 2);
        String customerName = (String) model.getValueAt(i, 3);
        String serviceRendered = (String) model.getValueAt(i, 4);
        String price = (String) model.getValueAt(i, 5);
        String employeeAssigned = (String) model.getValueAt(i, 6);
      
        PreparedStatement pst = sql.prepareStatement("UPDATE workjob SET check_in = ?, Time = ?, Customer_name = ?, Service_rendered = ?, Price = ?, Employee_Assigned = ? WHERE id = ?");
        
        pst.setString(1, checkIn);
        pst.setString(2, time);
        pst.setString(3, customerName);
        pst.setString(4, serviceRendered);
        pst.setString(5, price);
        pst.setString(6, employeeAssigned);
        pst.setInt(7, id);
        
       
        pst.executeUpdate();
        
        
        pst.close();
    }
    
   
    sql.close();
    
    
    JOptionPane.showMessageDialog(this, "Records updated successfully");
        int selectedRow = 0;
    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(this, "Please select a row to update", "Error", JOptionPane.ERROR_MESSAGE);
        return; // Exit the method
    }
} catch (ClassNotFoundException ex) {
    JOptionPane.showMessageDialog(this, "Database driver not found", "Error", JOptionPane.ERROR_MESSAGE);
    ex.printStackTrace(); 
} catch (SQLException ex) {
    JOptionPane.showMessageDialog(this, "Error updating records: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    ex.printStackTrace(); 
}








    }//GEN-LAST:event_TAB_editActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static cell.actionButton TAB_delete;
    public static cell.actionButton TAB_edit;
    // End of variables declaration//GEN-END:variables





}