package roth.lang.reflect;

import roth.lang.code.dev.JavaUtil;

public class AnnotationDeclaration extends Reflect
{
	protected final String name;
	protected final Attribute[] attributes;
	
	public AnnotationDeclaration(java.lang.annotation.Annotation javaAnnotation)
	{
		name = JavaUtil.getName(javaAnnotation);
		attributes = JavaUtil.getAttributes(javaAnnotation);
	}
	
}
