package roth.lang.code;

import roth.lang.List;
import roth.lang.Set;

public abstract class Type extends Code
{
	protected int hashCode;
	protected String _package;
	protected List<String> enclosures = new List<>();
	protected List<Import> imports = new List<>();
	protected Set<AnnotationDeclaration> annotationDeclarations = new Set<>();
	protected AccessType accessType;
	protected boolean _static;
	protected boolean member;
	protected String name;
	
}
