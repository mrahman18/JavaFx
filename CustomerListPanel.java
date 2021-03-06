/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flight.managment.system;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import static flight.managment.system.MySqlConfigration.connect;
import java.awt.Dimension;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 */
public class CustomerListPanel extends javax.swing.JPanel {

    /**
     * Creates new form CustomerListPanel
     */
    public CustomerListPanel() {
        initComponents();
        configDisplay();
        loadDatafromDatabase();
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
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        customerListJTable = new javax.swing.JTable();

        setBackground(new java.awt.Color(102, 51, 255));

        jLabel1.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Customer List");

        customerListJTable.setModel(new javax.swing.table.DefaultTableModel(
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
        customerListJTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                customerListJTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(customerListJTable);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 553, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void customerListJTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_customerListJTableMouseClicked
        int row = customerListJTable.rowAtPoint(evt.getPoint());
        int col = customerListJTable.columnAtPoint(evt.getPoint());
        if (row >= 0 && col >= 0) {
            String selectedFlightId = customerListJTable.getValueAt(row, 0).toString();
            String[] choices = {"Delete"};
            String input = (String) JOptionPane.showInputDialog(null, "Please, make your choice", "Setting", JOptionPane.QUESTION_MESSAGE, null, choices, choices[0]);

            switch (input.toLowerCase()) {
                case "delete":
                    deleteFlightByUserId(selectedFlightId);
                    break;
                default:
                    break;
            }
        }
    }//GEN-LAST:event_customerListJTableMouseClicked
    private void configDisplay() {
        this.setPreferredSize(new Dimension(790, 586));
        this.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable customerListJTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables

    private void loadDatafromDatabase() {
        DefaultTableModel model = new DefaultTableModel(new String[]{"User Id", "User Name", "First Name", "Last Name", "Address", "Zip COde", "State", "Email", "SSN", "SQA"}, 0);
        Connection conn = MySqlConfigration.connect();

        try {
            Statement statement = (Statement) conn.createStatement();
            ResultSet resultSet = statement.executeQuery("Select * From user");

            while (resultSet.next()) {
                model.addRow(new String[]{resultSet.getString("userId"), resultSet.getString("userName"), resultSet.getString("fName"), resultSet.getString("lName"), resultSet.getString("address"), resultSet.getString("zip"), resultSet.getString("state"), resultSet.getString("email"), resultSet.getString("ssn"), resultSet.getString("bfName")});
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginAndSignUpFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

        customerListJTable.setModel(model);
    }

    private void deleteFlightByUserId(String selectedFlightId) {

        Connection connection = MySqlConfigration.connect();
        try {
            Statement statement = (Statement) connect().createStatement();
            statement.execute("Delete FROM user WHERE usetId = '" + selectedFlightId + "'");
            statement.close();
            MySqlConfigration.disconnect();
            JOptionPane.showMessageDialog(null, "Successful");
            loadDatafromDatabase();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Somthing is worng");
            System.err.println(ex);

        }
    }

    private void updateFlightByUserId(String selectedFlightId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
