package javax.jmi.model;

/**
 * The <tt>Namespace</tt> element represents model elements that can contain 
 * other model elements.
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
 * <b>contents:</b> identifies the set of elements that the namespace object contains.<br>
 * 
 * <p><b>Operations</b><br>
 * <b>lookupElement:</b> searches for a specified element within its contained 
 * elements.<br>
 * <b>resolveQualifiedName:</b> searches for a specified (fully qualified) element 
 * within its contained elements.<br>
 * <b>nameIsValid:</b> checks whether the given name can be used within the namespace.<br>
 * <b>findElementByType:</b> returns all elements identified by type, contained 
 * within the namespace.<br>
 * 
 * <p><b>MOF Constraints</b><br>
 * C-5.
 *
 */
public interface Namespace extends ModelElement {
  
  /**
   * Searches for a specified element within its contained elements.
   */
  public ModelElement lookupElement(String name) throws NameNotFoundException;

  public ModelElement resolveQualifiedName(java.util.List<?> qualifiedName)
      throws NameNotResolvedException;

  public java.util.List<?> findElementsByType(MofClass ofType, boolean includeSubtypes);

  public boolean nameIsValid(String proposedName);

  public java.util.List<?> getContents();
}
