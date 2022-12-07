package javax.jmi.model;

import javax.jmi.reflect.*;

/**
 * <tt>ModelElement</tt> is the root of all MOF elements. It represents the 
 * elementary constructs of model elements.
 * 
 * <p><b>Abstract</b><br> 
 * Yes.
 *
 * <p><b>Super classes</b><br>
 * None.
 *
 * <p><b>Attributes</b><br>
 * <b>name:</b> unique name supplied by meta-modeler.<br>
 * <b>annotation:</b> description of the model element.<br>
 * <b>qualifiedName:</b> fully qualified name within the context of its outermost 
 * package extent.<br>
 *
 * <p><b>References</b><br> 
 * <b>container:</b> identifies the Namespace element that contains this element.<br>
 * <b>requiredElements:</b> identifies the ModelElements whose definition this 
 * object depends on.<br>
 * <b>constraints:</b> identifies the set of Constraint objects that apply to this object.<br>
 * 
 * <p><b>Operations</b><br>
 * <b>isFrozen:</b> reports whether the object is mutable.<br>
 * <b>isVisible:</b> this operation is reserved for future use.<br>
 * <b>isRequiredBecause:</b> checks whether the object depends on another object, 
 * and if so, returns the type of dependency.<br>
 * 
 * <p><b>MOF Constraints</b><br>
 * C-1, C-2, C-3, and C-4.
 *
 */
public interface ModelElement extends RefObject {
  public String CONTAINERDEP = "container";
  public String CONTENTSDEP = "contents";
  public String SIGNATUREDEP = "signature";
  public String CONSTRAINTDEP = "constraint";
  public String CONSTRAINEDELEMENTSDEP = "constrained elements";
  public String SPECIALIZATIONDEP = "specialization";
  public String IMPORTDEP = "import";
  public String TYPEDEFINITIONDEP = "type definition";
  public String REFERENCEDENDSDEP = "referenced ends";
  public String TAGGEDELEMENTSDEP = "tagged elements";
  public String INDIRECTDEP = "indirect";
  public String ALLDEP = "all";

  public java.util.Collection findRequiredElements(java.util.Collection kinds, boolean recursive);

  public boolean isRequiredBecause(ModelElement otherElement, String[] reason);

  public boolean isFrozen();

  public boolean isVisible(ModelElement otherElement);

  public String getName();

  public void setName(String newValue);

  public java.util.List getQualifiedName();

  public String getAnnotation();

  public void setAnnotation(String newValue);

  public java.util.Collection getRequiredElements();

  public Namespace getContainer();

  public void setContainer(Namespace newValue);

  public java.util.Collection getConstraints();
}
