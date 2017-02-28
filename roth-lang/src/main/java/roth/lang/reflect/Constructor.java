package roth.lang.reflect;

import roth.lang.code.dev.JavaUtil;

public class Constructor extends Reflect
{
	protected final AccessType accessType;
	protected final Parameter[] parameters;
	
	public Constructor(java.lang.reflect.Constructor<?> javaConstructor)
	{
		accessType = JavaUtil.getAccessType(javaConstructor);
		parameters = JavaUtil.getParameters(javaConstructor);
	}
	
}
