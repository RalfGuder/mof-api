package javax.jmi.model;

/**
 * 
 * The “Attribute” element defines a structural feature that contains a value (or values), i.e., an attribute.
Abstract No.
Super classes StructuralFeature.
Attributes isDerived: specifies whether the value is part of the state of the object, or
whether it is derived.
References None.
Operations None.
MOF Constraints None.
 *
 */
public interface Attribute extends StructuralFeature {
    public boolean isDerived();
    public void setDerived(boolean newValue);
}
