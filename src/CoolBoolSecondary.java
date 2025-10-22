/**
 *
 * @author Trevor Baroni
 *
 */
public interface CoolBoolSecondary extends CoolBoolKernel {

    /**
     * @param source
     *
     * @return the new CoolBool
     */
    CoolBoolSecondary copyFrom(CoolBoolSecondary source);

    /**
     * @return this as a string
     */
    @Override
    String toString();

    /**
     * @return this as an array of booleans (inefficient)
     */
    @Override
    boolean[] toArray();
}
