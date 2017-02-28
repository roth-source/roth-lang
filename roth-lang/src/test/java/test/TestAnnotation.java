package test;

public @interface TestAnnotation
{
	public static final String TEST_CONSTANT = "TEST_CONSTANT";
	public String testMemberField = "testMemberField";
	
	String testMethod() default "testMethod";
	
	String testMethod2();
	
}
