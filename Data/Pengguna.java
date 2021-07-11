package Data;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Pengguna {
    private SimpleIntegerProperty id;
    private SimpleStringProperty nama, username, alamat, password;
    
    public Pengguna(){
        this(0,"","","","");
    }

    public Pengguna(int id, String nama, String username, String alamat, String password) {
        this.id = new SimpleIntegerProperty(id);
        this.nama = new SimpleStringProperty(nama);
        this.username = new SimpleStringProperty(username);
        this.alamat = new SimpleStringProperty(alamat);
        this.password = new SimpleStringProperty(password);
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

    public String getUsername() {
        return username.get();
    }

    public void setUsername(String username) {
        this.username.set(username);
    }

    public String getAlamat() {
        return alamat.get();
    }

    public void setAlamat(String alamat) {
        this.alamat.set(alamat);
    }

    public String getPassword() {
        return password.get();
    }

    public void setPassword(String password) {
        this.password.set(password);
    }
    
}
