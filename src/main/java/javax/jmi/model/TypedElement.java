package javax.jmi.model;

/**
 * 
 * <tt>TypedElement</tt> is the abstraction of model elements that require a 
 * type as part of their definition (i.e., elements that represent types). The 
 * TypedElement itself does not define a type, but is associated with a 
 * <tt>Classifier</tt>.
 * 
 * <p><b>Abstract</b><br>
 * Yes.
 * 
 * <p><b>Super classes</b><br>
 * ModelElement.
 * 
 * <p><b>Attributes</b><br>
 * None.
 * 
 * <p><b>References</b><br>
 * <b>type:</b> provides the type represented by this element.
 * 
 * <p><b>Operations</b><br>
 * None.
 * 
 * <p><b>MOF Constraints</b><br>
 * None.
 *
 */
public interface TypedElement extends ModelElement {
    public Classifier getType();
    public void setType(Classifier newValue);
}
