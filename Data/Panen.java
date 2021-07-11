package Data;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Panen {
    private SimpleIntegerProperty id;
    private SimpleStringProperty nama;
    private SimpleIntegerProperty jumlah;
    Pengguna pengguna;

    public Panen(){
        this(0, "", 0, null);
    }
    
    public Panen(int id, String nama, int jumlah, Pengguna u) {
        this.id = new SimpleIntegerProperty(id);
        this.nama = new SimpleStringProperty(nama);
        this.jumlah = new SimpleIntegerProperty(jumlah);
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

    public int getJumlah() {
        return jumlah.get();
    }

    public void setJumlah(int jumlah) {
        this.jumlah.set(jumlah);
    }

    public Pengguna getPengguna() {
        return pengguna;
    }

    public void setPengguna(Pengguna pengguna) {
        this.pengguna = pengguna;
    }
    
}
