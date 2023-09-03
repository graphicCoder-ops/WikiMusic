package graphic.coder.wiki_music;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

import java.util.Scanner;

public class SongList {
    private ArrayList<Song> Songs = new ArrayList<Song>();// Keeps Track of Songs in PlayList
    public ArrayList<Song> filteredSongs = new ArrayList<Song>(); // Keeps Track of Songs that has been Searched
    private ArrayList<SearchMap> map = new ArrayList<SearchMap>(); // keeps Track of relation between Songs and
    // filteredSongs

    public SongList() {

        LoadData(); // Loads Data from User
    }

    /**
     * Deletes Song at specified Index but this time for Search Songs only
     * @param index Index of Song to be removed
     */
    public void deleteFiltered(int index) {
        delete(map.get(index).getOtherIndex()); // uses Index to get Mapped Index to remove it from Original ArrayList
        map.remove(index);// remove map data at that index
        filteredSongs.remove(index); // removes from filteredSongs ArrayList
    }

    /**
     * This method Searches for text in Names of Song and Stores them in filteredSongs
     * @param text Text that will be used to Search "Name" of Songs
     */
    public void search(String text) {
        // clearing existing data inside Arrays
        map.clear();
        filteredSongs.clear();
        Songs.forEach(e -> {
            // if Name of Song matches or contains "text" String
            if (e.getName().toLowerCase().contains(text.toLowerCase())) {
                filteredSongs.add(e); // adds object to filteredSongs
                map.add(new SearchMap(Songs.indexOf(e)));// maps its index in Songs
            }
        });

    }

    /**
     * Deletes Song at specified Index
     *
     * @param index Index of song to be removed
     */
    public void delete(int index) {
        Songs.remove(index);
    }

    /**
     * Returns number of Songs in Arraylist
     *
     * @return returns Length of ArrayList
     */
    public int getLength() {
        return Songs.size();
    }

    /**
     * Returns Song of given Index
     *
     * @param index index of element to return
     * @return Song of given index
     */
    public Song get(int index) {
        return Songs.get(index);

    }

    /**
     * Sorts Song by Name of Song
     */
    public void sortItems() {
        Collections.sort(Songs); //Sorting Array by Name of Song
        SaveData(); // Saving Data
    }

    /**
     * Adds new Song Based on
     *
     * @param Title
     * @param Artist
     * @param Path       Image Path of Song
     * @param Desciption
     * @param Lyrics
     */
    public void add(String Title, String Artist, String Path, String Desciption, String Lyrics) {
        Songs.add(new Song(Title, Artist, Path, Desciption, Lyrics));// adding new Song
        SaveData(); // Saving data to data.txt
    }

    /*
     * Saves Data onto data.txt
     */
    public void SaveData() {
        PrintWriter writer = null;
        try {
            File file = new File("Data/data.txt");
            writer = new PrintWriter(file);
            for (int i = 0; i < Songs.size(); i++) {
                writer.println(Songs.get(i).toString());
            }
        } catch (Exception e) {
            System.out.println("File not Found");
        } finally {
            if (writer != null) {
                writer.close(); //closes the Writer
            }
        }
    }

    /*
     * Loads Data from data.txt
     */
    public void LoadData() {
        Scanner reader = null;
        try {
            File fileDescriptor = new File("Data/data.txt");
            reader = new Scanner(fileDescriptor);

            while (reader.hasNext()) {
                String record = reader.nextLine();
                // Now split the string into separate fields...
                String[] fields = record.split(",");
                Song p = new Song(fields[0], // Name
                        fields[1], // Artist
                        fields[2], // Image Path of Album Photo
                        fields[3], // Description
                        fields[4]); // Lyrics
                Songs.add(p);

            }
        } catch (FileNotFoundException e) {
            System.out.println("File not Found");
        } finally {
            if (reader != null) {
                reader.close(); //closes the reader
            }
        }
    }
}
