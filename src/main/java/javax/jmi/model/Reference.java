package javax.jmi.model;



/**
 * A “Reference” defines a classifier’s knowledge of an association object which references that classifier,
and access to the link set of the association.
Abstract No.
Super classes StructuralFeature.
Attributes None.
References referencedEnd: specifies the association end of principle interest to the
reference.
exposedEnd: the association end representing the end of the reference’s
owning classifier.
Operations None.
MOF Constraints C-21, C-22, C-23, C-24, C-25, C-26, C-27.
 *
 */
public interface Reference extends StructuralFeature {
    public AssociationEnd getExposedEnd();
    public void setExposedEnd(AssociationEnd newValue);
    public AssociationEnd getReferencedEnd();
    public void setReferencedEnd(AssociationEnd newValue);
}
