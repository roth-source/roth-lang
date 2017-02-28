package roth.lang.reflect;

public abstract class Declaration extends Generic
{
	protected final int dimensions;
	
	public Declaration(int dimensions)
	{
		this.dimensions = dimensions;
	}
	
	public static Declaration get(java.lang.reflect.Type type)
	{
		return get(type, 0);
	}
	
	public static Declaration get(java.lang.reflect.Type javaType, int dimensions)
	{
		Declaration declaration = null;
		if(javaType instanceof java.lang.Class || javaType instanceof java.lang.reflect.ParameterizedType)
		{
			declaration = TypeDeclaration.get(javaType, dimensions);
		}
		else if(javaType instanceof java.lang.reflect.GenericArrayType)
		{
			declaration = get(((java.lang.reflect.GenericArrayType) javaType).getGenericComponentType(), ++dimensions);
		}
		else if(javaType instanceof java.lang.reflect.TypeVariable)
		{
			declaration = new TypeVariableDeclaration((java.lang.reflect.TypeVariable<?>) javaType, dimensions);
		}
		return declaration;
	}
	
}
