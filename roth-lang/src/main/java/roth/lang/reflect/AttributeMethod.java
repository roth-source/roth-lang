package roth.lang.reflect;

import roth.lang.code.dev.JavaUtil;

public class AttributeMethod extends Method
{
	protected final Object _default;
	
	public AttributeMethod(java.lang.reflect.Method javaMethod)
	{
		super(javaMethod);
		_default = JavaUtil.getDefaultValue(javaMethod);
	}
	
}
