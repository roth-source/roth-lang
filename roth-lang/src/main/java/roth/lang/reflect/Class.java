package roth.lang.reflect;

import roth.lang.code.dev.JavaUtil;

public class Class extends Type
{
	protected final boolean _abstract;
	protected final TypeVariable[] typeVariables;
	protected final Constant[] constants;
	protected final StaticField[] staticFields;
	protected final MemberField[] memberFields;
	protected final StaticMethod[] staticMethods;
	protected final MemberMethod[] memberMethods;
	protected final Constructor[] constructors;
	
	public Class(java.lang.Class<?> javaClass)
	{
		super(javaClass);
		_abstract = JavaUtil.isAbstract(javaClass);
		typeVariables = JavaUtil.getTypeVariables(javaClass);
		constants = JavaUtil.getConstants(javaClass);
		staticFields = JavaUtil.getStaticFields(javaClass);
		memberFields = JavaUtil.getMemberFields(javaClass);
		staticMethods = JavaUtil.getStaticMethods(javaClass);
		memberMethods = JavaUtil.getMemberMethods(javaClass);
		constructors = JavaUtil.getConstructors(javaClass);
	}
	
}
