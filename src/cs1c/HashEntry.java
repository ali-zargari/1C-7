package cs1c;

/**
 * Class used to contain a hash entry. Can be used by any hash table.
 * @param <E> Generic type.
 */
// HashEntry class for use by FHhashQP -----------------------
public class HashEntry<E>
{
    public E data;
    public int state;

    public HashEntry( E x, int st )
    {
        data = x;
        state = st;
    }

    public HashEntry()
    {
        this(null, FHhashQP.EMPTY);
    }
}