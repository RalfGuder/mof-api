package javax.jmi.model;

/**
 * 
 * The “Constant” element defines constant values of simple data types.
Abstract No.
Super classes TypedElement.
Attributes value: the value of the constant.
References None.
Operations None.
MOF Constraints C-52, C-53.
 *
 */
public interface Constant extends TypedElement {
    public String getValue();
    public void setValue(String newValue);
}
