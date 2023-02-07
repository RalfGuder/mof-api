package javax.jmi.model;

/**
 * An <tt>Association</tt> represents a modeling element that classifies a set 
 * of links.
 * 
 * <p><b>Abstract</b><br> 
 * No.
 * 
 * <p><b>Super classes</b><br>
 * Classifier.
 * 
 * <p><b>Attributes</b><br> 
 * <b>isDerived:</b> specifies whether the association contains links or whether 
 * the link set is derived.<br>
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
public interface Association extends Classifier {
  public boolean isDerived();

  public void setDerived(boolean newValue);
}
