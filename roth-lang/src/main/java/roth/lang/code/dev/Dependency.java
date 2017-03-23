package roth.lang.code.dev;

import java.io.File;

import roth.lang.Map;
import roth.lang.Set;
import roth.lang.reflect.Type;

public class Dependency
{
	protected int hashCode;
	protected String name;
	protected Map<String, Type> typeMap = new Map<>();
	
	public Dependency(File jarFile, Set<Class<?>> classes)
	{
		this.hashCode = jarFile.hashCode();
		this.name = jarFile.getName();
		this.typeMap = JavaUtil.getTypeMap(classes);
	}
	
	public int getHashCode()
	{
		return hashCode;
	}
	
	
	
}
