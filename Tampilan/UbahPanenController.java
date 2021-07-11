package Tampilan;

import Data.Panen;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import pintartani.Controller;

public class UbahPanenController implements Initializable {

    Controller con = new Controller();
    Panen panen = new Panen();
    
    @FXML
    private TextField Tanaman;
    
    @FXML
    private TextField Jumlah;
    
    @FXML
    void handleButtonSimpanTanaman(ActionEvent event) throws IOException {
        if(!Tanaman.getText().isEmpty() && !Jumlah.getText().isEmpty()){
            for(Panen t:this.con.getDataUtama().getListPanen()){
                if(t.getId() == panen.getId()){
                    t.setNama(Tanaman.getText());
                    t.setJumlah(Integer.parseInt(Jumlah.getText()));
                    this.con.saveListPanen();
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Peringatan");
                    alert.setHeaderText("Peringatan");
                    alert.setContentText("Berhasil menyimpan tanaman.");
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
    
    public void setPanen(Panen t){
        this.panen=t;
        Jumlah.setText(Integer.toString(this.panen.getJumlah()));
        Tanaman.setText(this.panen.getNama());
    }
}
