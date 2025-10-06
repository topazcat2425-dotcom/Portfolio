/**
 *
 * @param T
 *
 * @author Trevor Baroni
 *
 */
public interface Standard<T> {

    /**
     * @param source
     *
     * @return the new CoolBool
     */
    CoolBool copyFrom(CoolBool source);

    /**
     * @return this as a string
     */
    @Override
    String toString();

    /**
     * @return this as an array of booleans (inefficient)
     */
    boolean[] toArray();
}