package javax.jmi.model;

/**
 * An <tt>AssociationEnd</tt> represents one end of an association object. That 
 * is, an association is composed of two AssociationEnds.
 * 
 * <p><b>Abstract</b><br>
 * No.
 * 
 * <p><b>Super classes</b><br>
 * TypedElement.
 * 
 * <p><b>Attributes</b><br>
 * <b>multiplicity:</b> defines the cardinality of the association end.<br>
 * <b>aggregation:</b> defines whether the association end is constrained by 
 * <tt>aggregate</tt> semantics.<br>
 * <b>isNavigable:</b> specifies whether the association end supports navigation.<br>
 * <b>isChangeable:</b> specifies whether the association end can be updated 
 * (using the generated APIs).
 * 
 * <p><b>References</b><br>
 * None.
 * 
 * <p><b>Operations</b><br>
 * <b>otherEnd:</b> returns the other <tt>AssociationEnd</tt>.
 * 
 * <p><b>MOF Constraints</b><br>
 * <b>EndTypeMustBeClass</b> (C-39): The type of an AssociationEnd must be Class.<br>
 * <b>EndsMustBeUnique</b> (C-40): The <tt>isUnique</tt> flag in an AssociationEnd’s 
 * multiplicity must be true.<br>
 * <b>CannotHaveTwoOrderedEnds</b> (C-41): An Association cannot have two 
 * AssociationEnds marked as <tt>ordered</tt>.<br>
 * <b>CannotHaveTwoAggregateEnds</b> (C-42): An Association cannot have an 
 * aggregation semantic specified for both AssociationEnds.<br>
 *
 */
public interface AssociationEnd extends TypedElement {
  public AssociationEnd otherEnd();

  public boolean isNavigable();

  public void setNavigable(boolean newValue);

  public AggregationKind getAggregation();

  public void setAggregation(AggregationKind newValue);

  public MultiplicityType getMultiplicity();

  public void setMultiplicity(MultiplicityType newValue);

  public boolean isChangeable();

  public void setChangeable(boolean newValue);
}
