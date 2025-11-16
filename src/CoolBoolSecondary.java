/**
 *
 * {@code CoolBoolKernel} enhanced with secondary methods.
 *
 * @author Trevor Baroni
 *
 */
public abstract class CoolBoolSecondary implements CoolBool {

    /**
     * Copies from the source to this.
     *
     * @param source
     *
     * @updates this
     */
    @Override
    public void copyFrom(CoolBool source) {

        // clears this to make room to copy
        this.clear();

        // iterates through the cool bool...ean
        for (int i = 0; i < source.length(); i++) {
            // copies everything from source to this
            if (source.report(i)) {
                this.setTrue(i);
            } else {
                this.setFalse(i);
            }
        }
    }

    /**
     * Returns {@code this} as a string.
     *
     * @return {@code this} as a string
     */
    @Override
    public String toString() {

        String result = "";

        // iterates through this
        for (int i = 0; i < this.length(); i++) {
            // if true, add a 1 to the string, else add 0
            if (this.report(i)) {
                result = result.concat("1");
            } else {
                result = result.concat("0");
            }
        }

        return result;

    }

    /**
     * Turns {@code this} into an array of booleans.
     *
     * @return {@code this} as an array of booleans (inefficient)
     */
    @Override
    public boolean[] toArray() {
        boolean[] arr = new boolean[this.length()];

        // iterates through and adds each true/false to the array
        for (int i = 0; i < this.length(); i++) {
            arr[i] = this.report(i);
        }

        return arr;
    }

    /**
     * Turns every true into false and every false into true... for some reason.
     */
    @Override
    public void boolflip() {

        for (int i = 0; i < this.length(); i++) {
            if (this.report(i)) {
                this.setFalse(i);
            } else {
                this.setTrue(i);
            }
        }
    }

    /**
     * Returns the amount of true values.
     *
     * @return number of true values.
     */
    @Override
    public int numTrue() {
        int count = 0;

        for (int i = 0; i < this.length(); i++) {
            if (this.report(i)) {
                count++;
            }
        }
        return count;
    }

    @Override
    public boolean equals(Object x) {
        assert x != null : "get that outta here!";

        boolean samies = false;

        if (x == this) {
            samies = true;
        }

        if (x instanceof CoolBool) {
            boolean[] obj = ((CoolBoolSecondary) x).toArray();
            boolean[] thi = this.toArray();
            if (thi.equals(obj)) {
                samies = true;
            }
        }

        return samies;
    }

    @Override
    public int hashCode() {

        int hash = 0;

        boolean[] arr = this.toArray();

        for (boolean i : arr) {
            if (i) {
                hash++;
            }
        }

        return hash;
    }
}
