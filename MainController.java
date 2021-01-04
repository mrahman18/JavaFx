/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package splashscreenproject;

import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javax.swing.JOptionPane;



public class MainController implements Initializable {
    
      @FXML
      private Label lbl_close;
      
      @FXML
      private Label lblError;
      
      @FXML
      private TextField txtUsername;
      
      @FXML
      private TextField txtPassword;
      
      @FXML
      private Button btnSignin;
      
      @FXML
      private Button btnSignup;
      
     Connection con;
      PreparedStatement pst;
      ResultSet resultSet ;
    
          
      
      
     @FXML
             void login(ActionEvent event){
                 
          String uname= txtUsername.getText();
          String pass = txtPassword.getText();
          
          if(uname.equals("") && pass.equals("")){
              JOptionPane.showMessageDialog(null, "Username or password blank");
          }
          else{
              try {
                  Class.forName("com.mysql.jdbc.Driver");
                  con = DriverManager.getConnection("jdbc:mysql://localhost/login", "root","");
                  
                  pst = con.prepareStatement("select * from users where username=? and password =? ");
                  
                  pst.setString(1, uname);
                  pst.setString(2, pass);
                  
                  resultSet = pst.executeQuery();
                  
                   resultSet = pst.executeQuery();
                   if( resultSet.next()){
                       JOptionPane.showMessageDialog(null, "Login Success");
                   }else{
                       JOptionPane.showMessageDialog(null, "Login Failed");
                       txtUsername.setText("");
                       txtPassword.setText("");
                       txtUsername.requestFocus();
                   }
                       
                  
                          
              } catch (ClassNotFoundException ex) {
                  Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
              } catch (SQLException ex) {
                  Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
              }
          }
              
             }
      @Override
      public void initialize(URL url, ResourceBundle rb) {
        
    }    
      
          
          
         
}
        

