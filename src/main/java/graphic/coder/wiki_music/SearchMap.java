package graphic.coder.wiki_music;

/*
 * This class sole purpose is to map out between Songs and Filtered Songs
 * for Example: SearchMap[0]=4; Means 1st element of FilteredSongs belongs to index of 5th element of Songs
 * IndexOther is FilteredSong's index in Songs ArrayList
 */

public class SearchMap {

    private int indexOther;// Index in another ArrayList
    // Constructor

    public SearchMap(int y) {
        indexOther = y;
    }

    /**
     * Getter for indexOther
     *
     * @return other index in ArrayList
     */
    public int getOtherIndex() {
        return indexOther;
    }
}
