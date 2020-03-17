import java.util.Iterator;
import java.util.NoSuchElementException;

public class PeekingIterator {

    private Iterator<Integer> iterator;
    private Integer peekedValue;

    public PeekingIterator(Iterator<Integer> iterator) {
        this.iterator = iterator;
        peekedValue = null;
    }

    /**
     * Time - O(1)
     * @return
     */
    public Integer peek() {
        if (peekedValue == null) {
            if (!iterator.hasNext()) {
                throw new NoSuchElementException();
            }
            peekedValue = iterator.next();
        }
        return peekedValue;
    }
    

    /**
     * Time - O(1)
     * @return
     */

    //@Override
    public Integer next() {
        if (peekedValue != null) {
            Integer toReturn = peekedValue;
            peekedValue = null;
            return toReturn;
        }
        if (!iterator.hasNext()) {
            throw new NoSuchElementException();
        }
        return iterator.next();
    }


     /**
     * Time - O(1)
     * @return
     */

    //@Override
    public boolean hasNext() {
        return peekedValue != null || iterator.hasNext();
    }
}