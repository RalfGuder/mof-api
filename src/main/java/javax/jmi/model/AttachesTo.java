package javax.jmi.model;

import javax.jmi.reflect.RefAssociation;

/**
 * The <tt>AttachesTo</tt> association associates tags with model elements.
 * end1: modelElement Identifies the model element that the tag is attached to.
 * end1Class: ModelElement
 * multiplicity: one or more
 * end2: tag Identifies the tags attached to a model element.
 * end2Class: Tag
 * multiplicity: zero or more
 *
 */
public interface AttachesTo extends RefAssociation {
  public boolean exists(ModelElement modelElement, Tag tag);

  /**
   * Identifies the model element that the <b>tag</b> is attached to.
   *
   * @param tag Tag
   * @return One or more (unordered) ModelElements.
   */
  public java.util.Collection<ModelElement> getModelElement(Tag tag);

  /**
   * Identifies the tags attached to a model element.
   *
   * @param modelElement ModelElement
   * @return Zero or more (ordered) Tags
   */
  public java.util.List<Tag> getTag(ModelElement modelElement);

  public boolean add(ModelElement modelElement, Tag tag);

  public boolean remove(ModelElement modelElement, Tag tag);
}
