package roth.lang.reflect;

import roth.lang.code.dev.JavaUtil;

public class TypeVariable extends Reflect
{
	protected final String name;
	protected final Declaration[] extendsDeclarations;
	
	public TypeVariable(java.lang.reflect.TypeVariable<?> javaTypeVariable)
	{
		name = JavaUtil.getName(javaTypeVariable);
		extendsDeclarations = JavaUtil.getExtendsDeclarations(javaTypeVariable);
	}
	
}
