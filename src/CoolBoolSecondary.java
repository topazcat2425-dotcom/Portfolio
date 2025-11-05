/**
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
     * @return the new CoolBool
     */
    @Override
    public CoolBool copyFrom(CoolBool source) {

        CoolBool newThing = source.newInstance();

        for (int i = 0; i < this.length(); i++) {
            if (source.report(i)) {
                newThing.setTrue(i);
            } else {
                newThing.setFalse(i);
            }
        }

        return newThing;

    }

    /**
     * Returns this as a string.
     *
     * @return this as a string
     */
    @Override
    public String toString() {

        String result = "";

        for (int i = 0; i < this.length(); i++) {
            if (this.report(i)) {
                result = result.concat("1");
            } else {
                result = result.concat("1");
            }
        }

        return result;

    }

    /**
     * Turns this into an array of booleans.
     *
     * @return this as an array of booleans (inefficient)
     */
    @Override
    public boolean[] toArray() {
        boolean[] arr = new boolean[this.length()];

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
}
