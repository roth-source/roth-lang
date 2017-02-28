package roth.lang.code;

import roth.lang.Set;

public class Constant extends Code
{
	protected Set<AnnotationDeclaration> annotationDeclarations = new Set<>();
	protected AccessType accessType;
	protected boolean _volatile;
	protected boolean _transient;
	protected Declaration declaration;
	protected String name;
	protected Object value;
	
}
