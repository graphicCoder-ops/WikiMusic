package graphic.coder.wiki_music;

import java.io.File;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

public class AddController {
    final FileChooser fileChooser=new FileChooser();
    /*
     * Stores Image file selected for Album Photo
     */
    private File file;
    /*
     * Field variables for GUI controls go here, with @FXML
     */
    @FXML
    private TextField title;
    @FXML
    private TextField artist;
    @FXML
    private TextArea description;
    @FXML
    private TextArea lyricsText;
    @FXML
    private Button saveBtn;
    @FXML
    private Button selectImage;

    /*
     * Initializes the controller class. This method is automatically called after
     * the FXML file has been loaded.
     */
    @FXML
    public void initialize() {
        //Setting Event Handlers for Buttons
        saveBtn.setOnAction(e -> onSaveButtonClicked());
        selectImage.setOnAction(e -> onSelectImage());
    }

    /*
     * This Method is called when save Button is clicked in Add window
     * It add all data of song from user inputs in add window
     */
    private void onSaveButtonClicked() {

        MainController.songs.add(title.getText(), artist.getText(),
                file != null ? file.toURI().toString() : "none".toString(), description.getText(),
                lyricsText.getText());// Add new Song to PlayList of user
        saveBtn.getScene().getWindow().hide(); // closes window
        MainController.parent.update(); // updates UI of Main Window
    }

    /*
     * This method is called when 'select Image' Button is clicked
     * It opens FileDialog box and user can select image then want to be album photo
     * of song
     */
    private void onSelectImage() {
        file =fileChooser.showOpenDialog(selectImage.getScene().getWindow()); // opens file dialog box and we can select
    }

}
