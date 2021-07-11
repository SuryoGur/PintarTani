package Tampilan;

import Data.TanamPanen;
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

public class UbahTanamController implements Initializable {

    Controller con = new Controller();
    TanamPanen tanampanen = new TanamPanen();
    
    @FXML
    private TextField Tanaman;
    @FXML
    private DatePicker Panen;
    @FXML
    private DatePicker Tanam;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void handleButtonSimpanTanam(ActionEvent event) throws IOException {
        for(TanamPanen t:this.con.getDataUtama().getListTanamPanen()){
            if(t.getId() == tanampanen.getId()){
                t.setNama(Tanaman.getText());
                t.setPanen(Panen.getValue());
                t.setTanam(Tanam.getValue());
                this.con.saveListTanamPanen();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Peringatan");
                alert.setHeaderText("Peringatan");
                alert.setContentText("Berhasil menyimpan tanaman.");
                alert.showAndWait();
                break;
            }
        }
    }
    
    public void setController(Controller c){
        this.con = c;
    } 
    
    public void setTanamPanen(TanamPanen p){
        this.tanampanen = p;
        Tanaman.setText(this.tanampanen.getNama());
        Panen.setValue(this.tanampanen.getPanen());
        Tanam.setValue(this.tanampanen.getTanam());
    }
}
