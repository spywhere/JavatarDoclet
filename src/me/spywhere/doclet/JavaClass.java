package me.spywhere.doclet;

import java.util.ArrayList;

import com.google.gson.annotations.SerializedName;
import com.sun.javadoc.AnnotationDesc;
import com.sun.javadoc.ClassDoc;
import com.sun.javadoc.FieldDoc;
import com.sun.javadoc.MethodDoc;

public class JavaClass {
	String name;
	@SerializedName("extends")
	String[] extendClass = null;
	@SerializedName("implements")
	ArrayList<String[]> implementClass = null;
	ArrayList<JavaField> fields = null;
	ArrayList<JavaMethod> methods = null;
	ArrayList<String> tags = null;
	
	public JavaClass(ClassDoc cls) {
		name = cls.name();
		for(AnnotationDesc anno:cls.annotations()){
			if(tags == null){
				tags = new ArrayList<String>();
			}
			tags.add(anno.annotationType().name());
		}
		for(ClassDoc inter:cls.interfaces()){
			if(implementClass == null){
				implementClass = new ArrayList<String[]>();
			}
			implementClass.add(new String[] { inter.containingPackage().name(), inter.name() });
		}
		if(cls.superclass() != null){
			extendClass = new String[] { cls.superclass().containingPackage().name(), cls.superclass().name() };
		}
		for(FieldDoc field:cls.fields()){
			if(field.isPrivate()){
				continue;
			}
			if(fields == null){
				fields = new ArrayList<JavaField>();
			}
			fields.add(new JavaField(field));
		}
		for(MethodDoc method:cls.methods()){
			if(method.isPrivate()){
				continue;
			}
			if(methods == null){
				methods = new ArrayList<JavaMethod>();
			}
			methods.add(new JavaMethod(method));
		}
	}
}
