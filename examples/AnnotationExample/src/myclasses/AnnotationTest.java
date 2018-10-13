package myclasses;
import myannotations.ClassPreamble;

@ClassPreamble (
		author = "John Doe",
		date = "17/3/2013",
		lastModified = "4/12/2012",
		lastModifiedBy = "ihamod",
		reviewers = {"Student 1", "Student 2"}		
)
public class AnnotationTest {
	
	@Override
	public String toString() {return "";}
	
	//@Override
	public String doSomething() {return "";}
	
	@Deprecated
	public String doSomething2() {return "";}
}
