package Tampilan;

import Data.TanamPanen;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
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
import pintartani.*;

public class TanamPanenController implements Initializable {

    Controller con = new Controller();
    ObservableList<TanamPanen> filter = FXCollections.observableArrayList();
    
    @FXML
    private Label uname;
    
    @FXML
    private Label fullname;
    
    @FXML
    private TableView<TanamPanen> TabelTanamPanen;
    
    @FXML
    private TableColumn<TanamPanen, Integer> NomorTanam;
    
    @FXML
    private TableColumn<TanamPanen, String> NamaTanam;
    
    @FXML
    private TableColumn<TanamPanen, LocalDate> Tanam;
    
    @FXML
    private TableColumn<TanamPanen, LocalDate> Panen;
    
    @FXML
    private TextField CariTanam;
    
    @FXML
    void handleButtonHapus(ActionEvent event) throws IOException {
        if(TabelTanamPanen.getSelectionModel().getSelectedItem() != null){
            this.con.getDataUtama().getListTanamPanen().remove(TabelTanamPanen.getSelectionModel().getSelectedItem());
            this.con.saveListTanamPanen();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Peringatan");
            alert.setHeaderText("Peringatan");
            alert.setContentText("Tanaman telah berhasil dihapus!");
            alert.showAndWait();
            TabelTanamPanen.refresh(); 
            FXMLLoader loads = new FXMLLoader();
            loads.setLocation(getClass().getResource("/Tampilan/TanamPanen.fxml"));
            Parent x = (Parent)  loads.load();
            TanamPanenController controller = loads.getController();
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
        TabelTanamPanen.refresh();
    }
    
    @FXML
    void handleButtonTambah(ActionEvent event) throws IOException {
        FXMLLoader loads = new FXMLLoader();
        loads.setLocation(getClass().getResource("/Tampilan/TambahTanam.fxml"));
        Parent x = (Parent)  loads.load();
        TambahTanamController controller = loads.getController();
        controller.setController(this.con);
        Scene scene2 = new Scene(x);
        Stage window = new Stage();
        window.setResizable(false);
        window.centerOnScreen();
        window.setTitle("Tambah Tanam");
        window.setScene(scene2);
        window.show();
    }
    
    @FXML
    void handleButtonUbah(ActionEvent event) throws IOException {
        FXMLLoader loads = new FXMLLoader();
        loads.setLocation(getClass().getResource("/Tampilan/UbahTanam.fxml"));
        Parent x = (Parent)  loads.load();
        UbahTanamController controller = loads.getController();
        controller.setController(this.con);
        Scene scene2 = new Scene(x);
        Stage window = new Stage();
        window.setResizable(false);
        window.centerOnScreen();
        window.setTitle("Ubah Tanam");
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
        TabelTanamPanen.setEditable(true);
        NomorTanam.setCellValueFactory((TableColumn.CellDataFeatures<TanamPanen, Integer> p) -> new ReadOnlyObjectWrapper(TabelTanamPanen.getItems().indexOf(p.getValue())+1 + ""));   
        NamaTanam.setCellValueFactory(new PropertyValueFactory<>("nama"));
        Tanam.setCellValueFactory(new PropertyValueFactory<>("tanam"));
        Panen.setCellValueFactory(new PropertyValueFactory<>("panen"));
        CariTanam.textProperty().addListener((ObservableValue<? extends String> obser, String newVal, String oldVal) -> { 
            filter = FXCollections.observableArrayList();
            if(!CariTanam.getText().isEmpty()){
                this.con.getDataUtama().getListTanamPanen().stream().filter((TanamPanen lk) -> lk.getNama().contains(CariTanam.getText()) && lk.getPengguna().getId() == this.con.getActivePengguna().getId() ).forEachOrdered((lk) -> {
                    filter.add(lk);
                });
            }else{
                this.con.getDataUtama().getListTanamPanen().stream().filter((t) -> (t.getPengguna().getId() == this.con.getActivePengguna().getId())).forEachOrdered((t) -> {
                    filter.add(t);
                });
            }
            TabelTanamPanen.setItems(filter);
        });
    }    
    
    public void setController(Controller c){
        this.con = c;
        uname.setText(this.con.getActivePengguna().getUsername());
        fullname.setText(this.con.getActivePengguna().getNama());
        this.con.getDataUtama().getListTanamPanen().stream().filter((t) -> (t.getPengguna().getId() == this.con.getActivePengguna().getId())).forEachOrdered((t) -> {
            filter.add(t);
        });
        TabelTanamPanen.setItems(filter);
    }
    
}
