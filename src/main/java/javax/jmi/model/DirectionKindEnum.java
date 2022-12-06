package javax.jmi.model;

import java.io.InvalidObjectException;
import java.io.ObjectStreamException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.jmi.reflect.RefEnum;

public final class DirectionKindEnum implements DirectionKind {
	private static final long serialVersionUID = 1L;
	public static final DirectionKindEnum IN_DIR = new DirectionKindEnum("in_dir");
    public static final DirectionKindEnum OUT_DIR = new DirectionKindEnum("out_dir");
    public static final DirectionKindEnum INOUT_DIR = new DirectionKindEnum("inout_dir");
    public static final DirectionKindEnum RETURN_DIR = new DirectionKindEnum("return_dir");

    private static final List<String> typeName;
    private final String literalName;

    static {
        List<String> temp = new ArrayList<String>();
        temp.add("Model");
        temp.add("DirectionKind");
        typeName = Collections.unmodifiableList(temp);
    }

    private DirectionKindEnum(String literalName) {
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
        if (o instanceof DirectionKindEnum) return (o == this);
        else if (o instanceof DirectionKind) return (o.toString().equals(literalName));
        else return ((o instanceof RefEnum) && ((RefEnum) o).refTypeName().equals(typeName) && o.toString().equals(literalName));
    }

    protected Object readResolve() throws ObjectStreamException {
    	try {
    		return forName(literalName);
    	} catch ( IllegalArgumentException iae ) {
    		throw new InvalidObjectException(iae.getMessage());
    	}
    }
  public static DirectionKind forName( java.lang.String value ) {
    if ( value.equals("in_dir") ) return DirectionKindEnum.IN_DIR;
    if ( value.equals("out_dir") ) return DirectionKindEnum.OUT_DIR;
    if ( value.equals("inout_dir") ) return DirectionKindEnum.INOUT_DIR;
    if ( value.equals("return_dir") ) return DirectionKindEnum.RETURN_DIR;
    throw new IllegalArgumentException("Unknown enumeration value '"+value+"' for type 'Model.DirectionKind'");
  }
}
