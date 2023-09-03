module graphic.coder.wiki_music {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens graphic.coder.wiki_music to javafx.fxml;
    exports graphic.coder.wiki_music;
}