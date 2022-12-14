package javax.jmi.model;

import javax.jmi.reflect.*;

public class NameNotFoundException extends RefException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final String name;
    public NameNotFoundException(String name) {
        super("name: " + name);
        this.name = name;
    }
    public String getName() {
        return name;
    }
}
