package javax.jmi.model;

import javax.jmi.reflect.*;

/**
 * 
 * The <tt>Generalizes</tt> association identifies a supertype/subtype relationship.
end1: supertype Identifies the supertype (i.e., generalized element).
end1Class: GeneralizableElement
multiplicity: zero or more
end2: subtype Identifies the subtype (i.e., the specialized element).
end2Class: GeneralizableElement
multiplicity: zero or more
 *
 */
public interface Generalizes extends RefAssociation {
    public boolean exists(GeneralizableElement supertype, GeneralizableElement subtype);
    public java.util.List<GeneralizableElement> getSupertype(GeneralizableElement subtype);
    public java.util.Collection<GeneralizableElement> getSubtype(GeneralizableElement supertype);
    public boolean add(GeneralizableElement supertype, GeneralizableElement subtype);
    public boolean remove(GeneralizableElement supertype, GeneralizableElement subtype);
}
