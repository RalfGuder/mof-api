package javax.jmi.model;

import javax.jmi.reflect.*;

/**
 * 
 * “Exposes” defines the opposite association end of the association end that a reference refers to.
end1: referer Identifies the referencing reference.
end1Class: Reference
multiplicity: zero or more
end2: exposedEnd The reference’s owning classifier’s end in the association.
end2Class: AssociationEnd
multiplicity: exactly one
 *
 */
public interface Exposes extends RefAssociation {
    public boolean exists(Reference referrer, AssociationEnd exposedEnd);
    public java.util.Collection<Reference> getReferrer(AssociationEnd exposedEnd);
    public AssociationEnd getExposedEnd(Reference referrer);
    public boolean add(Reference referrer, AssociationEnd exposedEnd);
    public boolean remove(Reference referrer, AssociationEnd exposedEnd);
}
