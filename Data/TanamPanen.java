package Data;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import java.time.LocalDate;

public class TanamPanen {
    private SimpleIntegerProperty id;
    private SimpleStringProperty nama;
    private LocalDate panen;
    private LocalDate tanam;
    Pengguna pengguna;
    
    public TanamPanen(){
        this(0,"",null,null,null);
    }
    
    public TanamPanen(int id, String nama, LocalDate panen, LocalDate tanam, Pengguna u){
        this.id = new SimpleIntegerProperty(id);
        this.nama = new SimpleStringProperty(nama);
        this.panen = panen;
        this.tanam = tanam;
        this.pengguna = u;
    }

    public int getId() {
        return id.get();
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getNama() {
        return nama.get();
    }

    public void setNama(String nama) {
        this.nama.set(nama);
    }

    public LocalDate getPanen() {
        return panen;
    }

    public void setPanen(LocalDate panen) {
        this.panen = panen;
    }

    public LocalDate getTanam() {
        return tanam;
    }

    public void setTanam(LocalDate tanam) {
        this.tanam = tanam;
    }

    public Pengguna getPengguna() {
        return pengguna;
    }

    public void setPengguna(Pengguna pengguna) {
        this.pengguna = pengguna;
    }
    
    
}