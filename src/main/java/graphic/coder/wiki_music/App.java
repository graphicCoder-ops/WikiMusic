package graphic.coder.wiki_music;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;

public class App extends Application {

    /**
     * Entry Point of GUI Application
     * @param stage
     * @throws IOException
     */
    @Override
    public void start(Stage stage) throws IOException {

        // Load the main window FXML file and create objects (controls etc.)
        Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));

        Scene scene = new Scene(root);  // Create scene containing the FXML root node
        scene.getStylesheets().add(String.valueOf(getClass().getResource("style.css")));
        stage.setScene(scene); // Place the scene in the stage
        stage.setMinWidth(550);
        stage.setMinHeight(400);
        stage.setTitle("Wiki Music");
        stage.show();  // Display the stage
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent t) {
                MainController.songs.SaveData();// Saves Data when Exiting
                Platform.exit();
                System.exit(0);
            }
        });
    }


    /**
     * Main Method entry point of Application
     * @param args
     */
    public static void main(String[] args) {
        launch(args);  // Call superclass to create JavaFX application
    }
}
