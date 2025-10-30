/**
 *
 * @author Trevor Baroni
 *
 */
public interface CoolBool extends CoolBoolKernel {

    /**
     * Copies from the source to this.
     *
     * @param source
     *
     * @return the new CoolBool
     */
    CoolBool copyFrom(CoolBool source);

    /**
     * Returns this as a string.
     *
     * @return this as a string
     */
    @Override
    String toString();

    /**
     * Turns this into an array of booleans.
     *
     * @return this as an array of booleans (inefficient)
     */
    boolean[] toArray();

    /**
     * Turns every true into false and every false into true... for some reason.
     */
    void boolflip();
}
