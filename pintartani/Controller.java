package pintartani;

import Data.*;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import javafx.collections.ObservableList;
import java.util.ArrayList;

public class Controller {
    DataUtama md = new DataUtama();
    
    XStream xstream = new XStream(new StaxDriver());
    FileInputStream berkasMasuk;
    FileOutputStream berkasKeluar;
    
    private int activeId;
    
    public void setActivePengguna(int id){
        this.activeId = id;
    }
    
    public Pengguna getActivePengguna(){
        return this.getDataUtama().getPengguna(this.activeId);
    }
    
    public DataUtama getDataUtama(){
        return this.md;
    }
    
    public void saveListPengguna() throws IOException{
        this.xstream.alias("Pengguna", Pengguna.class);
        xstream.registerConverter(new ObservableListConverter(xstream.getMapper()));
        String xml = this.xstream.toXML(this.getDataUtama().getListPengguna());         
        byte[] data= xml.getBytes();
        this.berkasKeluar = new FileOutputStream("./src/xml/Pengguna.xml");
        this.berkasKeluar.write(data);
    }
    
    public void saveListPanen() throws IOException{
        this.xstream.alias("Panen", Panen.class);
        xstream.registerConverter(new ObservableListConverter(xstream.getMapper()));
        String xml = this.xstream.toXML(this.getDataUtama().getListPanen());         
        byte[] data= xml.getBytes();
        this.berkasKeluar = new FileOutputStream("./src/xml/Panen.xml");
        this.berkasKeluar.write(data);
    }
    
    public void saveListTanamPanen() throws IOException{
        this.xstream.alias("TanamPanen", TanamPanen.class);
        xstream.registerConverter(new ObservableListConverter(xstream.getMapper()));
        String xml = this.xstream.toXML(this.getDataUtama().getListTanamPanen());
        byte[] data = xml.getBytes();
        this.berkasKeluar = new FileOutputStream("./src/xml/TanamPanen.xml");
        this.berkasKeluar.write(data);
    }
    
    public void readData() throws Exception{
        this.xstream.alias("Pengguna", Pengguna.class);
        this.xstream.alias("Panen", Panen.class);
        
        //Pengguna
        this.berkasMasuk = new FileInputStream("./src/xml/Pengguna.xml");
        int isi;
        char c;
        String s = "";
        while((isi=berkasMasuk.read()) != -1){
            c = (char) isi;
            s = s+c;
        }
        xstream.registerConverter(new ObservableListConverter(xstream.getMapper()));
        this.getDataUtama().setListPengguna((ObservableList<Pengguna>) xstream.fromXML(s));
        berkasMasuk.close();
        
        //Panen
        this.berkasMasuk = new FileInputStream("./src/xml/Panen.xml");
        isi = 0;
        char ccc;
        s = "";
        while((isi=berkasMasuk.read()) != -1){
            ccc = (char) isi;
            s = s+ccc;
        }
        xstream.registerConverter(new ObservableListConverter(xstream.getMapper()));
        this.getDataUtama().setListPanen((ObservableList<Panen>) xstream.fromXML(s));
        berkasMasuk.close();
        
        //TanamPanen
        this.berkasMasuk = new FileInputStream("./src/xml/TanamPanen.xml");
        isi = 0;
        char cccc;
        s = "";
        while((isi=berkasMasuk.read()) != -1){
            cccc = (char) isi;
            s = s+cccc;
        }
        xstream.registerConverter(new ObservableListConverter(xstream.getMapper()));
        this.getDataUtama().setListTanamPanen((ObservableList<TanamPanen>) xstream.fromXML(s));
        berkasMasuk.close();
    }
}
