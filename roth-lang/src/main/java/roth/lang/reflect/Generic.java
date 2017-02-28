package roth.lang.reflect;

public abstract class Generic extends Reflect
{
	
	public Generic()
	{
		
	}
	
	public static Generic get(java.lang.reflect.Type javaType)
	{
		Generic generic = null;
		if(javaType instanceof java.lang.reflect.WildcardType)
		{
			generic = new Wildcard((java.lang.reflect.WildcardType) javaType);
		}
		else
		{
			generic = Declaration.get(javaType);
		}
		return generic;
	}
	
}
