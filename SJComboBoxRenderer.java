package org.strangetec.sjcomponents;

import java.awt.Component;
import javax.swing.JList;
import javax.swing.plaf.basic.BasicComboBoxRenderer;

/**
 *
 * @author Elfin D. Strange
 * @since 30-March-2015
 * <p>
 * A renderer for the SJComboBox using a SJListItem to contain values and<br>
 * display values.
 * </p>
 */
public class SJComboBoxRenderer<T> extends BasicComboBoxRenderer {

    /**
     *
     * @param list
     * @param value
     * @param index
     * @param isSelected
     * @param cellHasFocus
     * @return
     */
    @Override
    public Component getListCellRendererComponent(JList list, Object value,
            int index, boolean isSelected, boolean cellHasFocus) {
        super.getListCellRendererComponent(list, value, TOP, isSelected,
                isSelected);
        if(value != null || index == -1) {
            T item = (T)value;
            setText(item.toString());
        }
        return this;
    }
}
