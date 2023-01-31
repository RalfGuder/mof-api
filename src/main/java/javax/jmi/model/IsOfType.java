package javax.jmi.model;

import javax.jmi.reflect.*;

/**
 * 
 * The “IsOfType” association identifies the type of a typed element.
end1: type Identifies the typed element.
end1Class: Classifier
multiplicity: exactly one
end2: typedElement Identifies the set of typed elements supported by the classifier.
end2Class: TypedElement
multiplicity: zero or more
 *
 */
public interface IsOfType extends RefAssociation {
    public boolean exists(Classifier type, TypedElement typedElements);
    public Classifier getType(TypedElement typedElements);
    public java.util.Collection<TypedElement> getTypedElements(Classifier type);
    public boolean add(Classifier type, TypedElement typedElements);
    public boolean remove(Classifier type, TypedElement typedElements);
}
