package roth.lang.reflect;

import roth.lang.code.dev.JavaUtil;

public class Interface extends Type
{
	protected final TypeVariable[] typeVariables;
	protected final Constant[] constants;
	protected final StaticMethod[] staticMethods;
	protected final MemberMethod[] memberMethods;
	
	public Interface(java.lang.Class<?> javaClass)
	{
		super(javaClass);
		typeVariables = JavaUtil.getTypeVariables(javaClass);
		constants = JavaUtil.getConstants(javaClass);
		staticMethods = JavaUtil.getStaticMethods(javaClass);
		memberMethods = JavaUtil.getMemberMethods(javaClass);
	}
	
}
