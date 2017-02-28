package roth.lang.reflect;

import roth.lang.code.dev.JavaUtil;

public class Attribute extends Reflect
{
	protected final String name;
	protected final Object value;
	
	public Attribute(java.lang.reflect.Method javaMethod, Object value)
	{
		name = JavaUtil.getName(javaMethod);
		this.value = value;
	}
	
}
