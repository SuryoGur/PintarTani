package pintartani;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import Data.*;
import Tampilan.*;
import java.io.IOException;
import javafx.scene.control.PasswordField;


public class FXMLDocumentController implements Initializable {
    
    Controller con = new Controller();
    
    @FXML 
    private TextField user;
    
    @FXML 
    private PasswordField pass;
    
    @FXML
    private void handleButtonMasuk(ActionEvent event) throws IOException {
        boolean dapat = false;
        if(!user.getText().isEmpty() && !pass.getText().isEmpty()){
            
            for(Pengguna u:this.con.getDataUtama().getListPengguna()){
                if(u.getUsername().equals(user.getText()) && u.getPassword().equals(pass.getText())){
                    dapat=true;
                    this.con.setActivePengguna(u.getId());
                    break;
                }
            }
            if(dapat){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Peringatan");
                alert.setHeaderText("Peringatan");
                alert.setContentText("Berhasil masuk.");
                alert.showAndWait();
                FXMLLoader loads = new FXMLLoader();
                loads.setLocation(getClass().getResource("/Tampilan/Dashboard.fxml"));
                Parent x = (Parent)loads.load();
                DashboardController controller = loads.getController();
                controller.setController(this.con);
                Scene scene2 = new Scene(x);
                Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                window.setResizable(false);
                window.centerOnScreen();
                window.setTitle("Pintar Bertani");
                window.setScene(scene2);
                window.show();
            }else{
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Peringatan");
                alert.setHeaderText("Peringatan");
                alert.setContentText("Username atau password salah");
                alert.showAndWait(); 
            }
        }else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Peringatan");
                alert.setHeaderText("Peringatan");
                alert.setContentText("Semua field wajib diisi");
                alert.showAndWait(); 
        }
    }
    
    @FXML
    private void handleButtonDaftar(ActionEvent event) throws IOException {
        FXMLLoader loads = new FXMLLoader();
        loads.setLocation(getClass().getResource("/pintartani/Daftar.fxml"));
        Parent x = (Parent)  loads.load();
        DaftarController controller = loads.getController();
        controller.setController(this.con);
        Scene scene2 = new Scene(x);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setResizable(false);
        window.centerOnScreen();
        window.setTitle("Pintar Bertani - Daftar");
        window.setScene(scene2);
        window.show();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }

    public void setController(Controller c){
        this.con = c;
    }
    
}
