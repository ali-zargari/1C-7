package hashTables;

import cs1c.SongEntry;

import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * This class will create and populate two hash tables of type FHhashQPwFind class, one for each wrapper class:
 *   tableOfSongIDs = a hash table based on SongCompInt
 *   tableOfSongGenres = a hash table based on SongsCompGenre.
 *
 * @author Ali Zargari
 */
public class TableGenerator {

    //Hash table based on SongCompInt
    private FHhashQPwFind<Integer, SongCompInt>  tableOfSongIDs ;

    //Hash table based on SongsCompGenre.
    private FHhashQPwFind<String, SongsCompGenre> tableOfGenres;

    // ArrayList of all genres.
    private ArrayList<String> genres;

    TableGenerator() {
        tableOfSongIDs  = new FHhashQPwFind< Integer, SongCompInt>();
        tableOfGenres = new FHhashQPwFind<String, SongsCompGenre>();
        genres = new ArrayList<String>();
    }

    /**
     * populates the tableOfSongIDs hash table with IDs
     *
     * @param allSongs array of songs
     * @return a table populated with IDs
     */
    public FHhashQPwFind<Integer, SongCompInt> populateIDtable(SongEntry[] allSongs) {

        for(int i = 0; i < allSongs.length; i++) {
            tableOfSongIDs.insert(new SongCompInt(allSongs[i]));
        }
        return tableOfSongIDs ;
    }

    /**
     * populates the tableOfGenres hash table and ArrayList of genre names with String names.
     *
     * @param allSongs array of songs
     * @return a table populated with genres
     */
    public FHhashQPwFind<String, SongsCompGenre> populateGenreTable(SongEntry[] allSongs) {

        for (SongEntry song : allSongs) {

            try {

                SongsCompGenre existingRecordInHashTable = tableOfGenres.find(song.getGenre());
                existingRecordInHashTable.addSong(song);

            } catch (NoSuchElementException e) {

                tableOfGenres.insert(new SongsCompGenre(song.getGenre()));
                genres.add(song.getGenre());
                SongsCompGenre newGenre = tableOfGenres.find(song.getGenre());
                newGenre.addSong(song);

            }
        }
        return tableOfGenres;
    }

    /**
     * Returns a string ArrayList holding the genres. Used in MyTunes.
     *
     * @return a list of genres names
     */
    public ArrayList<String> getGenreNames() {

        return genres;
    }

}
