package javax.jmi.model;


/**
 * An <tt>Import</tt> allows a package to reference model elements defined in 
 * some other package.
 * 
 * <p><b>Abstract</b><br>
 * No.
 * 
 * <p><b>Super classes</b><br>
 * ModelElement.
 * 
 * <p><b>Attributes</b><br>
 * <b>visibility:</b> this attribute is reserved for future use.<br>
 * <b>isClustered:</b> specifies whether the import represents simple package importation, or package clustering.<br>
 * 
 * <p><b>References</b><br>
 * <b>importedNamespace:</b> returns the namespece object that it references.<br>
 * 
 * <p><b>Operations</b><br>
 * None.
 * 
 * <p><b>MOF Constraints</b><br>
 * C-45, C-46, C-47, C-48, and C-49.
 *
 */
public interface Import extends ModelElement {
    public VisibilityKind getVisibility();
    public void setVisibility(VisibilityKind newValue);
    public boolean isClustered();
    public void setClustered(boolean newValue);
    public Namespace getImportedNamespace();
    public void setImportedNamespace(Namespace newValue);
}
