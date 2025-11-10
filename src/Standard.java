/**
 *
 * @param <T>
 *            this does stuff.
 *
 * @author Trevor Baroni
 *
 */
public interface Standard<T> {

    /**
     * @param source
     *
     * @return the new CoolBool
     * @update clears source
     */
    T transferFrom(T source);

    /**
     * @return new instance of this
     */
    T newInstance();

    /**
     * @clears this
     */
    void clear();
}
