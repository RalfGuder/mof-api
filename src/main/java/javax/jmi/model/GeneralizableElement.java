package javax.jmi.model;


/**
 * <tt>GeneralizableElement</tt> represents elements that can be generalized 
 * through supertyping and specialized through subtyping.
 * 
 * <p><b>Abstract</b><br>
 * Yes.
 * 
 * <p><b>Super classes</b><br>
 * Namespace.
 * 
 * <p><b>Attributes</b><br>
 * <b>visibility:</b> this attribute is reserved for future use.<br>
 * <b>isAbstract:</b> specifies whether the element is abstract.<br>
 * <b>isRoot:</b> specifies whether the element can be generalized (i.e., can 
 * have supertypes).<br>
 * <b>isLeaf:</b> specifies whether the element can be specialized (i.e., can 
 * have subtypes).<br>
 * 
 * <p><b>References</b><br>
 * <b>supertypes:</b> identifies the set of supertypes for this element.<br>
 * 
 * <p><b>Operations</b><br>
 * <b>allSupertypes:</b> returns the list of all (direct and indirect) 
 * supertypes.<br>
 * <b>lookupElementExtended:</b> returns an element whose name matches the 
 * supplied name.<br>
 * <b>findElementByTypeExtended:</b> returns all elements identified by type, 
 * contained within this element and all of its superclasses.<br>
 * 
 * <p><b>MOF Constraints</b><br>
 * C-6, C-7, C-8, C-9, C-10, C-11, and C-12.
 * 
 *
 */
public interface GeneralizableElement extends Namespace {
  public java.util.List<?> allSupertypes();

  public ModelElement lookupElementExtended(String name) throws NameNotFoundException;

  public java.util.List<?> findElementsByTypeExtended(MofClass ofType, boolean includeSubtypes);

  public boolean isRoot();

  public void setRoot(boolean newValue);

  public boolean isLeaf();

  public void setLeaf(boolean newValue);

  public boolean isAbstract();

  public void setAbstract(boolean newValue);

  public VisibilityKind getVisibility();

  public void setVisibility(VisibilityKind newValue);

  public java.util.List<?> getSupertypes();
}
