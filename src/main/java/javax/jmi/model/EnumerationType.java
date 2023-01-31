package javax.jmi.model;


/**
 * 
 * The “EnumerationType” element represents a data type with an enumerated set of possible string values.
Abstract No.
Super classes DataType.
Attributes labels: the strings representing the enumerated values constituting the
enumeration
References None.
Operations None.
MOF Constraints None.
 *
 */
public interface EnumerationType extends DataType {
    public java.util.List getLabels();
}
