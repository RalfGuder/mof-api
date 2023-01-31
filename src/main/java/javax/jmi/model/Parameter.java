package javax.jmi.model;

/**
 * 
 * The “Parameter” element defines parameters used to communicate with BehavioralFeatures.
Abstract No.
Super classes TypedElement.
Attributes direction: specifies the direction of information exchange (i.e., to pass a value
into, to receive a value from, or both).
multiplicity: defines the cardinality of the parameter.
References None.
Operations None.
MOF Constraints None.
 *
 */
public interface Parameter extends TypedElement {
    public DirectionKind getDirection();
    public void setDirection(DirectionKind newValue);
    public MultiplicityType getMultiplicity();
    public void setMultiplicity(MultiplicityType newValue);
}
