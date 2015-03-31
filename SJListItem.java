package org.strangetec.sjcomponents;

/**
 *
 * @author Elfin D. Strange
 * @since 30-March-2015
 * <p>
 * The SJListItem holds both the value and the display values for SJComboBox<br>
 * and SJList classes.
 * </p>
 */
public class SJListItem<T> {
    T p_value = null;
    String p_display = null;
    
    /**
     * <p>
     * Creates a SJListItem object and assign value and display.
     * </p>
     * @param value Value of the SJListItem
     * @param display Display value of the SJListItem
     */
    public SJListItem(T value, String display) {
        p_value = value;
        p_display = display.trim();
    }
    
    /**
     * Retrieve the value of the SJListItem.
     * @return Value of the SJListItem
     */
    public T getValue() { return p_value; }
    /**
     * Get the display value of the SJListItem.
     * @return Display value of SJListItem
     */
    public String getDisplay() { return p_display; }
    /**
     * Get the display value of the SJListItem.
     * @return Display value of the SJListItem
     */
    @Override
    public String toString() { return p_display; }
    /**
     * Sets the value of the SJListItem.
     * @param value New value for SJListItem
     */
    public void setValue(T value) { p_value = value; }
    /**
     * Sets the display value of the SJListItem.
     * @param display Display value of the SJListItem
     */
    public void setDisplay(String display) { p_display = display.trim(); }
}
