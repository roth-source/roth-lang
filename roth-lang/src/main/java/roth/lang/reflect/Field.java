package roth.lang.reflect;

import roth.lang.code.dev.JavaUtil;

public abstract class Field extends Reflect
{
	protected final AnnotationDeclaration[] annotationDeclarations;
	protected final AccessType accessType;
	protected final boolean _static;
	protected final boolean _volatile;
	protected final boolean _transient;
	protected final boolean _final;
	protected final Declaration declaration;
	protected final String name;
	
	public Field(java.lang.reflect.Field javaField)
	{
		annotationDeclarations = JavaUtil.getAnnotationDeclarations(javaField);
		accessType = JavaUtil.getAccessType(javaField);
		_static = JavaUtil.isStatic(javaField);
		_volatile = JavaUtil.isVolatile(javaField);
		_transient = JavaUtil.isTransient(javaField);
		_final = JavaUtil.isFinal(javaField);
		declaration = JavaUtil.getDeclaration(javaField);
		name = JavaUtil.getName(javaField);
	}
	
}
