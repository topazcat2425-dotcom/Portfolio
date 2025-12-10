package components.CoolBool;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * It's a better way to store an array of booleans. Implemented with integers.
 *
 * @convention the size is NOT dynamic, don't @ me.
 * @correspondence this is an array of ints, but it uses 31 of the 32 bits.
 *
 * @author Trevor Baroni
 *
 */
public class CoolBool2 extends CoolBoolSecondary {

    /**
     * the array.
     */
    private int[] arr = new int[0];

    /**
     * the length.
     */
    private int length = 0;

    /**
     * the amount of bits in the chosen storage container.
     */
    private final int BITS = 31;

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
        this.arr = new int[(size / this.BITS) + 1];
        this.length = size;

        for (int i = 0; i < this.arr.length; i++) {
            this.arr[i] = 0;
        }
    }

    /*
     * Constructor -----------------------------------------------------------
     */

    /**
     * no args constructor.
     *
     */
    public CoolBool2() {
        this.createNewRep(0);
    }

    /**
     * Constructor from size.
     *
     * @param size
     *            total size of the array
     */
    public CoolBool2(int size) {
        this.createNewRep(size);
    }

    /**
     * Constructor from size (String).
     *
     * @param size
     *            total size of the array
     * @requires size is not null
     */
    public CoolBool2(String size) {
        assert size != null : "Violates of requires size is not null";
        this.createNewRep(Integer.parseInt(size));
    }

    /*
     * standard methods:
     */

    /**
     * @param source
     *
     * @requires source is not null
     * @update clears source
     */
    @Override
    public void transferFrom(CoolBool source) {
        assert source != null : "Violation of requires source is not null";

        this.createNewRep(source.length());
        int j = 0;
        for (boolean i : source) {
            if (i) {
                this.setTrue(j);
            }
            j++;
        }
        source.clear();
    }

    /**
     * @return new instance of this
     */
    @Override
    public final CoolBool newInstance() {
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
        this.arr = new int[0];
        this.length = 0;
    }

    /*
     * kernel methods:
     */

    /**
     * Sets the position to true.
     *
     * @requires pos < |this|
     * @param pos
     */
    @Override
    public void setTrue(int pos) {
        assert pos < this.length() : "Violates requires pos < |this|";

        // is this spot already true?
        if (!this.report(pos)) {

            // if its not, isolate the byte we need
            int section = this.arr[(pos / this.BITS)];
            int posProper = (int) pos % this.BITS;

            // then adding the current bit from the byte
            this.arr[(pos / this.BITS)] = (int) (section
                    + Math.pow(2, posProper));
        }
    }

    /**
     * Sets the position to false.
     *
     * @param pos
     */
    @Override
    public void setFalse(int pos) {

        // is this spot already false?
        if (this.report(pos)) {

            // if its not, isolate the byte we need
            int section = this.arr[(pos / this.BITS)];
            int posProper = (int) pos % this.BITS;

            // then subtract the current bit from the byte
            this.arr[(pos / this.BITS)] = (int) (section
                    - Math.pow(2, posProper));
        }
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

        boolean tbd = false;

        // isolate the byte and the bit
        int section = this.arr[(pos / this.BITS)];
        int posProper = (int) pos % this.BITS;

        // look through the byte until we get to the right bit
        for (int i = (this.BITS - 1); i >= posProper; i--) {
            int thisOne = (int) Math.pow(2, i);

            // if this is the bit we're checking, set the boolean to true
            if (section / thisOne == 1) {
                section -= thisOne;
                if (posProper == i) {
                    tbd = true;
                }
            }
        }

        return tbd;
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

    /*
     * I'll also work on this later! Give me a few hours... or days
     */

    @Override
    public final Iterator<Boolean> iterator() {
        return new CoolBool1Iterator();
    }

    /**
     * Implementation of {@code Iterator} interface for {@code Map4}.
     */
    private final class CoolBool1Iterator implements Iterator<Boolean> {

        /**
         * Number of elements seen already (i.e., |~this.seen|).
         */
        private int currentPos;

        /**
         * No-argument constructor.
         */
        CoolBool1Iterator() {
            this.currentPos = 0;
        }

        @Override
        public boolean hasNext() {
            return this.currentPos < CoolBool2.this.length();
        }

        @Override
        public Boolean next() {
            assert this.hasNext() : "Violation of: ~this.unseen /= <>";
            if (!this.hasNext()) {
                /*
                 * Exception is supposed to be thrown in this case, but with
                 * assertion-checking enabled it cannot happen because of assert
                 * above.
                 */
                throw new NoSuchElementException();
            }
            boolean tbd = CoolBool2.this.report(this.currentPos);
            this.currentPos++;

            return tbd;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException(
                    "remove operation not supported");
        }

    }
}
