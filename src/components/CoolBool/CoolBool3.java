package components.CoolBool;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * It's a better way to store an array of booleans. Implemented with integers.
 *
 * @convention the size is NOT dynamic, don't @ me.
 * @correspondence this is an array of bytes, but it uses all 8 bits!
 *
 * @author Trevor Baroni
 *
 */
public class CoolBool3 extends CoolBoolSecondary {

    /**
     * the array.
     */
    private byte[] arr = new byte[0];

    /**
     * the length.
     */
    private int length = 0;

    /**
     * the amount of bits in the chosen storage container.
     */
    private final int BITS = 8;

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
        this.arr = new byte[(size / this.BITS) + 1];
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
    public CoolBool3() {
        this.createNewRep(0);
    }

    /**
     * Constructor from size.
     *
     * @param size
     *            total size of the array
     */
    public CoolBool3(int size) {
        this.createNewRep(size);
    }

    /**
     * Constructor from size (String).
     *
     * @param size
     *            total size of the array
     * @requires size is not null
     */
    public CoolBool3(String size) {
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
        this.arr = new byte[0];
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
            byte section = this.arr[(pos / this.BITS)];
            int posProper = (int) pos % this.BITS;

            // if we're updating the 0th bit, we just make it -1
            if (posProper == 0) {
                section *= -1;
                section--;
                this.arr[(pos / this.BITS)] = section;

            } else {
                // otherwise, we add/subtract the power of two that corrosponds
                // with the bit we're checking
                byte mult = 1;
                if (section < 0) {
                    mult = -1;
                }
                this.arr[(pos / this.BITS)] = (byte) (section
                        + (mult * Math.pow(2, posProper - 1)));
            }
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
            byte section = this.arr[(pos / this.BITS)];
            int posProper = (int) pos % this.BITS;

            // if we're updating the 0th bit, we just make it the opposite of what it was
            if (posProper == 0) {
                section *= -1;
                section--;
                this.arr[(pos / this.BITS)] = section;

            } else {
                // otherwise, we add/subtract the power of two that corrosponds
                // with the bit we're checking
                byte mult = 1;
                if (section < 0) {
                    mult = -1;
                }
                this.arr[(pos / this.BITS)] = (byte) (section
                        - (mult * Math.pow(2, posProper - 1)));
            }
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
        // isolate the byte we'll be checking
        byte section = this.arr[(pos / this.BITS)];

        // make it positive by removing the negative bit
        byte mult = 1;
        if (section < 0) {
            mult = -1;
            section++;
            section *= mult;
        }

        // get the position relative to the byte
        int posProper = (int) pos % this.BITS;

        // if we're checking the 0th byte, just check if the mult was negative or not
        if (posProper == 0) {
            if (mult == -1) {
                tbd = true;
            } else {
                tbd = false;
            }
        } else {
            /*
             * otherwise, we iterate down the bits in the byte, tearing each bit
             * off until we reach the position of the byte we needed.
             */
            for (int i = (this.BITS - 1); i >= posProper; i--) {
                byte thisOne = (byte) Math.pow(2, i - 1);

                // then we check if that bit was on or not
                if (section / thisOne == 1) {
                    section -= thisOne;
                    if (posProper == i) {
                        tbd = true;
                    }
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
            return this.currentPos < CoolBool3.this.length();
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
            boolean tbd = CoolBool3.this.report(this.currentPos);
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
