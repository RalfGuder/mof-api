package javax.jmi.model;

import javax.jmi.reflect.*;

/**
 * 
 * The “CanRaise” association identifies the exceptions that can be raised by an operation.
end1: operation The set of operations that can raise this exception.
end1Class: Operation
multiplicity: zero or more
end2: except The set of exceptions that this operation can raise.
end2Class: Exception
multiplicity: zero or more
 *
 */
public interface CanRaise extends RefAssociation {
    public boolean exists(Operation operation, MofException except);
    public java.util.Collection<Operation> getOperation(MofException except);
    public java.util.List<MofException> getExcept(Operation operation);
    public boolean add(Operation operation, MofException except);
    public boolean remove(Operation operation, MofException except);
}
