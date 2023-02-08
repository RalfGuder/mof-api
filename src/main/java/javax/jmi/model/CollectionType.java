package javax.jmi.model;


/**
 * 
 * The <tt>CollectionType</tt> element represents a data type that is a finite collection of instances of another
type (indicated by the inherited <tt>type</tt> reference).
Abstract No.
Super classes DataType, TypedElement.
Attributes multiplicity: describes the characteristics of the collection type.
References None.
Operations None.
MOF Constraints None.
 *
 */
public interface CollectionType extends DataType, TypedElement {
    public MultiplicityType getMultiplicity();
    public void setMultiplicity(MultiplicityType newValue);
}
