package roth.lang.reflect;

import roth.lang.code.dev.JavaUtil;

public class TypeDeclaration extends Declaration
{
	protected final String name;
	protected final Generic[] generics;
	
	public TypeDeclaration(java.lang.Class<?> javaClass, int dimensions)
	{
		super(dimensions);
		name = JavaUtil.getCanonicalName(javaClass);
		generics = JavaUtil.getGenerics(javaClass);
	}
	
	public TypeDeclaration(java.lang.reflect.ParameterizedType javaParameterizedType, int dimensions)
	{
		super(dimensions);
		name = JavaUtil.getCanonicalName(javaParameterizedType);
		generics = JavaUtil.getGenerics(javaParameterizedType);
	}
	
	public static TypeDeclaration get(java.lang.reflect.Type javaType)
	{
		return get(javaType, 0);
	}
	
	public static TypeDeclaration get(java.lang.reflect.Type javaType, int dimensions)
	{
		TypeDeclaration typeDeclaration = null;
		if(javaType instanceof java.lang.Class && !java.lang.Object.class.equals(javaType))
		{
			java.lang.Class<?> javaClass = ((java.lang.Class<?>) javaType);
			while(JavaUtil.isArray(javaClass))
			{
				javaClass = javaClass.getComponentType();
				dimensions++;
			}
			typeDeclaration = new TypeDeclaration(javaClass, dimensions);
		}
		else if(javaType instanceof java.lang.reflect.ParameterizedType)
		{
			typeDeclaration = new TypeDeclaration((java.lang.reflect.ParameterizedType) javaType, dimensions);
		}
		return typeDeclaration;
	}
	
}
