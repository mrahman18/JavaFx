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
      
      public void handleButtonAction(MouseEvent event){
          if (event.getSource() == lbl_close){
              System.exit(0);
          }
          if(event.getSource() == btnSignin){
              
          }
              // login here
      }
      
   
   
    
      @Override
      public void initialize(URL url, ResourceBundle rb) {
        
    }    
      Connection con = null;
      PreparedStatement preparedStatement = null;
      ResultSet resultSet = null;
      private void logIn(){
          String email = txtUsername.getText().toString();
          String password = txtPassword.getText().toString();
          
          //query
          String sql = "SELECT * From users Where email = ? and password = ?";
          
          try {
              preparedStatement = con.prepareStatement(sql);
              preparedStatement.setString(1, email);
              preparedStatement.setString(2, password);
              resultSet = preparedStatement.executeQuery();
              if(!resultSet.next()){
                  lblError.setText("Invalid Username/Password");
              }else
              {
                  showDialog("Login Successful", null, "Successful");
                
              }
              
              
              
              
              
              
              
              
          } catch (Exception ex) {
              Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
          }
          
          
          
      }
      private void showDialog(String info, String header, String Title){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION );
                  alert.setContentText(info);
                  alert.setHeaderText(header);
                  alert.showAndWait();
      }
    
}
