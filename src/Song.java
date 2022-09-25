public class Song implements Comparable<Song> {
    // Field Variables
    private String _Name; // Name or title of Song
    private String _Artist; // Name of Artist
    private String _imgPath; // image path of Album
    private String _Description;// Description of Song
    private String _Lyrics; // Lyrics of Song
    // Constructor

    public Song(String Name, String Artist, String ImgPath, String Description, String lyrics) {
        setName(Name);
        setArtist(Artist);
        setImgPath(ImgPath);
        setDescription(Description);
        setLyrics(lyrics);
    }

    /**
     * Overriding method from Comparable Interface
     * 
     * @param song Another Song to be Compared to
     * @return returns -1, 0 ,1 and 0 being neutral and 1 means greater and -1 means
     *         lesser
     */
    @Override
    public int compareTo(Song song) {
        return this._Name.compareToIgnoreCase(song.getName());
    }

    /**
     * Overriding method from Object Class
     * 
     * @return String of all field Variable Combined with Comma "," as Serparater
     */
    @Override
    public String toString() {
        return this._Name + "," + this._Artist + "," + this._imgPath + "," + this._Description + "," + this._Lyrics;
    }

    // Getters and Setters

    /**
     * @return String return the Name
     */
    public String getName() {
        return _Name;
    }

    /**
     * @param Name the Name to set
     */
    public void setName(String Name) {
        this._Name = Name;
        if (Name.isEmpty()) {
            this._Name = "Unknown Song";
        }
    }

    /**
     * @return String return the Artist
     */
    public String getArtist() {
        return _Artist;
    }

    /**
     * @param Artist the Artist to set
     */
    public void setArtist(String Artist) {
        this._Artist = Artist;
        if (this._Artist.isEmpty()) {
            this._Artist = "Unknown";
        }
    }

    /**
     * @return String return the Image Path
     */
    public String getImgPath() {
        return _imgPath;
    }

    /**
     * @param imgPath the Image Path to set
     */
    public void setImgPath(String imgPath) {
        this._imgPath = imgPath;
        if (this._imgPath.isEmpty()) {
            this._imgPath = " ";
        }
    }

    /**
     * @return String return the Description
     */
    public String get_Description() {
        return _Description;
    }

    /**
     * @param _Description the Description to set
     */
    public void setDescription(String _Description) {
        this._Description = _Description;
        if (this._Description.isEmpty()) {
            this._Description = "No Description";
        }
    }

    /**
     * @return String return the Lyrics
     */
    public String get_Lyrics() {
        return _Lyrics;
    }

    /**
     * @param _Lyrics the Lyrics to set
     */
    public void setLyrics(String _Lyrics) {
        this._Lyrics = _Lyrics;
        if (this._Lyrics.isEmpty()) {
            this._Lyrics = "No lyrics";
        }
    }

}
