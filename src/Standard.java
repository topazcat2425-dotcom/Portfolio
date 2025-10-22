/**
 *
 * @param <T> the object we're making standard for
 *
 * @author Trevor Baroni
 *
 */
public interface Standard<T> {

    /**
     *  @return a new instance of this
     */
    CoolBoolSecondary newInstance();

    /**
     * @clears this
     */
    void clear();

    /**
     * @param source
     * @clears this
     *
     * @return the new CoolBool
     */
    CoolBoolSecondary transferFrom(CoolBoolSecondary source);
}
