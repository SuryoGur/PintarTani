package Tampilan;

import Data.*;
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
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pintartani.*;

public class ProfilController implements Initializable {

    Controller con = new Controller();
        
    @FXML private Label uname;
    
    @FXML private Label fullname;
    
    @FXML
    private TextField namalengkap;
    
    @FXML
    private TextField username;
    
    @FXML
    private TextField alamat;
    
    @FXML
    private PasswordField password;
    
    @FXML
    void handleButtonUbah(ActionEvent event) throws IOException {
        FXMLLoader loads = new FXMLLoader();
        loads.setLocation(getClass().getResource("/Tampilan/UbahProfil.fxml"));
        Parent x = (Parent)  loads.load();
        UbahProfilController controller = loads.getController();
        controller.setController(this.con);
        Scene scene2 = new Scene(x);
        Stage window = new Stage();
        window.setResizable(false);
        window.centerOnScreen();
        window.setTitle("Ubah Profil");
        window.setScene(scene2);
        window.show();
    }
    
    @FXML
    void handleButtonKeluar(ActionEvent event) throws IOException {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Peringatan");
        alert.setHeaderText("Peringatan");
        alert.setContentText("Berhasil keluar.");
        alert.showAndWait();
        FXMLLoader loads = new FXMLLoader();
        loads.setLocation(getClass().getResource("/pintartani/FXMLDocument.fxml"));
        Parent x = (Parent)  loads.load();
        FXMLDocumentController controller = loads.getController();
        con.setActivePengguna(-1);
        controller.setController(this.con);
        Scene scene2 = new Scene(x);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setResizable(false);
        window.centerOnScreen();
        window.setTitle("Pintar Bertani - Login");
        window.setScene(scene2);
        window.show();
    }
    
    @FXML
    void handleButtonGrafikPanen(ActionEvent event) throws IOException {
        FXMLLoader loads = new FXMLLoader();
        loads.setLocation(getClass().getResource("/Tampilan/GrafikPanen.fxml"));
        Parent x = (Parent)  loads.load();
        GrafikPanenController controller = loads.getController();
        controller.setController(this.con);
        Scene scene2 = new Scene(x);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.centerOnScreen();
        window.setTitle("Pintar Bertani");
        window.setScene(scene2);
        window.show();
    }
    
    @FXML
    void handleButtonHasilPanen(ActionEvent event) throws IOException {
        FXMLLoader loads = new FXMLLoader();
        loads.setLocation(getClass().getResource("/Tampilan/HasilPanen.fxml"));
        Parent x = (Parent)  loads.load();
        HasilPanenController controller = loads.getController();
        controller.setController(this.con);
        Scene scene2 = new Scene(x);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.centerOnScreen();
        window.setTitle("Pintar Bertani");
        window.setScene(scene2);
        window.show();
    }
    
    @FXML
    void handleButtonTanamPanen (ActionEvent event) throws IOException {
        FXMLLoader loads = new FXMLLoader();
        loads.setLocation(getClass().getResource("/Tampilan/TanamPanen.fxml"));
        Parent x = (Parent)  loads.load();
        TanamPanenController controller = loads.getController();
        controller.setController(this.con);
        Scene scene2 = new Scene(x);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.centerOnScreen();
        window.setTitle("Pintar Bertani");
        window.setScene(scene2);
        window.show();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    
     public void setController(Controller c){
        this.con = c;
        uname.setText(this.con.getActivePengguna().getUsername());
        fullname.setText(this.con.getActivePengguna().getNama());
        namalengkap.setText(this.con.getActivePengguna().getNama());
        username.setText(this.con.getActivePengguna().getUsername());
        alamat.setText(this.con.getActivePengguna().getAlamat());
        password.setText(this.con.getActivePengguna().getPassword());
    }
    
}
