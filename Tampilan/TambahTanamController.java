package Tampilan;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import pintartani.Controller;

public class TambahTanamController implements Initializable {
    
    Controller con = new Controller();

    @FXML
    private TextField Tanaman;
    
    @FXML
    private DatePicker Tanam;
    
    @FXML
    private DatePicker Panen;
    
    @FXML
    void handleButtonTambahTanam(ActionEvent event) throws IOException {
            this.con.getDataUtama().addTanamPanen(Tanaman.getText(), Tanam.getValue(), Panen.getValue(), this.con.getActivePengguna());
            this.con.saveListPanen();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Peringatan");
            alert.setHeaderText("Peringatan");
            alert.setContentText("Berhasil menambah tanaman.");
            alert.showAndWait();
    }  

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    public void setController(Controller c){
        this.con = c;
    }   
}
