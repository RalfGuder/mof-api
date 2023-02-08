package javax.jmi.model;


/**
 * 
 * The <tt>Class</tt> element represents a (realizable) modeling element that classifies instance objects by the
features that they contain.
Abstract No.
Super classes Classifier.
Attributes isSingleton: specifies whether no more than one instance object or any number
of instance objects may exist.
References None.
Operations None.
MOF Constraints C-15, C-16.
 *
 */
public interface MofClass extends Classifier {
    public boolean isSingleton();
    public void setSingleton(boolean newValue);
}
