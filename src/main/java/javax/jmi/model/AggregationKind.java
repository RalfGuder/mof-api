package javax.jmi.model;

import javax.jmi.reflect.RefEnum;

/**
 * <tt>AggregationKind</tt> enumerates the possible aggregation semantics for 
 * Associations (specified via AssociationEnds).
 * 
 * <p>Aggregation semantics in the MOF is intended to be aligned 
 * with UML. Unfortunately, the OMG UML specification does not define the meaning 
 * of <tt>shared</tt> aggregation for UML. As an interim measure, the use of 
 * <tt>shared</tt> aggregation in MOF meta-models is discouraged.
 * 
 * <pre>
 * enum AggregationKind {none, shared, composite};
 * </pre>
 * 
 */
public interface AggregationKind extends RefEnum {
}
