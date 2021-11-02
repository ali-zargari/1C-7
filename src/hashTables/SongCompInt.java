package hashTables;

import cs1c.SongEntry;

/**
 *
 * Wrapper class for a SongEntry object. We will use this to compare objects based on the songs int id field.
 *
 * @author Ali Zargari
 */
public class SongCompInt implements Comparable<Integer> {
    SongEntry song;

    /**
     * Initialize the song.
     *
     * @param song a song we want to play
     */
    public SongCompInt(SongEntry song){

        this.song = song;
    }

    /**
     * Compare the clients song with one that they pass in the parameter
     *
     * @param key key for the song we want to compare.
     * @return (The id of the clients song) - (the song they want to compare to).
     */
    @Override
    public int compareTo(Integer key) {

        return song.getID() - key;
    }

    /**
     * Two SongCompInt are the same if the id (the key of the table) of the SongEntry objects are the same.
     *
     * @param key the key we are comparing.
     * @return True if the the 2 keys we are comparing are the same. False if not.
     */
    @Override
    public boolean equals(Object key) {

        return (compareTo((Integer)key) == 0);
    }

    /**
     * overrides the hashCode function of the Object class to return the song ID.
     *
     * @return the song id
     */
    @Override
    public int hashCode(){

        return song.getID();
    }

    /**
     *
     * output all the data for a specific instance of SongCompInt
     *
     * @return all the data for a specific instance of SongCompInt
     */
    @Override
    public String toString(){
        return song.toString();
    }
}
