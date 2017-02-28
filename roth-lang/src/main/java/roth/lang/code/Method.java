package roth.lang.code;

import roth.lang.Set;

public class Method extends Code
{
	protected Set<AnnotationDeclaration> annotationDeclarations = new Set<>();
	protected AccessType accessType;
	protected boolean _static;
	protected boolean _final;
	protected boolean _abstract;
	protected boolean _synchronized;
	protected boolean _native;
	protected Set<TypeVariable> typeVariables = new Set<>();
	protected TypeDeclaration returnTypeDeclaration;
	protected String name;
	protected Set<Parameter> parameters = new Set<>(); 
	protected Set<String> throwsNames = new Set<>();
	
}
