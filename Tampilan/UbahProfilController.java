package Tampilan;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import Data.*;
import javafx.scene.control.Alert;
import pintartani.Controller;

public class UbahProfilController implements Initializable {
    
    Controller con = new Controller();
    Pengguna pengguna = new Pengguna();

    @FXML
    private TextField namalengkap;
    @FXML
    private TextField username;
    @FXML
    private TextField alamat;
    @FXML
    private PasswordField password;
    
    @FXML
    void handleButtonSimpan(ActionEvent event) throws IOException {
        if(!namalengkap.getText().isEmpty() && !username.getText().isEmpty() && !alamat.getText().isEmpty() && !password.getText().isEmpty()){
            for(Pengguna t:this.con.getDataUtama().getListPengguna()){
                if(t.getId() == pengguna.getId()){
                    t.setNama(namalengkap.getText());
                    t.setUsername(username.getText());
                    t.setAlamat(alamat.getText());
                    t.setPassword(password.getText());
                    this.con.saveListPanen();
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Peringatan");
                    alert.setHeaderText("Peringatan");
                    alert.setContentText("Berhasil menyimpan profil.");
                    alert.showAndWait();
                    break;
                }
            }
        }else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Peringatan");
            alert.setHeaderText("Peringatan");
            alert.setContentText("Mohon isi semua field!");
            alert.showAndWait();
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void setController(Controller c){
        this.con = c;
    }

    public void setPengguna(Pengguna t) {
        this.pengguna = t;
        namalengkap.setText(this.pengguna.getNama());
        username.setText(this.pengguna.getUsername());
        alamat.setText(this.pengguna.getAlamat());
        password.setText(this.pengguna.getPassword());
    }
    
}
