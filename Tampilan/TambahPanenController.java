package Tampilan;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import pintartani.Controller;

public class TambahPanenController implements Initializable {

    Controller con = new Controller();
    
    @FXML
    private TextField Tanaman;
    
    @FXML
    private TextField Jumlah;
    
    @FXML
    void handleButtonTambahTanaman(ActionEvent event) throws IOException {
        if(!Tanaman.getText().isEmpty() && !Jumlah.getText().isEmpty()){
            this.con.getDataUtama().addPanen(Tanaman.getText(), Integer.parseInt(Jumlah.getText()), this.con.getActivePengguna());
            this.con.saveListPanen();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Peringatan");
            alert.setHeaderText("Peringatan");
            alert.setContentText("Berhasil menambah tanaman.");
            alert.showAndWait();
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
}
