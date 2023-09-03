package graphic.coder.wiki_music;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class CardController {
    private boolean _isFilter;// tells if content passes is searched
    private Song _song;// song field variable is reference to song from mainController for each instance of this Node
    private int id;// keeps track of instances of this class
    public static int count;// total number of instance of this class
    /*
     * Field variables for GUI controls go here, with @FXML
     */
    @FXML
    private ImageView imgView;
    @FXML
    private Label titleTxt;
    @FXML
    private Label artistTxt;
    @FXML
    private Button deleteBtn;
    @FXML
    private Button openBtn;

    /*
     * Initializes the controller class. This method is automatically called after
     * the FXML file has been loaded.
     */
    @FXML
    private void initialize() {

        id = count++;//Setting current id of this instance
        //Setting Event Handlers for Buttons
        openBtn.setOnAction(e -> onOpenButton());
        deleteBtn.setOnAction(e -> onDelete());
    }

    /**
     * Method is called by Main Controller to set Content to this Custom Node
     * @param song Content for this UI Node to display
     * @param isFiltered if content passed is searched or not
     */
    void setContent(Song song, boolean isFiltered) {
        //Setting values to field Variables
        _isFilter = isFiltered;
        _song = song;
        //Setting Content to FXML controls
        if(!(song.getImgPath().equalsIgnoreCase("none"))){
            imgView.setImage(new Image(song.getImgPath()));
        }
        titleTxt.setText(song.getName());
        artistTxt.setText("by " + song.getArtist());
    }
    /*
     * This method executes when Open Button is Pressed
     * It Loads View/Edit Window which lets user to Edit and View Content of this Instance Node
     */
    void onOpenButton() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("View.fxml"));
            Stage stage = new Stage();

            stage.setScene(new Scene(loader.load()));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("View/Edit");

            stage.setResizable(false);
            ViewController view = loader.getController();
            view.initData(_song);
            stage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.out.println("View.fxml file not Found!");
        }
    }
    /*
     * This Method is called when Delete button is Pressed
     * It deletes this Node data from Arraylist using index
     * and calls update method which refreshe UI so this Instance is deleted too.
     */
    private void onDelete() {
        // using filter to see if Songs are searched or not
        if (_isFilter) {
            // Code is different cuz for search item indexing is different if you look at code of deleteFiltered
            MainController.songs.deleteFiltered(id); // deletes from filteredSongs Arraylist and Songs
            MainController.parent.updateFilter(); // updates
        } else {
            MainController.parent.delete(id); // deletes from all songs and deletes
        }
    }
}
