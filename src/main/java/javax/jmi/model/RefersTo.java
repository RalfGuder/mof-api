package javax.jmi.model;

import javax.jmi.reflect.*;

/**
 * 
 * The <tt>RefersTo</tt> association defines the association end that a reference refers to.
end1: referent The reference object that refers to an association end.
end1Class: Reference
multiplicity: zero or more
end2: referencedEnd The association end being referenced.
end2Class: AssociationEnd
multiplicity: exactly one
 *
 */
public interface RefersTo extends RefAssociation {
    public boolean exists(Reference referent, AssociationEnd referencedEnd);
    public java.util.Collection<Reference> getReferent(AssociationEnd referencedEnd);
    public AssociationEnd getReferencedEnd(Reference referent);
    public boolean add(Reference referent, AssociationEnd referencedEnd);
    public boolean remove(Reference referent, AssociationEnd referencedEnd);
}
