package javax.jmi.model;


/**
 * A <tt>Feature</tt> defines a characteristic (e.g, operation or attribute) of 
 * a model element.
 * 
 * <p><b>Abstract</b><br>
 * Yes.
 * 
 * <p><b>Super classes</b><br>
 * ModelElement.
 * 
 * <p><b>Attributes</b><br>
 * <b>visibility:</b> this attribute is reserved for future use.<br>
 * <b>scope:</b> specifies whether the feature is a classifier scoped or instance 
 * scoped feature.<br>
 * 
 * <p><b>References</b><br>
 * None.
 * 
 * <p><b>Operations</b><br>
 * None.
 * 
 * <p><b>MOF Constraints</b><br>
 * None.
 *
 */
public interface Feature extends ModelElement {
    public ScopeKind getScope();
    public void setScope(ScopeKind newValue);
    public VisibilityKind getVisibility();
    public void setVisibility(VisibilityKind newValue);
}
