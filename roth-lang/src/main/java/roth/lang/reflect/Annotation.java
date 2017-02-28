package roth.lang.reflect;

import roth.lang.code.dev.JavaUtil;

public class Annotation extends Type
{
	protected final Constant[] constants;
	protected final StaticField[] staticFields;
	protected final AttributeMethod[] attributeMethods;
	
	public Annotation(java.lang.Class<?> javaClass)
	{
		super(javaClass);
		constants = JavaUtil.getConstants(javaClass);
		staticFields = JavaUtil.getStaticFields(javaClass);
		attributeMethods = JavaUtil.getAttributeMethods(javaClass);
	}
	
}
