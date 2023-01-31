package javax.jmi.model;

/**
 * A <tt>Tag</tt> is an arbitrary name/value pair that can be attached to most 
 * elements. Tags provide an easy extension mechanism by allowing users to add 
 * information to a metamodel element.
 * 
 * <p><b>Abstract</b><br>
 * No.
 * 
 * <p><b>Super classes</b><br>
 * ModelElement.
 * 
 * <p><b>Attributes</b><br>
 * <b>tagId:</b> specifies the meaning of the tag.<br>
 * <b>values:</b> (ordered) specifies the string value(s) for the tag.<br>
 * 
 * <p><b>References</b><br>
 * <b>elements:</b> the elements that this tag is attached to.<br>
 * 
 * <p><b>Operations</b><br>
 * None.
 * 
 * <p><b>MOF Constraints</b><br>
 * None.
 */
public interface Tag extends ModelElement {
    public String getTagId();
    public void setTagId(String newValue);
    public java.util.List<?> getValues();
    public java.util.Collection<?> getElements();
}
