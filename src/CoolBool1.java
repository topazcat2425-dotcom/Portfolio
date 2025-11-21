import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 *
 * @author Trevor Baroni
 * @param <CoolBool>
 *
 */
public abstract class CoolBool1 implements CoolBoolKernel {

    /*
     * the array.
     */
    private byte[] arr = new byte[0];

    /*
     * the length.
     */
    private int length = 0;

    /**
     * Reads the "array" and reports what the first 6 values are.
     *
     * @param position
     *
     * @return if this at position is true
     */
    private boolean didStuff(int position) {

        boolean partRead = false;
        byte removed = 0;
        byte section = this.arr[(position / 8) - 1];

        for (int i = 7; i >= position; i--) {
            int thisOne = (int) Math.pow(2, i);
            if (section / thisOne == 1) {
                section -= thisOne;
                removed += thisOne;
                if (i == position) {
                    partRead = true;
                }
            }
        }

        section += removed;

        return partRead;

        // if (choice / 32 == 1) {
        //     System.out.println("First is true!");
        //     choice -= 32;
        // } else {
        //     System.out.println("First is not true.");
        // }

        // if (choice / 16 == 1) {
        //     System.out.println("Second is true!");
        //     choice -= 16;
        // } else {
        //     System.out.println("Second is not true.");
        // }

        // if (choice / 8 == 1) {
        //     System.out.println("Third is true!");
        //     choice -= 8;
        // } else {
        //     System.out.println("Third is not true.");
        // }

        // if (choice / 4 == 1) {
        //     System.out.println("Fourth is true!");
        //     choice -= 4;
        // } else {
        //     System.out.println("Fourth is not true.");
        // }

        // if (choice / 2 == 1) {
        //     System.out.println("Fifth is true!");
        //     choice -= 2;
        // } else {
        //     System.out.println("Fifth is not true.");
        // }

        // if (choice == 1) {
        //     System.out.println("Sixth is true!");
        //     choice -= 1;
        // } else {
        //     System.out.println("Sixth is not true.");
        // }
    }

    /**
     * Creator of initial representation.
     *
     * @param size
     *            total preorder for sorting
     * @requires IS_TOTAL_PREORDER([relation computed by order.compare method]
     * @ensures <pre>
     * $this.insertionMode = true  and
     * $this.machineOrder = order  and
     * $this.entries = <>  and
     * $this.heapSize = 0
     * </pre>
     */
    private void createNewRep(int size) {
        this.arr = new byte[(size / 8) + 1];
        this.length = size;

        for (int i = 0; i < this.arr.length; i++) {
            this.arr[i] = 0;
        }
    }

    /*
     * Constructors -----------------------------------------------------------
     */

    /**
     * Constructor from size.
     *
     * @param size
     *            total size of the array
     */
    public CoolBool1(int size) {
        this.createNewRep(size);
    }

    /*
     * standard methods:
     */

    /**
     * @param source
     *
     * @update clears source
     */
    public void transferFrom(CoolBool source) {
        // TBD!!! I'll work on it later
    }

    /**
     * @return new instance of this
     */
    @Override
    public final CoolBool1 newInstance() {
        try {
            return this.getClass().getConstructor().newInstance();
        } catch (ReflectiveOperationException e) {
            throw new AssertionError(
                    "Cannot construct object of type " + this.getClass());
        }
    }

    /**
     * @clears this
     */
    @Override
    public void clear() {
        this.arr = new byte[0];
    }

    /*
     * kernel methods:
     */

    /**
     * Sets the position to true.
     *
     * @param pos
     */
    @Override
    public void setTrue(int pos) {
        byte removed = 0;
        byte section = this.arr[(pos / 8) - 1];

        for (byte i = 7; i >= pos; i--) {
            byte thisOne = (byte) Math.pow(2, i);
            if (section / thisOne == 1) {
                section -= thisOne;
                removed += thisOne;
            } else if (i == pos) {
                section += thisOne;
            }
        }

        section += removed;

        this.arr[(pos / 8) - 1] = section;
    }

    /**
     * Sets the position to false.
     *
     * @param pos
     */
    @Override
    public void setFalse(int pos) {
        byte removed = 0;
        byte section = this.arr[(pos / 8) - 1];

        for (byte i = 7; i >= pos; i--) {
            byte thisOne = (byte) Math.pow(2, i);
            if (section / thisOne == 1) {
                section -= thisOne;
                if (i != pos) {
                    removed += thisOne;
                }
            }
        }

        section += removed;
        this.arr[(pos / 8) - 1] = section;
    }

    /**
     * Reports the value the boolean at pos.
     *
     * @param pos
     *
     * @return reported element
     */
    @Override
    public boolean report(int pos) {
        boolean partRead = false;
        byte removed = 0;
        byte section = this.arr[(pos / 8) - 1];

        for (byte i = 7; i >= pos; i--) {
            byte thisOne = (byte) Math.pow(2, i);
            if (section / thisOne == 1) {
                section -= thisOne;
                removed += thisOne;
                if (i == pos) {
                    partRead = true;
                }
            }
        }

        section += removed;
        this.arr[(pos / 8) - 1] = section;

        return partRead;
    }

    /**
     * Reports the length of this.
     *
     * @return length of array
     */
    @Override
    public int length() {
        return this.length;
    }

    @Override
    public final Iterator<Byte> iterator() {
        return new CoolBool1Iterator();
    }

    /**
     * Implementation of {@code Iterator} interface for {@code Map4}.
     */
    private final class CoolBool1Iterator implements Iterator<Byte> {

        /**
         * Number of elements seen already (i.e., |~this.seen|).
         */
        private int numberSeen;

        /**
         * Bucket from which current bucket iterator comes.
         */
        private int currentBucket;

        /**
         * Bucket iterator from which next element will come.
         */
        private Iterator<Pair<K, V>> bucketIterator;

        /**
         * No-argument constructor.
         */
        Map4Iterator() {
            this.numberSeen = 0;
            this.currentBucket = 0;
            this.bucketIterator = Map4.this.hashTable[0].iterator();
        }

        @Override
        public boolean hasNext() {
            return this.numberSeen < Map4.this.size;
        }

        @Override
        public Pair<K, V> next() {
            assert this.hasNext() : "Violation of: ~this.unseen /= <>";
            if (!this.hasNext()) {
                /*
                 * Exception is supposed to be thrown in this case, but with
                 * assertion-checking enabled it cannot happen because of assert
                 * above.
                 */
                throw new NoSuchElementException();
            }
            this.numberSeen++;
            while (!this.bucketIterator.hasNext()) {
                this.currentBucket++;
                this.bucketIterator = Map4.this.hashTable[this.currentBucket]
                        .iterator();
            }
            return this.bucketIterator.next();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException(
                    "remove operation not supported");
        }

    }
}
