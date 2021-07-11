package pintartani;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class PintarTani extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("FXMLDocument.fxml"));
        
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setTitle("Pintar Bertani - Login");
        stage.setScene(scene);
        stage.setResizable(false);
        Image icon = new Image(getClass().getResourceAsStream("/Gambar/smartani.png"));
        stage.getIcons().add(icon);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
