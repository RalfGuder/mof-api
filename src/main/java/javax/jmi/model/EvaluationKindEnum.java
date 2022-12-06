package javax.jmi.model;

import static java.util.Collections.unmodifiableList;

import java.io.InvalidObjectException;
import java.io.ObjectStreamException;
import java.util.ArrayList;
import java.util.List;

import javax.jmi.reflect.RefEnum;

public final class EvaluationKindEnum implements EvaluationKind {
	private static final long serialVersionUID = 1L;
	public static final EvaluationKindEnum IMMEDIATE = new EvaluationKindEnum("immediate");
    public static final EvaluationKindEnum DEFERRED = new EvaluationKindEnum("deferred");

    private static final List<String> typeName;
    private final String literalName;

    static {
        List<String> temp = new ArrayList<String>();
        temp.add("Model");
        temp.add("Constraint");
        temp.add("EvaluationKind");
        typeName = unmodifiableList(temp);
    }

    private EvaluationKindEnum(String literalName) {
        this.literalName = literalName;
    }

    public java.util.List<String> refTypeName() {
        return typeName;
    }

    public String toString() {
        return literalName;
    }

    public int hashCode() {
        return literalName.hashCode();
    }

    public boolean equals(Object o) {
        if (o instanceof EvaluationKindEnum) return (o == this);
        else if (o instanceof EvaluationKind) return (o.toString().equals(literalName));
        else return ((o instanceof RefEnum) && ((RefEnum) o).refTypeName().equals(typeName) && o.toString().equals(literalName));
    }

    protected Object readResolve() throws ObjectStreamException {
    	try {
    		return forName(literalName);
    	} catch ( IllegalArgumentException iae ) {
    		throw new InvalidObjectException(iae.getMessage());
    	}
    }
  public static EvaluationKind forName( java.lang.String value ) {
    if ( value.equals("immediate") ) return EvaluationKindEnum.IMMEDIATE;
    if ( value.equals("deferred") ) return EvaluationKindEnum.DEFERRED;
    throw new IllegalArgumentException("Unknown enumeration value '"+value+"' for type 'Model.Constraint.EvaluationKind'");
  }
}
