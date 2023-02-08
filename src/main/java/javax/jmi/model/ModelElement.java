package javax.jmi.model;

import java.util.Collection;
import java.util.List;
import javax.jmi.reflect.RefObject;

/**
 * <tt>ModelElement</tt> is the root of all MOF elements. It represents the 
 * elementary constructs of model elements.
 * 
 * <h3>Abstract</h3> 
 * Yes.
 *
 * <h3>Super classes</h3>
 * None. (While the CORBA IDL for ModelElement inherits from Reflective::RefObject, 
 * this is <i>not generalization</i> in the MOF Model sense. Rather it is an artifact 
 * of the IDL mapping.)
 *
 * <h3>Attributes</h3>
 * <b>name:</b> unique name supplied by meta-modeler.<br>
 * <b>annotation:</b> description of the model element.<br>
 * <b>qualifiedName:</b> fully qualified name within the context of its outermost 
 * package extent.<br>
 *
 * <h3>References</h3> 
 * <b>container:</b> identifies the Namespace element that contains this element.<br>
 * <b>requiredElements:</b> identifies the ModelElements whose definition this 
 * object depends on.<br>
 * <b>constraints:</b> identifies the set of Constraint objects that apply to this object.<br>
 * 
 * <h3>Operations</h3>
 * <b>isFrozen:</b> reports whether the object is mutable.<br>
 * <b>isVisible:</b> this operation is reserved for future use.<br>
 * <b>isRequiredBecause:</b> checks whether the object depends on another object, 
 * and if so, returns the type of dependency.<br>
 * 
 * <h3>Constraints</h3>
 * <b>[C-1] - MustBeContainedUnlessPackage</b><br> 
 * A ModelElement that is not a Package must have a container.
 * <pre>
 * context ModelElement
 * inv:
 *     not self.oclIsTypeOf(Package) implies 
 *         self.container -&gt; size = 1
 * </pre>
 * 
 * <b>[C-2] FrozenAttributesCannotBeChanged</b><br>
 * The attribute values of a ModelElement which is frozen cannot be changed.
 * <pre>
 * context ModelElement
 * inv:
 *     self.isFrozen() implies
 *         let myTypes = self.oclType() -&gt; allSupertypes() -&gt; 
 *             includes(self.oclType()) in
 *         let myAttrs : Set(Attribute) = 
 *             self.RefBaseObject::refMetaObject() -&gt; 
 *                 asOclType(Class) -&gt; 
 *                 findElementsByTypeExtended(Attribute) in
 *         myAttrs -&gt; forAll(a | 
 *                        self.RefObject::refValue@pre(a) = 
 *                            self.RefObject::refValue(a))
 * </pre>
 * 
 * <b>[C-3] FrozenElementsCannotBeDeleted</b><br>
 * A frozen ModelElement which is in a frozen Namespace can only be deleted, by 
 * deleting the Namespace.
 * <pre>
 * context ModelElement
 * post:
 *     (self.isFrozen@pre() and self.container@pre -&gt; notEmpty and 
 *      self.container.isFrozen@pre()) implies
 *     (self.container.Object::non_existent() or not self.Object::non_existent())
 * </pre>
 * <b>[C-4] FrozenDependenciesCannotBeChanged</b><br>
 * The link sets that express dependencies of a frozen Element on other Elements 
 * cannot be explicitly changed.
 * <pre>
 * context ModelElement
 * post:
 *     self.isFrozen() implies
 *         let myClasses = self.oclType() -&gt; allSupertypes() -&gt; 
 *             includes(self.oclType()) in
 *         let myRefs = Set(Reference) = 
 *             self.RefBaseObject::refMetaObject() -&gt; 
 *                 asOclType(Class) -&gt;
 *                 findElementsByTypeExtended(Reference) in
 *         let myDepRefs = myRefs -&gt; 
 *             select(r | 
 *                    Set{"contents", "constraints", "supertypes", 
 *                        "type", "referencedEnd", "exceptions", 
 *                        "importedNamespace", "elements"} -&gt;
 *                    includes(r.name)) in
 *         myDepRefs -&gt;
 *             forAll(r |
 *                    self.RefObject::refValue@pre(r) =
 *                        self.RefObject::refValue(r))
 * </pre>
 * 
 */
public interface ModelElement extends RefObject {
  public String CONTAINERDEP = "container";
  public String CONTENTSDEP = "contents";
  public String SIGNATUREDEP = "signature";
  public String CONSTRAINTDEP = "constraint";
  public String CONSTRAINEDELEMENTSDEP = "constrained elements";
  public String SPECIALIZATIONDEP = "specialization";
  public String IMPORTDEP = "import";
  public String TYPEDEFINITIONDEP = "type definition";
  public String REFERENCEDENDSDEP = "referenced ends";
  public String TAGGEDELEMENTSDEP = "tagged elements";
  public String INDIRECTDEP = "indirect";
  public String ALLDEP = "all";

  /**
   * Selects a subset of a ModelElement's immediate or recursive dependents.
   * 
   * <p>This operation selects a subset of the ModelElements that this one depends 
   * on, based on their dependency categories. The <b>kinds</b> argument gives 
   * the kinds of dependency of interest to the caller.
   * 
   * <p>String constants for the standard dependency categories are given in 
   * Section 3.8, "MOF Model Constants", on page 3-82 and their meanings are 
   * defined in Section 3.5.9, "DependsOn", on page 3-75. In this context, the 
   * AllDep pseudocategory (i.e., "all") is equivalent to passing all of the 
   * standard categories, and the IndirectDep pseudo-category (i.e., "indirect") 
   * is ignored.
   * 
   * <p>If the "recursive" argument is "false", the operation return the direct 
   * dependents only. If it is "true", all dependents in the transitive closure 
   * of {@linkplain DependsOn} for the specified "kinds" are returned.
   * 
   * <pre>
   * context ModelElement::isRequiredBecause( 
   *                kinds : Sequence(DependencyKind),
   *                recursive : boolean) : Sequence(ModelElement)
   * post: result =
   *     if kinds -&gt; includes("all")
   *     then
   *         self.findRequiredElements(
   *             Set{"constraint", "container", "constrained elements",
   *                 "specialization", "import", "contents", "signature",
   *                 "tagged elements", "type definition", "referenced ends"})
   *     else
   *         if recursive
   *         then 
   *             self.recursiveFindDeps(kinds, Set{self})
   *         else
   *             kinds -&gt; collect(k : self.findDepsOfKind(k)) -&gt; asSet()
   *         endif
   *     endif
   * </pre>
   *
   * @param kinds in String (multiplicity: one or more; unordered; unique)
   * @param recursive in Boolean
   * @return ModelElement (multiplicity: zero or more; unordered, unique)
   */
  public Collection<ModelElement> findRequiredElements(Collection<String> kinds,
      boolean recursive);

  /**
   * Checks whether the object depends on another object, and if so, returns 
   * the type of dependency.
   * 
   * <p>This operation performs two functions:
   * <ul>
   * <li>It checks whether this ModelElement directly or indirectly depends on 
   * the ModelElement given by <b>otherElement</b>. If it does, the operation's 
   * result is <tt>true</tt>; otherwise, it is <tt>false</tt>.
   * <li>If a dependency exists; that is, the result is <tt>true</tt>, the operation 
   * returns a String in <b>reason</b> that categorizes the dependency. String 
   * constants for the dependency kind categories are given in Section 3.8, "MOF 
   * Model Constants", on page 3-82 and their meanings are defined in Section 3.5.9, 
   * "DependsOn", on page 3-75. If the dependency is indirect, IndirectDep is 
   * returned. If there are multiple dependencies, any category that applies may 
   * be returned in <b>reason</b>. If no dependencies exist, an empty string is 
   * returned in <b>reason</b>.
   * </ul>
   *
   * @param otherElement in ModelElement
   * @param reason out String
   * @return Boolean
   */
  public boolean isRequiredBecause(ModelElement otherElement, String[] reason);

  /**
   * Reports whether the object is mutable.
   * 
   * <p>Reports the freeze status of a ModelElement. A ModelElement, at any 
   * particular time, is either frozen or not frozen. All ModelElements of a 
   * published model are permanently frozen.
   *
   * @return Boolean
   */
  public boolean isFrozen();

  /**
   * This operation is reserved for future use.
   * 
   * <p>Returns <tt>true</tt>. This operation is reserved for future use when the 
   * MOF visibility rules have stabilized. Then it will determine whether the 
   * supplied otherElement is visible to this ModelElement.
   *
   * @param otherElement in ModelElement
   * @return Boolean
   */
  public boolean isVisible(ModelElement otherElement);

  /**
   * Unique name supplied by meta-modeler.
   * 
   * <p>Provides a meta-modeler supplied name that uniquely identifies the 
   * ModelElement in the context of the ModelElement's containing Namespace. When 
   * choosing a ModelElement's name, the meta-modeler should consider the rules 
   * for translating names into identifiers in the relevant mappings. To minimize 
   * portability problems, use names that start with an ASCII letter, and consist 
   * of ASCII letters and digits, space and underscore. Avoid names where 
   * capitalization, spaces, or underscores are significant.
   *
   * @return Exactly one String.
   */
  public String getName();

  public void setName(String newValue);

  /**
   * Fully qualified name within the context of its outermost package extent.
   * 
   * <p>Provides a unique name for the ModelElement within the context of its 
   * outermost containing Package. The qualifiedName is a list of String values 
   * consisting of the names of the ModelElement, its container, its container's 
   * container and so on until a non-contained element is reached. The first 
   * member of the list is the name of the non-contained element.
   *
   * @return one or more; ordered; non-unique String
   */
  public List<String> getQualifiedName();

  /**
   * Description of the model element.
   * 
   * <p>Provides an informal description of the ModelElement.
   *
   * @return exactly one String
   */
  public String getAnnotation();

  public void setAnnotation(String newValue);

  /**
   * Identifies the ModelElements whose definition this object depends on.
   * 
   * <p>Identifies the ModelElements on whose definition the definition of this 
   * ModelElement depends.
   *
   * @return zero or more ModelElement.
   * @see DependsOn#getProvider(ModelElement)
   */
  public Collection<ModelElement> getRequiredElements();

  /**
   * Identifies the Namespace element that contains this element.
   * 
   * <p>Identifies the Namespace that contains the ModelElement. Since the 
   * Contains Association is a Composite Association, any ModelElement can have 
   * at most one container, and the containment graph is strictly tree shaped.
   *
   * @return zero or one Namespace
   */
  public Namespace getContainer();

  public void setContainer(Namespace newValue);

  /**
   * Identifies the set of Constraint objects that apply to this object.
   * 
   * <p>Identifies the set of Constraints that apply to the ModelElement. 
   * A Constraint applies to all instances of the ModelElement and its 
   * sub-Classes.
   *
   * @return zero or more Constraint
   * @see Constraint#getConstrainedElements()
   * @see Constrains#getConstraint(ModelElement)
   */
  public Collection<Constraint> getConstraints();
}
