package javax.jmi.model;

import java.io.InvalidObjectException;
import java.io.ObjectStreamException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.jmi.reflect.RefEnum;


public final class AggregationKindEnum implements AggregationKind {
	private static final long serialVersionUID = 1L;
	
	public static final AggregationKindEnum NONE = new AggregationKindEnum("none");
    public static final AggregationKindEnum SHARED = new AggregationKindEnum("shared");
    public static final AggregationKindEnum COMPOSITE = new AggregationKindEnum("composite");

    private static final List<String> typeName;
    private final String literalName;

    static {
        List<String> temp = new ArrayList<String>();
        temp.add("Model");
        temp.add("AggregationKind");
        typeName = Collections.unmodifiableList(temp);
    }

    private AggregationKindEnum(String literalName) {
        this.literalName = literalName;
    }

    public List<String> refTypeName() {
        return typeName;
    }

    public String toString() {
        return literalName;
    }

    public int hashCode() {
        return literalName.hashCode();
    }

    public boolean equals(Object o) {
        if (o instanceof AggregationKindEnum) return (o == this);
        else if (o instanceof AggregationKind) return (o.toString().equals(literalName));
        else return ((o instanceof RefEnum) && ((RefEnum) o).refTypeName().equals(typeName) && o.toString().equals(literalName));
    }

    protected Object readResolve() throws ObjectStreamException {
    	try {
    		return forName(literalName);
    	} catch ( IllegalArgumentException iae ) {
    		throw new InvalidObjectException(iae.getMessage());
    	}
    }
  public static AggregationKind forName( java.lang.String value ) {
    if ( value.equals("none") ) return AggregationKindEnum.NONE;
    if ( value.equals("shared") ) return AggregationKindEnum.SHARED;
    if ( value.equals("composite") ) return AggregationKindEnum.COMPOSITE;
    throw new IllegalArgumentException("Unknown enumeration value '"+value+"' for type 'Model.AggregationKind'");
  }
}
