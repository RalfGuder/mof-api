package javax.jmi.model;

/**
 * 
 * The <tt>StructuralFeature</tt> elements defines a static characteristic (e.g., an attribute) of a model element.
Abstract Yes.
Super classes Feature, TypedElement.
Attributes multiplicity: defines the cardinality of an attribute/reference.
isChangeable: specifies whether the attribute values are immutable (through
the generated APIs).
References None.
Operations None.
MOF Constraints None.
 *
 */
public interface StructuralFeature extends Feature, TypedElement {
    public MultiplicityType getMultiplicity();
    public void setMultiplicity(MultiplicityType newValue);
    public boolean isChangeable();
    public void setChangeable(boolean newValue);
}
