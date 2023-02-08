package javax.jmi.model;


/**
 * 
 * The <tt>Operation</tt> element defines a dynamic feature that offers a service, i.e., an operation.
Abstract No.
Super classes BehavioralFeature.
Attributes isQuery: specifies whether the behavior of the operation alters the state of the
object.
References exceptions: specifies the exceptions that the operation may raise.
Operations None.
MOF Constraints C-28, C-29, C-30.
 *
 */
public interface Operation extends BehavioralFeature {
    public boolean isQuery();
    public void setQuery(boolean newValue);
    public java.util.List getExceptions();
}
