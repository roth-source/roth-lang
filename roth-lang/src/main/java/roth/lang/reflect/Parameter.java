package roth.lang.reflect;

import roth.lang.code.dev.JavaUtil;

public class Parameter extends Reflect
{
	protected final AnnotationDeclaration[] annotationDeclarations;
	protected final boolean varArgs;
	protected final boolean _final;
	protected final Declaration declaration;
	protected final String name;
	
	public Parameter(java.lang.reflect.Parameter javaParameter)
	{
		annotationDeclarations = JavaUtil.getAnnotationDeclarations(javaParameter);
		varArgs = JavaUtil.isVarArgs(javaParameter);
		_final = JavaUtil.isFinal(javaParameter);
		declaration = JavaUtil.getDeclaration(javaParameter);
		name = JavaUtil.getName(javaParameter);
	}
	
}
