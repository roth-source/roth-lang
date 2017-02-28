package roth.lang.reflect;

import roth.lang.code.dev.JavaUtil;

public abstract class Method extends Reflect
{
	protected final AnnotationDeclaration[] annotationDeclarations;
	protected final AccessType accessType;
	protected final boolean _static;
	protected final boolean _final;
	protected final boolean _abstract;
	protected final boolean _synchronized;
	protected final boolean _native;
	protected final TypeVariable[] typeVariables;
	protected final Declaration returnDeclaration;
	protected final String name;
	protected final Parameter[] parameters;
	protected final String[] throwsNames;
	
	public Method(java.lang.reflect.Method javaMethod)
	{
		annotationDeclarations = JavaUtil.getAnnotationDeclarations(javaMethod);
		accessType = JavaUtil.getAccessType(javaMethod);
		_static = JavaUtil.isStatic(javaMethod);
		_final = JavaUtil.isFinal(javaMethod);
		_abstract = JavaUtil.isAbstract(javaMethod);
		_synchronized = JavaUtil.isSynchronized(javaMethod);
		_native = JavaUtil.isNative(javaMethod);
		typeVariables = JavaUtil.getTypeVariables(javaMethod);
		returnDeclaration = JavaUtil.getReturnDeclaration(javaMethod);
		name = JavaUtil.getName(javaMethod);
		parameters = JavaUtil.getParameters(javaMethod);
		throwsNames = JavaUtil.getThrowsNames(javaMethod);
	}
	
}
