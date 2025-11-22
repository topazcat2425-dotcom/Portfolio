import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 *
 * @author Trevor Baroni
 *
 */
public class CoolBool1 extends CoolBoolSecondary {

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
     * Reads the "array" and reports what the first 6 values are.
     */
    private void debugStick() {
        for (byte i : this.arr) {
            System.out.print(i + " ");
        }
        System.out.println();
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
        this.arr = new byte[(size / 7) + 1];
        this.length = size;

        for (int i = 0; i < this.arr.length; i++) {
            this.arr[i] = 0;
        }
    }

    /*
     * Constructor -----------------------------------------------------------
     */

    /**
     * no argss constructy
     */
    public CoolBool1() {
        this.createNewRep(0);
    }

    /**
     * Constructor from size.
     *
     * @param size
     *            total size of the array
     */
    public CoolBool1(int size) {
        this.createNewRep(size);
    }

    /**
     * Constructor from size.
     *
     * @param size
     *            total size of the array
     */
    public CoolBool1(String size) {
        this.createNewRep(Integer.parseInt(size));
    }

    /*
     * standard methods:
     */

    /**
     * @param source
     *
     * @update clears source
     */
    @Override
    public void transferFrom(CoolBool source) {
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
     * @param pos
     */
    @Override
    public void setTrue(int pos) {
        if (!this.report(pos)) {
            byte section = this.arr[(pos / 7)];
            int posProper = (int) pos % 7;

            this.arr[(pos / 7)] = (byte) (section + Math.pow(2, posProper));
        }
    }

    /**
     * Sets the position to false.
     *
     * @param pos
     */
    @Override
    public void setFalse(int pos) {
        if (this.report(pos)) {
            byte section = this.arr[(pos / 7)];
            int posProper = (int) pos % 7;

            this.arr[(pos / 7)] = (byte) (section - Math.pow(2, posProper));
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

        byte section = this.arr[(pos / 7)];
        int posProper = (int) pos % 7;

        for (byte i = 6; i >= posProper; i--) {
            byte thisOne = (byte) Math.pow(2, i);

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
            return this.currentPos < CoolBool1.this.length();
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
            boolean tbd = CoolBool1.this.report(this.currentPos);
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
