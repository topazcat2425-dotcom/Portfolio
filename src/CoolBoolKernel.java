/**
 *
 *
 * @author Trevor Baroni
 * @param <CoolBool>
 *
 */
public interface CoolBoolKernel extends Standard<CoolBool>, Iterable<Boolean> {

    /**
     * Sets the position to true.
     *
     * @param pos
     */
    void setTrue(int pos);

    /**
     * Sets the position to false.
     *
     * @param pos
     */
    void setFalse(int pos);

    /**
     * Reports the value the boolean at pos.
     *
     * @param pos
     *
     * @return reported element
     */
    boolean report(int pos);

    /**
     * Reports the length of this.
     *
     * @return length of array
     */
    int length();

}
