package org.strangetec.sjcomponents;

import java.util.ArrayList;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.event.ListDataListener;

/**
 *
 * @author Daniel A. Lowe
 * @param <T> Type of hidden value
 * @since 30-March-2015
 * <p>
 * Creates a ComboBox which contains a hidden value and a display value.
 * </p>
 */
public class SJComboBox<T> extends JComboBox {
    private DefaultComboBoxModel<SJListItem<T>> model = new
        DefaultComboBoxModel<SJListItem<T>>();;
    /**
     * Default constructor.
     */
    public SJComboBox() {
        setRenderer(new SJComboBoxRenderer<T>());
        setModel(model);
    }
    /**
     * Creates a SJComboBox with the given renderer.
     * @param renderer Renderer for new SJComboBox
     */
    public SJComboBox(SJComboBoxRenderer<T> renderer) {
        setRenderer(renderer);
        setModel(model);
    }
    /**
     * Create a SJComboBox using an array for the hidden value and display<br>
     * value.
     * @param items Array of values for the SJComboBox
     */
    public SJComboBox(T[] items) {
        SJListItem<T>[] values = new SJListItem[items.length];
        for(int cnt = 0; cnt < items.length; cnt++) {
            values[cnt] = new SJListItem<T>(items[cnt], items[cnt].toString());
        }
        model = new DefaultComboBoxModel<SJListItem<T>>(values);
        setModel(model);
    }
    /**
     * Using an array for the values and an array for the display, creates<br>
     * a SJComboBox.
     * @param items Array of hidden values
     * @param displays Array of display values
     * @throws IndexOutOfBoundsException If the two arrays are of different
     * sizes
     */
    public SJComboBox(T[] items, String[] displays) throws
            IndexOutOfBoundsException {
        if(items.length != displays.length)
            throw new IndexOutOfBoundsException("Items and displays arrays " +
                    "must be the same length");
        SJListItem<T>[] values = new SJListItem[items.length];
        for(int cnt = 0; cnt < values.length; cnt++)
            values[cnt] = new SJListItem<T>(items[cnt], displays[cnt]);
        model = new DefaultComboBoxModel<SJListItem<T>>(values);
        setModel(model);
    }
    /**
     * Creates a SJComboBox using a vector for both the hidden and display<br>
     * values.
     * @param items 
     */
    public SJComboBox(Vector<T> items) {
        SJListItem<T>[] values = new SJListItem[items.capacity()];
        for(int cnt = 0; cnt < items.capacity(); cnt++)
            values[cnt] = new SJListItem<T>(items.elementAt(cnt)
                    ,items.elementAt(cnt).toString());
        model = new DefaultComboBoxModel<SJListItem<T>>(values);
        setModel(model);
    }
    /**
     * Creates a SJComboBox using a vector for the hidden values, and a<br>
     * vector for the display values.
     * @param items Vector of hidden values
     * @param displays Vector of display values
     * @throws IndexOutOfBoundsException If the vectors are not the same size
     */
    public SJComboBox(Vector<T> items, Vector<String> displays) throws
            IndexOutOfBoundsException {
        if(items.capacity() != displays.capacity())
            throw new IndexOutOfBoundsException("Items and displays vectors " +
                    "must be the same length.");
        SJListItem<T>[] values = new SJListItem[items.capacity()];
        for(int cnt = 0; cnt < items.capacity(); cnt++)
            values[cnt] = new SJListItem(items.elementAt(cnt)
                    , displays.elementAt(cnt));
        model = new DefaultComboBoxModel<SJListItem<T>>(values);
        setModel(model);
    }
    /**
     * Creates a SJComboBox using an arraylist for both the hidden and<br>
     * display values.
     * @param items ArrayList for the hidden and display values.
     */
    public SJComboBox(ArrayList<T> items) {
        SJListItem<T>[] values = new SJListItem[items.size()];
        for(int cnt = 0; cnt < items.size(); cnt++)
            values[cnt] = new SJListItem<T>(items.get(cnt)
                    , items.get(cnt).toString());
        model = new DefaultComboBoxModel<SJListItem<T>>(values);
        setModel(model);
    }
    /**
     * Create a SJComboBox using an arraylist for hidden values and another<br>
     * arraylist for display values.
     * @param items ArrayList of hidden values
     * @param displays ArrayList of display values
     * @throws IndexOutOfBoundsException If the two ArrayLists do not have the
     * same number of elements
     */
    public SJComboBox(ArrayList<T> items, ArrayList<String> displays) throws
            IndexOutOfBoundsException{
        if(items.size() != displays.size())
            throw new IndexOutOfBoundsException("Items and displays lists " +
                    "must be the same length.");
        SJListItem<T>[] values = new SJListItem[items.size()];
        for(int cnt = 0; cnt < items.size(); cnt++)
            values[cnt] = new SJListItem<T>(items.get(cnt), displays.get(cnt));
        model = new DefaultComboBoxModel<SJListItem<T>>(values);
        setModel(model);
    }

    /**
     * Sets the selected item's value to the new value. Must be of class T.
     * @param item New value
     */
    public void setSelectedItem(Object item) {
        T value = (T)item;
        SJListItem<T> element = new SJListItem<T>(value, value.toString());
        model.setSelectedItem(element);
    }
    /**
     * Sets the select items hidden and display value.
     * @param item New hidden value
     * @param display New display value
     */
    public void setSelectedItem(T item, String display) {
        SJListItem<T> element = new SJListItem<T>(item, display);
        model.setSelectedItem(element);
    }
    /**
     * Retrieves the hidden value of the selected item.
     * @return Hidden value for selected item
     */
    public T getSelectedValue() {
        SJListItem<T> item = (SJListItem<T>)model.getSelectedItem();
        T value = item.getValue();
        return value;
    }
    /**
     * Retrieves the display value of the selected item.
     * @return Display value of the selected item
     */
    public String getSelectedDisplay() {
        SJListItem<T> item = (SJListItem<T>)model.getSelectedItem();
        String display = item.getDisplay();
        return display;
    }
    /**
     * Returns the size of the list.
     * @return Size of the list
     */
    public int getListSize() { return model.getSize(); }
    /**
     * Gets the hidden value at the given index.
     * @param index requested index
     * @return hidden value at index
     */
    public T getValueAt(int index) {
        SJListItem<T> item = model.getElementAt(index);
        T value = item.getValue();
        return value;
    }
    /**
     * Returns the index of the element with the given hidden value and display
     * value.
     * @param value Hidden value of the desired element
     * @param display Display value of the desired element
     * @return index of the desired element
     */
    public int getIndexOf(T value, String display) {
        SJListItem<T> item = new SJListItem<T>(value, display);
        int index = model.getIndexOf(item);
        return index;
    }
    /**
     * Adds a new element at the end of the list with the given hidden and
     * display values.
     * @param value Hidden value of the new element
     * @param display Display value of the new element
     */
    public void addElement(T value, String display) {
        SJListItem<T> item = new SJListItem<T>(value, display);
        model.addElement(item);
    }
    /**
     * Inserts a new element with the given hidden and display value at the
     * requested index.
     * @param value Hidden value of new element
     * @param display Display value of new element
     * @param index Index to insert new element
     */
    public void insertElementAt(T value, String display, int index) {
        SJListItem<T> item = new SJListItem<T>(value, display);
        model.insertElementAt(item, index);
    }
    /**
     * Removes the element at index
     * @param index Requested index
     */
    public void removeElementAt(int index) { model.removeElementAt(index); }
    /**
     * Remove element with the given hidden and display values
     * @param value Hidden value of element to remove
     * @param display Display value of element to remove
     */
    public void removeElement(T value, String display) {
        SJListItem<T> element = new SJListItem<T>(value, display);
        model.removeElement(element);
    }
    /**
     * Removes all elements from the list.
     */
    public void removeAllElements() { model.removeAllElements(); }
    /**
     * Replaces all elements in the SJComboBox with new elements.
     * @param values Array with the hidden values
     * @param displays Array with the display values
     * @throws IndexOutOfBoundsException If the length of the arrays do not
     * match
     */
    public void replaceAllElements(T[] values, String[] displays) throws
            IndexOutOfBoundsException{
        if(values.length != displays.length)
            throw new IndexOutOfBoundsException("Value and display arrays " +
                    "must be the same size");
        model.removeAllElements();
        SJListItem<T>[] elements = new SJListItem[values.length];
        for(int cnt = 0; cnt < values.length; cnt++)
            elements[cnt] = new SJListItem<T>(values[cnt], displays[cnt]);
         model = new DefaultComboBoxModel<SJListItem<T>>(elements);
   }
}