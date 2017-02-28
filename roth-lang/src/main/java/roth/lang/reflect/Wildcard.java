package roth.lang.reflect;

import roth.lang.code.dev.JavaUtil;

public class Wildcard extends Generic
{
	protected final Declaration[] extendsDeclarations;
	protected final Declaration[] superDeclarations;
	
	public Wildcard(java.lang.reflect.WildcardType javaWildcardType)
	{
		extendsDeclarations = JavaUtil.getExtendsDeclarations(javaWildcardType);
		superDeclarations = JavaUtil.getSuperDeclarations(javaWildcardType);
	}
	
}
