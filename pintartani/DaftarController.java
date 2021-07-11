package pintartani;

import java.io.IOException;
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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class DaftarController implements Initializable {

    FXMLLoader loads = new FXMLLoader();
    Controller con = new Controller();
    
    @FXML private TextField nama;

    @FXML private TextField user;
    
    @FXML private TextField alamat;

    @FXML private PasswordField pass;
    
    @FXML
    void handleButtonDaftar (ActionEvent event) throws IOException {
        if(!nama.getText().isEmpty() && !user.getText().isEmpty() && !alamat.getText().isEmpty()){
            this.con.getDataUtama().addPengguna(nama.getText(), user.getText(), alamat.getText(), pass.getText());
            this.con.saveListPengguna();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Peringatan");
            alert.setHeaderText("Peringatan");
            alert.setContentText("Berhasil daftar, silahkan masuk.");
            alert.showAndWait();
            loads.setLocation(getClass().getResource("/pintartani/FXMLDocument.fxml"));
            Parent viewParentTambah =(Parent)  loads.load();
            Scene scene2 = new Scene(viewParentTambah);
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            FXMLDocumentController controller = loads.getController();  
            controller.setController(this.con);
            window.setResizable(false);
            window.centerOnScreen();
            window.setTitle("Pintar Bertani - Login");
            window.setScene(scene2);
            window.show(); 
        }else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Peringatan");
            alert.setHeaderText("Peringatan");
            alert.setContentText("Semua field wajib diisi");
            alert.showAndWait(); 
        }
    }
    
    @FXML
    void handleButtonMasuk(ActionEvent event) throws IOException {
        loads.setLocation(getClass().getResource("/pintartani/FXMLDocument.fxml"));
        Parent viewParentTambah =(Parent)  loads.load();
        Scene scene2 = new Scene(viewParentTambah);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        FXMLDocumentController controller = loads.getController();  
        controller.setController(this.con);
        window.setResizable(false);
        window.centerOnScreen();
        window.setTitle("Pintar Bertani - Login");
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
