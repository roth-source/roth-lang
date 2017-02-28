package roth.lang.code;

import roth.lang.List;

public class Class extends Type
{
	protected boolean _abstract;
	protected List<Constant> constants = new List<>();
	protected List<Field> staticFields = new List<>();
	protected List<Initializer> staticInitializers = new List<>();
	protected List<Method> staticMethods = new List<>();
	protected List<Type> staticTypes = new List<>();
	protected List<Field> memberFields = new List<>();
	protected List<Initializer> memberInitializers = new List<>();
	protected List<Constructor> constructors = new List<>();
	protected List<Method> memberMethods = new List<>();
	protected List<Type> memberTypes = new List<>();
	
}
