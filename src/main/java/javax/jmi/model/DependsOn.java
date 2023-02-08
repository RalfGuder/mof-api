package javax.jmi.model;

import javax.jmi.reflect.*;

/**
 * <tt>DependsOn</tt> is a derived association that identifies the collection 
 * of model elements that a given model element's structure depends on.
 *
 end1: dependent This end identifies the dependent element.
end1Class: ModelElement
multiplicity: zero or more
end2: provider This end identifies the elements that the <b>dependent</b> end depends on.
end2Class: ModelElement
multiplicity: zero or more
 */
public interface DependsOn extends RefAssociation {
    public boolean exists(ModelElement dependent, ModelElement provider);
    public java.util.Collection<ModelElement> getDependent(ModelElement provider);
    public java.util.Collection<ModelElement> getProvider(ModelElement dependent);
}
