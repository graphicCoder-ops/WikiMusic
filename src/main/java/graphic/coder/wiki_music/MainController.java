package graphic.coder.wiki_music;


import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.TilePane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MainController {

    public static MainController parent; // static field variable use to access this instance method for other class.
    public static SongList songs = new SongList(); // field Variable keeps track of playList of Songs.
    /*
     * Field variables for GUI controls go here, with @FXML
     */
    @FXML
    private Button addBtn;
    @FXML
    private TilePane tilePane;
    @FXML
    private Button sortBtn;
    @FXML
    private Button searchBtn;
    @FXML
    private TextField searchTxt;

    /*
     * Initializes the controller class. This method is automatically called after
     * the FXML file has been loaded.
     */
    @FXML
    private void initialize() {
        parent = this;// Setting this Instance to Parent Field Variable
        update(); // adds element loaded from file
        //Setting EventHandlers for Buttons
        addBtn.setOnAction(e -> onAddButtonClicked());
        searchBtn.setOnAction(e -> onSearch());
        sortBtn.setOnAction(e -> onSortButtonClicked());

    }

    /*
     * Method is called when Search Button is Clicked
     * Searches the given Text in SearchTxt TextField and updates UI
     */
    void onSearch() {
        songs.search(searchTxt.getText());
        updateFilter();
        searchTxt.clear();
    }

    /*
     * Method is called when Sort Button is Clicked
     * Sorts all element in ArrayList as well in UI by Updating it
     */
    void onSortButtonClicked() {
        songs.sortItems();
        update();
    }

    /*
     * Method is called when Add Button is Clicked
     * Opens New Stage AddWindow.fxml with modality Application_MODAL
     */
    void onAddButtonClicked() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AddWindow.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(loader.load()));
            stage.setResizable(false);
            stage.setTitle("Add Song");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.show();
            update();
        } catch (IOException e) {
            System.out.println("AddWindow.fxml file not Found!");
        }
    }

    /**
     * Deletes Song in ArrayList as well as From UI by updating the UI
     *
     * @param index Index of Song to be removed from PlayList
     */
    public void delete(int index) {
        songs.delete(index);
        update();
    }

    /*
     * updates UI by clearing all elements and readding them
     * adds Filtered Songs ONLY
     */
    public void updateFilter() {
        CardController.count = 0;
        tilePane.getChildren().clear();
        for (int i = 0; i < songs.filteredSongs.size(); i++) {
            try {

                FXMLLoader loader = new FXMLLoader(
                        getClass().getResource(
                                "CardUI.fxml"));
                tilePane.getChildren().add(loader.load());
                CardController p = loader.getController();
                p.setContent(songs.filteredSongs.get(i), true);

            } catch (IOException e) {
                System.out.println("CardUI.fxml file not Found!");
            }
        }

    }

    /*
     * updates UI by clearing all elements and readding them
     * adds ALL songs in PlayList
     */
    public void update() {
        CardController.count = 0;
        tilePane.getChildren().clear();
        for (int i = 0; i < songs.getLength(); i++) {
            try {

                FXMLLoader loader = new FXMLLoader(
                        getClass().getResource(
                                "CardUI.fxml"));
                tilePane.getChildren().add(loader.load());
                CardController p = loader.getController();
                p.setContent(songs.get(i), false);

            } catch (IOException e) {
                System.out.println("CardUI.fxml file not Found!");
            }
        }

    }

}

