package roth.lang.code.dev;

import java.lang.reflect.Modifier;
import java.util.Objects;

import roth.lang.List;
import roth.lang.Map;
import roth.lang.Set;
import roth.lang.reflect.AccessType;
import roth.lang.reflect.AnnotationDeclaration;
import roth.lang.reflect.Attribute;
import roth.lang.reflect.AttributeMethod;
import roth.lang.reflect.Constant;
import roth.lang.reflect.Constructor;
import roth.lang.reflect.Declaration;
import roth.lang.reflect.Generic;
import roth.lang.reflect.MemberField;
import roth.lang.reflect.MemberMethod;
import roth.lang.reflect.Parameter;
import roth.lang.reflect.StaticField;
import roth.lang.reflect.StaticMethod;
import roth.lang.reflect.Type;
import roth.lang.reflect.TypeVariable;

public class JavaUtil
{
	
	protected JavaUtil()
	{
		
	}
	
	public static Map<String, Type> getTypeMap(Set<java.lang.Class<?>> javaClasses)
	{
		Map<String, Type> typeMap = new Map<>();
		for(java.lang.Class<?> javaClass : javaClasses)
		{
			Type type = Type.get(javaClass);
			if(type != null)
			{
				String name = javaClass.getCanonicalName();
				typeMap.put(name, type);
			}
		}
		return typeMap;
	}
	
	public static boolean isAnnotation(java.lang.Class<?> javaClass)
	{
		boolean annotation = false;
		try
		{
			annotation = javaClass.isAnnotation();
		}
		catch(Throwable e)
		{
			
		}
		return annotation;
	}
	
	public static boolean isEnum(java.lang.Class<?> javaClass)
	{
		boolean _enum = false;
		try
		{
			_enum = javaClass.isEnum();
		}
		catch(Throwable e)
		{
			
		}
		return _enum;
	}
	
	public static boolean isInterface(java.lang.Class<?> javaClass)
	{
		boolean _interface = false;
		try
		{
			_interface = javaClass.isInterface();
		}
		catch(Throwable e)
		{
			
		}
		return _interface;
	}
	
	public static boolean isClass(java.lang.Class<?> javaClass)
	{
		boolean _class = false;
		try
		{
			_class = !javaClass.isAnonymousClass() && !javaClass.isLocalClass() && !javaClass.isAnnotation() && !javaClass.isEnum() && !javaClass.isInterface();
		}
		catch(Throwable e)
		{
			
		}
		return _class;
	}
	
	public static boolean isMember(java.lang.Class<?> javaClass)
	{
		boolean member = false;
		try
		{
			member = javaClass.isMemberClass();
		}
		catch(Throwable e)
		{
			
		}
		return member;
	}
	
	public static boolean isArray(java.lang.Class<?> javaClass)
	{
		boolean array = false;
		try
		{
			array = javaClass.isArray();
		}
		catch(Throwable e)
		{
			
		}
		return array;
	}
	
	public static boolean isStatic(java.lang.Class<?> javaClass)
	{
		return isStatic(javaClass.getModifiers());
	}
	
	public static boolean isStatic(java.lang.reflect.Field javaField)
	{
		return isStatic(javaField.getModifiers());
	}
	
	public static boolean isStatic(java.lang.reflect.Method javaMethod)
	{
		return isStatic(javaMethod.getModifiers());
	}
	
	protected static boolean isStatic(int modifiers)
	{
		return Modifier.isStatic(modifiers);
	}
	
	public static boolean isFinal(java.lang.reflect.Parameter javaParameter)
	{
		return isFinal(javaParameter.getModifiers());
	}
	
	public static boolean isFinal(java.lang.reflect.Field javaField)
	{
		return isFinal(javaField.getModifiers());
	}
	
	public static boolean isFinal(java.lang.reflect.Method javaMethod)
	{
		return isFinal(javaMethod.getModifiers());
	}
	
	protected static boolean isFinal(int modifiers)
	{
		return Modifier.isFinal(modifiers);
	}
	
	public static boolean isVolatile(java.lang.reflect.Field javaField)
	{
		return isVolatile(javaField.getModifiers());
	}
	
	protected static boolean isVolatile(int modifiers)
	{
		return Modifier.isVolatile(modifiers);
	}
	
	public static boolean isTransient(java.lang.reflect.Field javaField)
	{
		return isTransient(javaField.getModifiers());
	}
	
	protected static boolean isTransient(int modifiers)
	{
		return Modifier.isTransient(modifiers);
	}
	
	public static boolean isAbstract(java.lang.Class<?> javaClass)
	{
		return isAbstract(javaClass.getModifiers());
	}
	
	public static boolean isAbstract(java.lang.reflect.Method javaMethod)
	{
		return isAbstract(javaMethod.getModifiers());
	}
	
	protected static boolean isAbstract(int modifiers)
	{
		return Modifier.isAbstract(modifiers);
	}
	
	public static boolean isSynchronized(java.lang.reflect.Method javaMethod)
	{
		return isSynchronized(javaMethod.getModifiers());
	}
	
	protected static boolean isSynchronized(int modifiers)
	{
		return Modifier.isSynchronized(modifiers);
	}
	
	public static boolean isNative(java.lang.reflect.Method javaMethod)
	{
		return isNative(javaMethod.getModifiers());
	}
	
	protected static boolean isNative(int modifiers)
	{
		return Modifier.isNative(modifiers);
	}
	
	public static boolean isVarArgs(java.lang.reflect.Parameter javaParameter)
	{
		boolean varArgs = false;
		try
		{
			varArgs = javaParameter.isVarArgs();
		}
		catch(Throwable e)
		{
			
		}
		return varArgs;
	}
	
	public static int getHashCode(java.lang.Class<?> javaClass)
	{
		return javaClass.hashCode();
	}
	
	public static String getPackage(java.lang.Class<?> javaClass)
	{
		return javaClass.getPackage().getName();
	}
	
	public static String[] getEnclosures(java.lang.Class<?> javaClass)
	{
		java.lang.Class<?> enclosingClass = javaClass;
		List<String> enclosures = new List<>();
		while((enclosingClass = enclosingClass.getEnclosingClass()) != null)
		{
			enclosures.addFirst(enclosingClass.getSimpleName());
		}
		return enclosures.toArray(String.class);
	}
	
	public static AnnotationDeclaration[] getAnnotationDeclarations(java.lang.Class<?> javaClass)
	{
		return getAnnotationDeclarations(javaClass.getDeclaredAnnotations());
	}
	
	public static AnnotationDeclaration[] getAnnotationDeclarations(java.lang.reflect.Field javaField)
	{
		return getAnnotationDeclarations(javaField.getDeclaredAnnotations());
	}
	
	public static AnnotationDeclaration[] getAnnotationDeclarations(java.lang.reflect.Method javaMethod)
	{
		return getAnnotationDeclarations(javaMethod.getDeclaredAnnotations());
	}
	
	public static AnnotationDeclaration[] getAnnotationDeclarations(java.lang.reflect.Parameter javaParameter)
	{
		return getAnnotationDeclarations(javaParameter.getDeclaredAnnotations());
	}
	
	protected static AnnotationDeclaration[] getAnnotationDeclarations(java.lang.annotation.Annotation[] javaAnnotations)
	{
		Set<AnnotationDeclaration> annotationDeclarations = new Set<>();
		for(java.lang.annotation.Annotation javaAnnotation : javaAnnotations)
		{
			annotationDeclarations.add(new AnnotationDeclaration(javaAnnotation));
		}
		return annotationDeclarations.toArray(AnnotationDeclaration.class);
	}
	
	public static String getCanonicalName(java.lang.Class<?> javaClass)
	{
		return javaClass.getCanonicalName();
	}
	
	public static String getCanonicalName(java.lang.reflect.ParameterizedType javaParameterizedType)
	{
		return ((java.lang.Class<?>) javaParameterizedType.getRawType()).getCanonicalName();
	}
	
	public static String getName(java.lang.Class<?> javaClass)
	{
		return javaClass.getSimpleName();
	}
	
	public static String getName(java.lang.reflect.Field javaField)
	{
		return javaField.getName();
	}
	
	public static String getName(java.lang.reflect.Method javaMethod)
	{
		return javaMethod.getName();
	}
	
	public static String getName(java.lang.reflect.Parameter javaParameter)
	{
		return javaParameter.getName();
	}
	
	public static String getName(java.lang.reflect.TypeVariable<?> javaTypeVariable)
	{
		return javaTypeVariable.getName();
	}
	
	public static String getName(java.lang.annotation.Annotation javaAnnotation)
	{
		return javaAnnotation.annotationType().getCanonicalName();
	}
	
	public static AccessType getAccessType(java.lang.Class<?> javaClass)
	{
		return getAccessType(javaClass.getModifiers());
	}
	
	public static AccessType getAccessType(java.lang.reflect.Field javaField)
	{
		return getAccessType(javaField.getModifiers());
	}
	
	public static AccessType getAccessType(java.lang.reflect.Method javaMethod)
	{
		return getAccessType(javaMethod.getModifiers());
	}
	
	public static AccessType getAccessType(java.lang.reflect.Constructor<?> javaConstructor)
	{
		return getAccessType(javaConstructor.getModifiers());
	}
	
	protected static AccessType getAccessType(int modifiers)
	{
		AccessType access = AccessType.PACKAGE;
		if(Modifier.isPublic(modifiers))
		{
			access = AccessType.PUBLIC;
		}
		else if(Modifier.isProtected(modifiers))
		{
			access = AccessType.PROTECTED;
		}
		else if(Modifier.isPrivate(modifiers))
		{
			access = AccessType.PRIVATE;
		}
		return access;
	}
	
	public static Constant[] getConstants(java.lang.Class<?> javaClass)
	{
		List<Constant> constants = new List<>();
		for(java.lang.reflect.Field javaField : javaClass.getDeclaredFields())
		{
			if(JavaUtil.isStatic(javaField))
			{
				if(JavaUtil.isFinal(javaField))
				{
					constants.add(new Constant(javaField));
				}
			}
		}
		return constants.toArray(Constant.class);
	}
	
	public static StaticField[] getStaticFields(java.lang.Class<?> javaClass)
	{
		List<StaticField> staticFields = new List<>();
		for(java.lang.reflect.Field javaField : javaClass.getDeclaredFields())
		{
			if(JavaUtil.isStatic(javaField))
			{
				if(!JavaUtil.isFinal(javaField))
				{
					staticFields.add(new StaticField(javaField));
				}
			}
		}
		return staticFields.toArray(StaticField.class);
	}
	
	public static MemberField[] getMemberFields(java.lang.Class<?> javaClass)
	{
		List<MemberField> memberFields = new List<>();
		for(java.lang.reflect.Field javaField : javaClass.getDeclaredFields())
		{
			if(!JavaUtil.isStatic(javaField))
			{
				memberFields.add(new MemberField(javaField));
			}
		}
		return memberFields.toArray(MemberField.class);
	}
	
	public static StaticMethod[] getStaticMethods(java.lang.Class<?> javaClass)
	{
		List<StaticMethod> staticMethods = new List<>();
		for(java.lang.reflect.Method javaMethod : javaClass.getDeclaredMethods())
		{
			if(JavaUtil.isStatic(javaMethod))
			{
				staticMethods.add(new StaticMethod(javaMethod));
			}
		}
		return staticMethods.toArray(StaticMethod.class);
	}
	
	public static MemberMethod[] getMemberMethods(java.lang.Class<?> javaClass)
	{
		List<MemberMethod> memberMethods = new List<>();
		for(java.lang.reflect.Method javaMethod : javaClass.getDeclaredMethods())
		{
			if(!JavaUtil.isStatic(javaMethod))
			{
				memberMethods.add(new MemberMethod(javaMethod));
			}
		}
		return memberMethods.toArray(MemberMethod.class);
	}
	
	public static Constructor[] getConstructors(java.lang.Class<?> javaClass)
	{
		List<Constructor> constructors = new List<>();
		for(java.lang.reflect.Constructor<?> javaConstructor : javaClass.getConstructors())
		{
			constructors.add(new Constructor(javaConstructor));
		}
		return constructors.toArray(Constructor.class);
	}
	
	public static AttributeMethod[] getAttributeMethods(java.lang.Class<?> javaClass)
	{
		Set<AttributeMethod> attributeMethods = new Set<>();
		for(java.lang.reflect.Method javaMethod : javaClass.getDeclaredMethods())
		{
			attributeMethods.add(new AttributeMethod(javaMethod));
		}
		return attributeMethods.toArray(AttributeMethod.class);
	}
	
	public static Object getValue(java.lang.reflect.Field javaField)
	{
		Object value = null;
		try
		{
			value = javaField.get(null);
		}
		catch(Throwable e)
		{
			
		}
		return value;
	}
	
	public static Declaration getDeclaration(java.lang.reflect.Field javaField)
	{
		return Declaration.get(javaField.getGenericType());
	}
	
	public static Declaration getDeclaration(java.lang.reflect.Parameter javaParameter)
	{
		return Declaration.get(javaParameter.getParameterizedType());
	}
	
	public static Parameter[] getParameters(java.lang.reflect.Constructor<?> javaConstructor)
	{
		return getParameters(javaConstructor.getParameters());
	}
	
	public static Parameter[] getParameters(java.lang.reflect.Method javaMethod)
	{
		return getParameters(javaMethod.getParameters());
	}
	
	protected static Parameter[] getParameters(java.lang.reflect.Parameter[] javaParameters)
	{
		Set<Parameter> parameters = new Set<>();
		for(java.lang.reflect.Parameter javaParameter : javaParameters)
		{
			parameters.add(new Parameter(javaParameter));
		}
		return parameters.toArray(Parameter.class);
	}
	
	public static TypeVariable[] getTypeVariables(java.lang.Class<?> javaClass)
	{
		return getTypeVariables(javaClass.getTypeParameters());
	}
	
	public static TypeVariable[] getTypeVariables(java.lang.reflect.Method javaMethod)
	{
		return getTypeVariables(javaMethod.getTypeParameters());
	}
	
	protected static TypeVariable[] getTypeVariables(java.lang.reflect.TypeVariable<?>[] javaTypeVariables)
	{
		Set<TypeVariable> typeVariables = new Set<>();
		for(java.lang.reflect.TypeVariable<?> javaTypeVariable : javaTypeVariables)
		{
			typeVariables.add(new TypeVariable(javaTypeVariable));
		}
		return typeVariables.toArray(TypeVariable.class);
	}
	
	public static Declaration getReturnDeclaration(java.lang.reflect.Method javaMethod)
	{
		return Declaration.get(javaMethod.getGenericReturnType());
	}
	
	public static String[] getThrowsNames(java.lang.reflect.Method javaMethod)
	{
		Set<String> throwsNames = new Set<>();
		for(java.lang.Class<?> javaClass : javaMethod.getExceptionTypes())
		{
			throwsNames.add(javaClass.getCanonicalName());
		}
		return throwsNames.toArray(String.class);
	}
	
	public static Attribute[] getAttributes(java.lang.annotation.Annotation javaAnnotation)
	{
		Set<Attribute> attributes = new Set<>();
		for(java.lang.reflect.Method javaMethod : javaAnnotation.annotationType().getDeclaredMethods())
		{
			try
			{
				Object value = javaMethod.invoke(javaAnnotation);
				if(!Objects.equals(value, javaMethod.getDefaultValue()))
				{
					attributes.add(new Attribute(javaMethod, value));
				}
			}
			catch(Exception e)
			{
				
			}
		}
		return attributes.toArray(Attribute.class);
	}
	
	public static Object getDefaultValue(java.lang.reflect.Method javaMethod)
	{
		return javaMethod.getDefaultValue();
	}
	
	public static Generic[] getGenerics(java.lang.Class<?> javaClass)
	{
		return new Generic[0];
	}
	
	public static Generic[] getGenerics(java.lang.reflect.ParameterizedType javaParameterizedType)
	{
		List<Generic> generics = new List<>();
		for(java.lang.reflect.Type type : javaParameterizedType.getActualTypeArguments())
		{
			generics.add(Generic.get(type));
		}
		return generics.toArray(Generic.class);
	}
	
	public static Declaration[] getExtendsDeclarations(java.lang.reflect.TypeVariable<?> javaTypeVariable)
	{
		List<Declaration> extendsDeclarations = new List<>();
		for(java.lang.reflect.Type javaType : javaTypeVariable.getBounds())
		{
			if(!java.lang.Object.class.equals(javaType))
			{
				extendsDeclarations.add(Declaration.get(javaType));
			}
		}
		return extendsDeclarations.toArray(Declaration.class);
	}
	
	public static Declaration[] getExtendsDeclarations(java.lang.reflect.WildcardType javaWildcardType)
	{
		List<Declaration> extendsDeclarations = new List<>();
		for(java.lang.reflect.Type javaType : javaWildcardType.getUpperBounds())
		{
			if(!java.lang.Object.class.equals(javaType))
			{
				extendsDeclarations.add(Declaration.get(javaType));
			}
		}
		return extendsDeclarations.toArray(Declaration.class);
	}
	
	public static Declaration[] getSuperDeclarations(java.lang.reflect.WildcardType javaWildcardType)
	{
		List<Declaration> superDeclarations = new List<>();
		for(java.lang.reflect.Type javaType : javaWildcardType.getLowerBounds())
		{
			if(!java.lang.Object.class.equals(javaType))
			{
				superDeclarations.add(Declaration.get(javaType));
			}
		}
		return superDeclarations.toArray(Declaration.class);
	}
	
}
