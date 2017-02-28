package roth.lang.reflect;

import roth.lang.code.dev.JavaUtil;

public class TypeVariableDeclaration extends Declaration
{
	protected final String name;
	
	public TypeVariableDeclaration(java.lang.reflect.TypeVariable<?> javaTypeVariable, int dimensions)
	{
		super(dimensions);
		name = JavaUtil.getName(javaTypeVariable);
	}
	
}
