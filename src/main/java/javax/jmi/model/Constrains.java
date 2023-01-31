package javax.jmi.model;

import javax.jmi.reflect.*;
/**
 * 
 * “Constrains” identifies the constraints, if any, on a model element.
end1: constraint Identifies the constraints.
end1Class: Constraint
multiplicity: zero or more
end2: constrainedElement Identifies the constrained elements.
end2Class: ModelElement
multiplicity: one or more
 *
 */
public interface Constrains extends RefAssociation {
    public boolean exists(Constraint constraint, ModelElement constrainedElement);
    public java.util.Collection<Constraint> getConstraint(ModelElement constrainedElement);
    public java.util.Collection<ModelElement> getConstrainedElement(Constraint constraint);
    public boolean add(Constraint constraint, ModelElement constrainedElement);
    public boolean remove(Constraint constraint, ModelElement constrainedElement);
}
