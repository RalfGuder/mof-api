package javax.jmi.model;

/**
 * 
 * An “Association” represents a modeling element that classifies a set of links.
Abstract No.
Super classes Classifier.
Attributes isDerived: specifies whether the association contains links or whether the link
set is derived.
References None.
Operations None.
MOF Constraints None.
 *
 */
public interface Association extends Classifier {
    public boolean isDerived();
    public void setDerived(boolean newValue);
}
