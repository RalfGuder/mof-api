package javax.jmi.model;

import javax.jmi.reflect.*;

/**
 * 
 * “Aliases” identifies the imported Namespace.
end1: importer Identifies the element that imports a namespace.
end1Class: Import
multiplicity: zero or more
end2: imported The namespace that is imported.
end2Class: Namespace
multiplicity: exactly one
 *
 */
public interface Aliases extends RefAssociation {
    public boolean exists(Import importer, Namespace imported);
    public java.util.Collection<Import> getImporter(Namespace imported);
    public Namespace getImported(Import importer);
    public boolean add(Import importer, Namespace imported);
    public boolean remove(Import importer, Namespace imported);
}
