package javax.jmi.model;

import java.util.List;

/**
 * The <tt>Namespace</tt> element represents model elements that can contain 
 * other model elements.
 * 
 * <p>The Namespace Class classifies and characterizes ModelElements that can 
 * contain other ModelElements. Along with containing the ModelElements, a 
 * Namespace defines a namespace, the allowable set of names and the naming 
 * constraints, for these elements.
 * 
 * <p>Subclasses of the Namespace Class have mechanisms for effectively extending 
 * their namespace, without actually containing additional ModelElements. Thus 
 * Namespace can be viewed in terms of its two roles, as a container and as a 
 * namespace mechanism. Because only subclasses extend the namespace, the namespace 
 * and contents are coincident in the definition of the Namespace Class. Each 
 * Namespace has four collections (the latter three derivable) that are used in 
 * the MOF Model's Constraints. These collections are:
 * <ul>
 * <li>The contents (also called the direct contents), which are defined by the 
 * contents reference.
 * <li>All contents, the transitive closure on the contents reference.
 * <li>The extended namespace (the contents plus elements included by extension), 
 * which Namespace subclasses accomplish through generalization and importation.
 * <li>The extended contents (the transitive closure on the contents reference 
 * applied to the extended namespace).
 * </ul>
 * 
 * <h3>Abstract</h3>
 * Yes.
 * 
 * <h3>Super classes</h3>
 * {@linkplain ModelElement}.
 * 
 * <h3>Attributes</h3>
 * None.
 * 
 * <h3>References</h3>
 * <b>contents:</b> identifies the set of elements that the namespace object contains.<br>
 * 
 * <h3>Operations</h3>
 * <b>lookupElement:</b> searches for a specified element within its contained 
 * elements.<br>
 * <b>resolveQualifiedName:</b> searches for a specified (fully qualified) element 
 * within its contained elements.<br>
 * <b>nameIsValid:</b> checks whether the given name can be used within the namespace.<br>
 * <b>findElementByType:</b> returns all elements identified by type, contained 
 * within the namespace.<br>
 * 
 * <h3>Constraints</h3>
 * C-5.
 *
 */
public interface Namespace extends ModelElement {

  /**
   * Searches for a specified element within its contained elements.
   * 
   * <p>Searches for an element contained by this Namespace whose <b>name</b> is 
   * precisely equal (as a wide string) to the supplied name. The operation 
   * either returns a ModelElement that satisfies the above, or raises the 
   * NameNotFound exception.
   * 
   * <pre>
   * context Namespace::lookupElement(name : string) : ModelElement
   * post: result =
   *     let elems = self.contents -> select(m | m.name = name) in
   *         if elems -> size = 0
   *         then
   *             -- Raise exception NameNotFound
   *         else
   *             elems -> first -- should only be one
   *         endif
   * </pre>
   *
   * @param name in String
   * @return ModelElement
   * @throws NameNotFoundException NameNotFound
   */
  public ModelElement lookupElement(String name) throws NameNotFoundException;

  /**
   * Searches for a specified (fully qualified) element  within its contained 
   * elements.
   * 
   * <p>Searches for a ModelElement contained within this Namespace that is identified
   * by the supplied qualifiedName. The qualifiedName is interpreted as a "path" 
   * starting from this Namespace.
   * 
   * <pre>
   * context Namespace::resolveQualifiedName(
   *                qualifiedName : Sequence(string)) : ModelElement
   * pre: qualifiedName -> size >= 1
   * post: result =
   *     let elems = self.contents ->
   *           select(m | m.name = qualifiedName -> first) in
   *    if elems -> size = 0
   *    then
   *        -- Raise exception NameNotResolved ...
   *    else
   *        if qualifiedName -> size = 1
   *        then
   *            elems -> first -- there should only be one
   *        else
   *            if not elems -> first -> oclIsOfKind(Namespace)
   *            then
   *                -- Raise exception NameNotResolved ...
   *            else
   *                let rest = qualifiedName ->
   *                    subSequence(2, qualifiedName -> size) in
   *                elems -> first -> resolveQualifiedName(rest)
   *            endif
   *        endif
   *    endif
   * </pre>
   * 
   *
   * @param qualifiedName in String (multiplicity one or more; ordered; not unique)
   * @return ModelElement (exactly one). If no element is found, an exception is 
   *         raised.
   * @throws NameNotResolvedException NameNotResolved
   */
  public ModelElement resolveQualifiedName(List<String> qualifiedName)
      throws NameNotResolvedException;

  /**
   * Returns all elements identified by type, contained within the namespace.
   * 
   * <p>Returns a list of the ModelElements contained by this Namespace that 
   * match the Class supplied. If <b>includeSubtypes</b> is false, this operation 
   * returns only those elements whose most-derived Class is <b>ofType</b>. If 
   * <b>includeSubtypes</b> is true, the operation also returns instances of 
   * subtypes of <b>ofType</b>. The order of the elements in the returned list 
   * is the same as their order in the Namespace.
   * 
   * <p>For example, "findElementsByType(ModelElement, false)" always returns an 
   * empty list, since ModelElement is an abstract Class. On the other hand, 
   * "findElementsByType(ModelElement, true)" always returns the contents of the 
   * Namespace, since all their Classes are subtypes of ModelElement.
   * 
   * <pre>
   * context Namespace::findElementsByType(
   *               ofType : Class,
   *               includeSubtypes : boolean) : Sequence(ModelElement)
   * post: result =
   *     if includeSubtypes
   *     then
   *         self.contents -> select(m | m.oclIsOfKind(ofType))
   *     else
   *         self.contents -> select(m | m.oclIsOfType(ofType))
   *     endif
   * </pre>
   *
   * @param ofType in Class
   * @param includeSubtypes in Boolean
   * @return ModelElement (multiplicity zero or more; ordered; unique)
   */
  public List<?> findElementsByType(MofClass ofType, boolean includeSubtypes);

  /**
   * Checks whether the given name can be used within the namespace.
   * 
   * <p>Determines whether the <b>proposedName</b> can be used as the name for a new 
   * member ModelElement in this Namespace. Specifically, it checks that the 
   * Namespace uniqueness rules would still be satisfied after adding such a name.
   * 
   * <pre>
   * context Namespace::nameIsValid( proposedName : string) : boolean
   * post: result =
   *     self.extendedNamespace -> forAll(e | not e.name = proposedName)
   * </pre>
   *
   * @param proposedName in String
   * @return Boolean
   */
  public boolean nameIsValid(String proposedName);

  /**
   * Identifies the set of elements that the namespace object contains.
   * 
   *
   * @return ModelElement (zero or more; ordered) 
   * @see Contains#getContainedElement(Namespace)
   */
  public List<ModelElement> getContents();
}
