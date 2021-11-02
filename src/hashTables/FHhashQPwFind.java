package hashTables;

import cs1c.FHhashQP;

import java.util.NoSuchElementException;

/**
 * A variation of the FHhashQP class that lets the client use hash keys for different operations like find.
 *
 * @author Ali Zargari
 * @param <KeyType> Objects key for comparisons.
 * @param <E> Generic Object.
 */
public class FHhashQPwFind<KeyType, E extends Comparable<KeyType> > extends FHhashQP<E> {

    /**
     * Returns the found object, or throws a java.util.NoSuchElementException
     *
     * @param key a key to help find the object.
     * @return the object, if found, throw NoSuchElementException if not.
     */
    public E find(KeyType key) {
        if(mArray[findPosKey(key)].state == ACTIVE) {
            return mArray[findPosKey(key)].data;
        }
        else {
            throw new NoSuchElementException();
        }
    }

    /**
     * Provides a trivial modification to myHash() which uses the key rather than the object, to hash.
     *
     * @param key The key to be used to hash
     * @return the hash key.
     */
    private int myHashKey( KeyType key) {
        int hashVal;

        hashVal = key.hashCode() % mTableSize;
        if(hashVal < 0)
            hashVal += mTableSize;

        return hashVal;
    }

    /**
     * Provides trivial modification to findPos() which uses the key rather than the object, to get a position.
     *
     * @param key The key to be used getting a position
     * @return the position.
     */
    private int findPosKey( KeyType key ){
        int kthOddNum = 1;
        int index = myHashKey(key);

        while ( mArray[index].state != EMPTY &&
                mArray[index].data.compareTo(key) != 0) {
            index += kthOddNum; // k squared = (k-1) squared + kth odd #
            kthOddNum += 2;     // compute next odd #
            if ( index >= mTableSize )
                index -= mTableSize;
        }

        return index;
    }
}
