package hashTables;

import cs1c.SongEntry;

import java.util.ArrayList;


/**
 *
 * Wrapper class for a SongEntry object. We will use this to compare objects based on the songs String genre field
 *
 * @author Ali Zargari
 */
public class SongsCompGenre implements Comparable<String> {

    String genre;
    ArrayList<SongEntry> songs;

    public SongsCompGenre(String genreName) {
        this.genre = genreName;
        songs = new ArrayList<>();
    }

    /**
     * compares the genre name to the key
     *
     * @param key Another genre name
     * @return Anything but a 0 means that the 2 objects being compared are not equal.
     */
    @Override
    public int compareTo(String key) {

        return genre.compareTo(key);
    }

    /**
     * Two SongsCompGenre are the same if the name of the two SongsCompGenre objects are equal.
     *
     * @param key the key we are comparing.
     * @return True if the the 2 keys we are comparing are the same. False if not.
     */
    @Override
    public boolean equals(Object key) {

        return (compareTo((String)key) == 0);
    }

    /**
     * @return the hashCode for the genre
     */
    @Override
    public int hashCode() {

        return genre.hashCode();
    }

    /**
     *
     * output all the data for a specific instance of SongCompGenre
     *
     * @return all the data for a specific instance of SongCompGenre
     */
    @Override
    public String toString(){
        return songs.toString();
    }

    /**
     * adds a song to the ArrayList songs.
     *
     * @param SongEntry  a new SongEntry object
     */
    void addSong(SongEntry SongEntry ) {

        songs.add(SongEntry );
    }

    /**
     * @return the name of the genre
     */
    String getName() {

        return genre;
    }

    /**
     * @return the songs in this genre
     */
    ArrayList<SongEntry> getData() {

        return songs;
    }
}
