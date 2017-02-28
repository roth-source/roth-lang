package roth.lang.code;

import roth.lang.Set;

public class Field extends Variable
{
	protected Set<AnnotationDeclaration> annotationDeclarations = new Set<>();
	protected AccessType accessType;
	protected boolean _static;
	protected boolean _volatile;
	protected boolean _transient;
	
}
