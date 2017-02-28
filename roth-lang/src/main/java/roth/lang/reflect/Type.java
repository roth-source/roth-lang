package roth.lang.reflect;

import roth.lang.code.dev.JavaUtil;

public class Type extends Reflect
{
	protected final int hashCode;
	protected final String _package;
	protected final String[] enclosures;
	protected final AnnotationDeclaration[] annotationDeclarations;
	protected final AccessType accessType;
	protected final boolean _static;
	protected final boolean member;
	protected final String name;
	
	public Type(java.lang.Class<?> javaClass)
	{
		hashCode = JavaUtil.getHashCode(javaClass);
		_package = JavaUtil.getPackage(javaClass);
		enclosures = JavaUtil.getEnclosures(javaClass);
		annotationDeclarations = JavaUtil.getAnnotationDeclarations(javaClass);
		accessType = JavaUtil.getAccessType(javaClass);
		_static = JavaUtil.isStatic(javaClass);
		member = JavaUtil.isMember(javaClass);
		name = JavaUtil.getName(javaClass);
	}
	
	public static Type get(java.lang.Class<?> javaClass)
	{
		Type type = null;
		if(JavaUtil.isAnnotation(javaClass))
		{
			type = new Annotation(javaClass);
		}
		else if(JavaUtil.isEnum(javaClass))
		{
			type = new Enum(javaClass);
		}
		else if(JavaUtil.isInterface(javaClass))
		{
			type = new Interface(javaClass);
		}
		else if(JavaUtil.isClass(javaClass))
		{
			type = new Class(javaClass);
		}
		return type;
	}
	
}
