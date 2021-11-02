project folder:
ali-zargari-cs1c-project07/

Brief description of submitted files:

src/cs1c/MillionSongDataSubset.java
    - One object of class MillionSongDataSubset parses a JSON data set and stores each entry in an array.

src/cs1c/SongEntry.java
    - One object of class SongEntry stores a simplified version of the genre data set from the Million Song Dataset.

src/cs1c/TimeConverter.java
    - Converts duration into a string representation.

src/cs1c/FHhashQP.java
    - Class used for creating a hash table. Includes all necessary functions to create a table.3

src/cs1c/HashEntry.java
    - Class used to contain a hash entry. Can be used by any hash table.




src/ hashTables/FHhashQPwFind.java
    - A variation of the FHhashQP class that lets the client use hash keys for different operations like find.

src/hashTables/SongsCompInt.java
    - Wrapper class for a SongEntry object. We will use this to compare objects based on the songs int id field.

src/hashTables/SongsCompGenre.java
    - Wrapper class for a SongEntry object. We will use this to compare objects based on the songs String genre field

src/hashTables/TableGenerator.java
    - This class will create and populate two hash tables of type FHhashQPwFind class, one for each wrapper class

src/hashTables/MyTunes.java
    - Creates an object of type MyTunes class that, which reads the song information from a JSON input file.
      Then, uses an object of type TableGenerator to populate two hash tables tableOfSongIDs and tableOfGenres each
      which compare SongEntry objects based on a different keys.

    - Tests the functionality of FHhashQPwFind class. Specifically checks for implementation of find()
      function to return an object associated with a given key input.



resources/findGenres.txt
   - contains list of genres

resources/findIDs.txt
   - contains song ids

resources/music_genre_subset.json
   - contains songs in json format

resources/gibberish.txt
   - contains various test inputs including invalid ones, empty ones, repeats, etc.

resources/RUN.txt
   - console output of MyTunes.java


README.txt
   - description of submitted files

