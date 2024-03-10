/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package forms;

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
 * @author Jake Marson Nable
 */
public class dashboard extends javax.swing.JPanel {
    private static final String username = "root" ;
    private static final String password = "1234" ;
    private static final String dataconn = "jdbc:mysql://127.0.0.1:3306/workjob" ; 
    
    Connection sql = null;
    PreparedStatement pst,pst1  = null;
    ResultSet rs = null;
    int q, i;
    
    
    public dashboard() {
        initComponents();
       
    }
   public void UpdateDb() {
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection sql = DriverManager.getConnection(dataconn, username, password);
        PreparedStatement pst = sql.prepareStatement("select * from workjob");
        ResultSet rs = pst.executeQuery();

        DefaultTableModel recordTable = (DefaultTableModel) pending_table1.getModel();
        recordTable.setRowCount(0); 

        ResultSetMetaData metaData = rs.getMetaData();
        int columnCount = metaData.getColumnCount();

        while (rs.next()) {
            Vector<Object> rowData = new Vector<>();

           
            for (int i = 1; i <= columnCount; i++) {
                rowData.add(rs.getObject(i)); 
            }

            recordTable.addRow(rowData);
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}
  
    public void UpdateDb1() {
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        sql = DriverManager.getConnection(dataconn, username, password);
        pst1 = sql.prepareStatement("select * from ongoing_table");
        rs = pst1.executeQuery();

        DefaultTableModel recordTable = (DefaultTableModel) ongoing_table1.getModel();
        recordTable.setRowCount(0); 

        ResultSetMetaData metaData = rs.getMetaData();
        int columnCount = metaData.getColumnCount();

        while (rs.next()) {
            Vector rowData = new Vector();

           
            for (int i = 1; i <= columnCount; i++) {
                rowData.add(rs.getString(i)); 
            }
            recordTable.addRow(rowData);
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    } finally {
        
        try {
            if (rs != null) rs.close();
            if (pst1 != null) pst1.close();
            if (sql != null) sql.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}

 
  @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pending_panel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        pending_table1 = new javax.swing.JTable();
        ongoing_panel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        ongoing_table1 = new javax.swing.JTable();

        setBackground(new java.awt.Color(204, 204, 204));
        setPreferredSize(new java.awt.Dimension(940, 610));

        pending_panel.setBackground(new java.awt.Color(255, 255, 255));
        pending_panel.setPreferredSize(new java.awt.Dimension(95, 286));

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Pending");

        pending_table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Checked in", "Time", "Customer Name", "Service Rendered", "Price", "Employee Assigned"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(pending_table1);

        javax.swing.GroupLayout pending_panelLayout = new javax.swing.GroupLayout(pending_panel);
        pending_panel.setLayout(pending_panelLayout);
        pending_panelLayout.setHorizontalGroup(
            pending_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
        );
        pending_panelLayout.setVerticalGroup(
            pending_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pending_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE))
        );

        ongoing_panel.setBackground(new java.awt.Color(255, 255, 255));
        ongoing_panel.setPreferredSize(new java.awt.Dimension(95, 286));

        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Ongoing");
        jLabel2.setPreferredSize(new java.awt.Dimension(94, 182));

        ongoing_table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Checked in", "Time", "Customer Name", "Service Rendered", "Employee Assigned", "Price", "Employee Assigned"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(ongoing_table1);

        javax.swing.GroupLayout ongoing_panelLayout = new javax.swing.GroupLayout(ongoing_panel);
        ongoing_panel.setLayout(ongoing_panelLayout);
        ongoing_panelLayout.setHorizontalGroup(
            ongoing_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 910, Short.MAX_VALUE)
            .addComponent(jScrollPane2)
        );
        ongoing_panelLayout.setVerticalGroup(
            ongoing_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ongoing_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pending_panel, javax.swing.GroupLayout.DEFAULT_SIZE, 910, Short.MAX_VALUE)
                    .addComponent(ongoing_panel, javax.swing.GroupLayout.DEFAULT_SIZE, 910, Short.MAX_VALUE))
                .addGap(15, 15, 15))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(pending_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(ongoing_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel ongoing_panel;
    public static javax.swing.JTable ongoing_table1;
    private javax.swing.JPanel pending_panel;
    public static javax.swing.JTable pending_table1;
    // End of variables declaration//GEN-END:variables
}
