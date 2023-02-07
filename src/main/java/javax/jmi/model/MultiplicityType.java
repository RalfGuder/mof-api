package javax.jmi.model;

import javax.jmi.reflect.RefStruct;

/**
 * <tt>MultiplicityType</tt> is a structure (record) type that is used to specify 
 * the multiplicity properties of an Attribute, Parameter, Reference, or AssociationEnd.
 * 
 * <p><b>Constraints:</b><br>
 * [The <tt>lower</tt> bound of a MultiplicityType to be <tt>Unbounded</tt>.[C-54]]<br>
 * [The <tt>lower</tt> bound of a MultiplicityType cannot exceed the <tt>upper</tt>
 *  bound. [C-55]]<br>
 * [The <tt>upper</tt> bound of a MultiplicityType cannot be less than 1. [C-56]]<br>
 * [If a MultiplicityType specifies bounds of [0..1] or [1..1]), the <tt>is_ordered</tt> 
 * and <tt>is_unique</tt> values must be false. [C-57]]
 * 
 * <pre>
 * struct MultiplicityType {
 *     long lower;
 *     long upper;
 *     boolean isOrdered;
 *     boolean isUnique;
 * };
 * const string LOWER_CANNOT_BE_NEGATIVE_OR_UNBOUNDED = 
 *     "org.omg:constraint.model.multiplicity_type.lower_cannot_be_negative_or_unbounded";
 * const string LOWER_CANNOT_EXCEED_UPPER = 
 *     "org.omg:constraint.model.multiplicity_type.lower_cannot_exceed_upper";
 * const string UPPER_MUST_BE_POSITIVE = 
 *     "org.omg:constraint.model.multiplicity_type.upper_must_be_positive";
 * const string MUST_BE_UNORDERED_NONUNIQUE =
 *     "org.omg:constraint.model.multiplicity_type.must_be_unordered_nonunique";
 * </pre>
 */
public interface MultiplicityType extends RefStruct {
  
  /**
   * This field gives the lower bounds on the number of elements allowed for the 
   * Attribute, Parameter, Reference, or AssociationEnd.
   *
   * @return int Integer
   */
  public int getLower();

  /**
   * This field gives the upper bounds on the number of elements allowed for the
   * Attribute, Parameter, Reference, or AssociationEnd. A value of Unbounded 
   * indicates that there is no upper bound on the number of elements.
   *
   * @return int Integer
   */
  public int getUpper();

  /**
   * This flag indicates whether the order of the elements corresponding to the
   * Attribute, Parameter, Reference, or AssociationEnd has any semantic 
   * significance.
   *
   * @return boolean Boolean
   */
  public boolean isOrdered();

  /**
   * This flag indicates whether or not the elements corresponding to the 
   * Attribute, Parameter, Reference, or AssociationEnd are required (or 
   * guaranteed) to be unique.
   *
   * @return boolean Boolean
   */
  public boolean isUnique();
}
