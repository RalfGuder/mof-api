package javax.jmi.model;


/**
 * The "NameNotResolved" exception is raised when resolution of a qualified name 
 * has failed.
 */
public class NameNotResolvedException extends javax.jmi.reflect.RefException {
  private static final long serialVersionUID = 1L;
  private final String explanation;
  private final java.util.List<java.lang.String> restOfName;

  /**
   * The "NameNotResolved" exception is raised when resolution of a qualified name 
   * has failed.
   *
   * @param explanation can have the following values with the corresponding 
   *        interpretation:
   *        <ul>
   *        <li> "InvalidName": the first name in restOfName was malformed.
   *        <li> "MissingName": the first name in restOfName could not be 
   *        resolved as no name binding exists for that name.
   *        <li> "NotNameSpace": the first name in restOfName did not resolve to 
   *        a Namespace when a Namespace was expected.
   *        <li> "CannotProceed": the first name in restOfName could not be 
   *        resolved (for any other reason).
   *        </ul>
   * @param restOfName contains that part of the qualified name that was not 
   *        resolved.
   */
  public NameNotResolvedException(String explanation, java.util.List<java.lang.String> restOfName) {
    super("explanation: " + explanation + ", restOfName: " + restOfName);
    this.explanation = explanation;
    this.restOfName = restOfName;
  }

  /**
   * Gets the value of explanation property.
   * 
   * The <b>explanation</b> parameter  can have the following values with the 
   * corresponding interpretation:
   * <ul>
   * <li> "InvalidName": the first name in restOfName was malformed.
   * <li> "MissingName": the first name in restOfName could not be resolved as 
   * no name binding exists for that name.
   * <li> "NotNameSpace": the first name in restOfName did not resolve to a 
   * Namespace when a Namespace was expected.
   * <li> "CannotProceed": the first name in restOfName could not be resolved 
   * (for any other reason).
   * </ul>
   * 
   * @return A sting
   */
  public String getExplanation() {
    return explanation;
  }

  public java.util.List<java.lang.String> getRestOfName() {
    return restOfName;
  }
}
