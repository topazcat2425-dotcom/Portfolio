/**
 *
 * @author Trevor Baroni
 *
 */
public interface CoolBool extends CoolBoolKernel {

    /**
     * Copies {@code source} to {@code this}.
     *
     * @param source
     *            {@code CoolBool} to copy from
     * @replaces this
     * @ensures this = source
     */
    void copyFrom(CoolBool source);

    /**
     * Returns {@code this} as a string.
     *
     * @return {@code this} as a string
     */
    @Override
    String toString();

    /**
     * Turns {@code this} into an array of booleans.
     *
     * @return {@code this} as an array of booleans (inefficient)
     */
    boolean[] toArray();

    /**
     * Turns every true into false and every false into true... for some reason.
     */
    void boolflip();

    /**
     * Returns the amount of true values.
     *
     * @return number of true values.
     */
    int numTrue();
}
