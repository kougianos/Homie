package myclasses;

import java.lang.annotation.Annotation;

import myannotations.TypeHeader;

public class UseCustomAnnotation {

	public static void main(String[] args) {
		Class<SetCustomAnnotation> classObject = SetCustomAnnotation.class;
		
		if (classObject.isAnnotationPresent(TypeHeader.class))
		{
			Annotation annot = classObject.getAnnotation(TypeHeader.class);
			TypeHeader head = (TypeHeader) annot;
			System.out.println(head.developer());
			System.out.println(head.lastModified());
			for (int i = 0; i < head.teamMembers().length; i++)
				System.out.println(head.teamMembers()[i]);
			System.out.println(head.meaningOfLife());
		}


	}

}
