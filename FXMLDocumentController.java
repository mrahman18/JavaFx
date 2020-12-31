/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package splashscreenproject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label progress;
    
    public static Label label;
    
    
    @FXML
    private ProgressBar progressBar;
    
    public static ProgressBar statProgressBar;
    
    /*@FXML 
    private ImageView imageView; */
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
       
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       label = progress ;
       statProgressBar = progressBar;
       
     /*  
       try {
            Image image = new Image(new FileInputStream("src\\splashscreenproject\\sample.png"));
            
            imageView.setImage(image);
            imageView.setCache(true);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
      */
       
    }    
    
}
