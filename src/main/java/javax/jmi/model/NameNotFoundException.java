package javax.jmi.model;

import javax.jmi.reflect.RefException;


/**
 * The "NameNotFound" exception is raised when a lookup of a simple name has failed.
 *
 */
public class NameNotFoundException extends RefException {
  private static final long serialVersionUID = 1L;
  private final String name;

  /**
   * The "NameNotFound" exception is raised when a lookup of a simple name has failed.
   *
   * @param name gives the string value that could not be found in the {@linkplain 
   *        Namespace} or extended Namespace searched by the operation.
   */
  public NameNotFoundException(String name) {
    super("name: " + name);
    this.name = name;
  }

  public String getName() {
    return name;
  }
}
