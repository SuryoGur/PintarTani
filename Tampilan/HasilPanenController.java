package Tampilan;

import java.io.IOException;
import Data.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import pintartani.Controller;
import pintartani.FXMLDocumentController;

public class HasilPanenController implements Initializable {

    Controller con = new Controller();
    ObservableList<Panen> filter = FXCollections.observableArrayList();
    
    @FXML
    private Label uname;
    
    @FXML
    private Label fullname;
    
    @FXML
    private TableView<Panen> tabelPanen;

    @FXML
    private TableColumn<Panen, Integer> kolomNomor;

    @FXML
    private TableColumn<Panen, String> kolomTanaman;

    @FXML
    private TableColumn<Panen, Integer> kolomJumlah;  
   
    @FXML
    private TextField cariTanaman;
    
    @FXML
    void handleButtonHapus(ActionEvent event) throws IOException {
        if(tabelPanen.getSelectionModel().getSelectedItem() != null){
            this.con.getDataUtama().getListPanen().remove(tabelPanen.getSelectionModel().getSelectedItem());
            this.con.saveListPanen();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Peringatan");
            alert.setHeaderText("Peringatan");
            alert.setContentText("Tanaman telah berhasil dihapus!");
            alert.showAndWait();
            tabelPanen.refresh(); 
            FXMLLoader loads = new FXMLLoader();
            loads.setLocation(getClass().getResource("/Tampilan/HasilPanen.fxml"));
            Parent x = (Parent)  loads.load();
            HasilPanenController controller = loads.getController();
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
            alert.setContentText("Harap pilih data di tabel!");
            alert.showAndWait();
        }
        tabelPanen.refresh();
    }
    
    @FXML
    void handleButtonTambah(ActionEvent event) throws IOException {
        FXMLLoader loads = new FXMLLoader();
        loads.setLocation(getClass().getResource("/Tampilan/TambahPanen.fxml"));
        Parent x = (Parent)  loads.load();
        TambahPanenController controller = loads.getController();
        controller.setController(this.con);
        Scene scene2 = new Scene(x);
        Stage window = new Stage();
        window.setResizable(false);
        window.centerOnScreen();
        window.setTitle("Tambah Panen");
        window.setScene(scene2);
        window.show();
    }
    
    @FXML
    void handleButtonUbah(ActionEvent event) throws IOException {
        FXMLLoader loads = new FXMLLoader();
        loads.setLocation(getClass().getResource("/Tampilan/UbahPanen.fxml"));
        Parent x = (Parent)  loads.load();
        UbahPanenController controller = loads.getController();
        controller.setController(this.con);
        Scene scene2 = new Scene(x);
        Stage window = new Stage();
        window.setResizable(false);
        window.centerOnScreen();
        window.setTitle("Ubah Panen");
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
    void handleButtonProfil(ActionEvent event) throws IOException {
        FXMLLoader loads = new FXMLLoader();
        loads.setLocation(getClass().getResource("/Tampilan/Profil.fxml"));
        Parent x = (Parent)  loads.load();
        ProfilController controller = loads.getController();
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
        tabelPanen.setEditable(true);
        kolomNomor.setCellValueFactory((TableColumn.CellDataFeatures<Panen, Integer> p) -> new ReadOnlyObjectWrapper(tabelPanen.getItems().indexOf(p.getValue())+1 + ""));   
        kolomTanaman.setCellValueFactory(new PropertyValueFactory<>("nama"));
        kolomJumlah.setCellValueFactory(new PropertyValueFactory<>("jumlah"));
        cariTanaman.textProperty().addListener((ObservableValue<? extends String> obser, String newVal, String oldVal) -> { 
            filter = FXCollections.observableArrayList();
            if(!cariTanaman.getText().isEmpty()){
                this.con.getDataUtama().getListPanen().stream().filter((Panen lk) -> lk.getNama().contains(cariTanaman.getText()) && lk.getPengguna().getId() == this.con.getActivePengguna().getId() ).forEachOrdered((lk) -> {
                    filter.add(lk);
                });
            }else{
                this.con.getDataUtama().getListPanen().stream().filter((t) -> (t.getPengguna().getId() == this.con.getActivePengguna().getId())).forEachOrdered((t) -> {
                    filter.add(t);
                });
            }
            tabelPanen.setItems(filter);
        });
    }    
    
    public void setController(Controller c){
        this.con = c;
        uname.setText(this.con.getActivePengguna().getUsername());
        fullname.setText(this.con.getActivePengguna().getNama());
        filter = FXCollections.observableArrayList();
        this.con.getDataUtama().getListPanen().stream().filter((t) -> (t.getPengguna().getId() == this.con.getActivePengguna().getId())).forEachOrdered((t) -> {
            filter.add(t);
        });
        tabelPanen.setItems(filter);
    }
}
