package javax.jmi.model;

/**
 * A <tt>Constraint</tt> defines a rule that restricts the state or behavior of 
 * one or more elements.
 * 
 * <p><b>Abstract</b><br>
 * No.
 * 
 * <p><b>Super classes</b><br>
 * ModelElement.
 * 
 * <p><b>Attributes</b><br>
 * <b>expression:</b> an expression that represents the constraint.<br>
 * <b>language:</b> the used to express the constraint.<br>
 * <b>evaluationPolicy:</b> the evaluation policy for the constraint.<br>
 * 
 * <p><b>References</b><br>
 * <b>constrainedElements:</b> the elements that the constraint applies to.<br>
 * 
 * <p><b>Operations</b><br>
 * None.
 * 
 * <p><b>MOF Constraints</b><br>
 * C-50, C-51.
 */
public interface Constraint extends ModelElement {
    public String getExpression();
    public void setExpression(String newValue);
    public String getLanguage();
    public void setLanguage(String newValue);
    public EvaluationKind getEvaluationPolicy();
    public void setEvaluationPolicy(EvaluationKind newValue);
    public java.util.Collection<?> getConstrainedElements();
}
