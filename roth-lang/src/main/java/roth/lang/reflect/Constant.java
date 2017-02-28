package roth.lang.reflect;

import roth.lang.code.dev.JavaUtil;

public class Constant extends Reflect
{
	protected final AnnotationDeclaration[] annotationDeclarations;
	protected final AccessType accessType;
	protected final boolean _volatile;
	protected final boolean _transient;
	protected final Declaration declaration;
	protected final String name;
	protected final Object value;
	
	public Constant(java.lang.reflect.Field javaField)
	{
		annotationDeclarations = JavaUtil.getAnnotationDeclarations(javaField);
		accessType = JavaUtil.getAccessType(javaField);
		_volatile = JavaUtil.isVolatile(javaField);
		_transient = JavaUtil.isTransient(javaField);
		declaration = JavaUtil.getDeclaration(javaField);
		name = JavaUtil.getName(javaField);
		value = JavaUtil.getValue(javaField);
	}
	
}
