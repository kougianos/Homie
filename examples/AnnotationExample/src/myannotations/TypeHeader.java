package myannotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface TypeHeader {
	
	String developer() default "Unknown";
	String lastModified();
	String [] teamMembers();
	int meaningOfLife();

}
