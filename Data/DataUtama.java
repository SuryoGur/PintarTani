package Data;

import java.time.LocalDate;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DataUtama {
    ObservableList<Pengguna> listPengguna = FXCollections.observableArrayList();
    ObservableList<Panen> listPanen = FXCollections.observableArrayList();
    ObservableList<TanamPanen> listTanamPanen = FXCollections.observableArrayList();
       
    public ObservableList<Pengguna> getListPengguna(){
        return this.listPengguna;
    }
    
    public ObservableList<Panen> getListPanen(){
        return this.listPanen;
    }
    
    public ObservableList<TanamPanen> getListTanamPanen(){
        return this.listTanamPanen;
    }
   
    public void setListPengguna(ObservableList<Pengguna> lp){
        this.listPengguna = lp;
    }
    
    public void setListPanen(ObservableList<Panen> lt){
        this.listPanen = lt;
    }
    
    public void setListTanamPanen(ObservableList<TanamPanen> tp){
        this.listTanamPanen = tp;
    }
       
    public Pengguna getPengguna(int n){
        return this.listPengguna.get(n);
    }
    
    public Panen getPanen(int n){
        return this.listPanen.get(n);
    }
    
    public TanamPanen getTanamPanen(int n) {
        return this.listTanamPanen.get(n);
    }
       
    public void addPengguna(String nama, String username, String alamat, String password){ 
        listPengguna.add(new Pengguna(listPengguna.size(), nama, username, alamat, password));
    }
    
    public void addPanen(String nama, int jumlah, Pengguna u){ 
        listPanen.add(new Panen(listPanen.size(), nama, jumlah, u));
    }
    
    public void addTanamPanen(String nama, LocalDate panen, LocalDate tanam, Pengguna u){
        listTanamPanen.add(new TanamPanen(listTanamPanen.size(), nama, panen, tanam, u));
    }
}
