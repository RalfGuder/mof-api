package javax.jmi.model;

import javax.jmi.reflect.RefEnum;

/**
 * This data type enumerates the three possible kinds of visibility for a 
 * ModelElement outside of its container. These are:
 * <ol>
 * <li><tt>public_vis</tt>, which allows anything that can use ModelElement’s 
 * container to also use the ModelElement.<br>
 * <li><tt>protected_vis</tt>, which allows use of the ModelElement within containers 
 * that inherits from this one’s container.<br>
 * <li><tt>private_vis</tt>, which denies all outside access to the ModelElement.
 * </ol>
 * 
 * <p>The rules governing visibility of ModelElements in the MOF are yet to be 
 * specified. As an interim measure, all ModelElements are deemed to be visible, 
 * irrespective of the “visibility” attribute settings. The IDL mapping specification 
 * includes minimal preconditions on visibility to ensure that generated IDL is 
 * compilable.
 * 
 * <pre>
 * enum VisibilityKind {public_vis, private_vis, protected_vis};
 * </pre>
 *
 */
public interface VisibilityKind extends RefEnum {
}
