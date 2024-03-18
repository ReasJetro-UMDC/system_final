package System_UI;

import com.formdev.flatlaf.FlatLightLaf;
import forms.appointment;
import static forms.appointment.pending_table;
import forms.complete;
import forms.dashboard;
import static forms.dashboard.ongoing_table1;
import static forms.dashboard.pending_table1;
import forms.history;
import forms.revenue;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class main extends javax.swing.JFrame {
private static final String username = "root" ;
    private static final String password = "1234" ;
    private static final String dataconn = "jdbc:mysql://127.0.0.1:3306/workjob" ; 
   
    Connection sql = null;
    PreparedStatement pst,pst1 = null;
    ResultSet rs = null;
    int q, i;
   
     DefaultTableModel model;
    public main() {
        initComponents();
        setBackground(new Color(0,0,0,0));
        
        dashboard = new dashboard();
        appointment = new appointment();
        complete = new complete();
        history = new history();
        revenue = new revenue();
        form_frames.setLayout(new BorderLayout());
        
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
    private void forms(Component com){
        
        
        form_frames.removeAll();
        form_frames.add(com);
        repaint();
        revalidate();
    }
    
    private dashboard dashboard;
    private appointment appointment;
    private complete complete;
    private history history;
    private revenue revenue;
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        dashboard_button = new javax.swing.JButton();
        appointment_button = new javax.swing.JButton();
        complete_button = new javax.swing.JButton();
        history_button = new javax.swing.JButton();
        revenue_button = new javax.swing.JButton();
        close_button = new javax.swing.JButton();
        Company_nameframe = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        form_frames = new javax.swing.JPanel();
        dashboard1 = new forms.dashboard();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setPreferredSize(new java.awt.Dimension(1200, 700));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));

        dashboard_button.setBackground(new java.awt.Color(51, 51, 51));
        dashboard_button.setFont(new java.awt.Font("Century Gothic", 1, 28)); // NOI18N
        dashboard_button.setForeground(new java.awt.Color(255, 255, 255));
        dashboard_button.setText("  Dashboard");
        dashboard_button.setToolTipText("");
        dashboard_button.setBorder(null);
        dashboard_button.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        dashboard_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dashboard_buttonActionPerformed(evt);
            }
        });

        appointment_button.setBackground(new java.awt.Color(51, 51, 51));
        appointment_button.setFont(new java.awt.Font("Century Gothic", 1, 28)); // NOI18N
        appointment_button.setForeground(new java.awt.Color(255, 255, 255));
        appointment_button.setText("  Appointment");
        appointment_button.setToolTipText("");
        appointment_button.setActionCommand(" Appointment");
        appointment_button.setBorder(null);
        appointment_button.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        appointment_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                appointment_buttonActionPerformed(evt);
            }
        });

        complete_button.setBackground(new java.awt.Color(51, 51, 51));
        complete_button.setFont(new java.awt.Font("Century Gothic", 1, 28)); // NOI18N
        complete_button.setForeground(new java.awt.Color(255, 255, 255));
        complete_button.setText("  Complete");
        complete_button.setToolTipText("");
        complete_button.setBorder(null);
        complete_button.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        complete_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                complete_buttonActionPerformed(evt);
            }
        });

        history_button.setBackground(new java.awt.Color(51, 51, 51));
        history_button.setFont(new java.awt.Font("Century Gothic", 1, 28)); // NOI18N
        history_button.setForeground(new java.awt.Color(255, 255, 255));
        history_button.setText("  History");
        history_button.setToolTipText("");
        history_button.setBorder(null);
        history_button.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        history_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                history_buttonActionPerformed(evt);
            }
        });

        revenue_button.setBackground(new java.awt.Color(51, 51, 51));
        revenue_button.setFont(new java.awt.Font("Century Gothic", 1, 28)); // NOI18N
        revenue_button.setForeground(new java.awt.Color(255, 255, 255));
        revenue_button.setText("  Revenue");
        revenue_button.setToolTipText("");
        revenue_button.setBorder(null);
        revenue_button.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        revenue_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                revenue_buttonActionPerformed(evt);
            }
        });

        close_button.setBackground(new java.awt.Color(51, 51, 51));
        close_button.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        close_button.setForeground(new java.awt.Color(255, 255, 255));
        close_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-power-button-24 (1).png"))); // NOI18N
        close_button.setText("Exit");
        close_button.setToolTipText("");
        close_button.setBorder(null);
        close_button.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        close_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                close_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dashboard_button, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(appointment_button, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(complete_button, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(revenue_button, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(close_button, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(176, Short.MAX_VALUE))
            .addComponent(history_button, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(dashboard_button, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(appointment_button, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(complete_button, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(history_button, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(revenue_button, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 324, Short.MAX_VALUE)
                .addComponent(close_button, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 260, 700));

        Company_nameframe.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/logo (2).png"))); // NOI18N
        jLabel1.setText("jLabel1");

        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel2.setText("JMN Machine Shop Management System");

        javax.swing.GroupLayout Company_nameframeLayout = new javax.swing.GroupLayout(Company_nameframe);
        Company_nameframe.setLayout(Company_nameframeLayout);
        Company_nameframeLayout.setHorizontalGroup(
            Company_nameframeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Company_nameframeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 514, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(342, Short.MAX_VALUE))
        );
        Company_nameframeLayout.setVerticalGroup(
            Company_nameframeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Company_nameframeLayout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(Company_nameframeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.add(Company_nameframe, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 20, 940, 70));

        form_frames.setBackground(new java.awt.Color(204, 204, 204));
        form_frames.setLayout(new java.awt.BorderLayout());
        form_frames.add(dashboard1, java.awt.BorderLayout.CENTER);

        jPanel2.add(form_frames, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 90, 940, 610));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void dashboard_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dashboard_buttonActionPerformed
        forms(dashboard);
    }//GEN-LAST:event_dashboard_buttonActionPerformed

    private void appointment_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_appointment_buttonActionPerformed
        forms(appointment);
    }//GEN-LAST:event_appointment_buttonActionPerformed

    private void complete_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_complete_buttonActionPerformed
        forms(complete);
    }//GEN-LAST:event_complete_buttonActionPerformed

    private void history_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_history_buttonActionPerformed
        forms(history);
    }//GEN-LAST:event_history_buttonActionPerformed

    private void revenue_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_revenue_buttonActionPerformed
        forms(revenue);
    }//GEN-LAST:event_revenue_buttonActionPerformed

    private void close_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_close_buttonActionPerformed
        int input = JOptionPane.showConfirmDialog(this, "Are you sure you want to exit the program?", "Confirm", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        
        if(input==JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_close_buttonActionPerformed

    public static void main(String args[]) {
      
        FlatLightLaf.setup();
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new main().setVisible(true);
            }
        });
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Company_nameframe;
    private javax.swing.JButton appointment_button;
    private javax.swing.JButton close_button;
    private javax.swing.JButton complete_button;
    private forms.dashboard dashboard1;
    private javax.swing.JButton dashboard_button;
    private javax.swing.JPanel form_frames;
    private javax.swing.JButton history_button;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JButton revenue_button;
    // End of variables declaration//GEN-END:variables
}
