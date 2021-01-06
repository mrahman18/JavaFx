/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package splashscreenproject;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.swing.*;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;



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
             void login(ActionEvent event) throws IOException{
                 
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
                       btnSignin.getScene().getWindow().hide();
                Parent root = FXMLLoader.load(getClass().getResource("Admindab.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
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
             @FXML
             private void createAccountForm() throws IOException{
                 
                     Parent root = FXMLLoader.load(getClass().getResource("Registration.fxml"));
                     Stage registerStage = new Stage();
                     registerStage.setScene(new Scene(root,608,516));
                     registerStage.show();
                     
        
                     
                 
             }
             
      @Override
      public void initialize(URL url, ResourceBundle rb) {
        
    }    
      
          
          
         
}
        

