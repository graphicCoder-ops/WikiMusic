
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ViewController {
    private boolean EDITMODE = false;
    private Song _song;
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
    private Button toggleBtn;
    @FXML
    private ImageView imgView;

    /*
     * Initializes the controller class. This method is automatically called after
     * the FXML file has been loaded.
     */
    @FXML
    private void initialize() {
        toggleBtn.setOnAction(e -> toggleEdit());
        saveBtn.setOnAction(e -> saveData());
    }

    void toggleEdit() {
        if (EDITMODE) {
            EDITMODE = false;
            toggleBtn.setText("Edit");
            title.setEditable(false);
            artist.setEditable(false);
            description.setEditable(false);
            lyricsText.setEditable(false);

        } else {
            EDITMODE = true;
            toggleBtn.setText("View");
            title.setEditable(true);
            artist.setEditable(true);
            description.setEditable(true);
            lyricsText.setEditable(true);
        }
    }

    public void initData(Song song) {
        _song = song;
        title.setText(song.getName());
        artist.setText(song.getArtist());
        description.setText(song.get_Description());
        lyricsText.setText(song.get_Lyrics());
        imgView.setImage(new Image(song.getImgPath()));

    }

    void saveData() {
        _song.setName(title.getText());
        _song.setArtist(artist.getText());
        _song.setLyrics(lyricsText.getText());
        _song.setDescription(description.getText());
        saveBtn.getScene().getWindow().hide();
        MainController.parent.update();
    }
}
