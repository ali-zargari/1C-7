package hashTables;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

import cs1c.MillionSongDataSubset;
import cs1c.SongEntry;

/**
 * Tests the functionality of FHhashQPwFind.java.
 * Specifically checks for implementation of find() function to return an object associated with a given key input.
 *
 * @author Foothill College, Bita M, Ali Zargari
 */
public class MyTunes 
{
	public static final boolean SHOW_DETAILS = false;

	// Two hash tables of type FHhashQPwFind which extends parent class FHhashQP --------
	private FHhashQPwFind<Integer, SongCompInt>  tableOfSongIDs;
	private FHhashQPwFind<String, SongsCompGenre> tableOfGenres; 

	// List of genres found while populating tableOfGenres field
	private ArrayList<String> genreNames;


	/**
	 * Populates two hash tables:
	 * - a hash table for comparing songs based on their int field ID.
	 * - a hash table for comparing songs based on their String field genre.
	 * @param allSongs	Array of SongEntry objects
	 */
	public MyTunes(SongEntry[] allSongs)
	{

		TableGenerator g = new TableGenerator();

		// Populates a hash table for comparing songs based on their int field ID.
		tableOfSongIDs = g.populateIDtable(allSongs);

		// Populates a hash table for comparing songs based on their String field genre.
		// Uses this table to also populates list of genre names with unique keys.
		tableOfGenres = g.populateGenreTable(allSongs);		

		// Return the unique genre names found when populating genre table
		genreNames = g.getGenreNames();
	}

	/**
	 * Uses MillionSongDataSubset to read all songs from data file.
	 * @param jsonFile		A JSON file to parse
	 * @return				The array of SongEntry objects
	 */
	public static SongEntry [] readSongsFromDataFile(String jsonFile)
	{
		// parses the JSON input file
		MillionSongDataSubset msd = new MillionSongDataSubset(jsonFile);

		// retrieves the parsed objects
		SongEntry [] allSongs = msd.getArrayOfSongs();

		// displays the number of songs read from the input file
		System.out.printf("Total number of songs read %d \n", allSongs.length);

		return allSongs;
	}


	/**
	 * Basic file reader which reads a file with format:
	 * [value to find]
	 * [value to find]
	 * etc.
	 * And stores each value into a list.
	 * @param filename	The input file to read.
	 * @return Read lines as a list.
	 */
	public ArrayList<String> readFindRequests(String filename)
	{
		ArrayList<String> requests = new ArrayList<>();
		Scanner input = null;

		try 
		{
			File infile = new File(filename);
			input = new Scanner(infile);

			String line = "";
			while (input.hasNextLine()) 
			{
				line = input.nextLine(); 

				requests.add("" + line);
			} // while more lines in file
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} 	
		finally
		{
			if (input != null)
				input.close();
		}
		return requests;
	}

	/**
	 * Tests the FHhashQPwFind and wrapper class SongCompInt.
	 * @param filename The input file to read.
	 */
	public void testIDtable(String filename) 
	{
		System.out.printf("Test file for id table: %s \n", filename);

		ArrayList<String> idsToFind = readFindRequests(filename);

		for (String idStr : idsToFind)
		{
			int id;
			try
			{
				id = Integer.parseInt(idStr);
			}
			catch (NumberFormatException e)
			{
				System.out.printf("\nWarning: Input \"%s\" is not a valid number. Skipping.\n", idStr);
				continue;
			}

			System.out.printf( "\nFinding song id: %d\n", id);

			try
			{

				SongCompInt compResult  = tableOfSongIDs.find(id);
				if (compResult != null)
				{
					System.out.printf("Song id %d found in tableOfSongIDs. \n", id);
				}
			}
			catch (NoSuchElementException e)
			{ 
				System.out.printf("Song id %d NOT found in tableOfSongIDs.\n", id);
			} 
		} // for all requested IDs to find

		System.out.println("Done with testing table of ids.\n");
	}

	/**
	 * Tests the FHhashQPwFind and wrapper class SongsCompGenre.
	 * @param filename The input file to read.
	 */
	private void testGenreTable(String filename) 
	{
		System.out.printf("Test file for genre table: %s \n", filename);

		System.out.println("\nNumber of store songs in each genre:");
		ArrayList<String> genreKeys = this.genreNames;

		for (String genreName : genreKeys)
		{

			SongsCompGenre genre = tableOfGenres.find(genreName);

			// NOTE: A genre has an ArrayList of SongEntry objects.
			System.out.printf("%20s \t %6d \n", genre.getName(), genre.getData().size());
		}


		ArrayList<String> genresToFind = readFindRequests(filename);

		for (String genre : genresToFind)
		{			
			System.out.printf( "\nFinding genre: %s\n", genre);

			try
			{
				SongsCompGenre compResult  = tableOfGenres.find(genre);
				if (compResult != null)
				{
					System.out.printf("Genre \"%s\" found in tableOfGenres. \n", genre);
				}
			}
			catch (NoSuchElementException e)
			{ 
				System.out.printf("Genre \"%s\" NOT found in tableOfGenres.\n", genre);
			} 
		} // for all requested IDs to find

		System.out.println("Done with testing table of genres.\n");
	}


	/**
	 * Creates an object of type MyTunes class that, which reads the song information from a JSON input file
	 * and stores all entries in an array of SongEntry objects.
	 * Constructs an object of MyTunes, which populates two hash tables.
	 * Each tables uses different attribute of SongEntry class as the key to find. 
	 * Tests finding keys in each hash table and reports whether requested key is found.
	 */
	public static void main(String[] args) 
	{
		final String DATAFILE = "resources/music_genre_subset.json";	// Directory path for JSON file
		final String TESTFILE01 = "resources/findIDs.txt";	// Example test file for hashing based on IDs
		final String TESTFILE02 = "resources/findGenres.txt"; // Example test file for hashing based on genres names
		final String TESTFILE03 = "resources/gibberish.txt"; // Example test file for hashing based on invalid inputs.

		// Note: This is similar to your previous projects.
		//		 Placed in a separate method for readability.
		// Parses the input file and stores all songs in an array of SongEntry object.
		SongEntry [] allSongs = readSongsFromDataFile(DATAFILE);

		// The constructor of class builds the hash tables
		MyTunes theStore = new 	MyTunes(allSongs);

		// Tests FHhashQPwFind and SongCompInt
		theStore.testIDtable(TESTFILE03);

		// Tests FHhashQPwFind and SongsCompGenre
		theStore.testGenreTable(TESTFILE03);

		// flush the error stream
		System.err.flush();

		System.out.println("\nDone with MyTunes.");
	}
}
